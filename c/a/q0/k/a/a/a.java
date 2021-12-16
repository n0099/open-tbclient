package c.a.q0.k.a.a;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f10848b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10849c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2129189244, "Lc/a/q0/k/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2129189244, "Lc/a/q0/k/a/a/a;");
        }
    }

    public static boolean a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            if (!f10849c) {
                e();
            }
            Method method = f10848b;
            if (method == null) {
                return false;
            }
            try {
                method.invoke(a, strArr);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String replaceAll = str.replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "/");
            if (replaceAll.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                return replaceAll;
            }
            return "L" + replaceAll + ";";
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            if (f()) {
                if (cls == null) {
                    return false;
                }
                return a(b(cls.getName()));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr)) == null) {
            if (f()) {
                if (strArr == null || strArr.length <= 0) {
                    return false;
                }
                return a(strArr);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (a.class) {
                if (f10849c) {
                    return;
                }
                try {
                    f10849c = true;
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    Method b2 = b.b(cls, "getRuntime", new Class[0]);
                    if (b2 != null) {
                        b2.setAccessible(true);
                        Object invoke = b2.invoke(null, new Object[0]);
                        a = invoke;
                        if (invoke != null) {
                            Method b3 = b.b(cls, "setHiddenApiExemptions", String[].class);
                            f10848b = b3;
                            if (b3 != null) {
                                b3.setAccessible(true);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.VERSION.SDK_INT >= 28 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT > 29 : invokeV.booleanValue;
    }
}
