package com.baidu.android.systemmonitor;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(StatisticManager statisticManager) {
        this.f783a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        long currentTimeMillis = System.currentTimeMillis();
        context = this.f783a.mContext;
        if (currentTimeMillis - com.baidu.android.systemmonitor.d.b.i(context) > com.baidu.android.systemmonitor.devicestatistic.d.d()) {
            context2 = this.f783a.mContext;
            com.baidu.android.systemmonitor.devicestatistic.d.a(context2).c();
        }
    }
}
