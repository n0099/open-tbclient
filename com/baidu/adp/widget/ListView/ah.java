package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ ag vw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.vw = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.vw.vt != null) {
            ai.a(this.vw.vt);
        }
    }
}
