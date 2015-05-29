package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad Ig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.Ig = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ig.Ie != null) {
            af.a(this.Ig.Ie);
        }
    }
}
