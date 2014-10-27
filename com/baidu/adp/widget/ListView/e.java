package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d uv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.uv = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.uv.ut.start();
    }
}
