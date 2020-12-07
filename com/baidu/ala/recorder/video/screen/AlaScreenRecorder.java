package com.baidu.ala.recorder.video.screen;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.view.View;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.hardware.EncoderOutputStream;
import com.baidu.ala.recorder.video.hardware.HardH264Encoder;
/* loaded from: classes9.dex */
public class AlaScreenRecorder implements IVideoRecorder {
    private static volatile AlaScreenRecorder mInstance;
    private Context mContext;
    private MediaProjection mProjection;
    private AlaScreenRecorderThread mRecorderThread;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback = null;
    private RecorderHandler mHandler = null;
    private HardH264Encoder mEncoder = null;
    private EncoderOutputStream.OnEncoderError mEncoderError = new EncoderOutputStream.OnEncoderError() { // from class: com.baidu.ala.recorder.video.screen.AlaScreenRecorder.2
        @Override // com.baidu.ala.recorder.video.hardware.EncoderOutputStream.OnEncoderError
        public void onError(int i, String str) {
            EncoderOutputStream.OnEncoderOutput outputCallback = AlaScreenRecorder.this.mEncoder != null ? AlaScreenRecorder.this.mEncoder.getOutputCallback() : null;
            if (AlaScreenRecorder.this.mEncoder != null) {
                AlaScreenRecorder.this.mEncoder.stop();
                AlaScreenRecorder.this.mEncoder.release();
                AlaScreenRecorder.this.mEncoder = null;
            }
            if (i == 1) {
                AlaScreenRecorder.this.sendError("1", 4);
                AlaScreenRecorder.this.mEncoder = new HardH264Encoder(AlaScreenRecorder.mInstance);
                if (AlaScreenRecorder.this.mEncoder.initMediaParams()) {
                    AlaScreenRecorder.this.mEncoder.setEncodeErrorCallback(AlaScreenRecorder.this.mEncoderError);
                    AlaScreenRecorder.this.mEncoder.setOutput(outputCallback);
                    if (AlaScreenRecorder.this.mEncoder.start(1)) {
                        if (AlaScreenRecorder.this.mRecorderThread != null) {
                            AlaScreenRecorder.this.mRecorderThread.quit();
                            AlaScreenRecorder.this.mRecorderThread = new AlaScreenRecorderThread(AlaScreenRecorder.this.mEncoder.getEncoderSurface(), AlaScreenRecorder.this.mProjection, AlaScreenRecorder.this.mTransDataCallback, AlaScreenRecorder.this.mHandler, true);
                            AlaScreenRecorder.this.mRecorderThread.setVideoConfig(AlaScreenRecorder.this.mVideoConfig);
                            AlaScreenRecorder.this.mRecorderThread.start();
                        }
                    } else {
                        AlaScreenRecorder.this.mEncoder = null;
                        if (outputCallback != null) {
                            outputCallback.onEncode(null, 0, true, false, 0L);
                        }
                    }
                } else {
                    AlaScreenRecorder.this.mEncoder = null;
                    if (outputCallback != null) {
                        outputCallback.onEncode(null, 0, true, false, 0L);
                    }
                }
            }
            if ((AlaScreenRecorder.this.mRecorderThread != null && AlaScreenRecorder.this.mProjection != null && i == 2) || AlaScreenRecorder.this.mEncoder == null) {
                if (AlaScreenRecorder.this.mRecorderThread != null) {
                    AlaScreenRecorder.this.mRecorderThread.quit();
                }
                AlaScreenRecorder.this.sendError("2", 4);
                AlaScreenRecorder.this.mRecorderThread = new AlaScreenRecorderThread(null, AlaScreenRecorder.this.mProjection, AlaScreenRecorder.this.mTransDataCallback, AlaScreenRecorder.this.mHandler, false);
                AlaScreenRecorder.this.mRecorderThread.setVideoConfig(AlaScreenRecorder.this.mVideoConfig);
                AlaScreenRecorder.this.mRecorderThread.start();
            }
        }
    };
    private IVideoRecorder.IVideoDataCallBack mTransDataCallback = new IVideoRecorder.IVideoDataCallBack() { // from class: com.baidu.ala.recorder.video.screen.AlaScreenRecorder.3
        @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
        public void onRawVideoFrameReceived(byte[] bArr, int i, int i2, int i3) {
            if (AlaScreenRecorder.this.mEncoder != null) {
                AlaScreenRecorder.this.mEncoder.inputEncoderBuffer(bArr);
            } else if (AlaScreenRecorder.this.mVideoDataCallback != null) {
                AlaScreenRecorder.this.mVideoDataCallback.onRawVideoFrameReceived(bArr, i, i2, i3);
            }
        }

        @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j, long j2) {
        }

