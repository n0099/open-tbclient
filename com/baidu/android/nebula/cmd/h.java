package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.IntentFilter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDownloadFile f550a;

    public h(ScanDownloadFile scanDownloadFile) {
        Context context;
        this.f550a = scanDownloadFile;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        context = scanDownloadFile.mContext;
        context.registerReceiver(new i(this, scanDownloadFile), intentFilter);
    }

    public void a() {
        new f(this.f550a, "http://wap.baidu.com/static/freeapp/broswer_down_path.cfg?v=1").start();
    }
}
