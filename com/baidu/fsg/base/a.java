package com.baidu.fsg.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39295a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f39296b = "com.baidu.fsg.base";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39297c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39298d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final int f39299e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f39300f = "1.0";

    /* renamed from: g  reason: collision with root package name */
    public static final String f39301g = "";

    /* renamed from: h  reason: collision with root package name */
    public static final String f39302h = "BgAAAA";

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f39303i = true;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f39304j = true;
    public static final String k = "2.0.2.0";
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
