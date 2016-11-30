package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c sT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.sT = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.sT.release();
    }
}
