package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static e f43807a;

    /* renamed from: b  reason: collision with root package name */
    public static long f43808b;
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
                if (f43807a != null) {
                    e eVar = f43807a;
                    f43807a = eVar.f43805f;
                    eVar.f43805f = null;
                    f43808b -= 8192;
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
            if (eVar.f43805f == null && eVar.f43806g == null) {
                if (eVar.f43803d) {
                    return;
                }
                synchronized (f.class) {
                    if (f43808b + 8192 > 65536) {
                        return;
                    }
                    f43808b += 8192;
                    eVar.f43805f = f43807a;
                    eVar.f43802c = 0;
                    eVar.f43801b = 0;
                    f43807a = eVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
