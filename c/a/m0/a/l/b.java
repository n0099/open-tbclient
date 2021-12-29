package c.a.m0.a.l;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f4536b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231537904, "Lc/a/m0/a/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-231537904, "Lc/a/m0/a/l/b;");
                return;
            }
        }
        a = e.f4537b ? 2 : 4;
        f4536b = null;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4536b == null) {
                synchronized (b.class) {
                    if (f4536b == null) {
                        f4536b = new b();
                    }
                }
            }
            return f4536b;
        }
        return (b) invokeV.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b("BaiduAdCommon", str) : invokeL.intValue;
    }

    public int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (k(3)) {
                try {
                    return Log.d(str, str2);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int c(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th)) == null) {
            if (k(3)) {
                try {
                    return Log.d("BaiduAdCommon", str, th);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) ? c("", th) : invokeL.intValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (k(6)) {
                try {
                    return Log.e("BaiduAdCommon", str);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int f(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, th)) == null) {
            if (k(6)) {
                try {
                    return Log.e("BaiduAdCommon", str, th);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int g(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, th)) == null) ? f("", th) : invokeL.intValue;
    }

    public int h(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, objArr)) == null) {
            if (k(6)) {
                return e(m(objArr));
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (k(4)) {
                try {
                    return Log.i(str, str2);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? l("BaiduAdCommon", i2) : invokeI.booleanValue;
    }

    public boolean l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i2)) == null) ? i2 >= a : invokeLI.booleanValue;
    }

    public final String m(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, objArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(' ');
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
