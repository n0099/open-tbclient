package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.wz = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wz.wy.start();
    }
}
