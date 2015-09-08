package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c ze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.ze = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ze.release();
    }
}
