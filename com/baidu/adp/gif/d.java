package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ NSGif jW;
    private final /* synthetic */ int jX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NSGif nSGif, int i) {
        this.jW = nSGif;
        this.jX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.jX);
    }
}
