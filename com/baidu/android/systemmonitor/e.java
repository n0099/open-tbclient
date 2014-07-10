package com.baidu.android.systemmonitor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ StatisticManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StatisticManager statisticManager) {
        this.a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        new f(this.a, null).start();
    }
}
