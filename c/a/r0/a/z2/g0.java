package c.a.r0.a.z2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(837654612, "Lc/a/r0/a/z2/g0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(837654612, "Lc/a/r0/a/z2/g0;");
                return;
            }
        }
        a = c.a.r0.a.z2.c1.a.f10173b;
    }

    @SuppressLint({"PrivateApi", "ObsoleteSdkInt"})
    public static boolean a(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = false;
            boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    i2 = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                } else {
                    i2 = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                }
                if (i2 != 0) {
                    return false;
                }
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
                if (!"1".equals(str)) {
                    z = "0".equals(str) ? true : z2;
                }
                return z;
            } catch (Exception unused) {
                return z2;
            }
        }
        return invokeL.booleanValue;
    }

    public static Pair<Integer, Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Pair<Integer, Integer> d2 = d();
            return new Pair<>(Integer.valueOf(((Integer) d2.first).intValue()), Integer.valueOf(((Integer) d2.second).intValue() - c()));
        }
        return (Pair) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (e()) {
                return n0.r(AppRuntime.getAppContext().getResources(), n0.M() ? "navigation_bar_height" : "navigation_bar_height_landscape");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static Pair<Integer, Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            if (windowManager == null) {
                return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(n0.n(appContext)));
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return (Pair) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (f(appContext)) {
                return false;
            }
            return a(appContext);
        }
        return invokeV.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String str = Build.BRAND;
            try {
                if (TextUtils.isEmpty(str)) {
                    return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
                }
                if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                    return str.equalsIgnoreCase("XIAOMI") ? Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0 : str.equalsIgnoreCase("VIVO") ? Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0 : str.equalsIgnoreCase(a) ? Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0 : str.equalsIgnoreCase(com.kuaishou.weapon.un.g.f57226j) ? Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled", 0) != 0 : Settings.Global.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
                }
                return Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
            } catch (Exception e2) {
                if (c.a.r0.a.k.a) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
