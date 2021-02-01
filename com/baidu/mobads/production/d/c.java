package com.baidu.mobads.production.d;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3444a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w;
        RelativeLayout relativeLayout;
        View x;
        RelativeLayout.LayoutParams z;
        RelativeLayout relativeLayout2;
        if (this.f3444a.s()) {
            relativeLayout2 = this.f3444a.e;
            relativeLayout2.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f3444a.h.getAdView() != null) {
            this.f3444a.h.getAdView().setVisibility(0);
        }
        w = this.f3444a.w();
        if (w) {
            this.f3444a.A.d("add countdown view");
            this.f3444a.y();
            relativeLayout = this.f3444a.e;
            x = this.f3444a.x();
            z = this.f3444a.z();
            relativeLayout.addView(x, z);
        }
    }
}
