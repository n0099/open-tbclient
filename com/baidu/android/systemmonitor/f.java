package com.baidu.android.systemmonitor;

import android.content.Context;
import com.baidu.android.systemmonitor.a.a.h;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatisticManager f425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StatisticManager statisticManager) {
        this.f425a = statisticManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f425a.mContext;
        if (!com.baidu.android.systemmonitor.a.b.b(context)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h.ACTIVE_EVENT);
            context3 = this.f425a.mContext;
            com.baidu.android.systemmonitor.b.a.a(context3).a(arrayList);
        }
        context2 = this.f425a.mContext;
        new com.baidu.android.systemmonitor.a.a.e(context2).a();
    }
}
