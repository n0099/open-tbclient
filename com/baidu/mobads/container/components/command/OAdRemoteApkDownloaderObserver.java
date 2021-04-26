package com.baidu.mobads.container.components.command;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.app.statistic.c;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.XAdSDKRemoteExp;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.components.controller.XAdInstallController;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.FileUtils;
import com.baidu.mobads.container.util.IReflectionInfo;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.tieba.ala.ALaKeepAliveService;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OAdRemoteApkDownloaderObserver implements Observer, InstallReceiver.InstallListener {
    public static int NOTIF_INC = 10091;
    public static final String TAG = "OAdRemoteApkDownloaderObserver";
    public static HashMap<String, OAdRemoteApkDownloaderObserver> globalDownloadObservers = new HashMap<>();
    public static NotificationManager notificationManger;
    public IDownloader adDownloader;
    public Context mContext;
    public Object mCustomNotification;
    public XAdRemoteAPKDownloadExtraInfo mExtraInfo;
    public Bitmap mNotificationIcon;
    public XAdInstallController ctrl = null;
    public List<WeakReference<IOAdEventListener>> mStatusListenerList = new ArrayList();
    public String fileSizeInMillionBytes = "";
    public boolean isInstallComplete = false;
    public AtomicBoolean mLoadNotifIcon = new AtomicBoolean(false);
    public Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    public OAdRemoteApkDownloaderObserver(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        this.mExtraInfo = null;
        RemoteXAdLogger.getInstance().d(TAG, "observer created");
        if (notificationManger == null) {
            notificationManger = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("down", "下载信息", 2));
        }
        this.mContext = context.getApplicationContext();
        this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
        addGlobalDownloadObserver(xAdRemoteAPKDownloadExtraInfo.packageName, this);
    }

    public static synchronized void addGlobalDownloadObserver(String str, OAdRemoteApkDownloaderObserver oAdRemoteApkDownloaderObserver) {
        synchronized (OAdRemoteApkDownloaderObserver.class) {
            globalDownloadObservers.put(str, oAdRemoteApkDownloaderObserver);
        }
    }

    private void dispatchListeners() {
        final IOAdEventListener iOAdEventListener;
        if (this.mStatusListenerList.size() > 0) {
            try {
                for (WeakReference<IOAdEventListener> weakReference : this.mStatusListenerList) {
                    if (weakReference != null && (iOAdEventListener = weakReference.get()) != null) {
                        this.mainThreadHandler.post(new Runnable() { // from class: com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver.2
                            @Override // java.lang.Runnable
                            public void run() {
                                iOAdEventListener.run(new XAdRemoteEvent("AdStatusChange", OAdRemoteApkDownloaderObserver.this.mExtraInfo.packageName));
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().w(e2.getMessage());
            }
        }
    }

    private String getFormattedSize(long j) {
        long j2 = (j / 1024) / 1024;
        return j2 > 1000 ? String.format(Locale.CHINA, "%.1fG", Float.valueOf(((float) j2) / 1024.0f)) : String.format(Locale.CHINA, "%.1fM", Float.valueOf((float) j2));
    }

    public static synchronized OAdRemoteApkDownloaderObserver getGlobalDownloadObserver(String str) {
        OAdRemoteApkDownloaderObserver oAdRemoteApkDownloaderObserver;
        synchronized (OAdRemoteApkDownloaderObserver.class) {
            oAdRemoteApkDownloaderObserver = globalDownloadObservers.get(str);
        }
        return oAdRemoteApkDownloaderObserver;
    }

    public static synchronized int getGlobalNotifId(String str) {
        synchronized (OAdRemoteApkDownloaderObserver.class) {
            OAdRemoteApkDownloaderObserver oAdRemoteApkDownloaderObserver = globalDownloadObservers.get(str);
            if (oAdRemoteApkDownloaderObserver != null && oAdRemoteApkDownloaderObserver.getDownloadInfo() != null) {
                return oAdRemoteApkDownloaderObserver.getDownloadInfo().notifID;
            }
            int i2 = NOTIF_INC;
            NOTIF_INC = i2 + 1;
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0231  */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification getNotificationByDownloadInfo(IDownloader iDownloader) {
        String str;
        String str2;
        String outputPath;
        String str3;
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = this.mExtraInfo;
        String str4 = xAdRemoteAPKDownloadExtraInfo.mTitle;
        if (!xAdRemoteAPKDownloadExtraInfo.mAppName.isEmpty() && (str3 = this.mExtraInfo.mAppName) != null) {
            str4 = str3;
        }
        String str5 = "正在下载 " + str4;
        int i2 = 17301633;
        IDownloader.DownloadStatus downloadStatus = this.mExtraInfo.status;
        if (downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
            str4 = this.mExtraInfo.status.getMessage() + ": " + str4;
            str2 = this.isInstallComplete ? " 打开应用" : " 点击这里安装应用";
        } else if (downloadStatus == IDownloader.DownloadStatus.PAUSED) {
            str4 = this.mExtraInfo.status.getMessage() + ": " + str4;
            str2 = !iDownloader.isPausedManually() ? "目前不在wifi网络下， 点击这里继续下载" : "点击这里继续下载";
            str5 = "已为您暂停下载， 点击通知栏继续下载";
        } else if (downloadStatus == IDownloader.DownloadStatus.ERROR) {
            str4 = this.mExtraInfo.status.getMessage() + ": " + str4;
            str2 = " 稍后点击这里重新下载";
        } else {
            if (downloadStatus == IDownloader.DownloadStatus.DOWNLOADING) {
                str4 = this.mExtraInfo.status.getMessage() + ": " + str4;
                str = "下载进度: " + this.mExtraInfo.progress + "%  应用大小: " + this.fileSizeInMillionBytes;
            } else if (downloadStatus == IDownloader.DownloadStatus.INITING) {
                str4 = this.mExtraInfo.status.getMessage() + ": " + str4;
                str = this.mExtraInfo.status.getMessage();
            } else {
                str = "";
            }
            Intent intent = new Intent(this.mContext, AppUtils.getShellActivityClass());
            intent.putExtra("activityImplName", IReflectionInfo.DOWNLOAD_TASK_ACTIVITY);
            boolean z = true;
            intent.putExtra("dealWithDownload", true);
            intent.putExtra("pausedManually", iDownloader.isPausedManually());
            intent.putExtra("status", this.mExtraInfo.status.getCode());
            intent.putExtra("pk", this.mExtraInfo.packageName);
            outputPath = iDownloader.getOutputPath();
            if (TextUtils.isEmpty(outputPath)) {
                intent.putExtra("localApkPath", outputPath);
            } else {
                intent.putExtra("localApkPath", this.mExtraInfo.outputFolder + this.mExtraInfo.outputFileName);
            }
            intent.putExtra("title", str4);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setAction(Long.toString(System.currentTimeMillis()));
            PendingIntent activity = PendingIntent.getActivity(this.mContext, this.mExtraInfo.notifID, intent, 134217728);
            if (Build.VERSION.SDK_INT < 16) {
                IDownloader.DownloadStatus downloadStatus2 = this.mExtraInfo.status;
                z = (downloadStatus2 == IDownloader.DownloadStatus.DOWNLOADING || downloadStatus2 == IDownloader.DownloadStatus.PAUSED) ? false : false;
                Notification proxyCustomNotification = getProxyCustomNotification(this.mContext, "down", activity, this.mExtraInfo);
                if (proxyCustomNotification == null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.mExtraInfo.notifBuilder = new Notification.Builder(this.mContext, "down");
                        return ((Notification.Builder) this.mExtraInfo.notifBuilder).setContentTitle(str4).setContentText(str).setTicker(str5).setSmallIcon(i2).setContentIntent(activity).setAutoCancel(z).setProgress(100, this.mExtraInfo.progress, false).build();
                    }
                    this.mExtraInfo.notifBuilder = new Notification.Builder(this.mContext);
                    return ((Notification.Builder) this.mExtraInfo.notifBuilder).setContentTitle(str4).setContentText(str).setTicker(str5).setSmallIcon(i2).setContentIntent(activity).setAutoCancel(z).setProgress(100, this.mExtraInfo.progress, false).build();
                }
                return proxyCustomNotification;
            }
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2 = this.mExtraInfo;
            if (xAdRemoteAPKDownloadExtraInfo2.notifBuilder == null) {
                xAdRemoteAPKDownloadExtraInfo2.notifBuilder = new Notification();
            }
            Notification notification = (Notification) this.mExtraInfo.notifBuilder;
            notification.icon = i2;
            notification.flags |= 16;
            notification.tickerText = str5;
            notification.contentIntent = activity;
            try {
                notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, this.mContext, str4, str, activity);
                return notification;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
                return notification;
            }
        }
        str = str2;
        i2 = 17301634;
        Intent intent2 = new Intent(this.mContext, AppUtils.getShellActivityClass());
        intent2.putExtra("activityImplName", IReflectionInfo.DOWNLOAD_TASK_ACTIVITY);
        boolean z2 = true;
        intent2.putExtra("dealWithDownload", true);
        intent2.putExtra("pausedManually", iDownloader.isPausedManually());
        intent2.putExtra("status", this.mExtraInfo.status.getCode());
        intent2.putExtra("pk", this.mExtraInfo.packageName);
        outputPath = iDownloader.getOutputPath();
        if (TextUtils.isEmpty(outputPath)) {
        }
        intent2.putExtra("title", str4);
        intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent2.setAction(Long.toString(System.currentTimeMillis()));
        PendingIntent activity2 = PendingIntent.getActivity(this.mContext, this.mExtraInfo.notifID, intent2, 134217728);
        if (Build.VERSION.SDK_INT < 16) {
        }
    }

    private Notification getProxyCustomNotification(Context context, String str, PendingIntent pendingIntent, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        String str2;
        String str3;
        String str4;
        boolean z;
        int i2;
        String str5;
        String str6 = xAdRemoteAPKDownloadExtraInfo.mTitle;
        String str7 = xAdRemoteAPKDownloadExtraInfo.mAppName;
        if (str7 != null && !str7.isEmpty()) {
            str6 = xAdRemoteAPKDownloadExtraInfo.mAppName;
        }
        String str8 = str6;
        String str9 = "正在下载 " + str8;
        IDownloader.DownloadStatus downloadStatus = xAdRemoteAPKDownloadExtraInfo.status;
        int i3 = 17301634;
        String str10 = "暂停";
        if (downloadStatus != IDownloader.DownloadStatus.INITING) {
            if (downloadStatus == IDownloader.DownloadStatus.DOWNLOADING) {
                int i4 = xAdRemoteAPKDownloadExtraInfo.progress;
                str2 = "下载进度: " + i4 + "%  应用大小: " + getFormattedSize(xAdRemoteAPKDownloadExtraInfo.contentLength);
                i2 = i4;
                str5 = str9;
                z = false;
                i3 = 17301633;
                return invokeCustomNotification(context, str, str5, this.mNotificationIcon, str8, str2, null, z, i2, i3, str10, pendingIntent);
            }
            if (downloadStatus == IDownloader.DownloadStatus.PAUSED) {
                str10 = "继续";
                str5 = "已为您暂停下载, 请点击继续下载";
                str2 = str5;
                z = false;
                i2 = xAdRemoteAPKDownloadExtraInfo.progress;
            } else if (downloadStatus == IDownloader.DownloadStatus.ERROR) {
                str2 = "稍后点击这里重新下载";
                str5 = "已为您暂停下载, 请点击重新下载";
                str10 = "下载";
                z = false;
                i2 = -1;
            } else if (downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
                if (this.isInstallComplete) {
                    str3 = "安装完成, 请点击打开";
                    str4 = "打开";
                } else {
                    str3 = "下载完成, 请点击安装";
                    str4 = "安装";
                }
                str2 = str3;
                str10 = str4;
                z = true;
                i2 = -1;
                str5 = str9;
            } else {
                str2 = null;
            }
            return invokeCustomNotification(context, str, str5, this.mNotificationIcon, str8, str2, null, z, i2, i3, str10, pendingIntent);
        }
        str2 = "下载准备中";
        str5 = str9;
        z = false;
        i2 = -1;
        i3 = 17301633;
        return invokeCustomNotification(context, str, str5, this.mNotificationIcon, str8, str2, null, z, i2, i3, str10, pendingIntent);
    }

    private Notification invokeCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i2, int i3, String str6, PendingIntent pendingIntent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("context", context);
            jSONObject.put(AppConfigImp.KEY_CHANNELID, str);
            jSONObject.put(ALaKeepAliveService.KEY_TICKER, str2);
            jSONObject.put("icon", bitmap);
            jSONObject.put("title", str3);
            jSONObject.put("content", str4);
            jSONObject.put("status", str5);
            jSONObject.put("autoCancel", z);
            jSONObject.put("progress", i2);
            jSONObject.put("smallIcon", i3);
            jSONObject.put("action", str6);
            jSONObject.put("pendingIntent", pendingIntent);
            ICommonModuleObj moduleObj = AppConfigImp.getInstance().getModuleObj();
            if (moduleObj != null) {
                return (Notification) moduleObj.createModuleObj(ICommonModuleObj.KEY_NOTIFICATION, jSONObject);
            }
            return null;
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().i(th);
            return null;
        }
    }

    public static synchronized OAdRemoteApkDownloaderObserver remveGlobalDownloadObserver(String str) {
        OAdRemoteApkDownloaderObserver remove;
        synchronized (OAdRemoteApkDownloaderObserver.class) {
            remove = globalDownloadObservers.remove(str);
        }
        return remove;
    }

    private void stateEvent(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, AdStateCode adStateCode) {
        if (xAdRemoteAPKDownloadExtraInfo == null || adStateCode == null) {
            return;
        }
        try {
            if (xAdRemoteAPKDownloadExtraInfo.mExtras != null) {
                String str = xAdRemoteAPKDownloadExtraInfo.mExtras.get("uniqueId");
                if (adStateCode.getCode() == AdStateCode.EVENT_AD_STATE_END.getCode()) {
                    StateMachine.finish(str);
                } else {
                    StateMachine.event(str, adStateCode);
                }
            }
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th);
        }
    }

    private void toastMessage(String str) {
        Toast.makeText(this.mContext, str, 0).show();
    }

    public void addStatusListener(IOAdEventListener iOAdEventListener) {
        if (iOAdEventListener != null) {
            for (WeakReference<IOAdEventListener> weakReference : this.mStatusListenerList) {
                if (weakReference != null && weakReference.get() == iOAdEventListener) {
                    return;
                }
            }
            this.mStatusListenerList.add(new WeakReference<>(iOAdEventListener));
        }
    }

    public void clearNotification() {
        NotificationManager notificationManager = notificationManger;
        if (notificationManager != null) {
            notificationManager.cancel(this.mExtraInfo.notifID);
        }
    }

    public XAdRemoteAPKDownloadExtraInfo getDownloadInfo() {
        return this.mExtraInfo;
    }

    @Override // com.baidu.mobads.container.components.controller.InstallReceiver.InstallListener
    public void onPackageInstalled(Context context, Intent intent) {
        if (this.mExtraInfo.popNotify) {
            this.isInstallComplete = true;
            sendNotificationInfoToNotifCenter(this.adDownloader);
        }
        XAdInstallController.getInstance().stopListener(this.mContext, this.mExtraInfo.packageName);
        dispatchListeners();
    }

    public void sendNotificationInfoToNotifCenter(final IDownloader iDownloader) {
        this.mainThreadHandler.post(new Runnable() { // from class: com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OAdRemoteApkDownloaderObserver.this.mExtraInfo.status == IDownloader.DownloadStatus.CANCELLED) {
                        OAdRemoteApkDownloaderObserver.notificationManger.cancel(OAdRemoteApkDownloaderObserver.this.mExtraInfo.notifID);
                    } else {
                        OAdRemoteApkDownloaderObserver.notificationManger.notify(OAdRemoteApkDownloaderObserver.this.mExtraInfo.notifID, OAdRemoteApkDownloaderObserver.this.getNotificationByDownloadInfo(iDownloader));
                        if (OAdRemoteApkDownloaderObserver.this.mExtraInfo.status == IDownloader.DownloadStatus.ERROR) {
                            RemoteXAdLogger.getInstance().d(OAdRemoteApkDownloaderObserver.TAG, "status >> error");
                        }
                    }
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(OAdRemoteApkDownloaderObserver.TAG, e2);
                }
            }
        });
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String str;
        IDownloader iDownloader = (IDownloader) observable;
        this.adDownloader = iDownloader;
        this.mExtraInfo.status = iDownloader.getState();
        String fileName = FileUtils.getFileName(iDownloader.getOutputPath());
        if (!this.mExtraInfo.outputFileName.equals(fileName)) {
            this.mExtraInfo.outputFileName = fileName;
        }
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = this.mExtraInfo;
        if (xAdRemoteAPKDownloadExtraInfo.status == IDownloader.DownloadStatus.DOWNLOADING) {
            if (xAdRemoteAPKDownloadExtraInfo.contentLength < 0) {
                RemoteXAdLogger.getInstance().d(TAG, "download update---mExtraInfo.contentLength < 0");
                this.mExtraInfo.contentLength = iDownloader.getFileSizeLong();
                this.mExtraInfo.targetUrl = iDownloader.getTargetURL();
                this.mExtraInfo.hibernateStatus(this.mContext);
                this.fileSizeInMillionBytes = String.format(Locale.CHINA, "%.1fM", Float.valueOf(((float) this.mExtraInfo.contentLength) / 1048576.0f));
            }
            if (iDownloader.getProgress() > 0.0f) {
                int progress = (int) iDownloader.getProgress();
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2 = this.mExtraInfo;
                if (progress > xAdRemoteAPKDownloadExtraInfo2.progress) {
                    xAdRemoteAPKDownloadExtraInfo2.progress = progress;
                    if (xAdRemoteAPKDownloadExtraInfo2.popNotify) {
                        sendNotificationInfoToNotifCenter(iDownloader);
                    }
                }
            }
        } else {
            RemoteCommonUtils remoteCommonUtils = RemoteCommonUtils.getInstance();
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo3 = this.mExtraInfo;
            IDownloader.DownloadStatus downloadStatus = xAdRemoteAPKDownloadExtraInfo3.status;
            if (downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
                XAdInstallController.getInstance().registerInstallReceiver(this.mContext, this.mExtraInfo);
                XAdInstallController.getInstance().setInstallListener(this.mExtraInfo.packageName, this);
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo4 = this.mExtraInfo;
                String str2 = xAdRemoteAPKDownloadExtraInfo4.packageName;
                stateEvent(xAdRemoteAPKDownloadExtraInfo4, AdStateCode.EVENT_DL_COMPLETE);
                RemoteXAdLogger.getInstance().d(TAG, "download success-->>" + iDownloader.getOutputPath());
                boolean z = this.mExtraInfo.autoOpen;
                String str3 = this.mExtraInfo.outputFolder + this.mExtraInfo.outputFileName;
                AppUtils.ApkInfo localApkFileInfo = AppUtils.getLocalApkFileInfo(this.mContext, str3);
                if (localApkFileInfo != null && !TextUtils.isEmpty(localApkFileInfo.packageName) && !localApkFileInfo.packageName.equals(this.mExtraInfo.packageName)) {
                    this.mExtraInfo.hibernateStatus(this.mContext);
                    this.mExtraInfo.packageName = localApkFileInfo.packageName;
                }
                if (z) {
                    RemoteXAdLogger.getInstance().d(TAG, "launch installing .............");
                    if (AdDownloadApkUtils.isInstalled(this.mContext, this.mExtraInfo.packageName)) {
                        stateEvent(this.mExtraInfo, AdStateCode.EVENT_DL_OPEN);
                        OpenAppUtils.openApp(this.mContext, this.mExtraInfo.packageName);
                        str = RemoteCommonUtils.MSG_DOWNLOADED_OPEN_APP;
                    } else {
                        stateEvent(this.mExtraInfo, AdStateCode.EVENT_DL_INSTALL);
                        AdDownloadApkUtils.installApkWithLog(this.mContext, new File(str3), this.mExtraInfo);
                        str = RemoteCommonUtils.MSG_DOWNLOADED_INSTALL_APP;
                    }
                } else {
                    str = XAdRemoteEvent.COMPLETE;
                }
                stateEvent(this.mExtraInfo, AdStateCode.EVENT_AD_STATE_END);
                remoteCommonUtils.sendDownloadApkLog(this.mContext, 528, str, this.mExtraInfo);
                XAdRemoteSDKCountly.getInstance().onAPKDownloadComplete(this.mContext, this.mExtraInfo);
                if (localApkFileInfo != null && !TextUtils.isEmpty(localApkFileInfo.packageName) && XAdSDKRemoteExp.LiteInc.mPkgName.equals(localApkFileInfo.packageName)) {
                    FileUtils.copyFile(str3, this.mExtraInfo.outputFolder + EncryptUtils.getMD5(XAdSDKRemoteExp.LiteInc.mPkgName) + ".apk");
                    SendLogUtil.Builder.create(this.mContext).appendType(SDKLogTypeConstants.EXPTYPE_LITEINC_CP).appendAppSid(this.mExtraInfo.getAppsid()).append(XAdRemoteAPKDownloadExtraInfo.QK, this.mExtraInfo.queryKey).append(XAdRemoteAPKDownloadExtraInfo.ADID, this.mExtraInfo.mAdid).append("act", "0").append(XAdRemoteAPKDownloadExtraInfo.BUYER, this.mExtraInfo.mBuyer).append("lastPath", !TextUtils.isEmpty(this.mExtraInfo.mUrl) ? Uri.parse(this.mExtraInfo.mUrl).getLastPathSegment() : "").append("evt", c.f1808c).send();
                }
            } else if (downloadStatus == IDownloader.DownloadStatus.ERROR) {
                xAdRemoteAPKDownloadExtraInfo3.targetUrl = iDownloader.getTargetURL();
                RemoteXAdLogger.getInstance().e(TAG, "download failed-->>" + iDownloader.getOutputPath());
                XAdRemoteSDKCountly.getInstance().onAPKDownloadError(this.mExtraInfo);
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo5 = this.mExtraInfo;
                if (xAdRemoteAPKDownloadExtraInfo5.dlCnt < 3) {
                    remoteCommonUtils.sendDownloadApkLog(this.mContext, 406, "download_error", xAdRemoteAPKDownloadExtraInfo5);
                }
                stateEvent(this.mExtraInfo, AdStateCode.EVENT_DL_ERROR);
                stateEvent(this.mExtraInfo, AdStateCode.EVENT_AD_STATE_END);
            } else if (iDownloader.getState() == IDownloader.DownloadStatus.INITING) {
                this.mExtraInfo.dlCnt++;
            } else if (iDownloader.getState() == IDownloader.DownloadStatus.PAUSED) {
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo6 = this.mExtraInfo;
                if (xAdRemoteAPKDownloadExtraInfo6.dlCnt < 3) {
                    remoteCommonUtils.sendDownloadApkLog(this.mContext, 406, "download_paused", xAdRemoteAPKDownloadExtraInfo6);
                }
                stateEvent(this.mExtraInfo, AdStateCode.EVENT_DL_PAUSE);
                stateEvent(this.mExtraInfo, AdStateCode.EVENT_AD_STATE_END);
            }
            if (this.mExtraInfo.popNotify) {
                sendNotificationInfoToNotifCenter(iDownloader);
            }
            this.mExtraInfo.hibernateStatus(this.mContext);
        }
        dispatchListeners();
    }
}
