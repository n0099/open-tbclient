package com.baidu.searchbox.live.interfaces.net;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NetWorkError {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_CONNECT_EXCEPTION = -22;
    public static final int NETWORK_IO_EXCEPTION = -19;
    public static final int NETWORK_PARSE_EXCEPTION = -23;
    public static final int NETWORK_SOCKET_EXCEPTION = -12;
    public static final int NETWORK_SOCKET_TIMEOUT = -13;
    public static final int NETWORK_SSL_EXCEPTION = -20;
    public static final int NETWORK_UNKNOWN = -10;
    public static final int NETWORK_UNKNOWN_HOST_EXCEPTION = -21;
    public transient /* synthetic */ FieldHolder $fh;

    public NetWorkError() {
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
