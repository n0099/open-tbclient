package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes11.dex */
public class b {
    private FrameLayout bBH;
    private a bDp;

    public b(Activity activity, a.InterfaceC0201a interfaceC0201a) {
        this.bDp = new a(activity, interfaceC0201a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.bDp.aa(view);
        } else if (i == 1) {
            this.bDp.a(view, z, j, z2);
        } else if (i == 2) {
            this.bDp.b(view, z, j, z2);
        }
    }

    public void ef(int i) {
        if (i == 0) {
            this.bDp.RW();
        } else if (i == 1) {
            this.bDp.RU();
        } else if (i == 2) {
            this.bDp.RV();
        }
    }

    public void RX() {
        this.bDp.release();
    }

    public void RY() {
        this.bDp.c(this.bBH);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.bDp.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.bBH = frameLayout;
    }
}
