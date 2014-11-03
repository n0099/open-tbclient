package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ HaloView Hy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(HaloView haloView) {
        this.Hy = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.Hy.Hx;
        if (!z) {
            z2 = this.Hy.Hv;
            if (!z2) {
                HaloView haloView = this.Hy;
                HaloView haloView2 = this.Hy;
                i = haloView2.Hw;
                int i2 = i + 1;
                haloView2.Hw = i2;
                haloView.Hw = i2 % 4;
            }
            this.Hy.postDelayed(this, 800L);
            this.Hy.invalidate();
        }
    }
}
