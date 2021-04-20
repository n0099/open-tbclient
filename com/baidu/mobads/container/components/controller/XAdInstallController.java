package com.baidu.mobads.container.components.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XAdInstallController {
    public static final String TAG = "XAdInstallController";
    public static XAdInstallController mAdInstallController;
    public HashMap<String, InstallReceiver> mReceiverList = new HashMap<>();
    public HashMap<String, Boolean> mRegisterList = new HashMap<>();
    public final RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();

    public static XAdInstallController getInstance() {
        if (mAdInstallController == null) {
            synchronized (XAdInstallController.class) {
                if (mAdInstallController == null) {
                    mAdInstallController = new XAdInstallController();
                }
            }
        }
        return mAdInstallController;
    }

    private void startListener(Context context, String str) {
        if (context == null || !this.mReceiverList.containsKey(str)) {
            return;
        }
        if (this.mRegisterList.containsKey(str) && this.mRegisterList.get(str).booleanValue()) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            context.registerReceiver(this.mReceiverList.get(str), intentFilter);
            this.mRegisterList.put(str, Boolean.TRUE);
        } catch (Exception unused) {
            this.mAdLogger.e(TAG, "Install controller start failed.");
        }
    }

    public void registerInstallReceiver(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        if (context == null || xAdRemoteAPKDownloadExtraInfo == null) {
            return;
        }
        String str = xAdRemoteAPKDownloadExtraInfo.packageName;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mReceiverList.containsKey(str)) {
            this.mReceiverList.get(str).updateExtraInfo(xAdRemoteAPKDownloadExtraInfo);
        } else {
            this.mReceiverList.put(str, new InstallReceiver(xAdRemoteAPKDownloadExtraInfo));
        }
        startListener(context, str);
    }

    public void setInstallListener(String str, InstallReceiver.InstallListener installListener) {
        InstallReceiver installReceiver;
        if (TextUtils.isEmpty(str) || !this.mReceiverList.containsKey(str) || (installReceiver = this.mReceiverList.get(str)) == null) {
            return;
        }
        installReceiver.addInstallListener(installListener);
    }

    public void stopListener(Context context, String str) {
        if (context == null || !this.mReceiverList.containsKey(str)) {
            return;
        }
        try {
            context.unregisterReceiver(this.mReceiverList.get(str));
            this.mRegisterList.remove(str);
            this.mReceiverList.remove(str);
        } catch (Exception unused) {
            this.mAdLogger.d(TAG, "Install controller stop failed.");
        }
    }
}
