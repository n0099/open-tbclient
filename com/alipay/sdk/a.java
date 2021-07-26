package com.alipay.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1774a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1775b = "com.alipay.sdk";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1776c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1777d = "utdidSec";

    /* renamed from: e  reason: collision with root package name */
    public static final int f1778e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f1779f = "1.0";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1780g = "2fd7d18-clean";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1781h = "15.6.5";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1782i = "h.a.3.6.5";
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
