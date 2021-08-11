package com.baidu.mobads.container.components.controller;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class InstallReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InstallReceiver";
    public transient /* synthetic */ FieldHolder $fh;
    public final int countDown;
    public int currentCount;
    public volatile boolean isProcessing;
    public final RemoteXAdLogger mAdLogger;
    public XAdRemoteAPKDownloadExtraInfo mExtraInfo;
    public ArrayList<SoftReference<InstallListener>> mListeners;

    /* loaded from: classes5.dex */
    public interface InstallListener {
        void onPackageInstalled(Context context, Intent intent);
    }

    public InstallReceiver(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdRemoteAPKDownloadExtraInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isProcessing = false;
        this.mListeners = new ArrayList<>();
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.countDown = 5000;
        this.currentCount = 0;
        this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
    }

    public void addInstallListener(InstallListener installListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, installListener) == null) {
            this.mListeners.add(new SoftReference<>(installListener));
        }
    }

    public boolean canOpenApp(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        }
        return invokeLL.booleanValue;
    }

    public XAdRemoteAPKDownloadExtraInfo getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtraInfo : (XAdRemoteAPKDownloadExtraInfo) invokeV.objValue;
    }

    @Override // android.content.BroadcastReceiver
    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        boolean z;
        InstallListener installListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, intent) == null) || intent == null || TextUtils.isEmpty(intent.getAction()) || !intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        this.isProcessing = true;
        String replace = dataString.replace("package:", "");
        if (replace.equals(this.mExtraInfo.packageName)) {
            XAdRemoteSDKCountly.getInstance().onAPKInstallComplete(context.getApplicationContext(), this.mExtraInfo);
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = this.mExtraInfo;
            String str = xAdRemoteAPKDownloadExtraInfo.apoPage;
            String str2 = xAdRemoteAPKDownloadExtraInfo.mProd;
            String str3 = xAdRemoteAPKDownloadExtraInfo.mAppsid;
            String str4 = xAdRemoteAPKDownloadExtraInfo.placeId;
            boolean canOpenApp = canOpenApp(context, str);
            if (canOpenApp(context, this.mExtraInfo.asl)) {
                try {
                    SendLogUtil.Builder append = SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_ASL_INSTALL_COMPLETED).append("pk", replace).append("msg", "appstore_link_install_completed").append(XAdRemoteAPKDownloadExtraInfo.APO_PAGE, str).append("canopen_apopage", canOpenApp);
                    if (!TextUtils.isEmpty(str2)) {
                        append.appendProdType(str2);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        append.appendApId(str4);
                    }
                    append.appendAppSid(str3);
                    append.send();
                } catch (Exception unused) {
                }
                z = true;
            } else {
                z = false;
            }
            ArrayList<SoftReference<InstallListener>> arrayList = this.mListeners;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<SoftReference<InstallListener>> it = this.mListeners.iterator();
                boolean z2 = false;
                boolean z3 = false;
                while (it.hasNext()) {
                    SoftReference<InstallListener> next = it.next();
                    if (next != null && (installListener = next.get()) != null) {
                        installListener.onPackageInstalled(context, intent);
                        z2 = true;
                        if (!(installListener instanceof OAdRemoteApkDownloaderObserver)) {
                            z3 = true;
                        }
                    }
                }
                if (z2) {
                    this.mListeners.clear();
                    if (!z && z3) {
                        return;
                    }
                }
            }
            if (z) {
                try {
                    this.currentCount = 0;
                    TaskScheduler.getInstance().submitAtFixedRate(new BaseTask(this, context, replace, str, canOpenApp, str2, str4, str3) { // from class: com.baidu.mobads.container.components.controller.InstallReceiver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InstallReceiver this$0;
                        public final /* synthetic */ String val$apoPage;
                        public final /* synthetic */ String val$appsid;
                        public final /* synthetic */ boolean val$canOpen;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$finalPK;
                        public final /* synthetic */ String val$placeId;
                        public final /* synthetic */ String val$prod;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, replace, str, Boolean.valueOf(canOpenApp), str2, str4, str3};
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
                            this.val$context = context;
                            this.val$finalPK = replace;
                            this.val$apoPage = str;
                            this.val$canOpen = canOpenApp;
                            this.val$prod = str2;
                            this.val$placeId = str4;
                            this.val$appsid = str3;
                        }

                        @Override // com.baidu.mobads.container.executor.BaseTask
                        public Object doInBackground() {
                            InterceptResult invokeV;
                            Intent launchIntentForPackage;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                this.this$0.currentCount += 1000;
                                if (this.this$0.currentCount >= 5000) {
                                    cancel();
                                    return null;
                                }
                                if (AppUtils.isForeground(this.val$context, this.val$finalPK)) {
                                    cancel();
                                }
                                Context context2 = this.val$context;
                                if (AppUtils.isForeground(context2, context2.getPackageName())) {
                                    cancel();
                                    try {
                                        SendLogUtil.Builder append2 = SendLogUtil.Builder.create(this.val$context).appendType(SDKLogTypeConstants.TYPE_ASL_DELAY_APO).append("pk", this.val$finalPK).append("msg", "appstore_link_delayopen").append(XAdRemoteAPKDownloadExtraInfo.APO_PAGE, this.val$apoPage).append("canopenapopage", this.val$canOpen);
                                        if (!TextUtils.isEmpty(this.val$prod)) {
                                            append2.appendProdType(this.val$prod);
                                        }
                                        if (!TextUtils.isEmpty(this.val$placeId)) {
                                            append2.appendApId(this.val$placeId);
                                        }
                                        append2.appendAppSid(this.val$appsid);
                                        append2.send();
                                    } catch (Exception unused2) {
                                    }
                                    if (this.val$canOpen) {
                                        OpenAppUtils.browserOutside(this.val$context, this.val$apoPage);
                                        return null;
                                    } else if (TextUtils.isEmpty(this.val$finalPK) || (launchIntentForPackage = this.val$context.getPackageManager().getLaunchIntentForPackage(this.val$finalPK)) == null) {
                                        return null;
                                    } else {
                                        launchIntentForPackage.addFlags(268435456);
                                        this.val$context.startActivity(launchIntentForPackage);
                                        return null;
                                    }
                                }
                                return null;
                            }
                            return invokeV.objValue;
                        }
                    }, 0L, 1L, TimeUnit.SECONDS);
                    return;
                } catch (Throwable unused2) {
                }
            }
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2 = this.mExtraInfo;
            if (xAdRemoteAPKDownloadExtraInfo2.mAPOOpen && !TextUtils.isEmpty(xAdRemoteAPKDownloadExtraInfo2.mPage)) {
                try {
                    if (PackageUtils.sendAPOInfo(context, this.mExtraInfo.mPage, replace, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 2, 0)) {
                        Thread.sleep(350L);
                        OpenAppUtils.browserOutside(context, this.mExtraInfo.mPage);
                    }
                } catch (Throwable unused3) {
                }
                XAdInstallController.getInstance().stopListener(context, this.mExtraInfo.packageName);
            } else if (this.mExtraInfo.autoOpen) {
                try {
                    Thread.sleep(600L);
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(replace);
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        XAdInstallController.getInstance().stopListener(context, this.mExtraInfo.packageName);
                        SendLogUtil.Builder append2 = SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_INSTALL_WAKE_UP).append(XAdRemoteAPKDownloadExtraInfo.ADID, this.mExtraInfo.getAdid()).append(XAdRemoteAPKDownloadExtraInfo.QK, this.mExtraInfo.getQueryKey()).append("pk", this.mExtraInfo.getPackageName()).append(XAdRemoteAPKDownloadExtraInfo.BUYER, this.mExtraInfo.getBuyer()).append("prod", this.mExtraInfo.getProd()).appendAppSid(this.mExtraInfo.getAppsid()).append("schema", this.mExtraInfo.mPage).append("from", SocialConstants.PARAM_RECEIVER).append("clicktime", String.valueOf(this.mExtraInfo.getClickTime())).append("appsize", String.valueOf(this.mExtraInfo.getAppSize()));
                        if (this.mExtraInfo.mExtras != null) {
                            append2.append(this.mExtraInfo.mExtras);
                        }
                        append2.send();
                    }
                } catch (Exception e2) {
                    this.mAdLogger.d(TAG, e2);
                }
            }
        }
        this.isProcessing = false;
    }

    public boolean updateExtraInfo(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xAdRemoteAPKDownloadExtraInfo)) == null) {
            if (!this.isProcessing) {
                this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
            }
            return this.isProcessing;
        }
        return invokeL.booleanValue;
    }
}
