package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.talentshow.components.b.a;
/* loaded from: classes4.dex */
public class b {
    private FrameLayout buD;
    private a bwj;

    public b(Activity activity, a.InterfaceC0202a interfaceC0202a) {
        this.bwj = new a(activity, interfaceC0202a);
    }

    public void a(View view, int i, long j, boolean z, boolean z2) {
        if (i == 0) {
            this.bwj.aa(view);
        } else if (i == 1) {
            this.bwj.a(view, z, j, z2);
        } else if (i == 2) {
            this.bwj.b(view, z, j, z2);
        }
    }

    public void fm(int i) {
        if (i == 0) {
            this.bwj.Rn();
        } else if (i == 1) {
            this.bwj.Rl();
        } else if (i == 2) {
            this.bwj.Rm();
        }
    }

    public void Ro() {
        this.bwj.release();
    }

    public void Rp() {
        this.bwj.c(this.buD);
    }

    public void a(int i, long j, boolean z, boolean z2) {
        this.bwj.a(i, j, z, z2);
    }

    public void d(FrameLayout frameLayout) {
        this.buD = frameLayout;
    }
}
