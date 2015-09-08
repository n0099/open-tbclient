package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ HaloView adN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HaloView haloView) {
        this.adN = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.adN.adM;
        if (!z) {
            z2 = this.adN.adK;
            if (!z2) {
                HaloView haloView = this.adN;
                HaloView haloView2 = this.adN;
                i = haloView2.adL;
                int i2 = i + 1;
                haloView2.adL = i2;
                haloView.adL = i2 % 4;
            }
            this.adN.postDelayed(this, 800L);
            this.adN.invalidate();
        }
    }
}
