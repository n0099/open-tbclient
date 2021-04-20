package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.components.monitor.RemoteInstallApkTask;
import com.baidu.mobads.container.components.monitor.RemoteScheduledMonitor;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdDownloadApkUtils {
    public static final String DL_STATUS_DONE = "DONE";
    public static final String DL_STATUS_DOWNLOADED = "DOWNLOADED";
    public static final String DL_STATUS_DOWNLOADING = "DOWNLOADING";
    public static final String DL_STATUS_DOWNLOAD_FAILED = "DOWNLOAD_FAILED";
    public static final String DL_STATUS_INSTALLED = "INSTALLED";
    public static final String DL_STATUS_INSTALLED_BY_OTHER = "INSTALLED_BY_OTHER";
    public static final String DL_STATUS_NONE = "NONE";
    public static final String PKGS_PREF_ACTIVATION = "__sdk_pasys_pkgs_2";
    public static final String PKGS_PREF_DOWNLOAD = "__sdk_remote_dl_2";
    public static final String PKGS_PREF_DOWNLOAD_STATUS = "dl";
    public static final int PREF_DOWNLOADED = 3;
    public static final int PREF_DOWNLOADED_DELETE = 5;
    public static final int PREF_DOWNLOAD_UNKNOWN = -1;
    public static final int PREF_DOWNOADING = 1;
    public static final int PREF_DOWNOAD_CANCELED = 2;
    public static final int PREF_DOWNOAD_FAILED = 4;
    public static final int PREF_LAUNCH_APP = 100;
    public static final int PREF_NOT_DOWNLOAD = 0;
    public static final String TAG = "AdDownloadApkUtils";

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b9, code lost:
        if (java.lang.Math.abs(r9 - r3.length()) >= 2) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getApkDownloadStatus(Context context, String str, String str2) {
        SPUtils sPUtils = new SPUtils(context, PKGS_PREF_ACTIVATION);
        int i = -1;
        if (str != null && !"".equals(str)) {
            boolean z = false;
            try {
                JSONObject optJSONObject = new JSONObject(sPUtils.getString("pkgs", StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                if (optJSONObject != null) {
                    if (optJSONObject.optBoolean("a", false)) {
                        return 100;
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, e2.getMessage());
            }
            try {
                SPUtils sPUtils2 = new SPUtils(context, PKGS_PREF_DOWNLOAD);
                JSONObject jSONObject = new JSONObject(sPUtils2.getString(str + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + XAdRemoteAPKDownloadExtraInfo.getCurrentProcName(), StringUtil.EMPTY_ARRAY));
                int optInt = jSONObject.optInt("dl", -1);
                try {
                    String optString = jSONObject.optString("filename", null);
                    if (optString != null) {
                        File file = new File(SdcardUtils.getStoragePathForDlApk(context) + optString);
                        if (optInt == 3) {
                            if (file.exists() && file.length() != 0) {
                                long optLong = jSONObject.optLong(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, -1L);
                                if (optLong != -1) {
                                }
                                if (z) {
                                    optInt = 5;
                                    try {
                                        jSONObject.put("dl", 5);
                                        sPUtils2.putString(str, jSONObject.toString());
                                    } catch (Exception e3) {
                                        e = e3;
                                        i = 5;
                                        Log.e(TAG, e.getMessage());
                                        return i;
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        }
                    }
                    return optInt;
                } catch (Exception e4) {
                    e = e4;
                    i = optInt;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return i;
    }

    public static String getApkFileLocalPath(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PKGS_PREF_DOWNLOAD, 0);
            String string = sharedPreferences.getString(str + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + XAdRemoteAPKDownloadExtraInfo.getCurrentProcName(), "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.FOLDER);
                String optString2 = jSONObject.optString("filename");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    return optString + optString2;
                }
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
        return "";
    }

    public static String getStatusStr(Context context, String str, String str2) {
        String str3;
        String str4 = "NONE";
        try {
            int apkDownloadStatus = getApkDownloadStatus(context, str, str2);
            boolean isInstalled = isInstalled(context, str);
            if (apkDownloadStatus == 0 || apkDownloadStatus == 1) {
                if (isInstalled) {
                    return DL_STATUS_INSTALLED_BY_OTHER;
                }
                str3 = DL_STATUS_DOWNLOADING;
                return str3;
            }
            if (apkDownloadStatus != 2) {
                if (apkDownloadStatus == 3) {
                    str3 = isInstalled ? DL_STATUS_INSTALLED : DL_STATUS_DOWNLOADED;
                    return str3;
                } else if (apkDownloadStatus != 4) {
                    if (apkDownloadStatus != 5) {
                        if (apkDownloadStatus == 100) {
                            return DL_STATUS_DONE;
                        }
                        if (isInstalled) {
                            str4 = DL_STATUS_INSTALLED_BY_OTHER;
                        }
                    } else if (isInstalled) {
                        str4 = DL_STATUS_DONE;
                    }
                    return str4;
                }
            }
            if (!isInstalled) {
                str3 = DL_STATUS_DOWNLOAD_FAILED;
                return str3;
            }
            return DL_STATUS_INSTALLED_BY_OTHER;
        } catch (Exception unused) {
            return "NONE";
        }
    }

    public static Uri getUriForFileByProvider(Context context, File file) {
        try {
            return AppUtils.getUriForFile(context, context.getPackageName() + ".bd.provider", file);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void installApkWithLog(Context context, File file, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        try {
            AppUtils.installApp(context, file);
            RemoteScheduledMonitor remoteScheduledMonitor = RemoteScheduledMonitor.getInstance();
            remoteScheduledMonitor.addTask(new RemoteInstallApkTask(context, xAdRemoteAPKDownloadExtraInfo));
            remoteScheduledMonitor.startMonitor();
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(th);
        }
    }

    public static void installApp(Context context, String str, File file, boolean z) {
        try {
            AppUtils.installApp(context, file);
            if (!z || str == null || str == null || str.equals("")) {
                return;
            }
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = new XAdRemoteAPKDownloadExtraInfo(str, "");
            xAdRemoteAPKDownloadExtraInfo.autoOpen = true;
            InstallReceiver installReceiver = new InstallReceiver(xAdRemoteAPKDownloadExtraInfo);
            IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            context.registerReceiver(installReceiver, intentFilter);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public static boolean isInstalled(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return str.equals(applicationInfo.packageName);
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean needProviderForDl(Context context) {
        return Build.VERSION.SDK_INT >= 24 && AppUtils.getTargetSdkVersion(context) >= 24;
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
}
