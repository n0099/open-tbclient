package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4172a = aVar;
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
        a aVar = this.f4172a;
        activity = this.f4172a.f4168a;
        int e = com.baidu.platform.comapi.wnplatform.o.g.e(activity);
        activity2 = this.f4172a.f4168a;
        i = a.F;
        aVar.E = e - com.baidu.platform.comapi.wnplatform.o.g.a(activity2, i);
        customScrollView = this.f4172a.n;
        i2 = this.f4172a.E;
        customScrollView.setBlankHeight(i2);
        i3 = this.f4172a.E;
        activity3 = this.f4172a.f4168a;
        i4 = a.F;
        i5 = a.G;
        int a2 = i3 + com.baidu.platform.comapi.wnplatform.o.g.a(activity3, i4 - i5);
        customScrollView2 = this.f4172a.n;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
