package com.baidu.cyberplayer.sdk.recorder;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
@Keep
/* loaded from: classes3.dex */
public abstract class CyberAudioRecorder {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnEncBufferCallbackListener {
        boolean onFrameRecorded(ByteBuffer byteBuffer, int i2, boolean z);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(int i2, int i3, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        boolean onInfo(int i2, int i3, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    public CyberAudioRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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
