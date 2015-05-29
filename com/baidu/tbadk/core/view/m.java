package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ HaloView YG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HaloView haloView) {
        this.YG = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.YG.YF;
        if (!z) {
            z2 = this.YG.YD;
            if (!z2) {
                HaloView haloView = this.YG;
                HaloView haloView2 = this.YG;
                i = haloView2.YE;
                int i2 = i + 1;
                haloView2.YE = i2;
                haloView.YE = i2 % 4;
            }
            this.YG.postDelayed(this, 800L);
            this.YG.invalidate();
        }
    }
}
