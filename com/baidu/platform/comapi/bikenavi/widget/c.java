package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4222a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CustomScrollView customScrollView;
        int i;
        int i2;
        int i3;
        CustomScrollView customScrollView2;
        this.f4222a.E = com.baidu.platform.comapi.wnplatform.p.h.e(this.f4222a.f4216a) - com.baidu.platform.comapi.wnplatform.p.h.a(this.f4222a.f4216a, a.F);
        customScrollView = this.f4222a.l;
        i = this.f4222a.E;
        customScrollView.setBlankHeight(i);
        i2 = this.f4222a.E;
        Activity activity = this.f4222a.f4216a;
        int i4 = a.F;
        i3 = a.G;
        int a2 = i2 + com.baidu.platform.comapi.wnplatform.p.h.a(activity, i4 - i3);
        customScrollView2 = this.f4222a.l;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
