package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a != null) {
            ae.a(this.a.a);
        }
    }
}
