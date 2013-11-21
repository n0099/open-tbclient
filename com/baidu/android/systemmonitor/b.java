package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.nebula.util.BDLocationManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f769a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(StatisticManager statisticManager) {
        this.f769a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f769a.mContext;
        BDLocationManager.b(context).c();
    }
}
