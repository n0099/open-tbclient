package com.alipay.sdk.cons;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "https";
    public static final String b = "user_agent";
    public static final String c = "tid";
    public static final String d = "external_info";
    public static final String e = "has_alipay";
    public static final String f = "has_msp_app";
    public static final String g = "utdid";
    public static final String h = "app_key";
    public static final String i = "trideskey";
    public static final String j = "new_client_key";
    public static final String k = "pa";
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
