package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad Iq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.Iq = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Iq.Io != null) {
            af.a(this.Iq.Io);
        }
    }
}
