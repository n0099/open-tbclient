package com.alipay.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean a = false;
    public static final String b = "com.alipay.sdk";
    @Deprecated
    public static final String c = "com.alipay.sdk";
    public static final String d = "release";
    public static final String e = "alipaySdk";
    public static final int f = 1;
    public static final String g = "15.8.02";
    public static final String h = "ad163e0-clean";
    public static final String i = "15.8.02";
    public static final String j = "h.a.3.8.02";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
