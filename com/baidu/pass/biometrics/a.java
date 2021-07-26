package com.baidu.pass.biometrics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9089a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f9090b = "com.baidu.pass.biometrics";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f9091c = "com.baidu.pass.biometrics";

    /* renamed from: d  reason: collision with root package name */
    public static final String f9092d = "release";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9093e = "";

    /* renamed from: f  reason: collision with root package name */
    public static final int f9094f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f9095g = "9.3.7.1";
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
