package com.baidu.searchbox.http;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ConnectNetworkType {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final int APACH_HTTP_TYPE = 0;
    public static final int CRONET_HTTP_TYPE = 3;
    public static final int HTTPURLCONNECTION_HTTP_TYPE = 1;
    public static final int OKHTTP_HTTP_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public ConnectNetworkType() {
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
