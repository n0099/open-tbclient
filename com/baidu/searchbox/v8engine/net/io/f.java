package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static e a;

    /* renamed from: b  reason: collision with root package name */
    public static long f38978b;
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
                if (a != null) {
                    e eVar = a;
                    a = eVar.f38976f;
                    eVar.f38976f = null;
                    f38978b -= 8192;
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
            if (eVar.f38976f == null && eVar.f38977g == null) {
                if (eVar.f38974d) {
                    return;
                }
                synchronized (f.class) {
                    if (f38978b + 8192 > 65536) {
                        return;
                    }
                    f38978b += 8192;
                    eVar.f38976f = a;
                    eVar.f38973c = 0;
                    eVar.f38972b = 0;
                    a = eVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
