package c.a.e0.i;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f2805b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f2806c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2807d = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(712249655, "Lc/a/e0/i/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(712249655, "Lc/a/e0/i/h;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return Thread.currentThread().getName() + PreferencesUtil.LEFT_MOUNT + a + ":" + f2805b + ":" + f2806c + PreferencesUtil.RIGHT_MOUNT + str;
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && f2807d) {
            Log.d("CashierSdk", str);
        }
    }

    public static void c(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, th) == null) && f2807d) {
            e(new Throwable().getStackTrace());
            Log.e("CashierSdk", f(str), th);
        }
    }

    public static void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr) == null) && f2807d) {
            e(new Throwable().getStackTrace());
            Log.e("CashierSdk", f(objArr));
        }
    }

    public static void e(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, stackTraceElementArr) == null) {
            a = stackTraceElementArr[1].getFileName();
            f2805b = stackTraceElementArr[1].getMethodName();
            f2806c = stackTraceElementArr[1].getLineNumber();
        }
    }

    public static String f(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, objArr)) == null) {
            if (objArr == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            return a(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, str) == null) && f2807d) {
            Log.i("CashierSdk", str);
        }
    }
}
