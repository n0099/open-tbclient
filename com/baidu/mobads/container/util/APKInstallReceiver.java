package com.baidu.mobads.container.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
/* loaded from: classes2.dex */
public class APKInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        remoteXAdLogger.d("APKInstallReceiver", "action Receiver :" + action + ", pkg:" + intent.getStringExtra("package"));
        if ((PackageChangedReceiver.ACTION_INSTALL.equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action) || PackageChangedReceiver.ACTION_UNINSTALL.equals(action)) && !TextUtils.isEmpty(intent.getDataString())) {
            RemoteXAdLogger remoteXAdLogger2 = RemoteXAdLogger.getInstance();
            remoteXAdLogger2.d("APKInstallReceiver", "updateStateByBroadCast:" + intent.getAction() + ", package:" + intent.getDataString());
            APKStateManager.getInstance().actionToSniffByBroadCast(context, intent.getDataString().substring(8));
        }
    }
}
