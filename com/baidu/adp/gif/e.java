package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ NSGif dv;
    private final /* synthetic */ int dw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NSGif nSGif, int i) {
        this.dv = nSGif;
        this.dw = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.dw);
    }
}
