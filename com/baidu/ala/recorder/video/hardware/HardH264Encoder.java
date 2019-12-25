package com.baidu.ala.recorder.video.hardware;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.hardware.EncoderOutputStream;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class HardH264Encoder {
    private static final int CHECK_STREAM_DURATION = 5000;
    public static final int ENCODE_FPS = 25;
    public static final int ENCODE_GOP = 2;
    private static final int ENCODE_RETRY_COUNT_MAX = 1;
    private static final String MIME = "video/avc";
    private EncoderOutputStream.OnEncoderError mErrorCallback;
    private EncoderOutputStream.OnEncoderOutput mOutput;
    private IVideoRecorder mRecorder;
    private int mRetryCount = 0;
    private int mFrameCount = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private MediaCodec mMediaCodec = null;
    private MediaFormat mMediaFormat = null;
    private Surface mSurface = null;
    private EncoderOutputStream mSteamProc = null;
    private boolean mIsStart = false;
    private byte[] mYUVBuffer = null;
    private int mTranColorType = 16402;
    private Runnable mCheckStreamRun = new Runnable() { // from class: com.baidu.ala.recorder.video.hardware.HardH264Encoder.1
        @Override // java.lang.Runnable
        public void run() {
            if (HardH264Encoder.this.mSteamProc != null) {
                if (HardH264Encoder.this.mSteamProc.hasStream()) {
                    HardH264Encoder.this.mHandler.postDelayed(HardH264Encoder.this.mCheckStreamRun, 5000L);
                } else if (HardH264Encoder.this.mRetryCount >= 1) {
                    if (HardH264Encoder.this.mErrorCallback != null) {
                        HardH264Encoder.this.mErrorCallback.onError(2, "exchange Encoder");
                    }
                    if (HardH264Encoder.this.mOutput != null) {
                        HardH264Encoder.this.mOutput.onEncode(null, 0, true, false, 0L);
                    }
                } else if (HardH264Encoder.this.mErrorCallback != null) {
                    HardH264Encoder.this.mErrorCallback.onError(1, "exchange Encoder");
                }
            }
        }
    };

    public HardH264Encoder(IVideoRecorder iVideoRecorder) {
        this.mRecorder = null;
        this.mRecorder = iVideoRecorder;
    }

    private boolean setMediaFormat(MediaCodec mediaCodec, boolean z) {
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType(MIME);
            int selectColorFormat = selectColorFormat(capabilitiesForType);
            int selectProfile = selectProfile(capabilitiesForType);
            this.mMediaFormat = MediaFormat.createVideoFormat(MIME, this.mRecorder.getOutputWidth(), this.mRecorder.getOutputHeight());
            this.mMediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.mRecorder.getBitRate());
            this.mMediaFormat.setInteger("frame-rate", 25);
            this.mMediaFormat.setInteger("color-format", selectColorFormat);
            this.mMediaFormat.setInteger("i-frame-interval", 2);
            if (!z) {
                this.mMediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, selectProfile);
                this.mMediaFormat.setInteger(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 256);
            }
            mediaCodec.configure(this.mMediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Throwable th) {
            BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, BdStatsConstant.StatsType.ERROR, "setMediaFormat exception" + th.getMessage());
            return false;
        }
    }

    public boolean initMediaParams() {
        try {
            this.mMediaCodec = MediaCodec.createEncoderByType(MIME);
            if (setMediaFormat(this.mMediaCodec, false) || setMediaFormat(this.mMediaCodec, true)) {
                this.mSurface = this.mMediaCodec.createInputSurface();
                this.mSteamProc = new EncoderOutputStream(this.mMediaCodec);
                return true;
            }
            return false;
        } catch (Exception e) {
            BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, BdStatsConstant.StatsType.ERROR, "initMediaParams exception:" + e.getMessage());
            BdLog.e(e);
            return false;
        }
    }

    public Surface getEncoderSurface() {
        return this.mSurface;
    }

    public void inputEncoderBuffer(byte[] bArr) {
        if (this.mMediaCodec == null || this.mIsStart) {
        }
    }

    private long computePresentationTime(long j) {
        return 132 + ((TimeUtils.NANOS_PER_MS * j) / 25);
    }

    public boolean start(int i) {
        this.mRetryCount = i;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(this.mCheckStreamRun, 5000L);
        try {
            this.mMediaCodec.start();
            this.mSteamProc.start(i);
            this.mIsStart = true;
            return true;
        } catch (Throwable th) {
            BdLog.e(th);
            BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, BdStatsConstant.StatsType.ERROR, "start failed, exception:" + th.getMessage() + ", exceptionType:" + th.getClass().toString() + ", try count:" + i);
            return false;
        }
    }

    public void stop() {
        this.mIsStart = false;
        this.mHandler.removeCallbacks(this.mCheckStreamRun);
        try {
            this.mMediaCodec.stop();
            if (this.mSteamProc != null) {
                this.mSteamProc.stop();
                this.mSteamProc = null;
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.mCheckStreamRun);
        try {
            this.mMediaCodec.release();
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void setOutput(EncoderOutputStream.OnEncoderOutput onEncoderOutput) {
        this.mOutput = onEncoderOutput;
        if (this.mSteamProc != null) {
            this.mSteamProc.setOutput(onEncoderOutput);
        }
    }

    public EncoderOutputStream.OnEncoderOutput getOutputCallback() {
        if (this.mSteamProc != null) {
            return this.mSteamProc.getOutputCallback();
        }
        return null;
    }

    public void setEncodeErrorCallback(EncoderOutputStream.OnEncoderError onEncoderError) {
        this.mErrorCallback = onEncoderError;
        if (this.mSteamProc != null) {
            this.mSteamProc.setEncodeErrorCallback(onEncoderError);
        }
    }

    private int selectColorFormat(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return 2130708361;
    }

    private int selectProfile(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < codecCapabilities.profileLevels.length; i++) {
            if (codecCapabilities.profileLevels[i].profile == 8) {
                z2 = true;
            } else if (codecCapabilities.profileLevels[i].profile == 2) {
                z = true;
            }
        }
        if (z2) {
            return 8;
        }
        return z ? 2 : 1;
    }

    private boolean isRecognizedFormat(int i) {
        switch (i) {
            case 19:
            case 20:
                this.mTranColorType = 81938;
                return true;
            case 21:
            case 39:
            case 2130706688:
                this.mTranColorType = 16402;
                return true;
            default:
                return false;
        }
    }
}
