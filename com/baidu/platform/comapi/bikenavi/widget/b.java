package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9430a;

    public b(a aVar) {
        this.f9430a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        Activity activity2;
        int i;
        CustomScrollView customScrollView;
        int i2;
        int i3;
        Activity activity3;
        int i4;
        int i5;
        CustomScrollView customScrollView2;
        a aVar = this.f9430a;
        activity = aVar.f9418a;
        int e2 = com.baidu.platform.comapi.wnplatform.o.g.e(activity);
        activity2 = this.f9430a.f9418a;
        i = a.F;
        aVar.E = e2 - com.baidu.platform.comapi.wnplatform.o.g.a(activity2, i);
        customScrollView = this.f9430a.n;
        i2 = this.f9430a.E;
        customScrollView.setBlankHeight(i2);
        i3 = this.f9430a.E;
        activity3 = this.f9430a.f9418a;
        i4 = a.F;
        i5 = a.G;
        int a2 = i3 + com.baidu.platform.comapi.wnplatform.o.g.a(activity3, i4 - i5);
        customScrollView2 = this.f9430a.n;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
