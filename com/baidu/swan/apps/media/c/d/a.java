package com.baidu.swan.apps.media.c.d;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.livePlayer.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.swan.apps.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private ByteBuffer[] aWI;
    private ByteBuffer[] aWJ;
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannel;
    private String mFormat;
    private MediaCodec mMediaCodec;
    private int mSampleRate;
    private long aWL = 0;
    private ByteArrayOutputStream aWK = new ByteArrayOutputStream();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public a(String str, int i, int i2, int i3) {
        boolean z = false;
        this.mSampleRate = 0;
        this.mChannel = 0;
        this.mFormat = "aac";
        this.mSampleRate = i2;
        this.mChannel = i;
        if (TextUtils.isEmpty(str)) {
            this.mFormat = "aac";
        } else {
            this.mFormat = str;
        }
        try {
            String str2 = this.mFormat;
            switch (str2.hashCode()) {
                case 96323:
                    if (str2.equals("aac")) {
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
                    MediaCodecInfo fZ = fZ("audio/mp4a-latm");
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i2, i);
                    createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
                    createAudioFormat.setInteger("aac-profile", 2);
                    if (fZ != null) {
                        this.mMediaCodec = MediaCodec.createByCodecName(fZ.getName());
                        this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.mMediaCodec.start();
                        this.aWI = this.mMediaCodec.getInputBuffers();
                        this.aWJ = this.mMediaCodec.getOutputBuffers();
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

    public byte[] s(byte[] bArr) {
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
                if (str.equals("aac")) {
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
                return t(bArr);
            case 1:
                return u(bArr);
            case 2:
            default:
                return bArr;
        }
    }

    private MediaCodecInfo fZ(String str) {
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

    private long ab(long j) {
        if (this.mSampleRate == 0) {
            return 0L;
        }
        return (((1000 * j) * 90) * 1024) / this.mSampleRate;
    }

    private byte[] i(int i, int i2, int i3, int i4) {
        int i5 = i + 7;
        byte[] bArr = new byte[i5];
        int dG = dG(i3);
        bArr[0] = -1;
        bArr[1] = -15;
        bArr[2] = (byte) ((dG << 2) + ((i2 - 1) << 6) + (i4 >> 2));
        bArr[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
        bArr[4] = (byte) ((i5 & 2047) >> 3);
        bArr[5] = (byte) (((i5 & 7) << 5) + 31);
        bArr[6] = -4;
        return bArr;
    }

    private int dG(int i) {
        switch (i) {
            case 7350:
                return 12;
            case 8000:
            default:
                return 11;
            case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                return 10;
            case 12000:
                return 9;
            case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K /* 16000 */:
                return 8;
            case 22050:
                return 7;
            case 24000:
                return 6;
            case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K /* 32000 */:
                return 5;
            case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
                return 4;
            case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K /* 48000 */:
                return 3;
            case 64000:
                return 2;
            case 88200:
                return 1;
            case 96000:
                return 0;
        }
    }

    private byte[] t(byte[] bArr) {
        if (this.mMediaCodec != null && bArr != null) {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start AAC encode");
            }
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.aWI[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.limit(bArr.length);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, ab(this.aWL), 0);
                this.aWL++;
            }
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                int i = this.mBufferInfo.size;
                ByteBuffer byteBuffer2 = this.aWJ[dequeueOutputBuffer];
                byteBuffer2.position(this.mBufferInfo.offset);
                byteBuffer2.limit(this.mBufferInfo.offset + i);
                byte[] i2 = i(i, 1, this.mSampleRate, this.mChannel);
                byteBuffer2.get(i2, 7, i);
                byteBuffer2.position(this.mBufferInfo.offset);
                try {
                    this.aWK.write(i2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
            }
            bArr = this.aWK.toByteArray();
            try {
                this.aWK.flush();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.aWK.reset();
        }
        return bArr;
    }

    private byte[] u(byte[] bArr) {
        return bArr;
    }
}
