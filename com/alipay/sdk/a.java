package com.alipay.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f30754b = "com.alipay.sdk";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f30755c = "com.alipay.sdk";

    /* renamed from: d  reason: collision with root package name */
    public static final String f30756d = "release";

    /* renamed from: e  reason: collision with root package name */
    public static final String f30757e = "alipaySdk";

    /* renamed from: f  reason: collision with root package name */
    public static final int f30758f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f30759g = "15.8.02";

    /* renamed from: h  reason: collision with root package name */
    public static final String f30760h = "ad163e0-clean";

    /* renamed from: i  reason: collision with root package name */
    public static final String f30761i = "15.8.02";

    /* renamed from: j  reason: collision with root package name */
    public static final String f30762j = "h.a.3.8.02";
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
