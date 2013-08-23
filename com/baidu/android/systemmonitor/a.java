package com.baidu.android.systemmonitor;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StatisticManager statisticManager) {
        this.f661a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f661a.mContext;
        com.baidu.android.systemmonitor.devicestatistic.f.a(context).b();
    }
}
