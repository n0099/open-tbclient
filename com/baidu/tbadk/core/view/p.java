package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ HaloView MP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HaloView haloView) {
        this.MP = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.MP.MO;
        if (!z) {
            z2 = this.MP.ML;
            if (!z2) {
                HaloView haloView = this.MP;
                HaloView haloView2 = this.MP;
                i = haloView2.MN;
                int i2 = i + 1;
                haloView2.MN = i2;
                haloView.MN = i2 % 4;
            }
            this.MP.postDelayed(this, 800L);
            this.MP.invalidate();
        }
    }
}
