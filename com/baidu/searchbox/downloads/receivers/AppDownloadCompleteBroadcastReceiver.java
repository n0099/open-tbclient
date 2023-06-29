package com.baidu.searchbox.downloads.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.apkcheck.ApkCheckerKt;
import com.baidu.searchbox.download.business.util.DownloadUtils;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.ApkStaticNetService;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.util.ApkInstallCallBack;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.y20;
import com.heytap.mcssdk.PushService;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AppDownloadCompleteBroadcastReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "AppDownloadCompleteBroadcastReceiver";

    /* JADX INFO: Access modifiers changed from: private */
    public void doDispatchStatistic(String str, JSONObject jSONObject, String str2) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObject2.put("file_size", DownloadUtils.getFileSize(str2));
            DownloadStatisticUtil.ubc("tool", "dispatch", "", str, "", DownloadStatisticConstants.UBC_DOWNLOAD_CENTER_CLICK, jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCloudStatisticJob(long j, String str) {
        if (!ApkCloudStatisticsUtils.enableAppsearchCloudStatic()) {
            return;
        }
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        downloadActionModel.mimeType = "apk";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        downloadActionModel.extraInfo = str;
        ApkCloudStatisticsUtils.doApkStartInstallCloudStatisticJob(downloadActionModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStatisticAfterInstall(final CategoryInfoData categoryInfoData, final JSONObject jSONObject) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.downloads.receivers.AppDownloadCompleteBroadcastReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadCompleteBroadcastReceiver.this.doDispatchStatistic(ApkUtil.parseApkInfo(categoryInfoData.mExtraInfo).source, jSONObject, categoryInfoData.mDownloadPath);
                AppDownloadCompleteBroadcastReceiver appDownloadCompleteBroadcastReceiver = AppDownloadCompleteBroadcastReceiver.this;
                CategoryInfoData categoryInfoData2 = categoryInfoData;
                appDownloadCompleteBroadcastReceiver.doCloudStatisticJob(categoryInfoData2.mId, categoryInfoData2.mExtraInfo);
            }
        }, "AppDownloadCompleteBroadcastReceiver.doStaticWork", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStaticWork(String str, long j, final String str2, boolean z, String str3) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            final String[] parsePackageInfo = ApkUtil.parsePackageInfo(AppRuntime.getAppContext(), str2);
            String str4 = parsePackageInfo[0];
            final String str5 = parsePackageInfo[1];
            String str6 = parsePackageInfo[2];
            String str7 = parsePackageInfo[3];
            jSONObject.put("name", str4);
            jSONObject.put("package", str5);
            jSONObject.put("versioncode", str6);
            jSONObject.put(Downloads.Impl.COLUMN_EXTRA_INFO_VERSIONNAME, str7);
            FileDownloader.updateDownloadExtraInfo(AppRuntime.getAppContext(), j, jSONObject.toString());
            boolean optBoolean = jSONObject.optBoolean(Downloads.Impl.COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL, false);
            if (z && !optBoolean && !ApkUtil.hasInstalled(AppRuntime.getAppContext(), str5, str6)) {
                final CategoryInfoData categoryInfoData = new CategoryInfoData();
                categoryInfoData.mDownloadPath = str2;
                categoryInfoData.mId = j;
                categoryInfoData.mExtraInfo = str;
                final JSONObject jSONObject2 = jSONObject;
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.downloads.receivers.AppDownloadCompleteBroadcastReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("pkg", str5);
                        } catch (JSONException unused) {
                        }
                        y20.x("file", DownloadStatisticConstants.UBC_TYPE_OPEN_FILE, "other", "auto", "app", jSONObject3);
                        ApkCheckerKt.checkApk(BdBoxActivityManager.getTopActivity(), categoryInfoData, false, new Function1<Boolean, Unit>() { // from class: com.baidu.searchbox.downloads.receivers.AppDownloadCompleteBroadcastReceiver.2.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function1
                            public Unit invoke(Boolean bool) {
                                if (bool.booleanValue()) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    try {
                                        jSONObject4.put("pkg", str5);
                                    } catch (JSONException unused2) {
                                    }
                                    y20.x("file", DownloadStatisticConstants.UBC_TYPE_START_INSTALL, "other", "auto", "app", jSONObject4);
                                    Context appContext = AppRuntime.getAppContext();
                                    File file = new File(str2);
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    ApkUtil.installApk(appContext, file, parsePackageInfo[1], ApkUtil.ifHideInstallComplete(jSONObject2.toString()), (ApkInstallCallBack) null);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    AppDownloadCompleteBroadcastReceiver.this.doStatisticAfterInstall(categoryInfoData, jSONObject2);
                                }
                                return null;
                            }
                        });
                    }
                });
            }
            encodeApkMD5(jSONObject, parsePackageInfo);
        } catch (Exception unused) {
        }
    }

    private void encodeApkMD5(JSONObject jSONObject, String[] strArr) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            String optString = jSONObject.optString("originalUri");
            jSONObject2.put(PushService.APP_VERSION_NAME, strArr[0]);
            jSONObject2.put("packageName", strArr[1]);
            jSONObject2.put(PushService.APP_VERSION_CODE, strArr[2]);
            jSONObject2.put("url", optString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ApkStaticNetService.requestApkAnalysisService(AppRuntime.getAppContext(), ApkUtil.encodeStr(jSONObject2.toString()));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (DEBUG) {
                Log.e(TAG, "app download complete receiver");
            }
            String action = intent.getAction();
            if (action != null && DownloadConstants.ACTION_DOWNLOAD_APP_COMPLETE.equals(action)) {
                final Long valueOf = Long.valueOf(intent.getLongExtra("download_id", -1L));
                if (!TextUtils.equals("1", intent.getStringExtra(DownloadConstants.PERFORM_DOWNLOAD))) {
                    if (DEBUG) {
                        Log.e(TAG, "filter id=" + valueOf);
                    }
                    try {
                        if (ContextCompat.checkSelfPermission(context, "android.permission.BROADCAST_STICKY") == 0) {
                            context.removeStickyBroadcast(intent);
                            return;
                        }
                        return;
                    } catch (SecurityException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                final boolean isShowInDownloadUI = SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).isShowInDownloadUI(String.valueOf(valueOf));
                if (DEBUG) {
                    Log.e(TAG, "id=" + valueOf);
                    Log.e(TAG, "needAutoInstall=" + isShowInDownloadUI + TAG);
                }
                final String stringExtra = intent.getStringExtra(DownloadConstants.DOWNLOAD_FILENAME);
                final String stringExtra2 = intent.getStringExtra("extra");
                final String stringExtra3 = intent.getStringExtra(DownloadConstants.DOWNLOAD_COLUMNTITLE);
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.downloads.receivers.AppDownloadCompleteBroadcastReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AppDownloadCompleteBroadcastReceiver.this.doStaticWork(stringExtra2, valueOf.longValue(), stringExtra, isShowInDownloadUI, stringExtra3);
                    }
                }, "AppDownloadCompleteBroadcastReceiver.doStaticWork", 3);
                try {
                    if (ContextCompat.checkSelfPermission(context, "android.permission.BROADCAST_STICKY") == 0) {
                        context.removeStickyBroadcast(intent);
                    }
                } catch (SecurityException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
