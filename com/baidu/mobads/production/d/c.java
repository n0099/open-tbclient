package com.baidu.mobads.production.d;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f8456a;

    public c(b bVar) {
        this.f8456a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w;
        RelativeLayout relativeLayout;
        View x;
        RelativeLayout.LayoutParams z;
        RelativeLayout relativeLayout2;
        if (this.f8456a.s()) {
            relativeLayout2 = this.f8456a.f8438e;
            relativeLayout2.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f8456a.f8441h.getAdView() != null) {
            this.f8456a.f8441h.getAdView().setVisibility(0);
        }
        w = this.f8456a.w();
        if (w) {
            this.f8456a.A.d("add countdown view");
            this.f8456a.y();
            relativeLayout = this.f8456a.f8438e;
            x = this.f8456a.x();
            z = this.f8456a.z();
            relativeLayout.addView(x, z);
        }
    }
}
