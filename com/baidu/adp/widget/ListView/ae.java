package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad Io;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.Io = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Io.Im != null) {
            af.a(this.Io.Im);
        }
    }
}
