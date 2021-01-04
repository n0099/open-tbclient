package com.baidu.swan.gamecenter.appmanager.install;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.c.h;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean wE(String str) {
        return ak(str, false);
    }

    public static boolean ak(String str, boolean z) {
        if (DEBUG) {
            Log.e("GameCenterApkUtil", "call installApk filePath = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a(AppRuntime.getAppContext(), new File(str), z);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private static boolean a(Context context, File file, boolean z) {
        if (context == null || file == null || !file.isFile() || !file.exists()) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (DEBUG) {
            Log.e("GameCenterApkUtil", "install apk start");
        }
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
            a(context, file, intent);
            context.startActivity(intent);
            if (DEBUG) {
                Log.e("GameCenterApkUtil", "install apk done");
                return true;
            }
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            intent.setComponent(null);
            a(context, file, intent);
            try {
                context.startActivity(intent);
                if (DEBUG) {
                    Log.e("GameCenterApkUtil", "retry install apk done");
                    return true;
                }
                return true;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
    }

    public static boolean au(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    return context.getPackageManager().getPackageInfo(str, 0) != null;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean aw(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
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
                if (DEBUG) {
                    Log.d("GameCenterApkUtil", "openApp:packageName = " + str);
                }
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static boolean a(Context context, File file, Intent intent) {
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
                    if (resolveInfo != null && resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName != null) {
                        context.grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 1);
                    }
                }
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    throw e;
                }
                return false;
            }
        }
        return true;
    }

    public static void hX(boolean z) {
        h.aPH().edit().putBoolean("install_guide_switch_key", z).apply();
    }

    public static boolean aWZ() {
        return h.aPH().getBoolean("install_guide_switch_key", true);
    }

    public static void aXa() {
        h.aPH().edit().putLong("install_authorize_guide_time_key", System.currentTimeMillis()).apply();
    }

    public static long aXb() {
        return h.aPH().getLong("install_authorize_guide_time_key", 0L);
    }

    public static void aXc() {
        h.aPH().edit().putLong("install_continue_guide_time_key", System.currentTimeMillis()).apply();
    }

    public static long aXd() {
        return h.aPH().getLong("install_continue_guide_time_key", 0L);
    }

    public static boolean wF(String str) {
        return (System.currentTimeMillis() / 86400000) - ((TextUtils.equals(str, "authorize") ? aXb() : aXd()) / 86400000) > 0;
    }

    public static String azi() {
        return (Build.VERSION.SDK_INT < 26 || AppRuntime.getAppContext().getPackageManager().canRequestPackageInstalls()) ? "continue" : "authorize";
    }

    public static boolean wG(String str) {
        return aWZ() && wF(str) && aXe() < aXg();
    }

    public static int aXe() {
        return h.aPH().getInt("install_guide_count_key", 0);
    }

    public static void aXf() {
        h.aPH().edit().putInt("install_guide_count_key", h.aPH().getInt("install_guide_count_key", 0) + 1).apply();
    }

    public static int aXg() {
        return h.aPH().getInt("install_guide_max_count_key", 3);
    }

    public static void mv(int i) {
        if (i > 0) {
            h.aPH().edit().putInt("install_guide_max_count_key", i).apply();
        }
    }
}
