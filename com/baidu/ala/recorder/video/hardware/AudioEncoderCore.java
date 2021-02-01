package com.baidu.ala.recorder.video.hardware;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AudioEncoderCore {
    private static final int AUDIO_FORMAT = 2;
    private static final String MIME_TYPE = "audio/mp4a-latm";
    private static final int SAMPLES_PER_FRAME = 1024;
    private static final String TAG = "AudioEncoderCore";
    private static final boolean VERBOSE = false;
    private static int mMaxInputSize = 16384;
    private OutputCallback mCallback;
    private EncodeConfig mEncodeConfig = new EncodeConfig();
    private MediaCodec mEncoder = null;

    /* loaded from: classes6.dex */
    public static class EncodeConfig {
        public static final int BIT_RATE = 64000;
        public static final int CHANEL_COUNT = 1;
        public static final int SAMPLE_RATE = 44100;
        public int sampleRate = 1024;
        public int chanels = 1;
        public int bitRate = BIT_RATE;
    }

    /* loaded from: classes6.dex */
    public interface OutputCallback {
        public static final int KEY_FRAME = 2;
        public static final int MC_ENCODER_CONFIGURE_ERR = 1;
        public static final int MC_ENCODER_EXCEPTION_ERR = 2;
        public static final int MC_ENCODER_TIMEOUT_ERR = 2;
        public static final int MC_ENCODER_UNKNOW_ERR = 3;
        public static final int NONE_KYE_FRAME = 4;

        void onCodecConfig(byte[] bArr, int i, int i2);

        void onCodecData(byte[] bArr, int i, int i2, int i3, long j);

        void onCodecError(int i);

        void onFormatChanged(MediaFormat mediaFormat);
    }

    public AudioEncoderCore(EncodeConfig encodeConfig, OutputCallback outputCallback) {
        this.mCallback = null;
        this.mEncodeConfig.sampleRate = encodeConfig.sampleRate;
        this.mEncodeConfig.chanels = encodeConfig.chanels;
        this.mEncodeConfig.bitRate = encodeConfig.bitRate;
        this.mCallback = outputCallback;
        try {
            prepareEncoder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int prepareEncoder() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, MIME_TYPE);
        mediaFormat.setInteger("aac-profile", 2);
        mediaFormat.setInteger("sample-rate", this.mEncodeConfig.sampleRate);
        mediaFormat.setInteger("channel-count", this.mEncodeConfig.chanels);
        mediaFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.mEncodeConfig.bitRate);
        mediaFormat.setInteger("max-input-size", mMaxInputSize);
        try {
            this.mEncoder = MediaCodec.createEncoderByType(MIME_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mEncoder.start();
        return 0;
    }

    private int unPrepareEncoder() {
        if (this.mEncoder != null) {
            this.mEncoder.stop();
            this.mEncoder.release();
            this.mEncoder = null;
            return 0;
        }
        return 0;
    }

    public void drainAudio(boolean z, byte[] bArr, int i) {
        ByteBuffer[] inputBuffers = this.mEncoder.getInputBuffers();
        int dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(-1L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.array();
            long nanoTime = System.nanoTime() / 1000;
            if (z) {
                this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, i, nanoTime, 4);
            } else {
                this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, i, nanoTime, 0);
            }
        }
    }
}
