package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4170a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4170a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomScrollView customScrollView;
        CustomScrollView customScrollView2;
        customScrollView = this.f4170a.n;
        if (customScrollView.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.BOTTOM) {
            this.f4170a.c(true);
            return;
        }
        customScrollView2 = this.f4170a.n;
        if (customScrollView2.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.TOP) {
            this.f4170a.d(true);
        }
    }
}
