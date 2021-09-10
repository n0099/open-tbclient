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
    public static e f45153a;

    /* renamed from: b  reason: collision with root package name */
    public static long f45154b;
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
                if (f45153a != null) {
                    e eVar = f45153a;
                    f45153a = eVar.f45151f;
                    eVar.f45151f = null;
                    f45154b -= 8192;
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
            if (eVar.f45151f == null && eVar.f45152g == null) {
                if (eVar.f45149d) {
                    return;
                }
                synchronized (f.class) {
                    if (f45154b + 8192 > 65536) {
                        return;
                    }
                    f45154b += 8192;
                    eVar.f45151f = f45153a;
                    eVar.f45148c = 0;
                    eVar.f45147b = 0;
                    f45153a = eVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
