package com.baidu.searchbox.download.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.android.common.logging.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.ExtraInfoModel;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.ad.util.InterceptCallback;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatistic;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.R;
import com.baidu.tieba.mx;
import com.baidu.tieba.w20;
import com.baidu.tieba.y20;
import com.google.android.material.internal.CollapsingTextHelper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ApkUtil {
    public static final String AES_KEY = "1C4272F31A5CB8EA";
    public static final int APK_INFO_COUNT = 4;
    public static final int APK_INFO_NAME = 0;
    public static final int APK_INFO_PKGNAME = 1;
    public static final int APK_INFO_VERCODE = 2;
    public static final int APK_INOF_VERNAME = 3;
    public static final String APK_MIMETYPE = "application/vnd.android.package-archive";
    public static final String DELETE_APK_PACKAGE_SETTINGS = "delete_apk_package";
    public static final String KEY_INSTALLER_PACKAGE_NAME = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    public static final String PACKAGE_INSTALLER = "com.android.packageinstaller";
    public static final String PACKAGE_INSTALLER_ACTIVITY = "com.android.packageinstaller.PackageInstallerActivity";
    public static final String TAG = "ApkUtil";
    public static final int UNINSTALL_TIPS_SHOW_LONG_TIME = 7;
    public static boolean mIsRegisterApkReceiver;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static ConcurrentHashMap<String, String> mInstallPKGMap = new ConcurrentHashMap<>();
    public static final char[] HEXCHAR = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static BroadcastReceiver mAPKBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.download.util.ApkUtil.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (TextUtils.equals(action, PackageChangedReceiver.ACTION_INSTALL)) {
                ApkUtil.afterInstalled(context, schemeSpecificPart);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface IInstallGuideCallback {
        void failed();

        void success();
    }

    public static /* synthetic */ boolean access$700() {
        return enableShowInstallPermissionDialog();
    }

    public static boolean enableShowInstallPermissionDialog() {
        if (BdBoxActivityManager.isForeground() && w20.h()) {
            return true;
        }
        return false;
    }

    public static String getInstallGuideUrl() {
        String searchboxHostForHttps = HostConfig.getSearchboxHostForHttps();
        if (AppConfig.isDebug() && !TextUtils.isEmpty("")) {
            searchboxHostForHttps = "";
        }
        return BaiduIdentityManager.getInstance().appendParam(String.format("%s/searchbox?action=proxy&type=app_install_guide", searchboxHostForHttps), 1);
    }

    public static void afterInstalled(final Context context, final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.util.ApkUtil.6
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3 = "";
                HashMap<String, Long> queryInstalledApk = ApkUtil.queryInstalledApk(context);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    int i = packageInfo.versionCode;
                    str2 = packageInfo.applicationInfo.sourceDir;
                    try {
                        str3 = str + "@" + i;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str2 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("pkg", str);
                    } catch (Exception unused3) {
                    }
                    y20.x("file", DownloadStatisticConstants.UBC_TYPE_FINISH_INSTALL, "other", "auto", "app", jSONObject);
                    ApkUtil.doInstalledCloudStatisticJob(jSONObject.toString());
                } else if (ApkUtil.mInstallPKGMap != null && ApkUtil.mInstallPKGMap.containsKey(str)) {
                    if (queryInstalledApk.containsKey(str3) && ApkUtil.filesEquals((String) ApkUtil.mInstallPKGMap.get(str), str2)) {
                        Long l = queryInstalledApk.get(str3);
                        if (l != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("pkg", str);
                            } catch (Exception unused4) {
                            }
                            y20.x("file", DownloadStatisticConstants.UBC_TYPE_FINISH_INSTALL, "other", "auto", "app", jSONObject2);
                            ApkUtil.doInstalledCloudStatisticJob(l.longValue());
                            ApkUtil.deleteDownload(context, l.longValue());
                            return;
                        }
                        return;
                    }
                    for (Map.Entry<String, Long> entry : queryInstalledApk.entrySet()) {
                        if (entry.getKey().contains(str)) {
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("pkg", str);
                            } catch (Exception unused5) {
                            }
                            y20.x("file", DownloadStatisticConstants.UBC_TYPE_FINISH_INSTALL, "other", "auto", "app", jSONObject3);
                            ApkUtil.doInstallHijackCloudStatisticJob(entry.getValue().longValue());
                            return;
                        }
                    }
                }
            }
        }, "afterInstalled", 2);
    }

    public static void deleteDownload(final Context context, long j) {
        if (PreferenceUtils.getBoolean(DELETE_APK_PACKAGE_SETTINGS, true)) {
            if (DownloadManagerExt.getInstance().needRequestExternalStorage(j)) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.download.util.ApkUtil.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Toast.makeText(context, (int) R.string.auto_deleted_package_no_permission, 1).show();
                        } catch (Exception e) {
                            if (ApkUtil.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            DownloadManagerExt.getInstance().deleteDownloadFile(j);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.download.util.ApkUtil.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(context, (int) R.string.auto_deleted_package, 1).show();
                    } catch (Exception e) {
                        if (ApkUtil.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static boolean filesEquals(String str, String str2) {
        return Arrays.equals(toMd5(str), toMd5(str2));
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static boolean hasInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager() == null) {
                return false;
            }
            context.getPackageManager().getPackageInfo(str, 64);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void installApk(String str, ApkInstallCallBack apkInstallCallBack) {
        installApk(str, false, apkInstallCallBack);
    }

    public static boolean openApp(Context context, String str) {
        openApp(context, "", str, new InterceptCallback() { // from class: com.baidu.searchbox.download.util.ApkUtil.3
            @Override // com.baidu.searchbox.feed.ad.util.InterceptCallback
            public void onResult(boolean z) {
                if (!z) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), (int) R.string.download_no_application_title).setDuration(3).showToast();
                }
            }
        });
        return false;
    }

    public static void doInstallHijackCloudStatisticJob(long j) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        downloadActionModel.mimeType = "apk";
        ApkCloudStatisticsUtils.doApkInstallHijackCloudStatisticJob(downloadActionModel);
    }

    public static void doInstalledCloudStatisticJob(long j) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.mimeType = "apk";
        downloadActionModel.downloadId = j;
        ApkCloudStatisticsUtils.doApkInstalledCloudStatisticJob(downloadActionModel);
    }

    public static String encodeStr(String str) {
        try {
            return AesUtil.encrypt("bdappsearch_2019", str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getApkMd5Signatures(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            Signature[] signatureArr = AppRuntime.getAppContext().getPackageManager().getPackageArchiveInfo(str, 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                return getSignatureString(signatureArr[0]);
            }
        } catch (Throwable th) {
            if (DEBUG) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static boolean ifHideInstallComplete(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new JSONObject(str).optInt(DownloadConstants.HIDE_INSTALL_COMPLETE, 0) != 1) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Deprecated
    public static boolean installApk(String str) {
        return installApk(str, false);
    }

    public static synchronized void registerApkReceiver(Context context) {
        synchronized (ApkUtil.class) {
            if (mIsRegisterApkReceiver) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addDataScheme("package");
            context.getApplicationContext().registerReceiver(mAPKBroadcastReceiver, intentFilter);
            mIsRegisterApkReceiver = true;
        }
    }

    public static boolean canShowUninstalledApkTips() {
        long j = DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_MAX_TIMES, 3L);
        long j2 = DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY_MAX, 2L);
        if (j < 1 || j2 < 1) {
            return false;
        }
        if (DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE, 0L) >= j) {
            if (Math.abs(System.currentTimeMillis() - DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_FIRST_CYCLE, -1L)) < DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE_INTERVAL, 30L) * 86400000) {
                return false;
            }
            saveUninstalledApkTipsData(false);
            return true;
        } else if (DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY, 0L) < j2) {
            return true;
        } else {
            if (Math.abs(System.currentTimeMillis() - DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_LAST, -1L)) <= DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_DAY_INTERVAL, 7L) * 86400000) {
                return false;
            }
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY, 1L);
            return true;
        }
    }

    public static void doInstalledCloudStatisticJob(String str) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.mimeType = "apk";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        downloadActionModel.extraInfo = str;
        ApkCloudStatisticsUtils.doApkInstalledCloudStatisticJob(downloadActionModel);
    }

    public static String getSignatureString(Signature signature) {
        byte[] byteArray = signature.toByteArray();
        try {
            StringBuilder sb = new StringBuilder();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            messageDigest.reset();
            messageDigest.update(byteArray);
            for (byte b : messageDigest.digest()) {
                int i = b & 255;
                if (Integer.toHexString(i).length() == 1) {
                    sb.append("0");
                    sb.append(Integer.toHexString(i));
                } else {
                    sb.append(Integer.toHexString(i));
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            if (!DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static HashMap<String, Long> queryInstalledApk(Context context) {
        ArrayList<CategoryInfoData> queryByCategory = FileDownloader.queryByCategory(context, 3);
        HashMap<String, Long> hashMap = new HashMap<>();
        Iterator<CategoryInfoData> it = queryByCategory.iterator();
        while (it.hasNext()) {
            CategoryInfoData next = it.next();
            String str = next.mExtraInfo;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("package");
                    if (hasInstalled(context, string)) {
                        String string2 = jSONObject.getString("versioncode");
                        hashMap.put(string + "@" + string2, Long.valueOf(next.mId));
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x005d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] toMd5(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        int read;
        try {
            try {
                fileInputStream = FileClassifyHelper.getApkFileInputStream(str);
                if (fileInputStream == null) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return null;
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.reset();
                    byte[] bArr = new byte[102400];
                    do {
                        read = fileInputStream.read(bArr, 0, 102400);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } while (read > 0);
                    byte[] digest = messageDigest.digest();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return digest;
                } catch (Exception e) {
                    e = e;
                    if (AppConfig.isDebug()) {
                        Log.e(TAG, "ApkUtil toMD5 fail" + e);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            if (str != 0) {
            }
            throw th;
        }
    }

    public static String getTitleCutOffWithoutSuffix(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            lastIndexOf = str.length();
        }
        int i = 0;
        int i2 = 0;
        while (i < lastIndexOf) {
            int i3 = 2;
            if (str.charAt(i) <= 127) {
                i3 = 1;
            }
            i2 += i3;
            if (i2 > j) {
                break;
            }
            i++;
        }
        String substring = str.substring(0, i);
        if (i < lastIndexOf) {
            return substring + CollapsingTextHelper.ELLIPSIS_NORMAL;
        }
        return substring;
    }

    public static void showInstallGuide(final String str, String str2) {
        if (DateUtils.isToday(DownloadSharedPrefsUtils.getInstance().getLong(DownloadCenterUtils.SHOW_APK_INSTALL_GUIDE_TIME, 0L))) {
            return;
        }
        if (DownloadSharedPrefsUtils.getInstance().getLong(DownloadCenterUtils.SHOW_APK_INSTALL_GUIDE_NUM, 0L) >= DownloadSharedPrefsUtils.getInstance().getLong(DownloadCenterUtils.SHOW_APK_INSTALL_GUIDE_MAX_NUM, 0L)) {
            return;
        }
        final long j = DownloadSharedPrefsUtils.getInstance().getLong(DownloadCenterUtils.SHOW_APK_INSTALL_GUIDE_INTERVAL, 1000L);
        final long currentTimeMillis = System.currentTimeMillis();
        requestInstallGuide(str2, new IInstallGuideCallback() { // from class: com.baidu.searchbox.download.util.ApkUtil.10
            @Override // com.baidu.searchbox.download.util.ApkUtil.IInstallGuideCallback
            public void failed() {
            }

            @Override // com.baidu.searchbox.download.util.ApkUtil.IInstallGuideCallback
            public void success() {
                if (System.currentTimeMillis() - currentTimeMillis > j) {
                    if (AppConfig.isDebug()) {
                        Log.d(ApkUtil.TAG, "showInstallGuide is out of time");
                        return;
                    }
                    return;
                }
                ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), IDownloadApp.Impl.get().buildDownloadInstallGuideIntent(AppRuntime.getAppContext(), "", "", str));
            }
        });
    }

    public static boolean hasInstalled(Context context, String str, String str2) {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager() == null || (packageInfo = context.getPackageManager().getPackageInfo(str, 128)) == null) {
                return false;
            }
            if (!TextUtils.equals(String.valueOf(packageInfo.versionCode), str2)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void installApk(String str, boolean z, ApkInstallCallBack apkInstallCallBack) {
        if (TextUtils.isEmpty(str)) {
            if (apkInstallCallBack != null) {
                apkInstallCallBack.onResult(false);
                return;
            }
            return;
        }
        try {
            installApk(AppRuntime.getAppContext(), new File(str), "", z, apkInstallCallBack);
        } catch (Exception e) {
            if (apkInstallCallBack != null) {
                apkInstallCallBack.onResult(false);
            }
            if (!AppConfig.isDebug()) {
                return;
            }
            throw new DebugException("installApk ", e);
        }
    }

    public static void installApk(final Context context, final File file, final String str, final boolean z, final ApkInstallCallBack apkInstallCallBack) {
        if (context != null && file != null) {
            try {
                if (!TextUtils.isEmpty(file.getAbsolutePath())) {
                    DownloadHelper.checkExternalStorage(file.getAbsolutePath(), true, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.util.ApkUtil.2
                        @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                        public void onResult(boolean z2) {
                            if (z2) {
                                boolean installApk = ApkUtil.installApk(context, file, str, z);
                                ApkInstallCallBack apkInstallCallBack2 = apkInstallCallBack;
                                if (apkInstallCallBack2 != null) {
                                    apkInstallCallBack2.onResult(installApk);
                                    return;
                                }
                                return;
                            }
                            ApkInstallCallBack apkInstallCallBack3 = apkInstallCallBack;
                            if (apkInstallCallBack3 != null) {
                                apkInstallCallBack3.onResult(false);
                            }
                        }
                    }, true);
                    return;
                }
            } catch (Exception unused) {
                if (apkInstallCallBack != null) {
                    apkInstallCallBack.onResult(false);
                    return;
                }
                return;
            }
        }
        if (apkInstallCallBack != null) {
            apkInstallCallBack.onResult(false);
        }
    }

    public static void installApk(Context context, String str, Uri uri, ApkInstallCallBack apkInstallCallBack) {
        installApk(context, str, uri, false, apkInstallCallBack);
    }

    public static void openApp(Context context, String str, String str2, InterceptCallback interceptCallback) {
        String str3;
        Activity realTopActivity = BdBoxActivityManager.getRealTopActivity();
        if (realTopActivity != null) {
            str3 = realTopActivity.getClass().getSimpleName();
        } else {
            str3 = "";
        }
        openApp(context, str, str2, InvokeStatisticKt.SCHEME_INVOKE_FROM_DOWNLOAD_CENTER, str3, "", interceptCallback);
    }

    public static void installApk(Context context, String str, Uri uri, boolean z, ApkInstallCallBack apkInstallCallBack) {
        if (context != null && !TextUtils.isEmpty(str) && uri != null) {
            installApk(context, FileDownloader.uriToFile(context.getApplicationContext(), uri), str, z, apkInstallCallBack);
        } else if (apkInstallCallBack != null) {
            apkInstallCallBack.onResult(false);
        }
    }

    @Deprecated
    public static boolean installApk(final Context context, final File file, final String str, boolean z) {
        if (context != null && file != null && !DownloadHelper.isExternalStorageAndNoPermission(file.getAbsolutePath()) && file.isFile() && file.exists()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.util.ApkUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (TextUtils.isEmpty(str2)) {
                        String[] parsePackageInfo = ApkUtil.parsePackageInfo(context, file.getAbsolutePath());
                        if (!TextUtils.isEmpty(parsePackageInfo[1])) {
                            ApkUtil.mInstallPKGMap.put(parsePackageInfo[1], file.getAbsolutePath());
                            str2 = parsePackageInfo[1];
                        }
                    } else {
                        ApkUtil.mInstallPKGMap.put(str, file.getAbsolutePath());
                    }
                    ApkUtil.installGuide(file, str2);
                }
            }, "parseInstallPackageInfo", 2);
            registerApkReceiver(context.getApplicationContext());
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
            if (DEBUG) {
                Log.d(TAG, "开始 install apk");
            }
            try {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(1342177280);
                intent.putExtra(KEY_INSTALLER_PACKAGE_NAME, context.getPackageName());
                if (z) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                if (!DeviceUtil.OSInfo.hasNougat()) {
                    intent.setComponent(new ComponentName(PACKAGE_INSTALLER, PACKAGE_INSTALLER_ACTIVITY));
                }
                ActivityUtils.processFileUriIntent(context, file, intent);
                context.startActivity(intent);
                if (DEBUG) {
                    Log.d(TAG, "正常 install apk done time = " + System.currentTimeMillis());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                intent.setComponent(null);
                ActivityUtils.processFileUriIntent(context, file, intent);
                try {
                    context.startActivity(intent);
                    if (DEBUG) {
                        Log.e(TAG, "异常 install apk done");
                    }
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean installApk(Context context, File file, boolean z) {
        return installApk(context, file, "", z);
    }

    @Deprecated
    public static boolean installApk(Context context, String str, Uri uri) {
        return installApk(context, str, uri, false);
    }

    @Deprecated
    public static boolean installApk(Context context, String str, Uri uri, boolean z) {
        if (context != null && !TextUtils.isEmpty(str) && uri != null) {
            return installApk(context, FileDownloader.uriToFile(context.getApplicationContext(), uri), str, z);
        }
        return false;
    }

    @Deprecated
    public static boolean installApk(String str, boolean z) {
        if (DEBUG) {
            Log.e(TAG, "call installApk filePath=" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return installApk(AppRuntime.getAppContext(), new File(str), z);
        } catch (Exception e) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static void installGuide(File file, final String str) {
        boolean canRequestPackageInstalls;
        if (Build.VERSION.SDK_INT < 26) {
            canRequestPackageInstalls = true;
        } else {
            canRequestPackageInstalls = AppRuntime.getAppContext().getPackageManager().canRequestPackageInstalls();
        }
        if (canRequestPackageInstalls) {
            final String absolutePath = file.getAbsolutePath();
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.download.util.ApkUtil.8
                @Override // java.lang.Runnable
                public void run() {
                    if (AppConfig.isDebug()) {
                        Log.d(ApkUtil.TAG, "installGuide is isForeground()? " + BdBoxActivityManager.isForeground());
                    }
                    if (!BdBoxActivityManager.isForeground()) {
                        ApkUtil.showInstallGuide(absolutePath, str);
                    }
                }
            }, ((file.length() * 10) / 1048576) + 1000);
            return;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.download.util.ApkUtil.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ApkUtil.access$700()) {
                        w20.c(BdBoxActivityManager.getTopActivity(), w20.b, new w20.g() { // from class: com.baidu.searchbox.download.util.ApkUtil.9.1
                            @Override // com.baidu.tieba.w20.g
                            public void onRequestPermissionsResult(boolean z) {
                            }
                        }, 102);
                    }
                } catch (Throwable unused) {
                    if (ApkUtil.DEBUG) {
                        Log.e(ApkUtil.TAG, "权限 提示失败");
                    }
                }
            }
        }, 1000L);
    }

    @NonNull
    public static String[] parsePackageInfo(Context context, String str) {
        String[] strArr = new String[4];
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 128);
            if (packageArchiveInfo != null) {
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str;
                applicationInfo.publicSourceDir = str;
                strArr[0] = packageManager.getApplicationLabel(applicationInfo).toString();
                strArr[1] = applicationInfo.packageName;
                strArr[2] = String.valueOf(packageArchiveInfo.versionCode);
                strArr[3] = packageArchiveInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    public static void openApp(Context context, String str, String str2, String str3, String str4, String str5, InterceptCallback interceptCallback) {
        if (!TextUtils.isEmpty(str2) && context != null) {
            mx.b().h(str, str2, true, interceptCallback, OpenAppManager.isNoAlertSwitchOn("h5"), new InvokeStatistic().addExtPackage(str2).setPage("package").setFrom(str3).addSContent(str4).addurl(str5));
        } else if (interceptCallback != null) {
            interceptCallback.onResult(false);
        }
    }

    public static ExtraInfoModel parseApkInfo(String str) {
        ExtraInfoModel extraInfoModel = new ExtraInfoModel();
        if (TextUtils.isEmpty(str)) {
            return extraInfoModel;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("source", "");
            extraInfoModel.source = optString;
            if (TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
                if (!TextUtils.isEmpty(optString2)) {
                    extraInfoModel.source = new JSONObject(optString2).optString("source", "");
                }
            }
            extraInfoModel.category = jSONObject.optString("category", "");
            extraInfoModel.channel = jSONObject.optString("channel", "");
            extraInfoModel.fileIcon = jSONObject.optString(DownloadCenterFunConstants.FILE_ICON, "");
            extraInfoModel.cardType = jSONObject.optString(DownloadCenterFunConstants.CARD_TYPE, "");
            extraInfoModel.pkgName = jSONObject.optString("package", "");
            extraInfoModel.version = jSONObject.optString("version", BaiduIdentityManager.getInstance().getVersionName());
            extraInfoModel.originalUri = jSONObject.optString("originalUri", "");
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                throw new DebugException("UnitedSchemeShowRecommendDialogDispatcher extInfo is not json form!");
            }
        }
        return extraInfoModel;
    }

    public static void saveUninstalledApkTipsData(boolean z) {
        if (z) {
            long j = DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_LAST, System.currentTimeMillis());
            long j2 = DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY, 0L);
            if (DateUtils.isToday(j)) {
                j2++;
            }
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY, j2);
            if (DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_FIRST_CYCLE, -1L) < 0) {
                DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_FIRST_CYCLE, System.currentTimeMillis());
            }
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_LAST, System.currentTimeMillis());
            DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE, DownloadSharedPrefsUtils.getInstance().getLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE, 0L) + 1);
            return;
        }
        DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_TODAY, 1L);
        DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_CYCLE, 1L);
        DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_FIRST_CYCLE, System.currentTimeMillis());
        DownloadSharedPrefsUtils.getInstance().putLong(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIME_LAST, System.currentTimeMillis());
    }

    public static void requestInstallGuide(String str, final IInstallGuideCallback iInstallGuideCallback) {
        CookieManager cookieManager = HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(false, false);
        String installGuideUrl = getInstallGuideUrl();
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("package_name", str);
            hashMap.put("data", jSONObject.toString());
            PostFormRequest build = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(installGuideUrl)).addUrlParam(BaiduIdentityManager.PARAM_OSNAME, BaiduIdentityManager.VALUE_OSNAME)).cookieManager(cookieManager)).params(hashMap).autoRetry(false)).readTimeout(3000)).connectionTimeout(3000)).writeTimeout(3000)).enableStat(true)).requestFrom(10)).requestSubFrom(1022)).build();
            if (build.makeRequestCall() == null) {
                return;
            }
            build.executeAsync(new ResponseCallback<String>() { // from class: com.baidu.searchbox.download.util.ApkUtil.11
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (AppConfig.isDebug()) {
                        Log.d(ApkUtil.TAG, "requestInstallGuide failed");
                    }
                    IInstallGuideCallback iInstallGuideCallback2 = IInstallGuideCallback.this;
                    if (iInstallGuideCallback2 != null) {
                        iInstallGuideCallback2.failed();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str2, int i) {
                    if (AppConfig.isDebug()) {
                        Log.d(ApkUtil.TAG, "requestInstallGuide success");
                    }
                    if (TextUtils.isEmpty(str2)) {
                        IInstallGuideCallback iInstallGuideCallback2 = IInstallGuideCallback.this;
                        if (iInstallGuideCallback2 != null) {
                            iInstallGuideCallback2.failed();
                            return;
                        }
                        return;
                    }
                    try {
                        JSONObject optJSONObject = new JSONObject(str2).optJSONObject("data");
                        if (optJSONObject != null && optJSONObject.optBoolean("exist")) {
                            if (AppConfig.isDebug()) {
                                Log.d(ApkUtil.TAG, "requestInstallGuide enable");
                            }
                            if (IInstallGuideCallback.this != null) {
                                IInstallGuideCallback.this.success();
                                return;
                            }
                            return;
                        }
                        if (AppConfig.isDebug()) {
                            Log.d(ApkUtil.TAG, "requestInstallGuide not enable");
                        }
                        if (IInstallGuideCallback.this != null) {
                            IInstallGuideCallback.this.failed();
                        }
                    } catch (Exception unused) {
                        if (AppConfig.isDebug()) {
                            Log.d(ApkUtil.TAG, "requestInstallGuide not enable");
                        }
                        IInstallGuideCallback iInstallGuideCallback3 = IInstallGuideCallback.this;
                        if (iInstallGuideCallback3 != null) {
                            iInstallGuideCallback3.failed();
                        }
                    }
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, SGET, MOVE_EXCEPTION, INVOKE, INVOKE, IF, INVOKE, INVOKE, IF, SGET, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public String parseResponse(Response response, int i) throws Exception {
                    if (response != null) {
                        try {
                            if (response.isSuccessful() && response.body() != null) {
                                return response.body().string();
                            }
                        } finally {
                            if (response != null) {
                                try {
                                    if (response.body() != null) {
                                        response.body().close();
                                    }
                                } catch (Exception e) {
                                    if (ApkUtil.DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                    if (response != null) {
                        try {
                            if (response.body() != null) {
                                response.body().close();
                            }
                        } catch (Exception e2) {
                            if (ApkUtil.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    return null;
                }
            });
        } catch (Exception unused) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "requestInstallGuide postParam failed");
            }
            if (iInstallGuideCallback != null) {
                iInstallGuideCallback.failed();
            }
        }
    }
}
