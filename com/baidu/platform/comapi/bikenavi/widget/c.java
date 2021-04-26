package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9785a;

    public c(a aVar) {
        this.f9785a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomScrollView customScrollView;
        CustomScrollView customScrollView2;
        customScrollView = this.f9785a.n;
        if (customScrollView.getStatus() != com.baidu.platform.comapi.wnplatform.n.b.BOTTOM) {
            customScrollView2 = this.f9785a.n;
            if (customScrollView2.getStatus() == com.baidu.platform.comapi.wnplatform.n.b.TOP) {
                this.f9785a.d(true);
                return;
            }
            return;
        }
        this.f9785a.c(true);
    }
}
