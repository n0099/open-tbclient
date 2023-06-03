package com.baidu.searchbox.download.statistics;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.model.ExtraInfoModel;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tieba.r8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class ApkCloudStatisticsUtils {
    public static final String TAG = "ApkCloudStatisticsUtils";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static ConcurrentLinkedQueue<String> mStaticJobInList = new ConcurrentLinkedQueue<>();
    public static AtomicInteger mReadyStaticCount = new AtomicInteger();

    public static boolean enableAppsearchCloudStatic() {
        if (NetWorkUtils.isNetworkConnected() && TextUtils.equals(DownloadSharedPrefsUtils.getInstance().getString(DownloadRecommendConstants.APPSEARCH_CLOUD_STATIC_KEY, "1"), "1")) {
            return true;
        }
        return false;
    }

    public static void doApkDownHijackCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "发起安装" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.DOWNHIJACK_STATISTIC_URL, downloadActionModel));
    }

    public static void doApkInstallHijackCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "发起安装" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.INSTALLHIJACK_STATISTIC_URL, downloadActionModel));
    }

    public static void doApkInstalledCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "安装完成" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.DOWNINSTALLED_STATISTIC_URL, downloadActionModel));
    }

    public static void doApkResumeDownloadStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "恢复下载" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.DOWNRESUME_STATISTIC_URL, downloadActionModel));
    }

    public static void doApkStartInstallCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "发起安装" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.DOWNSTARTINSTALL_STATISTIC_URL, downloadActionModel));
    }

    public static void doApkSuccessCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "下载完成" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.DOWNFINISH_STATISTIC_URL, downloadActionModel));
    }

    public static void doFileOpenCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.FILE_OPEN_STATISTIC_URL, downloadActionModel));
    }

    public static void doPluginOpenCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.PLUGIN_OPEN_STATISTIC_URL, downloadActionModel));
    }

    public static void doSysappOpenCloudStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.SYSAPP_OPEN_STATISTIC_URL, downloadActionModel));
    }

    public static String getDownloadStaticMimeType(String str) {
        return FileClassifyHelper.guessMimeTypeFromExtension(FileClassifyHelper.getFileSuffix(str));
    }

    public static String buildApkAnalysisParamsUrl() {
        HashMap hashMap = new HashMap();
        hashMap.put("action", "apkanalysis");
        hashMap.put("request_source", "1");
        hashMap.put("native_api", "1");
        hashMap.put("baidu_entry", "commendAlert");
        if (WarmTipsManager.hasConfirmDialog()) {
            hashMap.put("cuid", CommonParam.getCUID(AppRuntime.getApplication()));
        }
        return UrlUtil.addParam("https://appc.baidu.com/appsrv?", hashMap);
    }

    public static String buildSid() {
        ArrayList<r8> experimentInfoList = AbTestManager.getInstance().getExperimentInfoList();
        if (experimentInfoList != null && !experimentInfoList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (r8 r8Var : experimentInfoList) {
                sb.append(r8Var.c());
                sb.append("_");
                sb.append(r8Var.b());
                sb.append("-");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }

    public static void doApkPauseDownloadStatisticJob(int i, DownloadActionModel downloadActionModel) {
        String str;
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, "暂停下载or失败下载" + downloadActionModel.toString());
        }
        if (Downloads.isStatusError(i)) {
            str = ApkStaticNetService.DOWNFAIL_STATISTIC_URL + i;
            if (!TextUtils.isEmpty(downloadActionModel.mRedirectUris)) {
                str = UrlUtil.appendParam(str, ApkStaticNetService.STATIC_DOWNLOAD_REDIRECT_URL, downloadActionModel.mRedirectUris);
            }
        } else {
            str = ApkStaticNetService.DOWNPAUSED_STATISTIC_URL;
        }
        handleNextCloudStatic(getStaticUrl(str, downloadActionModel));
    }

    public static void doApkStartDownloadStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel == null) {
            return;
        }
        if (DEBUG) {
            Log.e(TAG, downloadActionModel.toString());
        }
        if (DEBUG) {
            Log.e(TAG, "发起下载 仅apk" + downloadActionModel.toString());
        }
        handleNextCloudStatic(getStaticUrl(ApkStaticNetService.WEBDOWNLOAD_URL, downloadActionModel));
    }

    public static void handleNextCloudStatic(String str) {
        if (!TextUtils.isEmpty(str)) {
            mStaticJobInList.add(str);
        } else {
            mReadyStaticCount.decrementAndGet();
        }
        if (mStaticJobInList.size() > 0 && mReadyStaticCount.get() < 2) {
            mReadyStaticCount.incrementAndGet();
            sendCloudStatic(mStaticJobInList.poll());
        }
    }

    public static String getStaticUrl(String str, DownloadActionModel downloadActionModel) {
        HashMap hashMap = new HashMap();
        hashMap.put(ApkStaticNetService.KEY_STATIC_TYPE, "basic");
        if (WarmTipsManager.hasConfirmDialog()) {
            hashMap.put("cuid", CommonParam.getCUID(AppRuntime.getApplication()));
        }
        hashMap.put(ApkStaticNetService.STATIC_DOWNLOAD_NET, NetWorkUtils.getNetworkClass());
        hashMap.put(ApkStaticNetService.STATIC_HOST_DOWNLOAD_VERSION_NAME, BaiduIdentityManager.getInstance().getVersionName());
        hashMap.put("sid", buildSid());
        if (downloadActionModel != null) {
            String str2 = "";
            if (downloadActionModel.downloadId != 0) {
                String[] queryStaticsInfoByDownloadID = SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).queryStaticsInfoByDownloadID(String.valueOf(downloadActionModel.downloadId));
                if (queryStaticsInfoByDownloadID == null || queryStaticsInfoByDownloadID.length != 6) {
                    return "";
                }
                str2 = queryStaticsInfoByDownloadID[0];
                hashMap.put(ApkStaticNetService.STATIC_DOWNLOAD_SIZE, queryStaticsInfoByDownloadID[1]);
                hashMap.put(ApkStaticNetService.STATIC_DOWNLOAD_REFER, removeBDussInUrl(queryStaticsInfoByDownloadID[2]));
                String str3 = queryStaticsInfoByDownloadID[4];
                if (TextUtils.isEmpty(str3)) {
                    str3 = downloadActionModel.mimeType;
                }
                hashMap.put("fileType", DownloadHelper.getFileTypeString(str2, str3));
                if (TextUtils.isEmpty(downloadActionModel.extraInfo) && !TextUtils.isEmpty(queryStaticsInfoByDownloadID[5])) {
                    downloadActionModel.extraInfo = queryStaticsInfoByDownloadID[5];
                }
            }
            if (!TextUtils.isEmpty(downloadActionModel.extraInfo)) {
                try {
                    ExtraInfoModel parseApkInfo = ApkUtil.parseApkInfo(downloadActionModel.extraInfo);
                    if (parseApkInfo != null) {
                        if (!TextUtils.isEmpty(parseApkInfo.pkgName)) {
                            hashMap.put("pkg", parseApkInfo.pkgName);
                        }
                        if (!TextUtils.isEmpty(parseApkInfo.source)) {
                            hashMap.put("source", parseApkInfo.source);
                        }
                        if (!TextUtils.isEmpty(parseApkInfo.category)) {
                            hashMap.put("category", parseApkInfo.category);
                        }
                        if (!TextUtils.isEmpty(parseApkInfo.channel)) {
                            hashMap.put("channel", parseApkInfo.channel);
                        }
                        if (TextUtils.isEmpty(parseApkInfo.version)) {
                            hashMap.put(ApkStaticNetService.STATIC_DOWNLOAD_VER, parseApkInfo.version);
                        }
                        if (!TextUtils.isEmpty(parseApkInfo.originalUri)) {
                            str2 = parseApkInfo.originalUri;
                        }
                    }
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e(TAG, "获取统计链接 额外参数失败：" + e.toString());
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(ApkStaticNetService.STATIC_DOWNLOAD_URL, str2);
            }
        }
        return UrlUtil.addParam(str, hashMap);
    }

    public static String removeBDussInUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            if (lowerCase.contains("bduss=")) {
                int indexOf = lowerCase.indexOf("?") + 1;
                String substring = lowerCase.substring(0, indexOf);
                String[] split = lowerCase.substring(indexOf).split("&");
                StringBuilder sb = new StringBuilder();
                sb.append(substring);
                for (String str2 : split) {
                    if (!str2.contains("bduss=")) {
                        sb.append(str2);
                        sb.append("&");
                    }
                }
                return sb.substring(0, sb.length() - 1);
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void sendCloudStatic(String str) {
        if (DEBUG) {
            Log.e(TAG, "发起统计" + str);
        }
        if (TextUtils.isEmpty(str)) {
            handleNextCloudStatic(null);
            return;
        }
        GetRequest build = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(false, false)).autoRetry(false).readTimeout(3000).connectionTimeout(3000).writeTimeout(3000).enableStat(true).requestFrom(10).requestSubFrom(1022).build();
        if (build.makeRequestCall() == null) {
            return;
        }
        build.executeAsync(new ResponseCallback<String>() { // from class: com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (ApkCloudStatisticsUtils.DEBUG) {
                    Log.e(ApkCloudStatisticsUtils.TAG, "统计成功:" + exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (ApkCloudStatisticsUtils.DEBUG) {
                    Log.e(ApkCloudStatisticsUtils.TAG, "统计成功:" + i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                if (ApkCloudStatisticsUtils.DEBUG) {
                    Log.e(ApkCloudStatisticsUtils.TAG, "统计成功:" + i);
                }
                try {
                    ApkCloudStatisticsUtils.handleNextCloudStatic(null);
                    return null;
                } finally {
                    if (response != null) {
                        try {
                            if (response.body() != null) {
                                response.body().close();
                            }
                        } catch (Exception e) {
                            if (ApkCloudStatisticsUtils.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }
}
