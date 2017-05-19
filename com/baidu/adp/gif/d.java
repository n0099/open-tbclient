package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ NSGif rq;
    private final /* synthetic */ int rr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NSGif nSGif, int i) {
        this.rq = nSGif;
        this.rr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.rr);
    }
}
