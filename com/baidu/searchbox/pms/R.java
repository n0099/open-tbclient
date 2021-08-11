package com.baidu.searchbox.pms;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DATA_WRITE_DB = 0x7f0f000e;
        public static final int DOWNLOAD_CANCELED = 0x7f0f000f;
        public static final int DOWNLOAD_ERROR_CREATEFILE = 0x7f0f0010;
        public static final int DOWNLOAD_ERROR_DUPLICATED = 0x7f0f0011;
        public static final int DOWNLOAD_ERROR_MD5 = 0x7f0f0012;
        public static final int DOWNLOAD_ERROR_MISS_PARAM = 0x7f0f0013;
        public static final int DOWNLOAD_ERROR_NETWORK = 0x7f0f0014;
        public static final int DOWNLOAD_ERROR_NETWROK_CHANGE = 0x7f0f0015;
        public static final int DOWNLOAD_ERROR_NETWROK_LIMIT = 0x7f0f0016;
        public static final int DOWNLOAD_ERROR_NOSPACE = 0x7f0f0017;
        public static final int DOWNLOAD_ERROR_PATH = 0x7f0f0018;
        public static final int DOWNLOAD_ERROR_WRITE = 0x7f0f0019;
        public static final int DOWNLOAD_PAUSED = 0x7f0f001a;
        public static final int DOWNLOAD_RESUMED = 0x7f0f001b;
        public static final int DOWNLOAD_SUCCESS = 0x7f0f001c;
        public static final int INSTALL_ERROR = 0x7f0f001f;
        public static final int INSTALL_SUCCESS = 0x7f0f0020;
        public static final int META_ERROR_CONNECTION = 0x7f0f0032;
        public static final int META_ERROR_FATAL = 0x7f0f0033;
        public static final int META_ERROR_NETWORK = 0x7f0f0034;
        public static final int META_ERROR_PARAMS = 0x7f0f0035;
        public static final int META_ERROR_RESPONSE = 0x7f0f0036;
        public static final int META_REQ_SUCCESS = 0x7f0f0037;
        public static final int app_name = 0x7f0f029e;
        public transient /* synthetic */ FieldHolder $fh;

        public string() {
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
    }

    public R() {
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
}
