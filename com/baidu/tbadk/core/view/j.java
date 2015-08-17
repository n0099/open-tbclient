package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ HaloView adD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HaloView haloView) {
        this.adD = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.adD.adC;
        if (!z) {
            z2 = this.adD.adA;
            if (!z2) {
                HaloView haloView = this.adD;
                HaloView haloView2 = this.adD;
                i = haloView2.adB;
                int i2 = i + 1;
                haloView2.adB = i2;
                haloView.adB = i2 % 4;
            }
            this.adD.postDelayed(this, 800L);
            this.adD.invalidate();
        }
    }
}
