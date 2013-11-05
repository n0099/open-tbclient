package com.baidu.android.systemmonitor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StatisticManager statisticManager) {
        this.f806a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        new g(this.f806a, null).start();
    }
}
