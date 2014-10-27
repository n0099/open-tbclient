package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ HaloView Hx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(HaloView haloView) {
        this.Hx = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.Hx.Hw;
        if (!z) {
            z2 = this.Hx.Hu;
            if (!z2) {
                HaloView haloView = this.Hx;
                HaloView haloView2 = this.Hx;
                i = haloView2.Hv;
                int i2 = i + 1;
                haloView2.Hv = i2;
                haloView.Hv = i2 % 4;
            }
            this.Hx.postDelayed(this, 800L);
            this.Hx.invalidate();
        }
    }
}
