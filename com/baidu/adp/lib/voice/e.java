package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c oe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.oe = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.oe.release();
    }
}
