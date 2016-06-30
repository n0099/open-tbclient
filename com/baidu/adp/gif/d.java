package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ NSGif ha;
    private final /* synthetic */ int hb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NSGif nSGif, int i) {
        this.ha = nSGif;
        this.hb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.hb);
    }
}
