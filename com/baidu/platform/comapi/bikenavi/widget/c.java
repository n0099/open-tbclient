package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f2846a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CustomScrollView customScrollView;
        int i;
        int i2;
        int i3;
        CustomScrollView customScrollView2;
        this.f2846a.E = com.baidu.platform.comapi.wnplatform.p.h.e(this.f2846a.f2842a) - com.baidu.platform.comapi.wnplatform.p.h.a(this.f2846a.f2842a, a.F);
        customScrollView = this.f2846a.l;
        i = this.f2846a.E;
        customScrollView.setBlankHeight(i);
        i2 = this.f2846a.E;
        Activity activity = this.f2846a.f2842a;
        int i4 = a.F;
        i3 = a.G;
        int a2 = i2 + com.baidu.platform.comapi.wnplatform.p.h.a(activity, i4 - i3);
        customScrollView2 = this.f2846a.l;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
