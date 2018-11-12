package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomScrollView customScrollView;
        CustomScrollView customScrollView2;
        customScrollView = this.a.n;
        if (customScrollView.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.BOTTOM) {
            this.a.c(true);
            return;
        }
        customScrollView2 = this.a.n;
        if (customScrollView2.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.TOP) {
            this.a.d(true);
        }
    }
}
