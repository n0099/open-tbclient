package com.baidu.cyberplayer.sdk.recorder;

import com.baidu.cyberplayer.sdk.Keep;
import java.nio.ByteBuffer;
import java.util.ArrayList;
@Keep
/* loaded from: classes3.dex */
public abstract class CyberAudioRecorder {
    public static final String KEY_INT_ENC_BIT_RATE = "enc_bit_rate";
    public static final String KEY_INT_ENC_CALLBACK_MAX_SIZE = "enc_buf_callback_max_size";
    public static final String KEY_INT_ENC_MAX_DURATION = "enc_max_duration";
    public static final String KEY_INT_IN_AUDIO_SOURCE = "in_audio_source";
    public static final String KEY_INT_IN_CHANNEL_NB = "in_channel_nb";
    public static final String KEY_INT_IN_SAMPLE_FORMAT = "in_sample_fmt";
    public static final String KEY_INT_IN_SAMPLE_RATE = "in_sample_rate";
    public static final String KEY_INT_OUT_CHANNEL_NB = "out_channel_nb";
    public static final String KEY_INT_OUT_SAMPLE_FORMAT = "out_sample_fmt";
    public static final String KEY_INT_OUT_SAMPLE_RATE = "out_sample_rate";
    public static final String KEY_STR_ENC_NAME = "enc_name";
    public static final String KEY_STR_MUXER_NAME = "muxer_name";
    public static final String KEY_STR_OUTPUT_FILE = "output_file";

    @Keep
    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnEncBufferCallbackListener {
        boolean onFrameRecorded(ByteBuffer byteBuffer, int i, boolean z);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    public abstract ArrayList<String> getSupportEncoder();

    public abstract void pause();

    public abstract void prepare();

    public abstract void release();

    public abstract void setOnCompletionListener(OnCompletionListener onCompletionListener);

    public abstract void setOnEncBufferListener(OnEncBufferCallbackListener onEncBufferCallbackListener);

    public abstract void setOnErrorListener(OnErrorListener onErrorListener);

    public abstract void setOnInfoListener(OnInfoListener onInfoListener);

    public abstract void setOnPreparedListener(OnPreparedListener onPreparedListener);

    public abstract void setParameter(String str, long j);

    public abstract void setParameter(String str, String str2);

    public abstract void start();

    public abstract void stop();
}
