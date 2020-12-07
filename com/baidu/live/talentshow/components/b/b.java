package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes4.dex */
public class b {
    private FrameLayout byb;
    private a bzI;

    public b(Activity activity, a.InterfaceC0210a interfaceC0210a) {
        this.bzI = new a(activity, interfaceC0210a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.bzI.aa(view);
        } else if (i == 1) {
            this.bzI.a(view, z, j, z2);
        } else if (i == 2) {
            this.bzI.b(view, z, j, z2);
        }
    }

    public void fG(int i) {
        if (i == 0) {
            this.bzI.Tc();
        } else if (i == 1) {
            this.bzI.Ta();
        } else if (i == 2) {
            this.bzI.Tb();
        }
    }

    public void Td() {
        this.bzI.release();
    }

    public void Te() {
        this.bzI.c(this.byb);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.bzI.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.byb = frameLayout;
    }
}
