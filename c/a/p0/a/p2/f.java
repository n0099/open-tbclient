package c.a.p0.a.p2;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.Window;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(826454891, "Lc/a/p0/a/p2/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(826454891, "Lc/a/p0/a/p2/f;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, activity) == null) || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(1024);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (~c());
        if (c.a.p0.a.s1.b.a.f7390b) {
            systemUiVisibility |= 5120;
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
    }

    public static void b(Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, activity, dialog) == null) || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || dialog == null || dialog.getWindow() == null || dialog.getWindow().getDecorView() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 5894;
        }
        return invokeV.intValue;
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) ? (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true : invokeL.booleanValue;
    }

    public static void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, activity) == null) || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        Window window = activity.getWindow();
        window.setFlags(1024, 1024);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | c());
    }

    public static void f(Activity activity, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, activity, intent) == null) {
            h(activity, intent, true);
        }
    }

    public static boolean g(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, intent)) == null) ? h(context, intent, false) : invokeLL.booleanValue;
    }

    public static boolean h(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, context, intent, z)) == null) ? i(context, intent, z, true) : invokeLLZ.booleanValue;
    }

    public static boolean i(Context context, Intent intent, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || !(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.swan_app_activity_not_found, 0).show();
                    return false;
                }
                return false;
            } catch (SecurityException unused2) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.swan_app_activity_not_found, 0).show();
                }
                if (a) {
                    String str = "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.";
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            if (a) {
                String str = "tryFinishAndRemoveTask: " + activity;
            }
            if (activity == null || activity.isDestroyed()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.finishAndRemoveTask();
            } else {
                activity.finish();
            }
        }
    }
}
