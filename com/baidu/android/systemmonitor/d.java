package com.baidu.android.systemmonitor;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ StatisticManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StatisticManager statisticManager) {
        this.a = statisticManager;
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
        context = this.a.mContext;
        com.baidu.android.systemmonitor.freqstatistic.e a = com.baidu.android.systemmonitor.freqstatistic.e.a(context);
        context2 = this.a.mContext;
        if (a.b(com.baidu.android.systemmonitor.c.b.h(context2))) {
            context3 = this.a.mContext;
            if (com.baidu.android.systemmonitor.c.d.a(context3)) {
                context5 = this.a.mContext;
                com.baidu.android.systemmonitor.a.a.a(context5).e();
                context6 = this.a.mContext;
                com.baidu.android.systemmonitor.c.b.a(context6, currentTimeMillis);
            }
            Intent intent = new Intent("com.baidu.freqstatistic.summaryresults");
            context4 = this.a.mContext;
            context4.getApplicationContext().sendBroadcast(intent);
        }
    }
}
