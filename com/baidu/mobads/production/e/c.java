package com.baidu.mobads.production.e;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w;
        RelativeLayout relativeLayout;
        View x;
        RelativeLayout.LayoutParams z;
        RelativeLayout relativeLayout2;
        if (this.a.s()) {
            relativeLayout2 = this.a.e;
            relativeLayout2.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.a.h.getAdView() != null) {
            this.a.h.getAdView().setVisibility(0);
        }
        w = this.a.w();
        if (w) {
            this.a.x.d("add countdown view");
            this.a.y();
            relativeLayout = this.a.e;
            x = this.a.x();
            z = this.a.z();
            relativeLayout.addView(x, z);
        }
    }
}
