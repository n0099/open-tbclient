package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static e f45127a;

    /* renamed from: b  reason: collision with root package name */
    public static long f45128b;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (f.class) {
                if (f45127a != null) {
                    e eVar = f45127a;
                    f45127a = eVar.f45125f;
                    eVar.f45125f = null;
                    f45128b -= 8192;
                    return eVar;
                }
                return new e();
            }
        }
        return (e) invokeV.objValue;
    }

    public static void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eVar) == null) {
            if (eVar.f45125f == null && eVar.f45126g == null) {
                if (eVar.f45123d) {
                    return;
                }
                synchronized (f.class) {
                    if (f45128b + 8192 > 65536) {
                        return;
                    }
                    f45128b += 8192;
                    eVar.f45125f = f45127a;
                    eVar.f45122c = 0;
                    eVar.f45121b = 0;
                    f45127a = eVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
