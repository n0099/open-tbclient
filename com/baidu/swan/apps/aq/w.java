package com.baidu.swan.apps.aq;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class w {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void cp(Context context) {
        if (context != null) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                cs(context);
                return;
            }
            String lowerCase = str.toLowerCase();
            if (DEBUG) {
                Log.d("SwanAppPermissionHelper", "goPermissionPage : " + lowerCase);
            }
            if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_XIAOMI)) {
                cq(context);
            } else if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_MEIZU)) {
                cr(context);
            } else {
                Map<String, ComponentName> auF = auF();
                if (auF.containsKey(lowerCase)) {
                    a(context, auF.get(lowerCase));
                    return;
                }
                Map<String, String> auG = auG();
                if (auG.containsKey(lowerCase)) {
                    X(context, auG.get(lowerCase));
                } else {
                    cs(context);
                }
            }
        }
    }

    private static Map<String, ComponentName> auF() {
        HashMap hashMap = new HashMap();
        hashMap.put(RomUtils.MANUFACTURER_HUAWEI, new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        hashMap.put("letv", new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
        hashMap.put("lg", new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
        hashMap.put("sony", new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
        return hashMap;
    }

    private static Map<String, String> auG() {
        HashMap hashMap = new HashMap();
        hashMap.put(RomUtils.MANUFACTURER_OPPO, "com.coloros.safecenter");
        hashMap.put(RomUtils.MANUFACTURER_VIVO, "com.bairenkeji.icaller");
        hashMap.put("coolpad", "com.yulong.android.security:remote");
        return hashMap;
    }

    private static void cq(Context context) {
        String auH = auH();
        if (DEBUG) {
            Log.d("SwanAppPermissionHelper", "goPermissionPageForXiaomi rom version : " + auH);
        }
        Intent intent = new Intent();
        if ("V10".equals(auH) || "V9".equals(auH) || "V8".equals(auH)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            e(context, intent);
        } else if ("V7".equals(auH) || "V6".equals(auH)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            e(context, intent);
        } else {
            cs(context);
        }
    }

    private static String auH() {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    str = bufferedReader.readLine();
                    com.baidu.swan.e.d.closeSafely(bufferedReader);
                } catch (IOException e) {
                    e = e;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.e.d.closeSafely(bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.e.d.closeSafely(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.e.d.closeSafely(null);
            throw th;
        }
        return str;
    }

    private static void cr(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            cs(context);
        }
    }

    private static void a(Context context, ComponentName componentName) {
        try {
            Intent intent = new Intent(context.getPackageName());
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            cs(context);
        }
    }

    private static void X(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo == null) {
            cs(context);
            return;
        }
        ResolveInfo e = e(context, packageInfo);
        if (e == null) {
            cs(context);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(e.activityInfo.packageName, e.activityInfo.name));
            context.startActivity(intent);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            cs(context);
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    private static ResolveInfo e(Context context, PackageInfo packageInfo) {
        List<ResolveInfo> list;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        try {
            list = context.getPackageManager().queryIntentActivities(intent, 0);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            list = null;
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    private static void cs(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        e(context, intent);
    }

    private static void e(Context context, Intent intent) {
        if (context == null || intent == null) {
            if (DEBUG) {
                Log.e("SwanAppPermissionHelper", "context or intent is null");
                return;
            }
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Y(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context or permission is null");
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= 23) {
            int i = -1;
            try {
                i = ActivityCompat.checkSelfPermission(context, str);
            } catch (Exception e) {
                if (DEBUG) {
                    throw e;
                }
            }
            return i == 0;
        } else {
            return true;
        }
    }
}
