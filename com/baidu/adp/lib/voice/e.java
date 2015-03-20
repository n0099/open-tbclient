package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c zG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.zG = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zG.release();
    }
}
