package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ HaloView ML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HaloView haloView) {
        this.ML = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.ML.MK;
        if (!z) {
            z2 = this.ML.MI;
            if (!z2) {
                HaloView haloView = this.ML;
                HaloView haloView2 = this.ML;
                i = haloView2.MJ;
                int i2 = i + 1;
                haloView2.MJ = i2;
                haloView.MJ = i2 % 4;
            }
            this.ML.postDelayed(this, 800L);
            this.ML.invalidate();
        }
    }
}
