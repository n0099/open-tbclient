package c.a.s0.a.z2;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, String> f10179b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-959302513, "Lc/a/s0/a/z2/a0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-959302513, "Lc/a/s0/a/z2/a0;");
                return;
            }
        }
        a = c.a.s0.a.k.a;
        HashMap hashMap = new HashMap(14);
        f10179b = hashMap;
        hashMap.put(com.kuaishou.weapon.un.s.f55458g, "定位");
        f10179b.put(com.kuaishou.weapon.un.s.f55459h, "定位");
        f10179b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, "录音");
        f10179b.put("android.permission.READ_CONTACTS", "读取联系人");
        f10179b.put("android.permission.ACCESS_NETWORK_STATE", "访问网络状态");
        f10179b.put("android.permission.REORDER_TASKS", "开机自启");
        f10179b.put(com.kuaishou.weapon.un.s.a, "网络");
        f10179b.put("android.permission.REQUEST_INSTALL_PACKAGES", "安装软件包");
        f10179b.put("android.permission.READ_CALENDAR", "读取日历");
        f10179b.put("android.permission.WRITE_CALENDAR", "写入日历");
        f10179b.put("android.permission.WRITE_EXTERNAL_STORAGE", "存储");
        f10179b.put(com.kuaishou.weapon.un.s.f55460i, "存储");
        f10179b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, "相机");
        f10179b.put("android.permission.WRITE_SETTINGS", "系统设置");
        f10179b.put("android.permission.SYSTEM_ALERT_WINDOW", "悬浮窗");
    }

    public static Map<String, ComponentName> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(RomUtils.MANUFACTURER_HUAWEI, new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            hashMap.put("letv", new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
            hashMap.put("lg", new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            hashMap.put("sony", new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(c.a.s0.a.z2.c1.a.a, "com.coloros.safecenter");
            hashMap.put(RomUtils.MANUFACTURER_VIVO, "com.bairenkeji.icaller");
            hashMap.put("coolpad", "com.yulong.android.security:remote");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    c.a.s0.w.d.d(bufferedReader);
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    if (a) {
                        e.printStackTrace();
                    }
                    c.a.s0.w.d.d(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                c.a.s0.w.d.d(bufferedReader2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            c.a.s0.w.d.d(bufferedReader2);
            throw th;
        }
    }

    public static PackageInfo d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static ResolveInfo e(Context context, PackageInfo packageInfo) {
        InterceptResult invokeLL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, packageInfo)) == null) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            try {
                list = context.getPackageManager().queryIntentActivities(intent, 0);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                list = null;
            }
            if (list == null || list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            startActivity(context, intent);
        }
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, context) == null) || context == null) {
            return;
        }
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            f(context);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (a) {
            String str2 = "goPermissionPage : " + lowerCase;
        }
        if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_XIAOMI)) {
            i(context);
        } else if (TextUtils.equals(lowerCase, "meizu")) {
            h(context);
        } else {
            Map<String, ComponentName> a2 = a();
            if (a2.containsKey(lowerCase)) {
                k(context, a2.get(lowerCase));
                return;
            }
            Map<String, String> b2 = b();
            if (b2.containsKey(lowerCase)) {
                l(context, b2.get(lowerCase));
            } else {
                f(context);
            }
        }
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            try {
                Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("packageName", context.getPackageName());
                context.startActivity(intent);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            String c2 = c();
            if (a) {
                String str = "goPermissionPageForXiaomi rom version : " + c2;
            }
            Intent intent = new Intent();
            if (!"V10".equals(c2) && !"V9".equals(c2) && !"V8".equals(c2)) {
                if (!"V7".equals(c2) && !"V6".equals(c2)) {
                    f(context);
                    return;
                }
                intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent.putExtra("extra_pkgname", context.getPackageName());
                startActivity(context, intent);
                return;
            }
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            startActivity(context, intent);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT < 23) {
                    return true;
                }
                int i2 = -1;
                try {
                    i2 = ContextCompat.checkSelfPermission(context, str);
                } catch (Exception e2) {
                    if (a) {
                        throw e2;
                    }
                }
                return i2 == 0;
            } else if (a) {
                throw new IllegalArgumentException("context or permission is null");
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void k(Context context, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, componentName) == null) {
            try {
                Intent intent = new Intent(context.getPackageName());
                intent.setComponent(componentName);
                context.startActivity(intent);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static void l(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            PackageInfo d2 = d(context, str);
            if (d2 == null) {
                f(context);
                return;
            }
            ResolveInfo e2 = e(context, d2);
            if (e2 == null) {
                f(context);
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(e2.activityInfo.packageName, e2.activityInfo.name));
                context.startActivity(intent);
            } catch (Exception e3) {
                if (a) {
                    e3.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            String str2 = f10179b.get(str);
            return str2 == null ? "" : str2;
        }
        return (String) invokeL.objValue;
    }

    public static void startActivity(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, intent) == null) {
            if (context != null && intent != null) {
                try {
                    context.startActivity(intent);
                    return;
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            boolean z = a;
        }
    }
}
