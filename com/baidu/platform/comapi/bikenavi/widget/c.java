package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f2890a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomScrollView customScrollView;
        CustomScrollView customScrollView2;
        customScrollView = this.f2890a.n;
        if (customScrollView.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.BOTTOM) {
            this.f2890a.c(true);
            return;
        }
        customScrollView2 = this.f2890a.n;
        if (customScrollView2.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.TOP) {
            this.f2890a.d(true);
        }
    }
}
