package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.systemmonitor.d.a.l;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StatisticManager statisticManager) {
        this.f821a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f821a.mContext;
        if (!com.baidu.android.systemmonitor.d.b.b(context)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(l.ACTIVE_EVENT);
            context3 = this.f821a.mContext;
            com.baidu.android.systemmonitor.c.a.a(context3).a(arrayList);
        }
        context2 = this.f821a.mContext;
        new com.baidu.android.systemmonitor.d.a.d(context2).a();
    }
}
