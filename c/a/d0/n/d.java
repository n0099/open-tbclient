package c.a.d0.n;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f1880a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f1881b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f1882c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1883d = true;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, th) == null) && f1883d) {
            c(new Throwable().getStackTrace());
            d(str);
        }
    }

    public static void b(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, objArr) == null) && f1883d) {
            c(new Throwable().getStackTrace());
            d(objArr);
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, stackTraceElementArr) == null) {
            f1880a = stackTraceElementArr[1].getFileName();
            f1881b = stackTraceElementArr[1].getMethodName();
            f1882c = stackTraceElementArr[1].getLineNumber();
        }
    }

    public static String d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, objArr)) == null) {
            if (objArr == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            return f(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || !f1883d) {
        }
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            return Thread.currentThread().getName() + PreferencesUtil.LEFT_MOUNT + f1880a + ":" + f1881b + ":" + f1882c + PreferencesUtil.RIGHT_MOUNT + str;
        }
        return (String) invokeL.objValue;
    }
}
