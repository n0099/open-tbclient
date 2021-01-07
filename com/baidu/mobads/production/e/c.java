package com.baidu.mobads.production.e;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3477a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3477a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w;
        RelativeLayout relativeLayout;
        View x;
        RelativeLayout.LayoutParams z;
        RelativeLayout relativeLayout2;
        if (this.f3477a.s()) {
            relativeLayout2 = this.f3477a.e;
            relativeLayout2.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f3477a.h.getAdView() != null) {
            this.f3477a.h.getAdView().setVisibility(0);
        }
        w = this.f3477a.w();
        if (w) {
            this.f3477a.x.d("add countdown view");
            this.f3477a.y();
            relativeLayout = this.f3477a.e;
            x = this.f3477a.x();
            z = this.f3477a.z();
            relativeLayout.addView(x, z);
        }
    }
}
