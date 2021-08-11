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
import com.alipay.sdk.app.statistic.b;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class OAdRemoteApkDownloaderObserver implements Observer, InstallReceiver.InstallListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int NOTIF_INC = 10091;
    public static final String TAG = "OAdRemoteApkDownloaderObserver";
    public static HashMap<String, OAdRemoteApkDownloaderObserver> globalDownloadObservers;
    public static NotificationManager notificationManger;
    public transient /* synthetic */ FieldHolder $fh;
    public IDownloader adDownloader;
    public XAdInstallController ctrl;
    public String fileSizeInMillionBytes;
    public boolean isInstallComplete;
    public Context mContext;
    public Object mCustomNotification;
    public XAdRemoteAPKDownloadExtraInfo mExtraInfo;
    public AtomicBoolean mLoadNotifIcon;
    public Bitmap mNotificationIcon;
    public List<WeakReference<IOAdEventListener>> mStatusListenerList;
    public Handler mainThreadHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1848262578, "Lcom/baidu/mobads/container/components/command/OAdRemoteApkDownloaderObserver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1848262578, "Lcom/baidu/mobads/container/components/command/OAdRemoteApkDownloaderObserver;");
                return;
            }
        }
        globalDownloadObservers = new HashMap<>();
    }

    public OAdRemoteApkDownloaderObserver(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xAdRemoteAPKDownloadExtraInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExtraInfo = null;
        this.ctrl = null;
        this.mStatusListenerList = new ArrayList();
        this.fileSizeInMillionBytes = "";
        this.isInstallComplete = false;
        this.mLoadNotifIcon = new AtomicBoolean(false);
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, oAdRemoteApkDownloaderObserver) == null) {
            synchronized (OAdRemoteApkDownloaderObserver.class) {
                globalDownloadObservers.put(str, oAdRemoteApkDownloaderObserver);
            }
        }
    }

    private void dispatchListeners() {
        IOAdEventListener iOAdEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.mStatusListenerList.size() <= 0) {
            return;
        }
        try {
            for (WeakReference<IOAdEventListener> weakReference : this.mStatusListenerList) {
                if (weakReference != null && (iOAdEventListener = weakReference.get()) != null) {
                    this.mainThreadHandler.post(new Runnable(this, iOAdEventListener) { // from class: com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ OAdRemoteApkDownloaderObserver this$0;
                        public final /* synthetic */ IOAdEventListener val$l;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iOAdEventListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$l = iOAdEventListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$l.run(new XAdRemoteEvent("AdStatusChange", this.this$0.mExtraInfo.packageName));
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().w(e2.getMessage());
        }
    }

    private String getFormattedSize(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, this, j2)) == null) {
            long j3 = (j2 / 1024) / 1024;
            return j3 > 1000 ? String.format(Locale.CHINA, "%.1fG", Float.valueOf(((float) j3) / 1024.0f)) : String.format(Locale.CHINA, "%.1fM", Float.valueOf((float) j3));
        }
        return (String) invokeJ.objValue;
    }

    public static synchronized OAdRemoteApkDownloaderObserver getGlobalDownloadObserver(String str) {
        InterceptResult invokeL;
        OAdRemoteApkDownloaderObserver oAdRemoteApkDownloaderObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (OAdRemoteApkDownloaderObserver.class) {
                oAdRemoteApkDownloaderObserver = globalDownloadObservers.get(str);
            }
            return oAdRemoteApkDownloaderObserver;
        }
        return (OAdRemoteApkDownloaderObserver) invokeL.objValue;
    }

    public static synchronized int getGlobalNotifId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0233  */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification getNotificationByDownloadInfo(IDownloader iDownloader) {
        InterceptResult invokeL;
        String str;
        String str2;
        String outputPath;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65546, this, iDownloader)) != null) {
            return (Notification) invokeL.objValue;
        }
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
            intent.addFlags(268435456);
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
        intent2.addFlags(268435456);
        intent2.setAction(Long.toString(System.currentTimeMillis()));
        PendingIntent activity2 = PendingIntent.getActivity(this.mContext, this.mExtraInfo.notifID, intent2, 134217728);
        if (Build.VERSION.SDK_INT < 16) {
        }
    }

    private Notification getProxyCustomNotification(Context context, String str, PendingIntent pendingIntent, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        InterceptResult invokeLLLL;
        String str2;
        String str3;
        String str4;
        boolean z;
        int i2;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, this, context, str, pendingIntent, xAdRemoteAPKDownloadExtraInfo)) == null) {
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
        return (Notification) invokeLLLL.objValue;
    }

    private Notification invokeCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i2, int i3, String str6, PendingIntent pendingIntent) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{context, str, str2, bitmap, str3, str4, str5, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str6, pendingIntent})) == null) {
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
        return (Notification) invokeCommon.objValue;
    }

    public static synchronized OAdRemoteApkDownloaderObserver remveGlobalDownloadObserver(String str) {
        InterceptResult invokeL;
        OAdRemoteApkDownloaderObserver remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            synchronized (OAdRemoteApkDownloaderObserver.class) {
                remove = globalDownloadObservers.remove(str);
            }
            return remove;
        }
        return (OAdRemoteApkDownloaderObserver) invokeL.objValue;
    }

    private void stateEvent(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, AdStateCode adStateCode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, this, xAdRemoteAPKDownloadExtraInfo, adStateCode) == null) || xAdRemoteAPKDownloadExtraInfo == null || adStateCode == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            Toast.makeText(this.mContext, str, 0).show();
        }
    }

    public void addStatusListener(IOAdEventListener iOAdEventListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOAdEventListener) == null) || iOAdEventListener == null) {
            return;
        }
        for (WeakReference<IOAdEventListener> weakReference : this.mStatusListenerList) {
            if (weakReference != null && weakReference.get() == iOAdEventListener) {
                return;
            }
        }
        this.mStatusListenerList.add(new WeakReference<>(iOAdEventListener));
    }

    public void clearNotification() {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (notificationManager = notificationManger) == null) {
            return;
        }
        notificationManager.cancel(this.mExtraInfo.notifID);
    }

    public XAdRemoteAPKDownloadExtraInfo getDownloadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtraInfo : (XAdRemoteAPKDownloadExtraInfo) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.controller.InstallReceiver.InstallListener
    public void onPackageInstalled(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, intent) == null) {
            if (this.mExtraInfo.popNotify) {
                this.isInstallComplete = true;
                sendNotificationInfoToNotifCenter(this.adDownloader);
            }
            XAdInstallController.getInstance().stopListener(this.mContext, this.mExtraInfo.packageName);
            dispatchListeners();
        }
    }

    public void sendNotificationInfoToNotifCenter(IDownloader iDownloader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iDownloader) == null) {
            this.mainThreadHandler.post(new Runnable(this, iDownloader) { // from class: com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OAdRemoteApkDownloaderObserver this$0;
                public final /* synthetic */ IDownloader val$tmpDownloader;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iDownloader};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$tmpDownloader = iDownloader;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.this$0.mExtraInfo.status == IDownloader.DownloadStatus.CANCELLED) {
                                OAdRemoteApkDownloaderObserver.notificationManger.cancel(this.this$0.mExtraInfo.notifID);
                            } else {
                                OAdRemoteApkDownloaderObserver.notificationManger.notify(this.this$0.mExtraInfo.notifID, this.this$0.getNotificationByDownloadInfo(this.val$tmpDownloader));
                                if (this.this$0.mExtraInfo.status == IDownloader.DownloadStatus.ERROR) {
                                    RemoteXAdLogger.getInstance().d(OAdRemoteApkDownloaderObserver.TAG, "status >> error");
                                }
                            }
                        } catch (Exception e2) {
                            RemoteXAdLogger.getInstance().d(OAdRemoteApkDownloaderObserver.TAG, e2);
                        }
                    }
                }
            });
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, observable, obj) == null) {
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
                    remoteCommonUtils.sendDownloadApkLog(this.mContext, SDKLogTypeConstants.TYPE_DOWNLOAD_COMPLETED_ACTION, str, this.mExtraInfo);
                    XAdRemoteSDKCountly.getInstance().onAPKDownloadComplete(this.mContext, this.mExtraInfo);
                    if (localApkFileInfo != null && !TextUtils.isEmpty(localApkFileInfo.packageName) && XAdSDKRemoteExp.LiteInc.mPkgName.equals(localApkFileInfo.packageName)) {
                        FileUtils.copyFile(str3, this.mExtraInfo.outputFolder + EncryptUtils.getMD5(XAdSDKRemoteExp.LiteInc.mPkgName) + ".apk");
                        SendLogUtil.Builder.create(this.mContext).appendType(1026).appendAppSid(this.mExtraInfo.getAppsid()).append(XAdRemoteAPKDownloadExtraInfo.QK, this.mExtraInfo.queryKey).append(XAdRemoteAPKDownloadExtraInfo.ADID, this.mExtraInfo.mAdid).append("act", "0").append(XAdRemoteAPKDownloadExtraInfo.BUYER, this.mExtraInfo.mBuyer).append("lastPath", !TextUtils.isEmpty(this.mExtraInfo.mUrl) ? Uri.parse(this.mExtraInfo.mUrl).getLastPathSegment() : "").append("evt", b.f35700c).send();
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
}
