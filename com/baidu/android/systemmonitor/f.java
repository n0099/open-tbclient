package com.baidu.android.systemmonitor;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.baidu.android.systemmonitor.localapp.AppManager;
/* loaded from: classes.dex */
class f extends Thread {
    final /* synthetic */ StatisticManager a;

    private f(StatisticManager statisticManager) {
        this.a = statisticManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(StatisticManager statisticManager, a aVar) {
        this(statisticManager);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Looper.prepare();
        setName("SystemMonitor_AsyncInitThread");
        Process.setThreadPriority(10);
        context = this.a.mContext;
        AppManager.a(context).b();
    }
}
