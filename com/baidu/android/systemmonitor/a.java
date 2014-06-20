package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.systemmonitor.devicestatistic.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ StatisticManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StatisticManager statisticManager) {
        this.a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.mContext;
        j.a(context).b();
    }
}
