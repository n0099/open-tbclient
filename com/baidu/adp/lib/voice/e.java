package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c zC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.zC = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zC.release();
    }
}
