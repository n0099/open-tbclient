package com.baidu.swan.b.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.veloce.d;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean nR(String str) {
        return F(str, false);
    }

    public static boolean F(String str, boolean z) {
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
            processFileUriIntent(context, file, intent);
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
            processFileUriIntent(context, file, intent);
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

    public static boolean at(Context context, String str) {
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

    public static boolean au(Context context, String str) {
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

    private static boolean processFileUriIntent(Context context, File file, Intent intent) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Uri uriForFile = FileProvider.getUriForFile(context, dq(context), file);
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

    private static String dq(Context context) {
        return d.auc() ? d.aud() + ".fileprovider" : context.getPackageName() + ".swan.fileprovider";
    }
}
