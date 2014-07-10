package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.nebula.util.BDLocationManager;
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
        BDLocationManager.b(context).c();
    }
}
