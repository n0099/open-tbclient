package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.container.components.controller.XAdInstallController;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.io.File;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdRemoteDownloadAPKCommand {
    public static final String TAG = "XAdRemoteDownloadAPKCommand";
    public XAdRemoteDownloadAdInfo mAdInstanceInfo;
    public RemoteXAdLogger mAdLogger;
    public Context mContext;
    public IOAdEventListener mDlStatusListener;

    public XAdRemoteDownloadAPKCommand(Context context, XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo) {
        this(context, xAdRemoteDownloadAdInfo, null);
    }

    private boolean adAppInstalled() {
        return AdDownloadApkUtils.isInstalled(this.mContext, this.mAdInstanceInfo.getAppPackageName());
    }

    private String getDownloadTitle(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        String str = xAdRemoteAPKDownloadExtraInfo.mTitle;
        String str2 = xAdRemoteAPKDownloadExtraInfo.mAppName;
        return (str2 == null || str2.isEmpty()) ? str : xAdRemoteAPKDownloadExtraInfo.mAppName;
    }

    private String getPackageName() {
        try {
            String appPackageName = this.mAdInstanceInfo.getAppPackageName();
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "download pkg = " + appPackageName + "， DownloadURL= " + this.mAdInstanceInfo.getClickThroughUrl());
            if (!TextUtils.isEmpty(appPackageName) || TextUtils.isEmpty(this.mAdInstanceInfo.getClickThroughUrl())) {
                return appPackageName;
            }
            this.mAdLogger.i(TAG, "start to download but package is empty");
            return EncryptUtils.getMD5(this.mAdInstanceInfo.getClickThroughUrl());
        } catch (Throwable th) {
            this.mAdLogger.i(TAG, th.getMessage());
            return "";
        }
    }

    private boolean isFileExpired(File file, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        try {
            if (System.currentTimeMillis() - file.lastModified() <= 1296000000 || !file.delete()) {
                return false;
            }
            xAdRemoteAPKDownloadExtraInfo.dlCnt = 0;
            xAdRemoteAPKDownloadExtraInfo.progress = 0;
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void stateEvent(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, AdStateCode adStateCode) {
        if (xAdRemoteAPKDownloadExtraInfo != null) {
            try {
                if (xAdRemoteAPKDownloadExtraInfo.mExtras != null && adStateCode != null) {
                    String str = xAdRemoteAPKDownloadExtraInfo.mExtras.get("uniqueId");
                    if (AdStateCode.EVENT_AD_STATE_END.getCode() == adStateCode.getCode()) {
                        StateMachine.finish(str);
                    } else {
                        StateMachine.event(str, adStateCode);
                    }
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
            }
        }
    }

    private void updateAdInfoInDownloadExtraInfo(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo;
        if (xAdRemoteAPKDownloadExtraInfo == null || (xAdRemoteDownloadAdInfo = this.mAdInstanceInfo) == null) {
            return;
        }
        xAdRemoteAPKDownloadExtraInfo.popNotify = xAdRemoteDownloadAdInfo.isPopNotif();
        xAdRemoteAPKDownloadExtraInfo.mobileConfirmed = !this.mAdInstanceInfo.isActionOnlyWifi();
        xAdRemoteAPKDownloadExtraInfo.autoOpen = this.mAdInstanceInfo.isAutoOpen();
        xAdRemoteAPKDownloadExtraInfo.mAPOOpen = false;
        xAdRemoteAPKDownloadExtraInfo.mUrl = this.mAdInstanceInfo.getClickThroughUrl();
        if (this.mAdInstanceInfo.getAPOOpen() && !TextUtils.isEmpty(this.mAdInstanceInfo.getPage())) {
            xAdRemoteAPKDownloadExtraInfo.mAPOOpen = true;
            xAdRemoteAPKDownloadExtraInfo.mPage = this.mAdInstanceInfo.getPage();
        }
        xAdRemoteAPKDownloadExtraInfo.copyExtraFrom(this.mAdInstanceInfo.getExtras());
        xAdRemoteAPKDownloadExtraInfo.addExtra("dl_type", this.mAdInstanceInfo.mDlType);
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_qk", this.mAdInstanceInfo.getQueryKey());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_adid", this.mAdInstanceInfo.getAdId());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_buyer", this.mAdInstanceInfo.mBuyer);
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_apid", this.mAdInstanceInfo.getApId());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_prod", this.mAdInstanceInfo.getProd());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_appsid", this.mAdInstanceInfo.getAppsid());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_url", this.mAdInstanceInfo.getClickThroughUrl());
        try {
            xAdRemoteAPKDownloadExtraInfo.addExtra("act", String.valueOf(this.mAdInstanceInfo.getActType()));
        } catch (Exception unused) {
        }
    }

    public boolean dealWithCompleted(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        boolean isInstalled = AdDownloadApkUtils.isInstalled(context, xAdRemoteAPKDownloadExtraInfo.packageName);
        RemoteCommonUtils remoteCommonUtils = RemoteCommonUtils.getInstance();
        if (isInstalled) {
            remoteCommonUtils.sendDownloadApkLog(this.mContext, 529, RemoteCommonUtils.MSG_DOWNLOADED_OPEN_APP, this.mAdInstanceInfo);
            stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_OPEN);
            OpenAppUtils.openApp(context, xAdRemoteAPKDownloadExtraInfo.packageName);
            return true;
        }
        String str = xAdRemoteAPKDownloadExtraInfo.outputFolder + xAdRemoteAPKDownloadExtraInfo.outputFileName;
        File file = new File(str);
        if (!file.exists() || file.length() <= 0 || isFileExpired(file, xAdRemoteAPKDownloadExtraInfo)) {
            return false;
        }
        remoteCommonUtils.sendDownloadApkLog(this.mContext, 529, RemoteCommonUtils.MSG_DOWNLOADED_INSTALL_APP, this.mAdInstanceInfo);
        stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_INSTALL);
        AppUtils.ApkInfo localApkFileInfo = AppUtils.getLocalApkFileInfo(this.mContext, str);
        if (localApkFileInfo != null && !TextUtils.isEmpty(localApkFileInfo.packageName) && !localApkFileInfo.packageName.equals(xAdRemoteAPKDownloadExtraInfo.packageName)) {
            xAdRemoteAPKDownloadExtraInfo.hibernateStatus(this.mContext);
            xAdRemoteAPKDownloadExtraInfo.packageName = localApkFileInfo.packageName;
        }
        XAdInstallController.getInstance().registerInstallReceiver(context, xAdRemoteAPKDownloadExtraInfo);
        AdDownloadApkUtils.installApkWithLog(context, file, xAdRemoteAPKDownloadExtraInfo);
        return true;
    }

    public void execute() {
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo;
        Object obj;
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2;
        try {
            String packageName = getPackageName();
            IDownloader adsApkDownloader = OAdRemoteDownloadManager.getInstance(this.mContext).getAdsApkDownloader(packageName);
            OAdRemoteApkDownloaderObserver globalDownloadObserver = OAdRemoteApkDownloaderObserver.getGlobalDownloadObserver(packageName);
            boolean z = true;
            if (globalDownloadObserver != null && adsApkDownloader != null) {
                xAdRemoteAPKDownloadExtraInfo = globalDownloadObserver.getDownloadInfo();
                globalDownloadObserver.addStatusListener(this.mDlStatusListener);
                updateAdInfoInDownloadExtraInfo(xAdRemoteAPKDownloadExtraInfo);
                adsApkDownloader.setDownloadOnlyWifi(!xAdRemoteAPKDownloadExtraInfo.mobileConfirmed);
                IDownloader.DownloadStatus state = adsApkDownloader.getState();
                RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                remoteXAdLogger.d(TAG, "startDownload>> downloader exist: state=" + state);
                if (state != IDownloader.DownloadStatus.CANCELLED && state != IDownloader.DownloadStatus.ERROR && state != IDownloader.DownloadStatus.PAUSED) {
                    if (state == IDownloader.DownloadStatus.COMPLETED) {
                        if (dealWithCompleted(this.mContext, xAdRemoteAPKDownloadExtraInfo)) {
                            SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                            stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_COMPLETE);
                            stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_AD_STATE_END);
                            return;
                        }
                        adsApkDownloader.cancel();
                        adsApkDownloader.removeObservers();
                        OAdRemoteApkDownloaderObserver.remveGlobalDownloadObserver(packageName);
                        OAdRemoteDownloadManager.getInstance(this.mContext).removeAdsApkDownloader(packageName);
                    } else if (state == IDownloader.DownloadStatus.DOWNLOADING || state == IDownloader.DownloadStatus.INITING) {
                        RemoteCommonUtils.getInstance().sendDownloadApkLog(this.mContext, 529, "downloading", this.mAdInstanceInfo);
                        stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_DOWNLOADING);
                        Context context = this.mContext;
                        makeToast(context, getDownloadTitle(xAdRemoteAPKDownloadExtraInfo) + adsApkDownloader.getState().getMessage(), 0, Boolean.valueOf(this.mAdInstanceInfo.isPopNotif()));
                        return;
                    }
                }
                adsApkDownloader.resume();
                StringBuilder sb = new StringBuilder("resume");
                sb.append("&preState=" + state.getCode());
                RemoteCommonUtils.getInstance().sendDownloadApkLog(this.mContext, 407, sb.toString(), this.mAdInstanceInfo);
                stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_RESUME);
                SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                return;
            }
            if (adsApkDownloader != null) {
                adsApkDownloader.cancel();
                adsApkDownloader.removeObservers();
            }
            OAdRemoteApkDownloaderObserver.remveGlobalDownloadObserver(packageName);
            OAdRemoteDownloadManager.getInstance(this.mContext).removeAdsApkDownloader(packageName);
            xAdRemoteAPKDownloadExtraInfo = null;
            XAdRemoteAPKDownloadExtraInfo storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(this.mContext, packageName);
            if (storedDownloadInfo != null) {
                updateAdInfoInDownloadExtraInfo(storedDownloadInfo);
                if (storedDownloadInfo.status == IDownloader.DownloadStatus.COMPLETED && dealWithCompleted(this.mContext, storedDownloadInfo)) {
                    SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                    stateEvent(storedDownloadInfo, AdStateCode.EVENT_DL_COMPLETE);
                    stateEvent(storedDownloadInfo, AdStateCode.EVENT_AD_STATE_END);
                    return;
                }
                storedDownloadInfo.setSingleAdsRelated(this.mAdInstanceInfo.getQueryKey(), this.mAdInstanceInfo.getAdId(), this.mAdInstanceInfo.getClickThroughUrl(), this.mAdInstanceInfo.isAutoOpen(), this.mAdInstanceInfo.mBuyer);
                storedDownloadInfo.setLocalRelated(EncryptUtils.getMD5(storedDownloadInfo.mUrl) + ".apk", SdcardUtils.getStoragePathForDlApk(this.mContext));
                SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                xAdRemoteAPKDownloadExtraInfo2 = storedDownloadInfo;
                obj = "";
            } else {
                obj = "";
                if (adAppInstalled()) {
                    RemoteCommonUtils.getInstance().sendDownloadApkLog(this.mContext, 529, "alreadyinstalled_call_openapp1", this.mAdInstanceInfo);
                    stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_OPEN);
                    OpenAppUtils.openApp(this.mContext, this.mAdInstanceInfo.getAppPackageName());
                    SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                    return;
                }
                String appName = this.mAdInstanceInfo.getAppName();
                if ((appName == null || appName.equals(obj)) && ((appName = this.mAdInstanceInfo.getTitle()) == null || appName.equals(obj))) {
                    appName = "您点击的应用";
                }
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo3 = new XAdRemoteAPKDownloadExtraInfo(packageName, appName);
                xAdRemoteAPKDownloadExtraInfo3.mAppName = appName;
                xAdRemoteAPKDownloadExtraInfo2 = xAdRemoteAPKDownloadExtraInfo3;
                xAdRemoteAPKDownloadExtraInfo3.setSingleAdsRelated(this.mAdInstanceInfo.getQueryKey(), this.mAdInstanceInfo.getAdId(), this.mAdInstanceInfo.getClickThroughUrl(), this.mAdInstanceInfo.isAutoOpen(), this.mAdInstanceInfo.mBuyer);
                xAdRemoteAPKDownloadExtraInfo2.popNotify = this.mAdInstanceInfo.isPopNotif();
                xAdRemoteAPKDownloadExtraInfo2.setLocalRelated(EncryptUtils.getMD5(xAdRemoteAPKDownloadExtraInfo2.mUrl) + ".apk", SdcardUtils.getStoragePathForDlApk(this.mContext));
                xAdRemoteAPKDownloadExtraInfo2.setPlaceRelated(this.mAdInstanceInfo.getApId(), this.mAdInstanceInfo.getProd(), this.mAdInstanceInfo.getAppsid());
                xAdRemoteAPKDownloadExtraInfo2.notifID = OAdRemoteApkDownloaderObserver.getGlobalNotifId(packageName);
                xAdRemoteAPKDownloadExtraInfo2.mobileConfirmed = !this.mAdInstanceInfo.isActionOnlyWifi();
                xAdRemoteAPKDownloadExtraInfo2.setClickTime(System.currentTimeMillis());
                xAdRemoteAPKDownloadExtraInfo2.setAppSize(this.mAdInstanceInfo.getAppSize());
                xAdRemoteAPKDownloadExtraInfo2.setTooLarge(this.mAdInstanceInfo.isTooLarge());
                xAdRemoteAPKDownloadExtraInfo2.copyExtraFrom(this.mAdInstanceInfo.getExtras());
                xAdRemoteAPKDownloadExtraInfo2.addExtra("dl_type", this.mAdInstanceInfo.mDlType);
                xAdRemoteAPKDownloadExtraInfo2.asl = this.mAdInstanceInfo.getAppStoreLink();
                try {
                    String appOpenStrs = this.mAdInstanceInfo.getAppOpenStrs();
                    JSONObject jSONObject = !TextUtils.isEmpty(appOpenStrs) ? new JSONObject(appOpenStrs) : null;
                    if (jSONObject != null) {
                        xAdRemoteAPKDownloadExtraInfo2.apoPage = jSONObject.optString("page");
                    }
                } catch (Throwable unused) {
                }
                try {
                    xAdRemoteAPKDownloadExtraInfo2.addExtra("act", String.valueOf(this.mAdInstanceInfo.getActType()));
                } catch (Exception unused2) {
                }
            }
            xAdRemoteAPKDownloadExtraInfo2.clickTouchTime = System.currentTimeMillis();
            IDownloader createAdsApkDownloader = OAdRemoteDownloadManager.getInstance(this.mContext).createAdsApkDownloader(new URL(xAdRemoteAPKDownloadExtraInfo2.mUrl), xAdRemoteAPKDownloadExtraInfo2.outputFolder, xAdRemoteAPKDownloadExtraInfo2.outputFileName, 3, xAdRemoteAPKDownloadExtraInfo2.packageName);
            if (this.mAdInstanceInfo.getAPOOpen() && this.mAdInstanceInfo.getPage() != null && !this.mAdInstanceInfo.getPage().equals(obj)) {
                xAdRemoteAPKDownloadExtraInfo2.mAPOOpen = true;
                xAdRemoteAPKDownloadExtraInfo2.mPage = this.mAdInstanceInfo.getPage();
            }
            OAdRemoteApkDownloaderObserver oAdRemoteApkDownloaderObserver = new OAdRemoteApkDownloaderObserver(this.mContext, xAdRemoteAPKDownloadExtraInfo2);
            oAdRemoteApkDownloaderObserver.addStatusListener(this.mDlStatusListener);
            if (xAdRemoteAPKDownloadExtraInfo2.mobileConfirmed) {
                z = false;
            }
            createAdsApkDownloader.setDownloadOnlyWifi(z);
            createAdsApkDownloader.addObserver(oAdRemoteApkDownloaderObserver);
            if (!xAdRemoteAPKDownloadExtraInfo2.mobileConfirmed && !NetworkInfoUtils.isWifiConnected(this.mContext).booleanValue()) {
                RemoteCommonUtils.getInstance().sendDownloadApkLog(this.mContext, 529, "waitwifi", this.mAdInstanceInfo);
                createAdsApkDownloader.pause();
                makeToast(this.mContext, "将在连入Wifi后开始下载", 0, Boolean.valueOf(this.mAdInstanceInfo.isPopNotif()));
                stateEvent(xAdRemoteAPKDownloadExtraInfo2, AdStateCode.EVENT_DL_WAIT_WIFI);
                return;
            }
            RemoteCommonUtils.getInstance().sendDownloadApkLog(this.mContext, 527, "realstart", this.mAdInstanceInfo);
            stateEvent(xAdRemoteAPKDownloadExtraInfo2, AdStateCode.EVENT_DL_START);
            createAdsApkDownloader.start();
            Context context2 = this.mContext;
            makeToast(context2, "开始下载 " + getDownloadTitle(xAdRemoteAPKDownloadExtraInfo2), 0, Boolean.valueOf(this.mAdInstanceInfo.isPopNotif()));
        } catch (Exception e2) {
            this.mAdLogger.e(TAG, e2);
        }
    }

    public void makeToast(final Context context, final String str, final int i, Boolean bool) {
        if (bool.booleanValue()) {
            ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.components.command.XAdRemoteDownloadAPKCommand.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(context, str, i).show();
                }
            });
        }
    }

    public boolean resumeDownload() {
        try {
            String packageName = getPackageName();
            RemoteCommonUtils remoteCommonUtils = RemoteCommonUtils.getInstance();
            IDownloader adsApkDownloader = OAdRemoteDownloadManager.getInstance(this.mContext).getAdsApkDownloader(packageName);
            OAdRemoteApkDownloaderObserver globalDownloadObserver = OAdRemoteApkDownloaderObserver.getGlobalDownloadObserver(packageName);
            if (globalDownloadObserver != null && adsApkDownloader != null) {
                XAdRemoteAPKDownloadExtraInfo downloadInfo = globalDownloadObserver.getDownloadInfo();
                globalDownloadObserver.addStatusListener(this.mDlStatusListener);
                updateAdInfoInDownloadExtraInfo(downloadInfo);
                adsApkDownloader.setDownloadOnlyWifi(!downloadInfo.mobileConfirmed);
                IDownloader.DownloadStatus state = adsApkDownloader.getState();
                RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                remoteXAdLogger.d(TAG, "startDownload>> downloader exist: state=" + state);
                if (state != IDownloader.DownloadStatus.CANCELLED && state != IDownloader.DownloadStatus.ERROR && state != IDownloader.DownloadStatus.PAUSED) {
                    if (state == IDownloader.DownloadStatus.COMPLETED) {
                        if (dealWithCompleted(this.mContext, downloadInfo)) {
                            SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                            stateEvent(downloadInfo, AdStateCode.EVENT_DL_COMPLETE);
                            stateEvent(downloadInfo, AdStateCode.EVENT_AD_STATE_END);
                            return true;
                        }
                        adsApkDownloader.cancel();
                        adsApkDownloader.removeObservers();
                        OAdRemoteApkDownloaderObserver.remveGlobalDownloadObserver(packageName);
                        OAdRemoteDownloadManager.getInstance(this.mContext).removeAdsApkDownloader(packageName);
                    } else if (state == IDownloader.DownloadStatus.DOWNLOADING || state == IDownloader.DownloadStatus.INITING) {
                        remoteCommonUtils.sendDownloadApkLog(this.mContext, 529, "downloading", this.mAdInstanceInfo);
                        stateEvent(downloadInfo, AdStateCode.EVENT_DL_DOWNLOADING);
                        Context context = this.mContext;
                        makeToast(context, getDownloadTitle(downloadInfo) + adsApkDownloader.getState().getMessage(), 0, Boolean.valueOf(this.mAdInstanceInfo.isPopNotif()));
                        return true;
                    }
                }
                adsApkDownloader.resume();
                remoteCommonUtils.sendDownloadApkLog(this.mContext, 407, "resume&preState=" + state.getCode(), this.mAdInstanceInfo);
                stateEvent(downloadInfo, AdStateCode.EVENT_DL_RESUME);
                SendLogUtil.fireAdMetrics(this.mAdInstanceInfo.getClickThroughUrl());
                return true;
            }
            if (adsApkDownloader != null) {
                adsApkDownloader.cancel();
                adsApkDownloader.removeObservers();
            }
            OAdRemoteApkDownloaderObserver.remveGlobalDownloadObserver(packageName);
            OAdRemoteDownloadManager.getInstance(this.mContext).removeAdsApkDownloader(packageName);
            XAdRemoteAPKDownloadExtraInfo storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(this.mContext, packageName);
            if (storedDownloadInfo != null) {
                updateAdInfoInDownloadExtraInfo(storedDownloadInfo);
                if (storedDownloadInfo.status == IDownloader.DownloadStatus.COMPLETED) {
                    if (dealWithCompleted(this.mContext, storedDownloadInfo)) {
                        stateEvent(storedDownloadInfo, AdStateCode.EVENT_DL_COMPLETE);
                        stateEvent(storedDownloadInfo, AdStateCode.EVENT_AD_STATE_END);
                        return true;
                    }
                } else if (storedDownloadInfo.status == IDownloader.DownloadStatus.CANCELLED || storedDownloadInfo.status == IDownloader.DownloadStatus.ERROR || storedDownloadInfo.status == IDownloader.DownloadStatus.PAUSED || storedDownloadInfo.status == IDownloader.DownloadStatus.DOWNLOADING) {
                    storedDownloadInfo.clickTouchTime = System.currentTimeMillis();
                    IDownloader createAdsApkDownloader = OAdRemoteDownloadManager.getInstance(this.mContext).createAdsApkDownloader(new URL(storedDownloadInfo.mUrl), storedDownloadInfo.outputFolder, storedDownloadInfo.outputFileName, 3, storedDownloadInfo.packageName);
                    if (this.mAdInstanceInfo.getAPOOpen() && this.mAdInstanceInfo.getPage() != null && !this.mAdInstanceInfo.getPage().equals("")) {
                        storedDownloadInfo.mAPOOpen = true;
                        storedDownloadInfo.mPage = this.mAdInstanceInfo.getPage();
                    }
                    OAdRemoteApkDownloaderObserver oAdRemoteApkDownloaderObserver = new OAdRemoteApkDownloaderObserver(this.mContext, storedDownloadInfo);
                    oAdRemoteApkDownloaderObserver.addStatusListener(this.mDlStatusListener);
                    createAdsApkDownloader.setDownloadOnlyWifi(!storedDownloadInfo.mobileConfirmed);
                    createAdsApkDownloader.addObserver(oAdRemoteApkDownloaderObserver);
                    remoteCommonUtils.sendDownloadApkLog(this.mContext, 407, "resume_saved_info&preState=" + storedDownloadInfo.status.getCode(), this.mAdInstanceInfo);
                    stateEvent(storedDownloadInfo, AdStateCode.EVENT_DL_RESUME);
                    createAdsApkDownloader.start();
                    return true;
                }
            }
        } catch (Throwable th) {
            this.mAdLogger.e(TAG, th);
        }
        return false;
    }

    public XAdRemoteDownloadAPKCommand(Context context, XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo, IOAdEventListener iOAdEventListener) {
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.mAdInstanceInfo = xAdRemoteDownloadAdInfo;
        this.mContext = context;
        this.mDlStatusListener = iOAdEventListener;
    }
}
