package c.a.p0.e.a.g;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f9794d;
    public transient /* synthetic */ FieldHolder $fh;
    public Method a;

    /* renamed from: b  reason: collision with root package name */
    public Method f9795b;

    /* renamed from: c  reason: collision with root package name */
    public Object f9796c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2095980770, "Lc/a/p0/e/a/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2095980770, "Lc/a/p0/e/a/g/b;");
                return;
            }
        }
        f9794d = new String[]{"android.util.BoostFramework", "com.qualcomm.qti.Performance", "org.codeaurora.Performance"};
    }

    public b(Class<?> cls, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            this.f9796c = a(context, cls);
            Method i4 = c.a.p0.k.a.a.c.a.i(cls, "perfLockAcquire", Integer.TYPE, int[].class);
            this.a = i4;
            if (i4 != null) {
                i4.setAccessible(true);
            }
            Method i5 = c.a.p0.k.a.a.c.a.i(cls, "perfLockRelease", new Class[0]);
            this.f9795b = i5;
            if (i5 != null) {
                i5.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static b b(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                cls = d();
                try {
                    c.a.p0.k.a.a.a.c(cls);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                cls = null;
            }
            return new b(cls, context);
        }
        return (b) invokeL.objValue;
    }

    public static Class<?> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String[] strArr = f9794d;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    return c.a.p0.k.a.a.c.a.a(strArr[i2]);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Class) invokeV.objValue;
    }

    public final Object a(@Nullable Context context, @NonNull Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cls)) == null) {
            Object obj = null;
            try {
                Constructor c2 = c.a.p0.k.a.a.c.a.c(cls, Context.class);
                if (c2 != null) {
                    obj = c2.newInstance(context);
                }
            } catch (Throwable unused) {
            }
            if (obj == null) {
                try {
                    return c.a.p0.k.a.a.c.a.m(cls);
                } catch (Throwable unused2) {
                    return obj;
                }
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f9796c == null || this.a == null || this.f9795b == null) ? false : true : invokeV.booleanValue;
    }

    public int e(int i2, int... iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, iArr)) == null) {
            if (c()) {
                try {
                    Object invoke = this.a.invoke(this.f9796c, Integer.valueOf(i2), iArr);
                    if (invoke == null) {
                        return -1;
                    }
                    return ((Integer) invoke).intValue();
                } catch (Throwable unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c()) {
                try {
                    Object invoke = this.f9795b.invoke(this.f9796c, new Object[0]);
                    if (invoke == null) {
                        return -1;
                    }
                    return ((Integer) invoke).intValue();
                } catch (Throwable unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
