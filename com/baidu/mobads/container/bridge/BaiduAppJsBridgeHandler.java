package com.baidu.mobads.container.bridge;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAPKCommand;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.components.controller.XAdInstallController;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.OAdTimer;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaiduAppJsBridgeHandler implements IOAdEventListener, InstallReceiver.InstallListener {
    public static final String ACTION_DOWNLOAD = "com.baidu.channel.aladdin.downloadapk";
    public static final String CB_PARAM_DATA = "data";
    public static final String CB_PARAM_MESSAGE = "message";
    public static final String CB_PARAM_PREFIX = "javascript:";
    public static final String CB_PARAM_RESULT = "result";
    public static final String CB_PARAM_RESULT_COMPLETE_TIME = "completime";
    public static final String CB_PARAM_RESULT_DOWN_STATUS = "downStatus";
    public static final String CB_PARAM_RESULT_FILE_ID = "file_id";
    public static final String CB_PARAM_RESULT_PACKAGE = "packageName";
    public static final String CB_PARAM_RESULT_PROCESS = "process";
    public static final String CB_PARAM_RESULT_URI = "uri";
    public static final String CB_PARAM_STATUS = "status";
    public static final String DL_TYPE_JMY = "lp_JMY";
    public static final String EVENT_DOWNLOAD_STATE_CHANGE = "AdStatusChange";
    public static final String INPUT_PARAM_ACTION = "action";
    public static final String INPUT_PARAM_APP_NAME = "appName";
    public static final String INPUT_PARAM_APP_URL = "appUrl";
    public static final String INPUT_PARAM_CALLBACK = "callback";
    public static final String INPUT_PARAM_DEEP_LINK_CALLBACK = "callback";
    public static final String INPUT_PARAM_DEEP_LINK_PARAMS = "params";
    public static final String INPUT_PARAM_DEEP_LINK_PARAMS_APP_URL = "appUrl";
    public static final String INPUT_PARAM_DEEP_LINK_URL = "deeplinkUrl";
    public static final String INPUT_PARAM_DIRECT_LAUNCH = "isStoreDirectLaunch";
    public static final String INPUT_PARAM_DOWNLOAD_URL = "downloadUrl";
    public static final String INPUT_PARAM_FILE_ID = "file_id";
    public static final String INPUT_PARAM_ICON_URL = "packageImg";
    public static final String INPUT_PARAM_IS_USER_ACTION = "isActiveStoreDirectLaunch";
    public static final String INPUT_PARAM_PACKAGE_NAME = "packageName";
    public static final String INPUT_PARAM_PK = "packageName";
    public static final String INPUT_PARAM_QUERY = "query";
    public static final String INPUT_PARAM_ROOT = "params";
    public static final String INPUT_PARAM_TYPE = "type";
    public static final String INPUT_PARAM_URI = "uri";
    public static final String INPUT_PARAM_URL = "url";
    public static final String INPUT_PARAM_WEB_URL = "webUrl";
    public static final String TAG = "JmyJsHandler";
    public static final String TYPE_BATCH_GET_DOWNLOAD_STATUS = "batchgetdownloadstatus";
    public static final String TYPE_CANCEL_DOWNLOAD = "canceldownload";
    public static final String TYPE_INSTALL_APK = "installapk";
    public static final String TYPE_OPEN_APK = "openapk";
    public static final String TYPE_PAUSE_DOWNLOAD = "pausedownload";
    public static final String TYPE_REGISTER = "register";
    public static final String TYPE_RESUME_DOWNLOAD = "resumedownload";
    public static final String TYPE_START_DOWNLOAD = "startdownload";
    public static final String TYPE_UNREGISTER = "unregister";
    public static final String V16_PARAM_PK = "pkg";
    public static final String V16_PARAM_SCHEME = "scheme";
    public static final String V16_QUERY_URL_PREFIX = "baiduboxapp://v16/utils/queryScheme?";
    public static final String V7_DEEPLINK_PREFIX = "baiduboxapp://v7/vendor/ad/deeplink?";
    public static final String V7_DOWNLOAD_URL_PREFIX = "baiduboxapp://v7/vendor/ad/download?";
    public static final String V7_REGISTER_DEEPLINK_PREFIX = "baiduboxapp://v7/vendor/ad/registerDeeplink?";
    public IXAdInstanceInfo mAdInstanceInfo;
    public String mAppsid;
    public Context mContext;
    public String mProd;
    public WebView mWebView;
    public HashMap<String, DownloadAppInfo> mAppInfoMap = new HashMap<>();
    public boolean mIsAppBackground = false;

    /* loaded from: classes2.dex */
    public class DownloadAppInfo {
        public XAdRemoteDownloadAdInfo mDownloadAdInfo;
        public String mFileId;
        public String mPk;
        public String mDownStatus = "0";
        public String mProcess = "0";
        public String mCompleteTime = "";
        public String mUri = "";
        public String mCallBack = "";
        public String mDeepLinkUrl = "";
        public String mDeepLinkCallBack = "";
        public boolean isDirectLaunch = false;
        public boolean isUserAction = false;
        public boolean isRegisterInstallListener = false;
        public AtomicBoolean mDlCompleted = new AtomicBoolean(false);

        public DownloadAppInfo(String str, String str2) {
            this.mPk = "";
            this.mFileId = "";
            this.mPk = str;
            this.mFileId = str2;
        }

        public JSONObject getCallBackJSON() {
            try {
                JSONObject callbackParams = BaiduAppJsBridgeHandler.this.getCallbackParams("0", "success");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaiduAppJsBridgeHandler.CB_PARAM_RESULT_DOWN_STATUS, this.mDownStatus);
                jSONObject.put("process", this.mProcess);
                jSONObject.put("uri", this.mUri);
                jSONObject.put("file_id", this.mFileId);
                jSONObject.put(BaiduAppJsBridgeHandler.CB_PARAM_RESULT_COMPLETE_TIME, this.mCompleteTime);
                callbackParams.put("data", jSONObject);
                return callbackParams;
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().i(BaiduAppJsBridgeHandler.TAG, th.getMessage());
                return null;
            }
        }

        public void setDownloadAdInfo(XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo) {
            this.mDownloadAdInfo = xAdRemoteDownloadAdInfo;
        }

        public void setFileUri(String str) {
            this.mUri = BaiduAppJsBridgeHandler.this.getUriForFile(str);
        }

        public void updateStatus(String str, String str2) {
            this.mDownStatus = str;
            this.mProcess = str2;
            if ("3".equals(str)) {
                this.mCompleteTime = "" + System.currentTimeMillis();
            }
        }
    }

    public BaiduAppJsBridgeHandler(Context context, WebView webView, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2) {
        this.mContext = context;
        this.mWebView = webView;
        this.mAdInstanceInfo = iXAdInstanceInfo;
        this.mProd = str;
        this.mAppsid = str2;
    }

    private JSONObject cancelDownload(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str);
            if (adsApkDownloader != null) {
                adsApkDownloader.cancel();
                return getDownloadStatus(str);
            }
            return getCallbackParams("202", "no available downloader");
        } catch (Throwable unused) {
            return null;
        }
    }

    private XAdRemoteDownloadAdInfo createDownloadAdInfo(String str, String str2, String str3) {
        XAdRemoteDownloadAdInfo createFromInstanceInfo = XAdRemoteDownloadAdInfo.createFromInstanceInfo(this.mAdInstanceInfo);
        createFromInstanceInfo.mIsPopNotif = true;
        createFromInstanceInfo.mDlType = DL_TYPE_JMY;
        createFromInstanceInfo.mProd = this.mProd;
        createFromInstanceInfo.mAppsid = this.mAppsid;
        createFromInstanceInfo.mAppPackageName = str;
        createFromInstanceInfo.mAppName = str2;
        createFromInstanceInfo.mTitle = str2;
        createFromInstanceInfo.mAutoOpen = false;
        createFromInstanceInfo.mActionOnlyWifi = false;
        createFromInstanceInfo.addExtraParam("creative_id", RemoteCommonUtils.getInstance().getStringFromJson(this.mAdInstanceInfo.getOriginJsonObject(), "creative_id"));
        createFromInstanceInfo.addExtraParam("uniqueId", this.mAdInstanceInfo.getUniqueId());
        createFromInstanceInfo.addExtraParam("icon_url", str3);
        return createFromInstanceInfo;
    }

    private JSONObject getBatchDownloadStatus(String str) {
        try {
            DownloadAppInfo queryDownloadAppInfoByFileId = queryDownloadAppInfoByFileId(str);
            if (queryDownloadAppInfoByFileId == null) {
                return null;
            }
            updateDownloadStatus(queryDownloadAppInfoByFileId);
            JSONObject callbackParams = getCallbackParams("0", "success");
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CB_PARAM_RESULT_DOWN_STATUS, queryDownloadAppInfoByFileId.mDownStatus);
            jSONObject2.put("process", queryDownloadAppInfoByFileId.mProcess);
            jSONObject2.put("uri", queryDownloadAppInfoByFileId.mUri);
            jSONObject2.put("file_id", queryDownloadAppInfoByFileId.mFileId);
            jSONObject2.put(CB_PARAM_RESULT_COMPLETE_TIME, queryDownloadAppInfoByFileId.mCompleteTime);
            jSONArray.put(jSONObject2);
            jSONObject.put("result", jSONArray);
            callbackParams.put("data", jSONObject);
            return callbackParams;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getCallbackParams(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("message", str2);
            return jSONObject;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return null;
        }
    }

    private XAdRemoteDownloadAdInfo getDownloadInfo(String str, String str2) {
        DownloadAppInfo downloadAppInfo;
        if (TextUtils.isEmpty(str) || (downloadAppInfo = this.mAppInfoMap.get(str)) == null || downloadAppInfo.mDownloadAdInfo == null) {
            return null;
        }
        downloadAppInfo.mDlCompleted.set(false);
        XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo = downloadAppInfo.mDownloadAdInfo;
        xAdRemoteDownloadAdInfo.mClickThroughUrl = str2;
        return xAdRemoteDownloadAdInfo;
    }

    private JSONObject getDownloadStatus(String str) {
        try {
            DownloadAppInfo downloadAppInfo = this.mAppInfoMap.get(str);
            if (downloadAppInfo != null) {
                updateDownloadStatus(downloadAppInfo);
                return downloadAppInfo.getCallBackJSON();
            }
            return null;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return null;
        }
    }

    private JSONObject getParams(String str) {
        try {
            String queryParameter = getQueryParameter(str, "params");
            if (TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            return new JSONObject(queryParameter);
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return null;
        }
    }

    private String getQueryParameter(String str, String str2) {
        try {
            Uri parse = Uri.parse(str);
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "getQueryParameter: " + parse.toString());
            return parse.getQueryParameter(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUriForFile(String str) {
        Uri uriForFileByProvider;
        try {
            File file = new File(str);
            if (file.exists()) {
                if (!AppUtils.needProviderForDl(this.mContext)) {
                    uriForFileByProvider = Uri.fromFile(file);
                } else {
                    uriForFileByProvider = AppUtils.getUriForFileByProvider(this.mContext, file);
                }
                return uriForFileByProvider != null ? uriForFileByProvider.toString() : "";
            }
            return "";
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return "";
        }
    }

    private JSONObject installApk(String str, String str2) {
        DownloadAppInfo downloadAppInfo;
        XAdRemoteAPKDownloadExtraInfo storedDownloadInfo;
        try {
            if (TextUtils.isEmpty(str) || (downloadAppInfo = this.mAppInfoMap.get(str)) == null) {
                return null;
            }
            if (TextUtils.isEmpty(str2) && (storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(this.mContext, str)) != null) {
                str2 = getUriForFile(storedDownloadInfo.outputFolder + storedDownloadInfo.outputFileName);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(RouterCallback.CODE_ERROR);
            intent.setDataAndType(Uri.parse(str2), "application/vnd.android.package-archive");
            if (AppUtils.isHideInstallComplete()) {
                intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            registerInstallListener(downloadAppInfo);
            this.mContext.startActivity(intent);
            return getCallbackParams("0", "success");
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th);
        }
        return null;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'NameNotFoundException', keep only Throwable */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAppInstalled(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PackageManager packageManager = this.mContext.getPackageManager();
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "judge pkg :" + str);
            packageManager.getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isAvailableScheme(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            return this.mContext.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isLocalFileExist(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject loadWebUrl(String str) {
        try {
            if (this.mWebView != null) {
                this.mWebView.loadUrl(str);
                return getCallbackParams("0", "success");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject openApp(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                if (this.mContext.getPackageManager().resolveActivity(intent, 65536) != null) {
                    this.mContext.startActivity(intent);
                    return getCallbackParams("0", "success");
                }
                return null;
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                OpenAppUtils.openApp(this.mContext, str);
                return getCallbackParams("0", "success");
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private void parseDeepLinkUrl(String str, String str2) {
        DownloadAppInfo downloadAppInfo;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (downloadAppInfo = this.mAppInfoMap.get(str)) == null) {
            return;
        }
        downloadAppInfo.mDeepLinkCallBack = getQueryParameter(str2, "callback");
        try {
            downloadAppInfo.mDeepLinkUrl = new JSONObject(getQueryParameter(str2, "params")).optString("appUrl");
        } catch (Throwable unused) {
        }
    }

    private JSONObject pauseDownload(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str);
            if (adsApkDownloader != null) {
                adsApkDownloader.pause();
                return getDownloadStatus(str);
            }
            return getCallbackParams("202", "no available downloader");
        } catch (Throwable unused) {
            return null;
        }
    }

    private DownloadAppInfo queryDownloadAppInfoByFileId(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.mAppInfoMap.isEmpty()) {
                return null;
            }
            for (String str2 : this.mAppInfoMap.keySet()) {
                DownloadAppInfo downloadAppInfo = this.mAppInfoMap.get(str2);
                if (downloadAppInfo != null && str.equals(downloadAppInfo.mFileId)) {
                    return downloadAppInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return null;
        }
    }

    private String readFileIdForBatch(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONArray(str).optJSONObject(0).optString("file_id");
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
            return "";
        }
    }

    private void registerDirectLaunch(boolean z, final String str, final String str2) {
        DownloadAppInfo downloadAppInfo = this.mAppInfoMap.get(str);
        if (downloadAppInfo != null) {
            registerInstallListener(downloadAppInfo);
            downloadAppInfo.isDirectLaunch = true;
            downloadAppInfo.isUserAction = z;
        }
        if (z) {
            final OAdTimer oAdTimer = new OAdTimer(5000, 500);
            this.mIsAppBackground = false;
            oAdTimer.setEventHandler(new OAdTimer.EventHandler() { // from class: com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler.2
                @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                public void onTimer(int i2) {
                    if (!AppUtils.isForeground(BaiduAppJsBridgeHandler.this.mContext, BaiduAppJsBridgeHandler.this.mContext.getPackageName())) {
                        BaiduAppJsBridgeHandler.this.mIsAppBackground = true;
                    }
                    if (!BaiduAppJsBridgeHandler.this.isAppInstalled(str)) {
                        if (BaiduAppJsBridgeHandler.this.mIsAppBackground && AppUtils.isForeground(BaiduAppJsBridgeHandler.this.mContext, BaiduAppJsBridgeHandler.this.mContext.getPackageName())) {
                            JSONObject startDownloader = BaiduAppJsBridgeHandler.this.startDownloader(str2, str);
                            if (startDownloader == null) {
                                startDownloader = BaiduAppJsBridgeHandler.this.getCallbackParams("202", "download_failed");
                            }
                            BaiduAppJsBridgeHandler.this.sendSDKTypeLog(SDKLogTypeConstants.TYPE_JMY_DIRECT_LAUNCH, "download_app", str, "", startDownloader);
                            oAdTimer.stop();
                            return;
                        }
                        return;
                    }
                    BaiduAppJsBridgeHandler baiduAppJsBridgeHandler = BaiduAppJsBridgeHandler.this;
                    baiduAppJsBridgeHandler.sendSDKTypeLog(SDKLogTypeConstants.TYPE_JMY_DIRECT_LAUNCH, "already installed", str, "", baiduAppJsBridgeHandler.getCallbackParams("0", "success"));
                    oAdTimer.stop();
                }

                @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                public void onTimerComplete() {
                    BaiduAppJsBridgeHandler.this.sendSDKTypeLog(SDKLogTypeConstants.TYPE_JMY_DIRECT_LAUNCH, "wait_over_time", str, "", new JSONObject());
                }
            });
            oAdTimer.start();
        }
    }

    private boolean registerDownloadAppInfo(String str, String str2, String str3, String str4, String str5) {
        if (!this.mAppInfoMap.containsKey(str)) {
            DownloadAppInfo downloadAppInfo = new DownloadAppInfo(str, str2);
            downloadAppInfo.setDownloadAdInfo(createDownloadAdInfo(str, str4, str5));
            downloadAppInfo.mCallBack = str3;
            downloadAppInfo.mFileId = str2;
            this.mAppInfoMap.put(str, downloadAppInfo);
            return true;
        }
        DownloadAppInfo downloadAppInfo2 = this.mAppInfoMap.get(str);
        if (downloadAppInfo2 != null) {
            downloadAppInfo2.mFileId = str2;
            downloadAppInfo2.mCallBack = str3;
            XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo = downloadAppInfo2.mDownloadAdInfo;
            if (xAdRemoteDownloadAdInfo != null) {
                xAdRemoteDownloadAdInfo.mAppName = str4;
                xAdRemoteDownloadAdInfo.addExtraParam("icon_url", str5);
            } else {
                downloadAppInfo2.setDownloadAdInfo(createDownloadAdInfo(str, str4, str5));
            }
            return true;
        }
        return false;
    }

    private void registerInstallListener(DownloadAppInfo downloadAppInfo) {
        if (downloadAppInfo == null || downloadAppInfo.isRegisterInstallListener) {
            return;
        }
        XAdInstallController.getInstance().registerInstallReceiver(this.mContext, new XAdRemoteAPKDownloadExtraInfo(downloadAppInfo.mPk, ""));
        XAdInstallController.getInstance().setInstallListener(downloadAppInfo.mPk, this);
        downloadAppInfo.isRegisterInstallListener = true;
    }

    private JSONObject resumeDownload(String str, String str2) {
        try {
            XAdRemoteDownloadAdInfo downloadInfo = getDownloadInfo(str2, str);
            if (downloadInfo != null && new XAdRemoteDownloadAPKCommand(this.mContext, downloadInfo, this).resumeDownload()) {
                return getDownloadStatus(str2);
            }
            return getCallbackParams("202", "no available downloader");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runJsCallback(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && this.mWebView != null) {
            String str2 = "javascript:" + str + "(\"" + jSONObject.toString().replace("\"", "\\\"") + "\")";
            RemoteXAdLogger.getInstance().d(TAG, str2);
            this.mWebView.loadUrl(str2);
            return;
        }
        RemoteXAdLogger.getInstance().d(TAG, "callback is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSDKTypeLog(int i2, String str, String str2, String str3, JSONObject jSONObject) {
        if (jSONObject != null) {
            DownloadAppInfo downloadAppInfo = null;
            try {
                if (TextUtils.isEmpty(str2)) {
                    downloadAppInfo = queryDownloadAppInfoByFileId(str3);
                } else if (this.mAppInfoMap.containsKey(str2)) {
                    downloadAppInfo = this.mAppInfoMap.get(str2);
                }
                SendLogUtil.Builder append = SendLogUtil.Builder.create(this.mContext).appendType(i2).appendProdType(this.mProd).appendAppSid(this.mAppsid).appendAdInfo(this.mAdInstanceInfo).append("msg", str).append("status", jSONObject.optString("status")).append("message", jSONObject.optString("message")).append("dl_type", DL_TYPE_JMY);
                if (downloadAppInfo != null) {
                    append.append("pk", downloadAppInfo.mPk).append("file_id", downloadAppInfo.mFileId).append("isDirectLaunch", downloadAppInfo.isDirectLaunch).append("isUserAction", downloadAppInfo.isUserAction);
                    String str4 = downloadAppInfo.mDeepLinkUrl;
                    if (!TextUtils.isEmpty(str4) && str4.length() > 64) {
                        str4 = str4.substring(0, 64);
                    }
                    append.append("page", str4);
                } else {
                    append.append("pk", str2);
                    append.append("file_id", str3);
                }
                append.send();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject startDownloader(String str, String str2) {
        try {
            XAdRemoteDownloadAdInfo downloadInfo = getDownloadInfo(str2, str);
            if (downloadInfo != null) {
                new XAdRemoteDownloadAPKCommand(this.mContext, downloadInfo, this).execute();
                return getDownloadStatus(str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void stopAllListener() {
    }

    private void updateDownloadStatus(DownloadAppInfo downloadAppInfo) {
        IDownloader.DownloadStatus state;
        String str;
        String outputPath;
        IDownloader.DownloadStatus downloadStatus;
        IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(downloadAppInfo.mPk);
        if (adsApkDownloader == null) {
            XAdRemoteAPKDownloadExtraInfo storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(this.mContext, downloadAppInfo.mPk);
            if (storedDownloadInfo == null || !((downloadStatus = storedDownloadInfo.status) == IDownloader.DownloadStatus.COMPLETED || downloadStatus == IDownloader.DownloadStatus.PAUSED || downloadStatus == IDownloader.DownloadStatus.CANCELLED)) {
                state = null;
                outputPath = "";
                str = "0";
            } else {
                state = storedDownloadInfo.status;
                str = "" + storedDownloadInfo.progress;
                outputPath = storedDownloadInfo.outputFolder + storedDownloadInfo.outputFileName;
            }
        } else {
            state = adsApkDownloader.getState();
            str = "" + ((int) adsApkDownloader.getProgress());
            outputPath = adsApkDownloader.getOutputPath();
        }
        if (state != null) {
            if (state == IDownloader.DownloadStatus.INITING) {
                downloadAppInfo.updateStatus("5", "0");
                return;
            } else if (state == IDownloader.DownloadStatus.DOWNLOADING) {
                downloadAppInfo.updateStatus("1", str);
                downloadAppInfo.setFileUri(outputPath + ".tmp");
                return;
            } else if (state == IDownloader.DownloadStatus.COMPLETED) {
                if (isLocalFileExist(outputPath)) {
                    downloadAppInfo.updateStatus("3", "100");
                    downloadAppInfo.setFileUri(outputPath);
                    downloadAppInfo.mDlCompleted.set(true);
                    return;
                }
                downloadAppInfo.updateStatus("0", "0");
                return;
            } else if (state != IDownloader.DownloadStatus.CANCELLED && state != IDownloader.DownloadStatus.PAUSED) {
                if (state != IDownloader.DownloadStatus.ERROR && state != IDownloader.DownloadStatus.COMPLETE_BUT_FILE_REMOVED) {
                    downloadAppInfo.updateStatus("0", "0");
                    return;
                }
                downloadAppInfo.updateStatus("4", "0");
                downloadAppInfo.setFileUri(outputPath + ".tmp");
                return;
            } else {
                downloadAppInfo.updateStatus("2", str);
                downloadAppInfo.setFileUri(outputPath + ".tmp");
                return;
            }
        }
        downloadAppInfo.updateStatus("0", "0");
    }

    public void handleShouldOverrideUrlLoading(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject callbackParams;
        try {
        } catch (Throwable unused) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RemoteXAdLogger.getInstance().d(TAG, "URL: " + str);
        JSONObject params = getParams(str);
        JSONObject jSONObject = null;
        String queryParameter = getQueryParameter(str, "callback");
        String str7 = "success";
        String str8 = "0";
        if (str.startsWith(V7_DOWNLOAD_URL_PREFIX) && params != null) {
            String optString = params.optString("type");
            String optString2 = params.optString("packageName");
            String optString3 = params.optString("callback");
            String str9 = "V7_DOWNLOAD_URL_PREFIX_" + optString;
            if ("register".equals(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    str6 = params.optString("file_id");
                    String optString4 = params.optString("appName");
                    String optString5 = params.optString(INPUT_PARAM_ICON_URL);
                    if (ACTION_DOWNLOAD.equals(params.optString("action"))) {
                        if (registerDownloadAppInfo(optString2, str6, optString3, optString4, optString5)) {
                            jSONObject = getCallbackParams("0", "success");
                        }
                    } else {
                        jSONObject = getCallbackParams("202", "register wrong action");
                    }
                    str3 = optString2;
                    queryParameter = optString3;
                    str2 = str9;
                }
                str6 = "";
                str3 = optString2;
                queryParameter = optString3;
                str2 = str9;
            } else {
                if (TYPE_START_DOWNLOAD.equals(optString)) {
                    callbackParams = startDownloader(params.optString("url"), optString2);
                } else if (TYPE_RESUME_DOWNLOAD.equals(optString)) {
                    callbackParams = resumeDownload(params.optString("url"), optString2);
                } else if (TYPE_PAUSE_DOWNLOAD.equals(optString)) {
                    callbackParams = pauseDownload(optString2);
                } else if (TYPE_CANCEL_DOWNLOAD.equals(optString)) {
                    callbackParams = cancelDownload(optString2);
                } else if (TYPE_INSTALL_APK.equals(optString)) {
                    callbackParams = installApk(optString2, params.optString("uri"));
                } else if (TYPE_OPEN_APK.equals(optString)) {
                    callbackParams = openApp(optString2, "");
                } else if (TYPE_BATCH_GET_DOWNLOAD_STATUS.equals(optString)) {
                    str6 = readFileIdForBatch(params.optString("query"));
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject = getBatchDownloadStatus(str6);
                    }
                    str3 = optString2;
                    queryParameter = optString3;
                    str2 = str9;
                } else {
                    if ("unregister".equals(optString)) {
                        this.mAppInfoMap.clear();
                        stopAllListener();
                        callbackParams = getCallbackParams("0", "success");
                    }
                    str6 = "";
                    str3 = optString2;
                    queryParameter = optString3;
                    str2 = str9;
                }
                jSONObject = callbackParams;
                str6 = "";
                str3 = optString2;
                queryParameter = optString3;
                str2 = str9;
            }
            return;
        } else if (str.startsWith(V7_REGISTER_DEEPLINK_PREFIX) && params != null) {
            String optString6 = params.optString("packageName");
            parseDeepLinkUrl(optString6, params.optString(INPUT_PARAM_DEEP_LINK_URL));
            str3 = optString6;
            str2 = "V7_REGISTER_DEEPLINK_PREFIX";
            str6 = "";
        } else {
            if (str.startsWith(V7_DEEPLINK_PREFIX) && params != null) {
                String optString7 = params.optString("appUrl");
                String optString8 = params.optString(INPUT_PARAM_WEB_URL);
                if (!TextUtils.isEmpty(optString7)) {
                    jSONObject = openApp("", optString7);
                    if (params.optBoolean(INPUT_PARAM_DIRECT_LAUNCH, false)) {
                        registerDirectLaunch(params.optBoolean(INPUT_PARAM_IS_USER_ACTION, false), params.optString("packageName"), params.optString(INPUT_PARAM_DOWNLOAD_URL));
                    }
                } else if (!TextUtils.isEmpty(optString8)) {
                    jSONObject = loadWebUrl(optString8);
                }
                str2 = "V7_DEEPLINK_PREFIX";
                str3 = "";
            } else if (str.startsWith(V16_QUERY_URL_PREFIX)) {
                JSONObject jSONObject2 = new JSONObject();
                if (params != null) {
                    str3 = params.optString("pkg");
                    str5 = params.optString("scheme");
                    str4 = params.optString("file_id");
                } else {
                    str4 = "";
                    str3 = str4;
                    str5 = str3;
                }
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5)) {
                    jSONObject2.put("result", "-1");
                    str8 = "202";
                    str7 = "";
                } else if (isAvailableScheme(str5)) {
                    jSONObject2.put("result", "0");
                } else if (isAppInstalled(str3)) {
                    jSONObject2.put("result", "0");
                } else {
                    jSONObject2.put("result", "1");
                }
                jSONObject2.put("packageName", str3);
                jSONObject2.put("file_id", str4);
                jSONObject = new JSONObject();
                jSONObject.put("status", str8);
                jSONObject.put("message", str7);
                jSONObject.put("data", jSONObject2);
                str6 = str4;
                str2 = "V16_QUERY_URL_PREFIX";
            } else {
                str2 = "";
                str3 = str2;
            }
            str6 = str3;
        }
        JSONObject callbackParams2 = jSONObject == null ? getCallbackParams("202", "") : jSONObject;
        runJsCallback(queryParameter, callbackParams2);
        sendSDKTypeLog(SDKLogTypeConstants.TYPE_JMY_ACTION, str2, str3, str6, callbackParams2);
    }

    public boolean isJimuyuUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(V7_DOWNLOAD_URL_PREFIX) || str.startsWith(V7_REGISTER_DEEPLINK_PREFIX) || str.startsWith(V16_QUERY_URL_PREFIX) || str.startsWith(V7_DEEPLINK_PREFIX);
    }

    @Override // com.baidu.mobads.container.components.controller.InstallReceiver.InstallListener
    public void onPackageInstalled(Context context, Intent intent) {
        try {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return;
            }
            String replace = dataString.replace("package:", "");
            if (this.mAppInfoMap.containsKey(replace)) {
                final DownloadAppInfo downloadAppInfo = this.mAppInfoMap.get(replace);
                downloadAppInfo.mDownStatus = "6";
                runJsCallback(downloadAppInfo.mCallBack, downloadAppInfo.getCallBackJSON());
                if (!TextUtils.isEmpty(downloadAppInfo.mDeepLinkCallBack) || downloadAppInfo.isDirectLaunch) {
                    final OAdTimer oAdTimer = new OAdTimer(5000, 1000);
                    oAdTimer.setEventHandler(new OAdTimer.EventHandler() { // from class: com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler.1
                        @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                        public void onTimer(int i2) {
                            if (AppUtils.isForeground(BaiduAppJsBridgeHandler.this.mContext, BaiduAppJsBridgeHandler.this.mContext.getPackageName())) {
                                BaiduAppJsBridgeHandler baiduAppJsBridgeHandler = BaiduAppJsBridgeHandler.this;
                                DownloadAppInfo downloadAppInfo2 = downloadAppInfo;
                                JSONObject openApp = baiduAppJsBridgeHandler.openApp(downloadAppInfo2.mPk, downloadAppInfo2.mDeepLinkUrl);
                                if (openApp == null) {
                                    openApp = BaiduAppJsBridgeHandler.this.getCallbackParams("202", "");
                                }
                                JSONObject jSONObject = openApp;
                                BaiduAppJsBridgeHandler.this.runJsCallback(downloadAppInfo.mDeepLinkCallBack, jSONObject);
                                BaiduAppJsBridgeHandler baiduAppJsBridgeHandler2 = BaiduAppJsBridgeHandler.this;
                                DownloadAppInfo downloadAppInfo3 = downloadAppInfo;
                                baiduAppJsBridgeHandler2.sendSDKTypeLog(SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, "success", downloadAppInfo3.mPk, downloadAppInfo3.mFileId, jSONObject);
                                oAdTimer.stop();
                            }
                        }

                        @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                        public void onTimerComplete() {
                            JSONObject callbackParams = BaiduAppJsBridgeHandler.this.getCallbackParams("202", "over 5 seconds");
                            BaiduAppJsBridgeHandler.this.runJsCallback(downloadAppInfo.mDeepLinkCallBack, callbackParams);
                            BaiduAppJsBridgeHandler baiduAppJsBridgeHandler = BaiduAppJsBridgeHandler.this;
                            DownloadAppInfo downloadAppInfo2 = downloadAppInfo;
                            baiduAppJsBridgeHandler.sendSDKTypeLog(SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, "wait_over_time", downloadAppInfo2.mPk, downloadAppInfo2.mFileId, callbackParams);
                        }
                    });
                    oAdTimer.start();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null || !"AdStatusChange".equals(iOAdEvent.getType())) {
            return;
        }
        String message = iOAdEvent.getMessage();
        if (TextUtils.isEmpty(message) || !this.mAppInfoMap.containsKey(message)) {
            return;
        }
        try {
            DownloadAppInfo downloadAppInfo = this.mAppInfoMap.get(message);
            if (downloadAppInfo == null) {
                return;
            }
            updateDownloadStatus(downloadAppInfo);
            JSONObject callBackJSON = downloadAppInfo.getCallBackJSON();
            if (downloadAppInfo.mDlCompleted.get()) {
                if (isAppInstalled(message)) {
                    openApp(message, downloadAppInfo.mDeepLinkUrl);
                } else {
                    installApk(message, callBackJSON.optString("uri"));
                }
            }
            if (TextUtils.isEmpty(downloadAppInfo.mCallBack) || this.mWebView == null) {
                return;
            }
            if (isAppInstalled(message)) {
                downloadAppInfo.mDownStatus = "6";
                callBackJSON = downloadAppInfo.getCallBackJSON();
            }
            runJsCallback(downloadAppInfo.mCallBack, callBackJSON);
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(TAG, th.getMessage());
        }
    }
}
