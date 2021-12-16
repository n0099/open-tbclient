package c.a.q0.h.j.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
import c.a.q0.a.o2.g.h;
import c.a.q0.h.j.b;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1490393776, "Lc/a/q0/h/j/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1490393776, "Lc/a/q0/h/j/o/a;");
                return;
            }
        }
        a = k.a;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? h.a().getLong("install_authorize_guide_time_key", 0L) : invokeV.longValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? h.a().getLong("install_continue_guide_time_key", 0L) : invokeV.longValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Build.VERSION.SDK_INT < 26 || AppRuntime.getAppContext().getPackageManager().canRequestPackageInstalls()) ? "continue" : "authorize" : (String) invokeV.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? h.a().getInt("install_guide_count_key", 0) : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? h.a().getInt("install_guide_max_count_key", 3) : invokeV.intValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? h.a().getBoolean("install_guide_switch_key", false) : invokeV.booleanValue;
    }

    public static boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        return context.getPackageManager().getPackageInfo(str, 0) != null;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, File file, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, context, file, z)) == null) {
            if (context != null && file != null && file.isFile() && file.exists()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                boolean z2 = a;
                try {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(1342177280);
                    intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", context.getPackageName());
                    if (z) {
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    if (Build.VERSION.SDK_INT < 24) {
                        intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
                    }
                    m(context, file, intent);
                    if ((context instanceof Activity) && b.o.D()) {
                        intent.setAction("android.intent.action.INSTALL_PACKAGE");
                        intent.setFlags(0);
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                        if (Build.VERSION.SDK_INT >= 24) {
                            intent.addFlags(1);
                        }
                        ((Activity) context).startActivityForResult(intent, context instanceof InstallActivity ? 1345431 : 0);
                    } else {
                        context.startActivity(intent);
                    }
                    boolean z3 = a;
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    intent.setComponent(null);
                    m(context, file, intent);
                    try {
                        context.startActivity(intent);
                        boolean z4 = a;
                    } catch (Exception e3) {
                        if (a) {
                            e3.printStackTrace();
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean i(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, context, str, z)) == null) {
            if (a) {
                String str2 = "call installApk filePath = " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return h(context, new File(str), z);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? f() && l(str) && d() < e() : invokeL.booleanValue;
    }

    public static boolean k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(str);
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
                    String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                    Intent intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.LAUNCHER");
                    intent2.setComponent(new ComponentName(str, str2));
                    intent2.setFlags(270532608);
                    try {
                        context.startActivity(intent2);
                        if (a) {
                            String str3 = "openApp:packageName = " + str;
                            return true;
                        }
                        return true;
                    } catch (Exception unused) {
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            return (System.currentTimeMillis() / 86400000) - ((TextUtils.equals(str, "authorize") ? a() : b()) / 86400000) > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean m(Context context, File file, Intent intent) {
        InterceptResult invokeLLL;
        ActivityInfo activityInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, context, file, intent)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                    if (uriForFile == null) {
                        return false;
                    }
                    intent.setDataAndType(uriForFile, intent.getType());
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    if (queryIntentActivities == null) {
                        return true;
                    }
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null) {
                            context.grantUriPermission(str, uriForFile, 1);
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    if (a) {
                        throw e2;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            h.a().edit().putLong("install_authorize_guide_time_key", System.currentTimeMillis()).apply();
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            h.a().edit().putLong("install_continue_guide_time_key", System.currentTimeMillis()).apply();
        }
    }

    public static void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            h.a().edit().putBoolean("install_guide_switch_key", z).apply();
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            h.a().edit().putInt("install_guide_count_key", h.a().getInt("install_guide_count_key", 0) + 1).apply();
        }
    }
}
