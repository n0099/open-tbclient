package c.a.r0.e.a.e;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public Method f10451b;

    /* renamed from: c  reason: collision with root package name */
    public Method f10452c;

    /* renamed from: d  reason: collision with root package name */
    public Method f10453d;

    /* renamed from: e  reason: collision with root package name */
    public Method f10454e;

    /* renamed from: f  reason: collision with root package name */
    public Method f10455f;

    /* renamed from: g  reason: collision with root package name */
    public Method f10456g;

    /* renamed from: h  reason: collision with root package name */
    public Method f10457h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10458i;

    public b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = obj;
    }

    @SuppressLint({"WrongConstant"})
    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Object obj = null;
            try {
                obj = context.getSystemService("mtk-perfservice");
                if (obj != null) {
                    c.a.r0.k.a.a.a.c(obj.getClass());
                }
            } catch (Throwable unused) {
            }
            return new b(obj);
        }
        return (b) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c()) {
                if (this.f10458i) {
                    return this.f10451b != null;
                }
                try {
                    this.f10458i = true;
                    if (this.f10451b == null) {
                        Method i2 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.f10451b = i2;
                        if (i2 != null) {
                            i2.setAccessible(true);
                        }
                    }
                } catch (Throwable unused) {
                }
                return this.f10451b != null;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && c()) {
            try {
                if (this.f10455f == null) {
                    Method i3 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userDisable", Integer.TYPE);
                    this.f10455f = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f10455f != null) {
                    this.f10455f.invoke(this.a, Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) && c()) {
            try {
                if (this.f10454e == null) {
                    Method i4 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userEnableTimeoutMs", Integer.TYPE, Integer.TYPE);
                    this.f10454e = i4;
                    if (i4 != null) {
                        i4.setAccessible(true);
                    }
                }
                if (this.f10454e != null) {
                    this.f10454e.invoke(this.a, Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int f(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i2, i3, i4, i5)) == null) {
            if (c()) {
                try {
                    if (this.f10451b == null) {
                        Method i6 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.f10451b = i6;
                        if (i6 != null) {
                            i6.setAccessible(true);
                        }
                    }
                    if (this.f10451b == null || (invoke = this.f10451b.invoke(this.a, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5))) == null) {
                        return -1;
                    }
                    return ((Integer) invoke).intValue();
                } catch (Throwable unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeIIII.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (c()) {
                try {
                    if (this.f10452c == null) {
                        Method i2 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userRegScn", new Class[0]);
                        this.f10452c = i2;
                        if (i2 != null) {
                            i2.setAccessible(true);
                        }
                    }
                    Object invoke = this.f10452c != null ? this.f10452c.invoke(this.a, new Object[0]) : null;
                    if (invoke != null) {
                        return ((Integer) invoke).intValue();
                    }
                } catch (Throwable unused) {
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void h(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) && c()) {
            try {
                if (this.f10453d == null) {
                    Method i8 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userRegScnConfig", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                    this.f10453d = i8;
                    if (i8 != null) {
                        i8.setAccessible(true);
                    }
                }
                if (this.f10453d != null) {
                    this.f10453d.invoke(this.a, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && c()) {
            try {
                if (this.f10456g == null) {
                    Method i3 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userUnreg", Integer.TYPE);
                    this.f10456g = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f10456g != null) {
                    this.f10456g.invoke(this.a, Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && c()) {
            try {
                if (this.f10457h == null) {
                    Method i3 = c.a.r0.k.a.a.c.a.i(this.a.getClass(), "userUnregScn", Integer.TYPE);
                    this.f10457h = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f10457h != null) {
                    this.f10457h.invoke(this.a, Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
