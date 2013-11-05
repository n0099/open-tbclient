package com.baidu.android.systemmonitor;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f774a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StatisticManager statisticManager) {
        this.f774a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        long currentTimeMillis = System.currentTimeMillis();
        context = this.f774a.mContext;
        com.baidu.android.systemmonitor.b.d a2 = com.baidu.android.systemmonitor.b.d.a(context);
        context2 = this.f774a.mContext;
        if (a2.b(com.baidu.android.systemmonitor.d.b.h(context2))) {
            context3 = this.f774a.mContext;
            if (com.baidu.android.systemmonitor.d.c.a(context3)) {
                context5 = this.f774a.mContext;
                com.baidu.android.systemmonitor.c.a.a(context5).e();
                context6 = this.f774a.mContext;
                com.baidu.android.systemmonitor.d.b.a(context6, currentTimeMillis);
            }
            Intent intent = new Intent("com.baidu.freqstatistic.summaryresults");
            context4 = this.f774a.mContext;
            context4.getApplicationContext().sendBroadcast(intent);
        }
    }
}
