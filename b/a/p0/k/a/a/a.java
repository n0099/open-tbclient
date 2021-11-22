package b.a.p0.k.a.a;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f11556a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f11557b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f11558c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1839789694, "Lb/a/p0/k/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1839789694, "Lb/a/p0/k/a/a/a;");
        }
    }

    public static boolean a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            if (!f11558c) {
                e();
            }
            Method method = f11557b;
            if (method == null) {
                return false;
            }
            try {
                method.invoke(f11556a, strArr);
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (a.class) {
                if (f11558c) {
                    return;
                }
                try {
                    f11558c = true;
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    Method b2 = b.b(cls, "getRuntime", new Class[0]);
                    if (b2 != null) {
                        b2.setAccessible(true);
                        Object invoke = b2.invoke(null, new Object[0]);
                        f11556a = invoke;
                        if (invoke != null) {
                            Method b3 = b.b(cls, "setHiddenApiExemptions", String[].class);
                            f11557b = b3;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.VERSION.SDK_INT >= 28 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT > 29 : invokeV.booleanValue;
    }
}
