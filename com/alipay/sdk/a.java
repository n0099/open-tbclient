package com.alipay.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35716a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f35717b = "com.alipay.sdk";

    /* renamed from: c  reason: collision with root package name */
    public static final String f35718c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35719d = "utdidSec";

    /* renamed from: e  reason: collision with root package name */
    public static final int f35720e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f35721f = "15.7.7";

    /* renamed from: g  reason: collision with root package name */
    public static final String f35722g = "726a7a5-clean";

    /* renamed from: h  reason: collision with root package name */
    public static final String f35723h = "15.7.7";

    /* renamed from: i  reason: collision with root package name */
    public static final String f35724i = "h.a.3.7.7";
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
