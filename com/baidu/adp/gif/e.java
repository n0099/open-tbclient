package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ NSGif fA;
    private final /* synthetic */ int fB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NSGif nSGif, int i) {
        this.fA = nSGif;
        this.fB = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.fB);
    }
}
