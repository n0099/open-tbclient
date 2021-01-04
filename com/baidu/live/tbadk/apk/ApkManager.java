package com.baidu.live.tbadk.apk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileDownloadCallBack;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class ApkManager {
    private final LinkedList<ApkData> mApkWaitingList;
    private Handler mHandler;

    private ApkManager() {
        this.mApkWaitingList = new LinkedList<>();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static ApkManager getInstance() {
        return ApkManagerClassInstance.instance;
    }

    private boolean isApkDownloaded(Context context, ApkData apkData) {
        if (context == null || apkData == null || TextUtils.isEmpty(apkData.apkPackageName)) {
            return false;
        }
        return new File(getApkFilePath(apkData.apkPackageName)).exists();
    }

    private boolean isLocalApkOvertime(ApkData apkData, long j) {
        if (apkData != null) {
            if (!(TextUtils.isEmpty(apkData.apkPath) && (TextUtils.isEmpty(apkData.apkUrl) || TextUtils.isEmpty(apkData.apkPackageName))) && j > 0) {
                String str = apkData.apkPath;
                if (TextUtils.isEmpty(str)) {
                    str = getApkFilePath(apkData.apkPackageName);
                }
                File file = new File(str);
                if (file.exists()) {
                    long lastModified = file.lastModified();
                    if (lastModified != 0) {
                        return System.currentTimeMillis() - lastModified > j;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean isApkInstalled(Context context, ApkData apkData) {
        if (context == null || apkData == null || TextUtils.isEmpty(apkData.apkPackageName)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(apkData.apkPackageName, 256);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private boolean isAllDeepLinkSchemeSupported(Context context, ApkData apkData) {
        if (context == null || apkData == null || TextUtils.isEmpty(apkData.apkDeeplinkScheme) || TextUtils.isEmpty(apkData.apkPackageName)) {
            return false;
        }
        return isDeepLinkSchemeSupported(context, apkData.apkPackageName, apkData.apkDeeplinkScheme) || isDeepLinkSchemeSupported(context, apkData.apkPackageName, apkData.apkOldDeeplinkScheme);
    }

    private boolean isDeepLinkSchemeSupported(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(str2));
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public ApkStatus getApkStatus(Context context, ApkData apkData) {
        if (context == null || apkData == null || TextUtils.isEmpty(apkData.apkDeeplinkScheme) || TextUtils.isEmpty(apkData.apkPackageName)) {
            return ApkStatus.ILLEGAL;
        }
        if (isAllDeepLinkSchemeSupported(context, apkData)) {
            return ApkStatus.READY;
        }
        if (isApkInstalled(context, apkData)) {
            return ApkStatus.NEED_UPDATE;
        }
        if (isApkDownloaded(context, apkData)) {
            if (apkData.overTimeIntervalMs > 0 && isLocalApkOvertime(apkData, apkData.overTimeIntervalMs)) {
                return ApkStatus.OVERTIME;
            }
            return ApkStatus.DOWNLOADED;
        }
        return ApkStatus.NONE;
    }

    public boolean launchApkByDeeplink(Context context, ApkData apkData) {
        if (context == null || apkData == null || TextUtils.isEmpty(apkData.apkPackageName) || TextUtils.isEmpty(apkData.apkDeeplinkScheme)) {
            return false;
        }
        if (isDeepLinkSchemeSupported(context, apkData.apkPackageName, apkData.apkDeeplinkScheme)) {
            return launchApp(context, apkData.apkDeeplinkScheme);
        }
        if (isDeepLinkSchemeSupported(context, apkData.apkPackageName, apkData.apkOldDeeplinkScheme)) {
            return launchApp(context, apkData.apkOldDeeplinkScheme);
        }
        return false;
    }

    private boolean launchApp(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public void startDownloadAndLaunchApk(Activity activity, ApkData apkData, boolean z) {
        if (apkData != null && !TextUtils.isEmpty(apkData.apkUrl) && !isApkWaiting(apkData)) {
            apkData.apkPath = getApkFilePath(apkData.apkPackageName);
            if (!z && isApkDownloaded(activity, apkData)) {
                installAndLaunchApp(activity, apkData);
                return;
            }
            File file = new File(getApkFilePath(apkData.apkPackageName));
            if (z && file.exists()) {
                file.delete();
            }
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            this.mApkWaitingList.add(apkData);
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(apkData.apkUrl);
            downloadData.setPath(apkData.apkPath);
            downloadData.setId(apkData.apkPackageName);
            downloadData.setName(apkData.apkPackageName);
            downloadData.setType(12);
            downloadData.setCallback(new ApkFileDownloadCallBack(apkData, activity));
            FileSerialDownLoader.getInstance().startDownLoadWithInsert(downloadData);
        }
    }

    static String getApkFilePath(String str) {
        return TbConfig.FILE_OUTPUT_FILE_ROOT_PATH + "/live_" + str + ".apk";
    }

    public void stopApkDownload(ApkData apkData) {
        if (apkData != null && !TextUtils.isEmpty(apkData.apkUrl) && !TextUtils.isEmpty(apkData.apkPackageName) && !this.mApkWaitingList.isEmpty()) {
            Iterator<ApkData> it = this.mApkWaitingList.iterator();
            while (it.hasNext()) {
                ApkData next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkUrl) && next.apkUrl.equals(apkData.apkUrl)) {
                    this.mApkWaitingList.remove(apkData);
                    FileSerialDownLoader.getInstance().cancelDownLoadById(apkData.apkPackageName, 12);
                    return;
                }
            }
        }
    }

    public void removeFileDownloadCallback(ApkData apkData) {
        if (apkData != null && !TextUtils.isEmpty(apkData.apkUrl) && !TextUtils.isEmpty(apkData.apkPackageName) && !this.mApkWaitingList.isEmpty()) {
            Iterator<ApkData> it = this.mApkWaitingList.iterator();
            while (it.hasNext()) {
                ApkData next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkUrl) && next.apkUrl.equals(apkData.apkUrl)) {
                    this.mApkWaitingList.remove(apkData);
                    DownloadData downloadDataById = FileSerialDownLoader.getInstance().getDownloadDataById(apkData.apkPackageName, 12);
                    if (downloadDataById != null) {
                        downloadDataById.setCallback(null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void addFileDownloadCallback(ApkData apkData, Activity activity) {
        DownloadData downloadDataById = FileSerialDownLoader.getInstance().getDownloadDataById(apkData.apkPackageName, 12);
        if (downloadDataById != null && !isApkWaiting(apkData)) {
            this.mApkWaitingList.add(apkData);
            downloadDataById.setCallback(new ApkFileDownloadCallBack(apkData, activity));
        }
    }

    public boolean isDownloading(ApkData apkData) {
        return (apkData == null || FileSerialDownLoader.getInstance().getDownloadDataById(apkData.apkPackageName, 12) == null) ? false : true;
    }

    private boolean isApkWaiting(ApkData apkData) {
        if (apkData == null || TextUtils.isEmpty(apkData.apkUrl)) {
            return false;
        }
        if (this.mApkWaitingList.isEmpty()) {
            return false;
        }
        Iterator<ApkData> it = this.mApkWaitingList.iterator();
        while (it.hasNext()) {
            ApkData next = it.next();
            if (next != null && !TextUtils.isEmpty(next.apkUrl) && next.apkUrl.equals(apkData.apkUrl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean installAndLaunchApp(Activity activity, ApkData apkData) {
        apkData.apkPath = getApkFilePath(apkData.apkPackageName);
        if (activity == null || apkData == null || TextUtils.isEmpty(apkData.apkPath)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (isHasInstallPermissionWithO(activity)) {
                realInstallAndLaunch(activity, apkData);
                if (apkData.apkStatusCallBack != null) {
                    apkData.apkStatusCallBack.onApkStartInstall(apkData);
                    return true;
                }
                return true;
            }
            startInstallPermissionSettingActivity(activity);
            return false;
        }
        realInstallAndLaunch(activity, apkData);
        return true;
    }

    private void realInstallAndLaunch(Activity activity, ApkData apkData) {
        if (activity != null && apkData != null && !TextUtils.isEmpty(apkData.apkPath)) {
            File file = new File(apkData.apkPath);
            if (file.exists()) {
                if (apkData.apkStatusCallBack != null) {
                    apkData.apkStatusCallBack.onApkStartInstall(apkData);
                }
                realInstallApk(activity, file);
                launchByClipboard(activity, apkData);
            }
        }
    }

    private void realInstallApk(Activity activity, File file) {
        Uri fromFile;
        if (activity != null && file != null && file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                if (!file.getAbsolutePath().startsWith(TbConfig.FILE_OUTPUT_FILE_ROOT_PATH)) {
                    String str = TbConfig.FILE_OUTPUT_FILE_ROOT_PATH + "/" + file.getName();
                    FileHelper.renameTo(file.getAbsolutePath(), str);
                    file = new File(str);
                }
                fromFile = FileProvider.getUriForFile(activity, TbConfig.FILE_PROVIDER_AUTHORITIES, file);
                intent.setAction("android.intent.action.INSTALL_PACKAGE");
                intent.addFlags(1);
            } else {
                fromFile = Uri.fromFile(file);
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            activity.startActivity(intent);
        }
    }

    @TargetApi(26)
    private boolean isHasInstallPermissionWithO(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageManager().canRequestPackageInstalls();
    }

    private void startInstallPermissionSettingActivity(Activity activity) {
        if (activity != null) {
            activity.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + activity.getApplication().getPackageName())), RequestResponseCode.REQUEST_SDK_INSTALL_APK_PERMISSION);
        }
    }

    private void launchByClipboard(Context context, ApkData apkData) {
        ClipboardManager clipboardManager;
        if (context != null && apkData != null && !TextUtils.isEmpty(apkData.apkClipBoardScheme) && (clipboardManager = (ClipboardManager) context.getSystemService("clipboard")) != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(context.getResources().getString(a.h.sdk_live_room_jump_clipboard_tip), apkData.apkClipBoardScheme));
        }
    }

    /* loaded from: classes11.dex */
    private class ApkFileDownloadCallBack implements FileDownloadCallBack {
        Activity activity;
        ApkData apkData;

        public ApkFileDownloadCallBack(ApkData apkData, Activity activity) {
            this.apkData = apkData;
            this.activity = activity;
        }

        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (this.apkData != null && this.apkData.apkStatusCallBack != null) {
                if (downloadData.getStatus() == 9) {
                    this.apkData.apkStatusCallBack.onJoinDownloadQueue();
                } else {
                    this.apkData.apkStatusCallBack.onApkDownloadProgress(downloadData.getLength(), downloadData.getSize());
                }
            }
        }

        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
        public boolean onPreDownload(DownloadData downloadData) {
            ApkManager.this.mHandler.post(new Runnable() { // from class: com.baidu.live.tbadk.apk.ApkManager.ApkFileDownloadCallBack.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ApkFileDownloadCallBack.this.apkData != null && ApkFileDownloadCallBack.this.apkData.apkStatusCallBack != null) {
                        ApkFileDownloadCallBack.this.apkData.apkStatusCallBack.onApkDownloadStart(ApkFileDownloadCallBack.this.apkData);
                    }
                }
            });
            return true;
        }

        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
        public void onFileDownloadSucceed(DownloadData downloadData) {
            ApkManager.this.mApkWaitingList.remove(this.apkData);
            if (this.apkData != null && this.apkData.apkStatusCallBack != null) {
                this.apkData.apkStatusCallBack.onApkDownloadSucceed(this.apkData);
            }
            ApkManager.this.installAndLaunchApp(this.activity, this.apkData);
        }

        @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            ApkManager.this.mApkWaitingList.remove(this.apkData);
            if (this.apkData != null && this.apkData.apkStatusCallBack != null) {
                this.apkData.apkStatusCallBack.onApkDownloadFailed(this.apkData, i, str);
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class ApkManagerClassInstance {
        public static final ApkManager instance = new ApkManager();

        private ApkManagerClassInstance() {
        }
    }
}
