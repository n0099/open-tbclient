package com.baidu.mobads.production.e;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2400a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w;
        RelativeLayout relativeLayout;
        View x;
        RelativeLayout.LayoutParams z;
        RelativeLayout relativeLayout2;
        if (this.f2400a.s()) {
            relativeLayout2 = this.f2400a.e;
            relativeLayout2.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f2400a.h.getAdView() != null) {
            this.f2400a.h.getAdView().setVisibility(0);
        }
        w = this.f2400a.w();
        if (w) {
            this.f2400a.x.d("add countdown view");
            this.f2400a.y();
            relativeLayout = this.f2400a.e;
            x = this.f2400a.x();
            z = this.f2400a.z();
            relativeLayout.addView(x, z);
        }
    }
}
