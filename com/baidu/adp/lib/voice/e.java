package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c zl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.zl = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zl.release();
    }
}
