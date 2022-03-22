package c.a.n0.e.a.g;

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
    public static final String[] f8202d;
    public transient /* synthetic */ FieldHolder $fh;
    public Method a;

    /* renamed from: b  reason: collision with root package name */
    public Method f8203b;

    /* renamed from: c  reason: collision with root package name */
    public Object f8204c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394916192, "Lc/a/n0/e/a/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1394916192, "Lc/a/n0/e/a/g/b;");
                return;
            }
        }
        f8202d = new String[]{"android.util.BoostFramework", "com.qualcomm.qti.Performance", "org.codeaurora.Performance"};
    }

    public b(Class<?> cls, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            this.f8204c = a(context, cls);
            Method i3 = c.a.n0.k.a.a.c.a.i(cls, "perfLockAcquire", Integer.TYPE, int[].class);
            this.a = i3;
            if (i3 != null) {
                i3.setAccessible(true);
            }
            Method i4 = c.a.n0.k.a.a.c.a.i(cls, "perfLockRelease", new Class[0]);
            this.f8203b = i4;
            if (i4 != null) {
                i4.setAccessible(true);
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
                    c.a.n0.k.a.a.a.c(cls);
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
            String[] strArr = f8202d;
            for (int i = 0; i < strArr.length; i++) {
                try {
                    return c.a.n0.k.a.a.c.a.a(strArr[i]);
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
                Constructor c2 = c.a.n0.k.a.a.c.a.c(cls, Context.class);
                if (c2 != null) {
                    obj = c2.newInstance(context);
                }
            } catch (Throwable unused) {
            }
            if (obj == null) {
                try {
                    return c.a.n0.k.a.a.c.a.m(cls);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f8204c == null || this.a == null || this.f8203b == null) ? false : true : invokeV.booleanValue;
    }

    public int e(int i, int... iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, iArr)) == null) {
            if (c()) {
                try {
                    Object invoke = this.a.invoke(this.f8204c, Integer.valueOf(i), iArr);
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
                    Object invoke = this.f8203b.invoke(this.f8204c, new Object[0]);
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
