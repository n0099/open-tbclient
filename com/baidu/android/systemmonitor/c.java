package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.systemmonitor.devicestatistic.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ StatisticManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(StatisticManager statisticManager) {
        this.a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        long currentTimeMillis = System.currentTimeMillis();
        context = this.a.mContext;
        if (currentTimeMillis - com.baidu.android.systemmonitor.util.e.i(context) > g.d()) {
            context2 = this.a.mContext;
            g.a(context2).c();
        }
    }
}
