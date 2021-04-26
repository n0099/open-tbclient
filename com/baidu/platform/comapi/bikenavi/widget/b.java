package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9784a;

    public b(a aVar) {
        this.f9784a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        Activity activity2;
        int i2;
        CustomScrollView customScrollView;
        int i3;
        int i4;
        Activity activity3;
        int i5;
        int i6;
        CustomScrollView customScrollView2;
        a aVar = this.f9784a;
        activity = aVar.f9771a;
        int e2 = com.baidu.platform.comapi.wnplatform.o.g.e(activity);
        activity2 = this.f9784a.f9771a;
        i2 = a.F;
        aVar.E = e2 - com.baidu.platform.comapi.wnplatform.o.g.a(activity2, i2);
        customScrollView = this.f9784a.n;
        i3 = this.f9784a.E;
        customScrollView.setBlankHeight(i3);
        i4 = this.f9784a.E;
        activity3 = this.f9784a.f9771a;
        i5 = a.F;
        i6 = a.G;
        int a2 = i4 + com.baidu.platform.comapi.wnplatform.o.g.a(activity3, i5 - i6);
        customScrollView2 = this.f9784a.n;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
