package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.IntentFilter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDownloadFile f581a;

    public f(ScanDownloadFile scanDownloadFile) {
        Context context;
        this.f581a = scanDownloadFile;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        context = scanDownloadFile.mContext;
        context.registerReceiver(new g(this, scanDownloadFile), intentFilter);
    }

    public void a() {
        new k(this.f581a, "http://wap.baidu.com/static/freeapp/broswer_down_path.cfg?v=1").start();
    }
}
