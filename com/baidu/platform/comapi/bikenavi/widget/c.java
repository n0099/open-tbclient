package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CustomScrollView customScrollView;
        int i;
        int i2;
        int i3;
        CustomScrollView customScrollView2;
        this.a.E = com.baidu.platform.comapi.wnplatform.p.h.e(this.a.a) - com.baidu.platform.comapi.wnplatform.p.h.a(this.a.a, a.F);
        customScrollView = this.a.l;
        i = this.a.E;
        customScrollView.setBlankHeight(i);
        i2 = this.a.E;
        Activity activity = this.a.a;
        int i4 = a.F;
        i3 = a.G;
        int a = i2 + com.baidu.platform.comapi.wnplatform.p.h.a(activity, i4 - i3);
        customScrollView2 = this.a.l;
        customScrollView2.setStatusHeight(a, 0);
    }
}
