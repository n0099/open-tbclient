package com.baidu.swan.apps.an;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class r {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void bI(Context context) {
        if (context != null) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                bL(context);
                return;
            }
            String lowerCase = str.toLowerCase();
            if (DEBUG) {
                Log.d("SwanAppPermissionHelper", "goPermissionPage : " + lowerCase);
            }
            if (TextUtils.equals(lowerCase, "xiaomi")) {
                bJ(context);
            } else if (TextUtils.equals(lowerCase, "meizu")) {
                bK(context);
            } else {
                Map<String, ComponentName> Um = Um();
                if (Um.containsKey(lowerCase)) {
                    a(context, Um.get(lowerCase));
                    return;
                }
                Map<String, String> Un = Un();
                if (Un.containsKey(lowerCase)) {
                    V(context, Un.get(lowerCase));
                } else {
                    bL(context);
                }
            }
        }
    }

    private static Map<String, ComponentName> Um() {
        HashMap hashMap = new HashMap();
        hashMap.put("huawei", new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        hashMap.put("letv", new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
        hashMap.put("lg", new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
        hashMap.put("sony", new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
        return hashMap;
    }

    private static Map<String, String> Un() {
        HashMap hashMap = new HashMap();
        hashMap.put("oppo", "com.coloros.safecenter");
        hashMap.put("vivo", "com.bairenkeji.icaller");
        hashMap.put("coolpad", "com.yulong.android.security:remote");
        return hashMap;
    }

    private static void bJ(Context context) {
        String Uo = Uo();
        if (DEBUG) {
            Log.d("SwanAppPermissionHelper", "goPermissionPageForXiaomi rom version : " + Uo);
        }
        Intent intent = new Intent();
        if ("V10".equals(Uo) || "V9".equals(Uo) || "V8".equals(Uo)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            context.startActivity(intent);
        } else if ("V7".equals(Uo) || "V6".equals(Uo)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            context.startActivity(intent);
        } else {
            bL(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String Uo() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            try {
                try {
                    str = bufferedReader.readLine();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            if (DEBUG) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        if (DEBUG) {
                            e4.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
            }
            throw th;
        }
        return str;
    }

    private static void bK(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            bL(context);
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
            bL(context);
        }
    }

    private static void V(Context context, String str) {
        PackageInfo W = W(context, str);
        if (W == null) {
            bL(context);
            return;
        }
        ResolveInfo e = e(context, W);
        if (e == null) {
            bL(context);
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
            bL(context);
        }
    }

    private static PackageInfo W(Context context, String str) {
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

    private static void bL(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
