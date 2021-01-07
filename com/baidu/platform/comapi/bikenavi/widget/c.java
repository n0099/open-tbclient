package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4223a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CustomScrollView customScrollView;
        int i;
        int i2;
        int i3;
        CustomScrollView customScrollView2;
        this.f4223a.E = com.baidu.platform.comapi.wnplatform.p.h.e(this.f4223a.f4217a) - com.baidu.platform.comapi.wnplatform.p.h.a(this.f4223a.f4217a, a.F);
        customScrollView = this.f4223a.l;
        i = this.f4223a.E;
        customScrollView.setBlankHeight(i);
        i2 = this.f4223a.E;
        Activity activity = this.f4223a.f4217a;
        int i4 = a.F;
        i3 = a.G;
        int a2 = i2 + com.baidu.platform.comapi.wnplatform.p.h.a(activity, i4 - i3);
        customScrollView2 = this.f4223a.l;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
