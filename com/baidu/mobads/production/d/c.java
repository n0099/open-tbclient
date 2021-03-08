package com.baidu.mobads.production.d;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2452a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w;
        RelativeLayout relativeLayout;
        View x;
        RelativeLayout.LayoutParams z;
        RelativeLayout relativeLayout2;
        if (this.f2452a.s()) {
            relativeLayout2 = this.f2452a.e;
            relativeLayout2.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f2452a.h.getAdView() != null) {
            this.f2452a.h.getAdView().setVisibility(0);
        }
        w = this.f2452a.w();
        if (w) {
            this.f2452a.A.d("add countdown view");
            this.f2452a.y();
            relativeLayout = this.f2452a.e;
            x = this.f2452a.x();
            z = this.f2452a.z();
            relativeLayout.addView(x, z);
        }
    }
}
