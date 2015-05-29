package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ NSGif ra;
    private final /* synthetic */ int rb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NSGif nSGif, int i) {
        this.ra = nSGif;
        this.rb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NSGif.nativeDestroy(this.rb);
    }
}
