package b.a.p0.e.a.e;

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

    /* renamed from: a  reason: collision with root package name */
    public final Object f10227a;

    /* renamed from: b  reason: collision with root package name */
    public Method f10228b;

    /* renamed from: c  reason: collision with root package name */
    public Method f10229c;

    /* renamed from: d  reason: collision with root package name */
    public Method f10230d;

    /* renamed from: e  reason: collision with root package name */
    public Method f10231e;

    /* renamed from: f  reason: collision with root package name */
    public Method f10232f;

    /* renamed from: g  reason: collision with root package name */
    public Method f10233g;

    /* renamed from: h  reason: collision with root package name */
    public Method f10234h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10235i;

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
        this.f10227a = obj;
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
                    b.a.p0.k.a.a.a.c(obj.getClass());
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
                if (this.f10235i) {
                    return this.f10228b != null;
                }
                try {
                    this.f10235i = true;
                    if (this.f10228b == null) {
                        Method i2 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.f10228b = i2;
                        if (i2 != null) {
                            i2.setAccessible(true);
                        }
                    }
                } catch (Throwable unused) {
                }
                return this.f10228b != null;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10227a != null : invokeV.booleanValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && c()) {
            try {
                if (this.f10232f == null) {
                    Method i3 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userDisable", Integer.TYPE);
                    this.f10232f = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f10232f != null) {
                    this.f10232f.invoke(this.f10227a, Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) && c()) {
            try {
                if (this.f10231e == null) {
                    Method i4 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userEnableTimeoutMs", Integer.TYPE, Integer.TYPE);
                    this.f10231e = i4;
                    if (i4 != null) {
                        i4.setAccessible(true);
                    }
                }
                if (this.f10231e != null) {
                    this.f10231e.invoke(this.f10227a, Integer.valueOf(i2), Integer.valueOf(i3));
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
                    if (this.f10228b == null) {
                        Method i6 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userRegBigLittle", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                        this.f10228b = i6;
                        if (i6 != null) {
                            i6.setAccessible(true);
                        }
                    }
                    if (this.f10228b == null || (invoke = this.f10228b.invoke(this.f10227a, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5))) == null) {
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
                    if (this.f10229c == null) {
                        Method i2 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userRegScn", new Class[0]);
                        this.f10229c = i2;
                        if (i2 != null) {
                            i2.setAccessible(true);
                        }
                    }
                    Object invoke = this.f10229c != null ? this.f10229c.invoke(this.f10227a, new Object[0]) : null;
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
                if (this.f10230d == null) {
                    Method i8 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userRegScnConfig", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                    this.f10230d = i8;
                    if (i8 != null) {
                        i8.setAccessible(true);
                    }
                }
                if (this.f10230d != null) {
                    this.f10230d.invoke(this.f10227a, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && c()) {
            try {
                if (this.f10233g == null) {
                    Method i3 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userUnreg", Integer.TYPE);
                    this.f10233g = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f10233g != null) {
                    this.f10233g.invoke(this.f10227a, Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && c()) {
            try {
                if (this.f10234h == null) {
                    Method i3 = b.a.p0.k.a.a.c.a.i(this.f10227a.getClass(), "userUnregScn", Integer.TYPE);
                    this.f10234h = i3;
                    if (i3 != null) {
                        i3.setAccessible(true);
                    }
                }
                if (this.f10234h != null) {
                    this.f10234h.invoke(this.f10227a, Integer.valueOf(i2));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
