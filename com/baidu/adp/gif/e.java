package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ NSGif fC;
    private final /* synthetic */ int fD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NSGif nSGif, int i) {
        this.fC = nSGif;
        this.fD = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.fD);
    }
}
