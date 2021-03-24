package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9871a;

    public b(a aVar) {
        this.f9871a = aVar;
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
        a aVar = this.f9871a;
        activity = aVar.f9859a;
        int e2 = com.baidu.platform.comapi.wnplatform.o.g.e(activity);
        activity2 = this.f9871a.f9859a;
        i = a.F;
        aVar.E = e2 - com.baidu.platform.comapi.wnplatform.o.g.a(activity2, i);
        customScrollView = this.f9871a.n;
        i2 = this.f9871a.E;
        customScrollView.setBlankHeight(i2);
        i3 = this.f9871a.E;
        activity3 = this.f9871a.f9859a;
        i4 = a.F;
        i5 = a.G;
        int a2 = i3 + com.baidu.platform.comapi.wnplatform.o.g.a(activity3, i4 - i5);
        customScrollView2 = this.f9871a.n;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
