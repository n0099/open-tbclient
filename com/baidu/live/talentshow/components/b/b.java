package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes10.dex */
public class b {
    private FrameLayout byb;
    private a bzJ;

    public b(Activity activity, a.InterfaceC0199a interfaceC0199a) {
        this.bzJ = new a(activity, interfaceC0199a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.bzJ.aa(view);
        } else if (i == 1) {
            this.bzJ.a(view, z, j, z2);
        } else if (i == 2) {
            this.bzJ.b(view, z, j, z2);
        }
    }

    public void eb(int i) {
        if (i == 0) {
            this.bzJ.Qm();
        } else if (i == 1) {
            this.bzJ.Qk();
        } else if (i == 2) {
            this.bzJ.Ql();
        }
    }

    public void Qn() {
        this.bzJ.release();
    }

    public void Qo() {
        this.bzJ.c(this.byb);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.bzJ.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.byb = frameLayout;
    }
}
