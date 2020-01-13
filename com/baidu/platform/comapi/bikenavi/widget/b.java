package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
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
        a aVar = this.a;
        activity = this.a.a;
        int e = com.baidu.platform.comapi.wnplatform.o.g.e(activity);
        activity2 = this.a.a;
        i = a.F;
        aVar.E = e - com.baidu.platform.comapi.wnplatform.o.g.a(activity2, i);
        customScrollView = this.a.n;
        i2 = this.a.E;
        customScrollView.setBlankHeight(i2);
        i3 = this.a.E;
        activity3 = this.a.a;
        i4 = a.F;
        i5 = a.G;
        int a = i3 + com.baidu.platform.comapi.wnplatform.o.g.a(activity3, i4 - i5);
        customScrollView2 = this.a.n;
        customScrollView2.setStatusHeight(a, 0);
    }
}
