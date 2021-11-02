package com.baidu.sapi2.biometrics.liveness;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42599a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f42600b = "com.baidu.sapi2.biometrics.liveness";

    /* renamed from: c  reason: collision with root package name */
    public static final String f42601c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f42602d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final int f42603e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f42604f = "1.0";
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
