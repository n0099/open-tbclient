package com.baidu.swan.apps.media.a.d;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.recorder.video.hardware.AudioEncoderCore;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.searchbox.ugc.transcoder.TranscoderPlugin;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import com.baidu.swan.apps.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private ByteBuffer[] dcU;
    private ByteBuffer[] dcV;
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannel;
    private String mFormat;
    private MediaCodec mMediaCodec;
    private int mSampleRate;
    private long dcW = 0;
    private ByteArrayOutputStream afE = new ByteArrayOutputStream();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public a(String str, int i, int i2, int i3) {
        boolean z = false;
        this.mSampleRate = 0;
        this.mChannel = 0;
        this.mFormat = TranscoderPlugin.AUDIO_CODEC;
        this.mSampleRate = i2;
        this.mChannel = i;
        if (TextUtils.isEmpty(str)) {
            this.mFormat = TranscoderPlugin.AUDIO_CODEC;
        } else {
            this.mFormat = str;
        }
        try {
            String str2 = this.mFormat;
            switch (str2.hashCode()) {
                case 96323:
                    if (str2.equals(TranscoderPlugin.AUDIO_CODEC)) {
                        break;
                    }
                    z = true;
                    break;
                case 108272:
                    if (str2.equals("mp3")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 110810:
                    if (str2.equals("pcm")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    if (DEBUG) {
                        Log.d("AudioRecorderManager", "aac format init");
                    }
                    MediaCodecInfo selectCodec = selectCodec("audio/mp4a-latm");
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i2, i);
                    createAudioFormat.setInteger("bitrate", i3);
                    createAudioFormat.setInteger("aac-profile", 2);
                    createAudioFormat.setInteger("max-input-size", BdStatsConstant.MAX_WRITE_LOG_SIZE);
                    if (selectCodec != null) {
                        this.mMediaCodec = MediaCodec.createByCodecName(selectCodec.getName());
                        this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.mMediaCodec.start();
                        this.dcU = this.mMediaCodec.getInputBuffers();
                        this.dcV = this.mMediaCodec.getOutputBuffers();
                        this.mBufferInfo = new MediaCodec.BufferInfo();
                        return;
                    }
                    return;
                case true:
                case true:
                default:
                    return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] K(byte[] bArr) {
        if (this.mMediaCodec == null || bArr == null) {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "wrong input or mediaCodec");
                return bArr;
            }
            return bArr;
        }
        String str = this.mFormat;
        char c = 65535;
        switch (str.hashCode()) {
            case 96323:
                if (str.equals(TranscoderPlugin.AUDIO_CODEC)) {
                    c = 0;
                    break;
                }
                break;
            case 108272:
                if (str.equals("mp3")) {
                    c = 1;
                    break;
                }
                break;
            case 110810:
                if (str.equals("pcm")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return L(bArr);
            case 1:
                return M(bArr);
            case 2:
            default:
                return bArr;
        }
    }

    private MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private long bS(long j) {
        if (this.mSampleRate == 0) {
            return 0L;
        }
        return (((1000 * j) * 90) * 1024) / this.mSampleRate;
    }

    private byte[] m(int i, int i2, int i3, int i4) {
        int i5 = i + 7;
        byte[] bArr = new byte[i5];
        int jq = jq(i3);
        bArr[0] = -1;
        bArr[1] = -15;
        bArr[2] = (byte) ((jq << 2) + ((i2 - 1) << 6) + (i4 >> 2));
        bArr[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
        bArr[4] = (byte) ((i5 & 2047) >> 3);
        bArr[5] = (byte) (((i5 & 7) << 5) + 31);
        bArr[6] = -4;
        return bArr;
    }

    private int jq(int i) {
        switch (i) {
            case 7350:
                return 12;
            case CoolPraiseGuideLottieView.ANIM_DURATION /* 8000 */:
            default:
                return 11;
            case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                return 10;
            case 12000:
                return 9;
            case 16000:
                return 8;
            case 22050:
                return 7;
            case 24000:
                return 6;
            case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K /* 32000 */:
                return 5;
            case 44100:
                return 4;
            case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K /* 48000 */:
                return 3;
            case AudioEncoderCore.EncodeConfig.BIT_RATE /* 64000 */:
                return 2;
            case 88200:
                return 1;
            case 96000:
                return 0;
        }
    }

    private byte[] L(byte[] bArr) {
        if (this.mMediaCodec != null && bArr != null) {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start AAC encode");
            }
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.dcU[dequeueInputBuffer];
                byteBuffer.clear();
                try {
                    byteBuffer.put(bArr);
                    byteBuffer.limit(bArr.length);
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, bS(this.dcW), 0);
                    this.dcW++;
                } catch (IllegalArgumentException | BufferOverflowException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                int i = this.mBufferInfo.size;
                ByteBuffer byteBuffer2 = this.dcV[dequeueOutputBuffer];
                try {
                    byteBuffer2.position(this.mBufferInfo.offset);
                    byteBuffer2.limit(this.mBufferInfo.offset + i);
                    byte[] m = m(i, 2, this.mSampleRate, this.mChannel);
                    try {
                        byteBuffer2.get(m, 7, i);
                        byteBuffer2.position(this.mBufferInfo.offset);
                        this.afE.write(m);
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
                    } catch (IOException | IllegalArgumentException | BufferUnderflowException e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IllegalArgumentException e3) {
                    if (DEBUG) {
                        e3.printStackTrace();
                    }
                }
            }
            bArr = this.afE.toByteArray();
            try {
                this.afE.flush();
            } catch (IOException e4) {
                if (DEBUG) {
                    e4.printStackTrace();
                }
            }
            this.afE.reset();
        }
        return bArr;
    }

    private byte[] M(byte[] bArr) {
        return bArr;
    }
}
