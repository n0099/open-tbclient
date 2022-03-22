package com.baidu.pass.biometrics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f27876b = "com.baidu.pass.biometrics";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f27877c = "com.baidu.pass.biometrics";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27878d = "release";

    /* renamed from: e  reason: collision with root package name */
    public static final String f27879e = "";

    /* renamed from: f  reason: collision with root package name */
    public static final int f27880f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f27881g = "9.5.5";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
