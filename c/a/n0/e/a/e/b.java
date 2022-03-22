package c.a.n0.e.a.e;

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
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public Method f8185b;

    /* renamed from: c  reason: collision with root package name */
    public Method f8186c;

    /* renamed from: d  reason: collision with root package name */
    public Method f8187d;

    /* renamed from: e  reason: collision with root package name */
    public Method f8188e;

    /* renamed from: f  reason: collision with root package name */
    public Method f8189f;

    /* renamed from: g  reason: collision with root package name */
    public Method f8190g;

    /* renamed from: h  reason: collision with root package name */
    public Method f8191h;
    public boolean i;

    public b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    c.a.n0.k.a.a.a.c(obj.getClass());
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
                if (this.i) {
                    return this.f8185b != null;
                }
                try {
                    this.i = true;
                    if (this.f8185b == null) {
                        Method i = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.f8185b = i;
                        if (i != null) {
                            i.setAccessible(true);
                        }
                    }
                } catch (Throwable unused) {
                }
                return this.f8185b != null;
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

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && c()) {
            try {
                if (this.f8189f == null) {
                    Method i2 = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userDisable", Integer.TYPE);
                    this.f8189f = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
                if (this.f8189f != null) {
                    this.f8189f.invoke(this.a, Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) && c()) {
            try {
                if (this.f8188e == null) {
                    Method i3 = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userEnableTimeoutMs", Integer.TYPE, Integer.TYPE);
                    this.f8188e = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f8188e != null) {
                    this.f8188e.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i, i2, i3, i4)) == null) {
            if (c()) {
                try {
                    if (this.f8185b == null) {
                        Method i5 = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.f8185b = i5;
                        if (i5 != null) {
                            i5.setAccessible(true);
                        }
                    }
                    if (this.f8185b == null || (invoke = this.f8185b.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))) == null) {
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
                    if (this.f8186c == null) {
                        Method i = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userRegScn", new Class[0]);
                        this.f8186c = i;
                        if (i != null) {
                            i.setAccessible(true);
                        }
                    }
                    Object invoke = this.f8186c != null ? this.f8186c.invoke(this.a, new Object[0]) : null;
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

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) && c()) {
            try {
                if (this.f8187d == null) {
                    Method i7 = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userRegScnConfig", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                    this.f8187d = i7;
                    if (i7 != null) {
                        i7.setAccessible(true);
                    }
                }
                if (this.f8187d != null) {
                    this.f8187d.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && c()) {
            try {
                if (this.f8190g == null) {
                    Method i2 = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userUnreg", Integer.TYPE);
                    this.f8190g = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
                if (this.f8190g != null) {
                    this.f8190g.invoke(this.a, Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && c()) {
            try {
                if (this.f8191h == null) {
                    Method i2 = c.a.n0.k.a.a.c.a.i(this.a.getClass(), "userUnregScn", Integer.TYPE);
                    this.f8191h = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
                if (this.f8191h != null) {
                    this.f8191h.invoke(this.a, Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
