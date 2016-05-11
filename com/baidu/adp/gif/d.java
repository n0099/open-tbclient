package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ NSGif hb;
    private final /* synthetic */ int hc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NSGif nSGif, int i) {
        this.hb = nSGif;
        this.hc = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.hc);
    }
}
