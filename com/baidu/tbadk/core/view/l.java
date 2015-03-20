package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ HaloView XR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HaloView haloView) {
        this.XR = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.XR.XQ;
        if (!z) {
            z2 = this.XR.XO;
            if (!z2) {
                HaloView haloView = this.XR;
                HaloView haloView2 = this.XR;
                i = haloView2.XP;
                int i2 = i + 1;
                haloView2.XP = i2;
                haloView.XP = i2 % 4;
            }
            this.XR.postDelayed(this, 800L);
            this.XR.invalidate();
        }
    }
}
