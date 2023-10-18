package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class aw extends av.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.mobads.sdk.internal.av.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "soul" : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, str2, th}) == null) {
        }
    }

    public aw() {
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

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (av.a aVar : av.b) {
                aVar.a(i, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void b(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.b(th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void c(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.c(th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void d(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.d(th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void e(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.e(th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void f(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.f(th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, th) == null) {
            for (av.a aVar : av.b) {
                aVar.a(i, th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i, Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.a(i, th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.a(i, objArr);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            for (av.a aVar : av.b) {
                aVar.a(obj);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.b(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.c(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.d(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.e(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.f(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.g(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            for (av.a aVar : av.b) {
                aVar.a(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, th) == null) {
            for (av.a aVar : av.b) {
                aVar.b(th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, th) == null) {
            for (av.a aVar : av.b) {
                aVar.c(th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, th) == null) {
            for (av.a aVar : av.b) {
                aVar.d(th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, th) == null) {
            for (av.a aVar : av.b) {
                aVar.e(th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void f(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, th) == null) {
            for (av.a aVar : av.b) {
                aVar.f(th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            for (av.a aVar : av.b) {
                aVar.a(th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void b(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.b(objArr);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void c(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.c(objArr);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.d(objArr);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void e(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.e(objArr);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void f(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.f(objArr);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, th, str) == null) {
            for (av.a aVar : av.b) {
                aVar.a(th, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, objArr) == null) {
            for (av.a aVar : av.b) {
                aVar.a(objArr);
            }
        }
    }
}
