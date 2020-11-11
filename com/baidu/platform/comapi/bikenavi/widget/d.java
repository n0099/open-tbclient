package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f2849a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomScrollView customScrollView;
        CustomScrollView customScrollView2;
        customScrollView = this.f2849a.l;
        if (customScrollView.getStatus() == com.baidu.platform.comapi.wnplatform.o.b.BOTTOM) {
            this.f2849a.c(true);
            return;
        }
        customScrollView2 = this.f2849a.l;
        if (customScrollView2.getStatus() == com.baidu.platform.comapi.wnplatform.o.b.TOP) {
            this.f2849a.d(true);
        }
    }
}
