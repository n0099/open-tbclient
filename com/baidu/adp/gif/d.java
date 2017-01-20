package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ NSGif jP;
    private final /* synthetic */ int jQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NSGif nSGif, int i) {
        this.jP = nSGif;
        this.jQ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.jQ);
    }
}
