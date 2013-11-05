package com.baidu.android.systemmonitor;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.android.systemmonitor.localapp.AppManager;
/* loaded from: classes.dex */
class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f808a;

    private g(StatisticManager statisticManager) {
        this.f808a = statisticManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(StatisticManager statisticManager, a aVar) {
        this(statisticManager);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Looper.prepare();
        setName("SystemMonitor_AsyncInitThread");
        Process.setThreadPriority(10);
        context = this.f808a.mContext;
        AppManager.a(context).b();
        context2 = this.f808a.mContext;
        BDLocationManager.b(context2);
    }
}
