package com.baidu.android.systemmonitor;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ StatisticManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(StatisticManager statisticManager) {
        this.a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.mContext;
        com.baidu.android.nebula.a.e.a(context).b();
    }
}
