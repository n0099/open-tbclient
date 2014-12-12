package com.baidu.tbadk.core.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ HaloView Ms;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HaloView haloView) {
        this.Ms = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.Ms.Mr;
        if (!z) {
            z2 = this.Ms.Mp;
            if (!z2) {
                HaloView haloView = this.Ms;
                HaloView haloView2 = this.Ms;
                i = haloView2.Mq;
                int i2 = i + 1;
                haloView2.Mq = i2;
                haloView.Mq = i2 % 4;
            }
            this.Ms.postDelayed(this, 800L);
            this.Ms.invalidate();
        }
    }
}