        @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
        public void onError(int i) {
        }
    };

    private AlaScreenRecorder() {
    }

    public static AlaScreenRecorder getInstance() {
        if (mInstance == null) {
            synchronized (AlaScreenRecorder.class) {
                if (mInstance == null) {
                    mInstance = new AlaScreenRecorder();
                }
            }
        }
        return mInstance;
    }

    public static void clearInstance() {
        mInstance = null;
    }

    public void init(Context context, RecorderHandler recorderHandler) {
        this.mContext = context;
        this.mHandler = recorderHandler;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startRecord() {
        if (this.mRecorderThread == null || this.mRecorderThread.getRenderHandler() == null) {
            if (this.mContext != null) {
                Intent intent = new Intent(this.mContext, ScreenRecorderPrepareActivity.class);
                if (this.mContext instanceof Application) {
                    intent.addFlags(268435456);
                }
                this.mContext.startActivity(intent);
                return;
            }
            return;
        }
        this.mRecorderThread.getRenderHandler().sendResumeRecord();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void stopRecord() {
        if (this.mRecorderThread != null && this.mRecorderThread.getRenderHandler() != null) {
            this.mRecorderThread.getRenderHandler().sendPauseRecord();
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mVideoDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void setRecorderCallback(RecorderCallback recorderCallback) {
        if (this.mHandler != null) {
            this.mHandler.setRecorderCallback(recorderCallback);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void willSwitchSense(int i) {
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public VideoFormat getVideoFormat() {
        return VideoFormat.RGBA;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputWidth() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoHeight() : this.mVideoConfig.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputHeight() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoWidth() : this.mVideoConfig.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isVideoThreadRun() {
        if (this.mRecorderThread != null) {
            return this.mRecorderThread.isVideoThreadRun();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isForeBackgroundSwitchEnable() {
        return false;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public View getPreview() {
        return null;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void release() {
        if (this.mRecorderThread != null && this.mRecorderThread.getRenderHandler() != null) {
            this.mRecorderThread.getRenderHandler().sendShutDown();
        }
        if (this.mHandler != null) {
            this.mHandler.sendVideoCollectionStop();
        }
        this.mRecorderThread = null;
        this.mContext = null;
        this.mHandler = null;
        if (this.mProjection != null) {
            this.mProjection.stop();
        }
        this.mProjection = null;
        clearInstance();
    }

    public void startRecorderThread(MediaProjection mediaProjection) {
        this.mProjection = mediaProjection;
        if (this.mRecorderThread == null) {
            if (this.mEncoder == null) {
                this.mRecorderThread = new AlaScreenRecorderThread(null, mediaProjection, this.mTransDataCallback, this.mHandler, false);
            } else {
                this.mEncoder.setEncodeErrorCallback(this.mEncoderError);
                this.mRecorderThread = new AlaScreenRecorderThread(this.mEncoder.getEncoderSurface(), mediaProjection, this.mTransDataCallback, this.mHandler, true);
            }
            this.mRecorderThread.setVideoConfig(this.mVideoConfig);
            if (this.mEncoder == null) {
                this.mRecorderThread.start();
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.ala.recorder.video.screen.AlaScreenRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaScreenRecorder.this.mRecorderThread != null) {
                            AlaScreenRecorder.this.mRecorderThread.start();
                        }
                    }
                }, 1000L);
            }
        }
        if (this.mHandler != null) {
            this.mHandler.sendVideoCollectionStart(true, this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight());
        }
    }

    public void sendError() {
        if (this.mHandler != null) {
            this.mHandler.sendError(2, "screen recorder permission denied");
        }
    }

    public void sendError(String str, int i) {
        if (this.mHandler != null) {
            this.mHandler.sendError(i, str);
        }
    }

    public void setHardEncoder(HardH264Encoder hardH264Encoder) {
        this.mEncoder = hardH264Encoder;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder, com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        if (this.mRecorderThread != null) {
            this.mRecorderThread.setVideoConfig(this.mVideoConfig);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getBitRate() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getBitStream();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startGetDataToSend() {
    }
}
