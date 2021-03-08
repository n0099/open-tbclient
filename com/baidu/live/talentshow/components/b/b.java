package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes10.dex */
public class b {
    private FrameLayout bDh;
    private a bEP;

    public b(Activity activity, a.InterfaceC0207a interfaceC0207a) {
        this.bEP = new a(activity, interfaceC0207a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.bEP.aa(view);
        } else if (i == 1) {
            this.bEP.a(view, z, j, z2);
        } else if (i == 2) {
            this.bEP.b(view, z, j, z2);
        }
    }

    public void eg(int i) {
        if (i == 0) {
            this.bEP.RZ();
        } else if (i == 1) {
            this.bEP.RX();
        } else if (i == 2) {
            this.bEP.RY();
        }
    }

    public void Sa() {
        this.bEP.release();
    }

    public void Sb() {
        this.bEP.c(this.bDh);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.bEP.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.bDh = frameLayout;
    }
}
