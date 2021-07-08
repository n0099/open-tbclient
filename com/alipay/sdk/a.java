package com.alipay.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1741a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1742b = "com.alipay.sdk";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1743c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1744d = "utdidSec";

    /* renamed from: e  reason: collision with root package name */
    public static final int f1745e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f1746f = "1.0";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1747g = "2fd7d18-clean";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1748h = "15.6.5";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1749i = "h.a.3.6.5";
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
