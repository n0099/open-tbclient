package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.alibaba.fastjson.asm.Label;
import com.baidu.fsg.base.router.RouterCallback;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AppUtils {
    public static boolean mIsHideInstallComplete = true;

    /* loaded from: classes2.dex */
    public static class ApkInfo {
        public final String appName = "";
        public PackageInfo mPackageInfo;
        public final String packageName;
        public final int versionCode;
        public final String versionName;

        public ApkInfo(Context context, PackageInfo packageInfo) {
            this.mPackageInfo = packageInfo;
            this.packageName = packageInfo.packageName;
            this.versionName = packageInfo.versionName;
            this.versionCode = packageInfo.versionCode;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", this.packageName);
                jSONObject.put("v", this.versionName);
                jSONObject.put("c", this.versionCode);
                jSONObject.put("s", new File(this.mPackageInfo.applicationInfo.sourceDir).lastModified());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public JSONObject toRecentJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", this.packageName);
                jSONObject.put("v", this.versionName);
                jSONObject.put("c", this.versionCode);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static Class<?> getActivityClass() {
        Object obj = null;
        try {
            obj = ReflectionUtils.invoke(Class.forName(IReflectionInfo.APP_ACTIVITY), null, "getActivityClass", null, null);
        } catch (Exception unused) {
            RemoteXAdLogger.getInstance().d("TAG", "getActivityClass exception.");
        }
        if (obj == null) {
            try {
                return Class.forName(IReflectionInfo.APP_ACTIVITY);
            } catch (ClassNotFoundException unused2) {
                RemoteXAdLogger.getInstance().d("TAG", "getActivityClass ClassNotFoundException.");
            }
        }
        return (Class) obj;
    }

    public static String getAppPackage(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static Intent getInstallIntent(Context context, String str) {
        try {
            return getInstallIntent(context, new File(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ApkInfo getLocalApkFileInfo(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return new ApkInfo(context, packageArchiveInfo);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class<?> getShellActivityClass() {
        Object obj = null;
        try {
            obj = ReflectionUtils.invoke(Class.forName(IReflectionInfo.BD_SHELL_ACTIVITY), null, "getActivityClass", null, null);
        } catch (Exception unused) {
            RemoteXAdLogger.getInstance().d("TAG", "getShellActivityClass exception.");
        }
        if (obj == null) {
            try {
                return Class.forName(IReflectionInfo.BD_SHELL_ACTIVITY);
            } catch (ClassNotFoundException unused2) {
                RemoteXAdLogger.getInstance().d("TAG", "getShellActivityClass ClassNotFoundException.");
            }
        }
        return (Class) obj;
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        Class<? super Object> cls;
        Object obj = null;
        try {
            try {
                cls = Class.forName(IReflectionInfo.DOWNLOAD_FILEPROVIDER).getSuperclass();
            } catch (Throwable unused) {
                RemoteXAdLogger.getInstance().d("TAG", "getUriForFile exception.");
            }
        } catch (ClassNotFoundException unused2) {
            cls = null;
        }
        obj = ReflectionUtils.invoke(cls, null, "getUriForFile", new Class[]{Context.class, String.class, File.class}, new Object[]{context, str, file});
        return (Uri) obj;
    }

    public static Uri getUriForFileByProvider(Context context, File file) {
        try {
            return getUriForFile(context, context.getPackageName() + ".bd.provider", file);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void installApp(Context context, File file) {
        try {
            context.startActivity(getInstallIntent(context, file));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x0001, B:4:0x0011, B:6:0x0017, B:8:0x0029, B:10:0x002d), top: B:17:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isForeground(Context context, String str) {
        try {
        } catch (Exception unused) {
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            String str2 = runningAppProcessInfo.processName;
            int myPid = Process.myPid();
            if (str2.equals(str) || runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
            while (r4.hasNext()) {
            }
        }
    }

    public static boolean isHideInstallComplete() {
        return mIsHideInstallComplete;
    }

    public static boolean isSystemPackage(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    public static boolean needProviderForDl(Context context) {
        return Build.VERSION.SDK_INT >= 24 && getTargetSdkVersion(context) >= 24;
    }

    public static void openApp(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(launchIntentForPackage);
        } catch (Exception unused) {
        }
    }

    public static boolean supportDl(Context context) {
        if (context == null) {
            return false;
        }
        if (needProviderForDl(context) && !supportInstallApkFromPublicSdPath(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                if (supportInstallApk(context, SdcardUtils.getApkDlPath(externalFilesDir.getPath()))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean supportInstallApk(Context context, String str) {
        if (needProviderForDl(context)) {
            try {
                File file = new File(str + "t");
                if (!file.exists()) {
                    file.mkdir();
                }
                return getUriForFileByProvider(context, file) != null;
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
                return false;
            }
        }
        return true;
    }

    public static boolean supportInstallApkFromPublicSdPath(Context context) {
        File externalStorageDirectory;
        return Build.VERSION.SDK_INT <= 28 && PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && PermissionUtils.hasPermission("permission_storage") && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && supportInstallApk(context, SdcardUtils.getApkDlPath(externalStorageDirectory.getPath()));
    }

    public static Intent getInstallIntent(Context context, File file) {
        Uri uriForFileByProvider;
        if (file != null) {
            try {
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    if (!needProviderForDl(context)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        uriForFileByProvider = Uri.fromFile(file);
                    } else {
                        intent.addFlags(RouterCallback.CODE_ERROR);
                        uriForFileByProvider = getUriForFileByProvider(context, file);
                    }
                    if (uriForFileByProvider == null) {
                        return null;
                    }
                    intent.setDataAndType(uriForFileByProvider, "application/vnd.android.package-archive");
                    if (isHideInstallComplete()) {
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    return intent;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static void installApp(Context context, String str) {
        try {
            context.startActivity(getInstallIntent(context, str));
        } catch (Exception unused) {
        }
    }
}
