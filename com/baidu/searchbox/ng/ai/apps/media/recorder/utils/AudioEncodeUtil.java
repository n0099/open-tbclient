package com.baidu.searchbox.ng.ai.apps.media.recorder.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class AudioEncodeUtil {
    private static final int AAC_DEFAULT_FREQUENCY_INDEX = 11;
    private static final int AAC_PROFILE = 2;
    private static final int ADTS_HEADER_LENGTH = 7;
    private static final boolean DEBUG = false;
    private static final String MIME_TYPE_AAC = "audio/mp4a-latm";
    private static final int PTS_AAC_CONSTANT = 1024;
    private static final int PTS_CONSTANT = 90;
    private static final int PTS_TIME_CONSTANT = 1000;
    private static final int SAMPLE_RATE_11025 = 11025;
    private static final int SAMPLE_RATE_12000 = 12000;
    private static final int SAMPLE_RATE_16000 = 16000;
    private static final int SAMPLE_RATE_22050 = 22050;
    private static final int SAMPLE_RATE_24000 = 24000;
    private static final int SAMPLE_RATE_32000 = 32000;
    private static final int SAMPLE_RATE_44100 = 44100;
    private static final int SAMPLE_RATE_48000 = 48000;
    private static final int SAMPLE_RATE_64000 = 64000;
    private static final int SAMPLE_RATE_7350 = 7350;
    private static final int SAMPLE_RATE_8000 = 8000;
    private static final int SAMPLE_RATE_88200 = 88200;
    private static final int SAMPLE_RATE_96000 = 96000;
    private static final String TAG = "AudioRecorderManager";
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannel;
    private String mFormat;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private int mSampleRate;
    private long mPTS = 0;
    private ByteArrayOutputStream mOutputStream = new ByteArrayOutputStream();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public AudioEncodeUtil(String str, int i, int i2, int i3) {
        boolean z = false;
        this.mSampleRate = 0;
        this.mChannel = 0;
        this.mFormat = AiAppsRecordConstants.FORMAT_AAC;
        this.mSampleRate = i2;
        this.mChannel = i;
        if (TextUtils.isEmpty(str)) {
            this.mFormat = AiAppsRecordConstants.FORMAT_AAC;
        } else {
            this.mFormat = str;
        }
        try {
            String str2 = this.mFormat;
            switch (str2.hashCode()) {
                case 96323:
                    if (str2.equals(AiAppsRecordConstants.FORMAT_AAC)) {
                        break;
                    }
                    z = true;
                    break;
                case 108272:
                    if (str2.equals(AiAppsRecordConstants.FORMAT_MP3)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 110810:
                    if (str2.equals(AiAppsRecordConstants.FORMAT_PCM)) {
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
                    MediaCodecInfo selectCodec = selectCodec(MIME_TYPE_AAC);
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MIME_TYPE_AAC, i2, i);
                    createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
                    createAudioFormat.setInteger("aac-profile", 2);
                    if (selectCodec != null) {
                        this.mMediaCodec = MediaCodec.createByCodecName(selectCodec.getName());
                        this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.mMediaCodec.start();
                        this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
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

    public byte[] startEncode(byte[] bArr) {
        if (this.mMediaCodec != null && bArr != null) {
            String str = this.mFormat;
            char c = 65535;
            switch (str.hashCode()) {
                case 96323:
                    if (str.equals(AiAppsRecordConstants.FORMAT_AAC)) {
                        c = 0;
                        break;
                    }
                    break;
                case 108272:
                    if (str.equals(AiAppsRecordConstants.FORMAT_MP3)) {
                        c = 1;
                        break;
                    }
                    break;
                case 110810:
                    if (str.equals(AiAppsRecordConstants.FORMAT_PCM)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return startAACEncode(bArr);
                case 1:
                    return startMP3Encode(bArr);
                case 2:
                default:
                    return bArr;
            }
        }
        return bArr;
    }

    public void release() {
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        try {
            this.mOutputStream.flush();
            this.mOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    private long computePTS(long j) {
        if (this.mSampleRate == 0) {
            return 0L;
        }
        return (((1000 * j) * 90) * 1024) / this.mSampleRate;
    }

    private byte[] createOutWithADTSHeader(int i, int i2, int i3, int i4) {
        int i5 = i + 7;
        byte[] bArr = new byte[i5];
        int changeSampleRateToIndex = changeSampleRateToIndex(i3);
        bArr[0] = -1;
        bArr[1] = -15;
        bArr[2] = (byte) ((changeSampleRateToIndex << 2) + ((i2 - 1) << 6) + (i4 >> 2));
        bArr[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
        bArr[4] = (byte) ((i5 & 2047) >> 3);
        bArr[5] = (byte) (((i5 & 7) << 5) + 31);
        bArr[6] = -4;
        return bArr;
    }

    private int changeSampleRateToIndex(int i) {
        switch (i) {
            case SAMPLE_RATE_7350 /* 7350 */:
                return 12;
            case SAMPLE_RATE_8000 /* 8000 */:
            default:
                return 11;
            case SAMPLE_RATE_11025 /* 11025 */:
                return 10;
            case SAMPLE_RATE_12000 /* 12000 */:
                return 9;
            case 16000:
                return 8;
            case SAMPLE_RATE_22050 /* 22050 */:
                return 7;
            case SAMPLE_RATE_24000 /* 24000 */:
                return 6;
            case SAMPLE_RATE_32000 /* 32000 */:
                return 5;
            case SAMPLE_RATE_44100 /* 44100 */:
                return 4;
            case SAMPLE_RATE_48000 /* 48000 */:
                return 3;
            case SAMPLE_RATE_64000 /* 64000 */:
                return 2;
            case SAMPLE_RATE_88200 /* 88200 */:
                return 1;
            case SAMPLE_RATE_96000 /* 96000 */:
                return 0;
        }
    }

    private byte[] startAACEncode(byte[] bArr) {
        if (this.mMediaCodec != null && bArr != null) {
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.mInputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.limit(bArr.length);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, computePTS(this.mPTS), 0);
                this.mPTS++;
            }
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                int i = this.mBufferInfo.size;
                ByteBuffer byteBuffer2 = this.mOutputBuffers[dequeueOutputBuffer];
                byteBuffer2.position(this.mBufferInfo.offset);
                byteBuffer2.limit(this.mBufferInfo.offset + i);
                byte[] createOutWithADTSHeader = createOutWithADTSHeader(i, 1, this.mSampleRate, this.mChannel);
                byteBuffer2.get(createOutWithADTSHeader, 7, i);
                byteBuffer2.position(this.mBufferInfo.offset);
                try {
                    this.mOutputStream.write(createOutWithADTSHeader);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
            }
            bArr = this.mOutputStream.toByteArray();
            try {
                this.mOutputStream.flush();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mOutputStream.reset();
        }
        return bArr;
    }

    private byte[] startMP3Encode(byte[] bArr) {
        return bArr;
    }
}
