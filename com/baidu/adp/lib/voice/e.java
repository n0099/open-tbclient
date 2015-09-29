package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.zf = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zf.release();
    }
}
