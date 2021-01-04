package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes11.dex */
public class b {
    private FrameLayout bCN;
    private a bEv;

    public b(Activity activity, a.InterfaceC0208a interfaceC0208a) {
        this.bEv = new a(activity, interfaceC0208a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.bEv.aa(view);
        } else if (i == 1) {
            this.bEv.a(view, z, j, z2);
        } else if (i == 2) {
            this.bEv.b(view, z, j, z2);
        }
    }

    public void fH(int i) {
        if (i == 0) {
            this.bEv.Uh();
        } else if (i == 1) {
            this.bEv.Uf();
        } else if (i == 2) {
            this.bEv.Ug();
        }
    }

    public void Ui() {
        this.bEv.release();
    }

    public void Uj() {
        this.bEv.c(this.bCN);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.bEv.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.bCN = frameLayout;
    }
}
