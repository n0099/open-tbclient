package com.baidu.mobads.container.components.controller;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
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
import com.tencent.open.SocialConstants;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class InstallReceiver extends BroadcastReceiver {
    public static final String TAG = "InstallReceiver";
    public XAdRemoteAPKDownloadExtraInfo mExtraInfo;
    public volatile boolean isProcessing = false;
    public ArrayList<SoftReference<InstallListener>> mListeners = new ArrayList<>();
    public final RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public final int countDown = 5000;
    public int currentCount = 0;

    /* loaded from: classes2.dex */
    public interface InstallListener {
        void onPackageInstalled(Context context, Intent intent);
    }

    public InstallReceiver(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
    }

    public void addInstallListener(InstallListener installListener) {
        this.mListeners.add(new SoftReference<>(installListener));
    }

    public boolean canOpenApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public XAdRemoteAPKDownloadExtraInfo getExtraInfo() {
        return this.mExtraInfo;
    }

    @Override // android.content.BroadcastReceiver
    @TargetApi(3)
    public void onReceive(final Context context, Intent intent) {
        boolean z;
        InstallListener installListener;
        if (intent == null || TextUtils.isEmpty(intent.getAction()) || !intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        this.isProcessing = true;
        final String replace = dataString.replace("package:", "");
        if (replace.equals(this.mExtraInfo.packageName)) {
            XAdRemoteSDKCountly.getInstance().onAPKInstallComplete(context.getApplicationContext(), this.mExtraInfo);
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = this.mExtraInfo;
            final String str = xAdRemoteAPKDownloadExtraInfo.apoPage;
            final String str2 = xAdRemoteAPKDownloadExtraInfo.mProd;
            final String str3 = xAdRemoteAPKDownloadExtraInfo.mAppsid;
            final String str4 = xAdRemoteAPKDownloadExtraInfo.placeId;
            final boolean canOpenApp = canOpenApp(context, str);
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
                    TaskScheduler.getInstance().submitAtFixedRate(new BaseTask() { // from class: com.baidu.mobads.container.components.controller.InstallReceiver.1
                        @Override // com.baidu.mobads.container.executor.BaseTask
                        public Object doInBackground() {
                            Intent launchIntentForPackage;
                            InstallReceiver.this.currentCount += 1000;
                            if (InstallReceiver.this.currentCount >= 5000) {
                                cancel();
                                return null;
                            }
                            if (AppUtils.isForeground(context, replace)) {
                                cancel();
                            }
                            Context context2 = context;
                            if (AppUtils.isForeground(context2, context2.getPackageName())) {
                                cancel();
                                try {
                                    SendLogUtil.Builder append2 = SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_ASL_DELAY_APO).append("pk", replace).append("msg", "appstore_link_delayopen").append(XAdRemoteAPKDownloadExtraInfo.APO_PAGE, str).append("canopenapopage", canOpenApp);
                                    if (!TextUtils.isEmpty(str2)) {
                                        append2.appendProdType(str2);
                                    }
                                    if (!TextUtils.isEmpty(str4)) {
                                        append2.appendApId(str4);
                                    }
                                    append2.appendAppSid(str3);
                                    append2.send();
                                } catch (Exception unused2) {
                                }
                                if (canOpenApp) {
                                    OpenAppUtils.browserOutside(context, str);
                                    return null;
                                } else if (TextUtils.isEmpty(replace) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(replace)) == null) {
                                    return null;
                                } else {
                                    launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                                    context.startActivity(launchIntentForPackage);
                                    return null;
                                }
                            }
                            return null;
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
                        launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
        if (!this.isProcessing) {
            this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
        }
        return this.isProcessing;
    }
}
