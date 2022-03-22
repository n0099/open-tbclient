package com.baidu.cyberplayer.sdk.recorder;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class CyberMediaRecorder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes3.dex */
    public final class AudioFormat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CYBER_ENCODING_DEFAULT = 1;
        public static final int CYBER_ENCODING_INVALID = 0;
        public static final int CYBER_ENCODING_PCM_DBL = 10002;
        public static final int CYBER_ENCODING_PCM_DBLP = 10007;
        public static final int CYBER_ENCODING_PCM_FLT = 4;
        public static final int CYBER_ENCODING_PCM_FLTP = 10006;
        public static final int CYBER_ENCODING_PCM_S16 = 2;
        public static final int CYBER_ENCODING_PCM_S16P = 10004;
        public static final int CYBER_ENCODING_PCM_S32 = 10001;
        public static final int CYBER_ENCODING_PCM_S32P = 10005;
        public static final int CYBER_ENCODING_PCM_S64 = 10008;
        public static final int CYBER_ENCODING_PCM_S64P = 10009;
        public static final int CYBER_ENCODING_PCM_U8 = 3;
        public static final int CYBER_ENCODING_PCM_U8P = 10003;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Keep
    /* loaded from: classes3.dex */
    public final class AudioSource {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CAMCORDER = 5;
        public static final int DEFAULT = 0;
        public static final int MIC = 1;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public CyberMediaRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
