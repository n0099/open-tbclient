package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ HaloView XT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HaloView haloView) {
        this.XT = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.XT.XS;
        if (!z) {
            z2 = this.XT.XQ;
            if (!z2) {
                HaloView haloView = this.XT;
                HaloView haloView2 = this.XT;
                i = haloView2.XR;
                int i2 = i + 1;
                haloView2.XR = i2;
                haloView.XR = i2 % 4;
            }
            this.XT.postDelayed(this, 800L);
            this.XT.invalidate();
        }
    }
}
