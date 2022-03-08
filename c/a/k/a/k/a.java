package c.a.k.a.k;

import android.os.Build;
import android.view.View;
import com.baidu.browser.core.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1331013482, "Lc/a/k/a/k/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1331013482, "Lc/a/k/a/k/a;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception e2) {
                BdLog.g(a, "get hasSmartBar method Exception ", e2);
                if (Build.DEVICE.equals("mx2")) {
                    return true;
                }
                if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, view) == null) && a()) {
            try {
                Method method = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
                Object[] objArr = new Object[1];
                try {
                    objArr[0] = View.class.getField("SYSTEM_UI_FLAG_HIDE_NAVIGATION").get(null);
                } catch (Exception e2) {
                    BdLog.g(a, "get SYSTEM_UI_FLAG_HIDE_NAVIGATION Exception ", e2);
                }
                method.invoke(view, objArr);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 16 || !Build.PRODUCT.toLowerCase(Locale.getDefault()).contains("meizu")) {
                    return false;
                }
                if (!Build.VERSION.INCREMENTAL.toLowerCase(Locale.getDefault()).contains("flyme_2") && !Build.VERSION.INCREMENTAL.toLowerCase(Locale.getDefault()).contains("flyme_os_3")) {
                    if (!Build.VERSION.INCREMENTAL.toLowerCase(Locale.getDefault()).contains("flyme_os_4")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                BdLog.g(a, "Initialize Exception", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
