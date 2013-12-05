package com.baidu.android.systemmonitor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f826a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StatisticManager statisticManager) {
        this.f826a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        new g(this.f826a, null).start();
    }
}
