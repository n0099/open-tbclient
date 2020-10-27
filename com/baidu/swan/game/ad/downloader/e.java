package com.baidu.swan.game.ad.downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ak;
import java.io.File;
import java.util.List;
/* loaded from: classes14.dex */
public class e {
    public static boolean aj(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a(AppRuntime.getAppContext(), new File(str), z);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean a(Context context, File file, boolean z) {
        if (context == null || file == null || !file.isFile() || !file.exists()) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(1342177280);
            intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", context.getPackageName());
            if (z) {
                intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            if (!com.baidu.swan.apps.ap.c.hasNougat()) {
                intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
            }
            processFileUriIntent(context, file, intent);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            intent.setComponent(null);
            processFileUriIntent(context, file, intent);
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    private static boolean processFileUriIntent(Context context, File file, Intent intent) {
        Uri uriForFile;
        if (com.baidu.swan.apps.ap.c.hasNougat()) {
            try {
                if (ak.aKA()) {
                    uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                } else {
                    uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".swan.fileprovider", file);
                }
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
                return false;
            }
        }
        return true;
    }

    public static boolean am(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    context.getPackageManager().getPackageInfo(str, 0);
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static String an(Context context, @NonNull String str) {
        PackageInfo packageArchiveInfo;
        File file = new File(str);
        if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) == null) {
            return "";
        }
        return packageArchiveInfo.packageName;
    }
}
