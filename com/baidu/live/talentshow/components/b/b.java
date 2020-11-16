package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes4.dex */
public class b {
    private FrameLayout bsQ;
    private a buy;

    public b(Activity activity, a.InterfaceC0200a interfaceC0200a) {
        this.buy = new a(activity, interfaceC0200a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.buy.aa(view);
        } else if (i == 1) {
            this.buy.a(view, z, j, z2);
        } else if (i == 2) {
            this.buy.b(view, z, j, z2);
        }
    }

    public void fi(int i) {
        if (i == 0) {
            this.buy.QE();
        } else if (i == 1) {
            this.buy.QC();
        } else if (i == 2) {
            this.buy.QD();
        }
    }

    public void QF() {
        this.buy.release();
    }

    public void QG() {
        this.buy.c(this.bsQ);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.buy.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.bsQ = frameLayout;
    }
}
