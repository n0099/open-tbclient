package com.baidu.android.nebula.cmd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes.dex */
class j {
    final /* synthetic */ ScanDownloadFile a;

    public j(ScanDownloadFile scanDownloadFile) {
        Context context;
        BroadcastReceiver broadcastReceiver;
        Context context2;
        BroadcastReceiver broadcastReceiver2;
        this.a = scanDownloadFile;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        try {
            context2 = scanDownloadFile.mContext;
            broadcastReceiver2 = scanDownloadFile.mInstallReceiver;
            context2.unregisterReceiver(broadcastReceiver2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        context = scanDownloadFile.mContext;
        broadcastReceiver = scanDownloadFile.mInstallReceiver;
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void a() {
        new h(this.a, "http://wap.baidu.com/static/freeapp/broswer_down_path.cfg?v=1").start();
    }
}
