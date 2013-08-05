package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.nebula.util.BDLocationManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(StatisticManager statisticManager) {
        this.f657a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f657a.mContext;
        BDLocationManager.b(context).c();
    }
}
