package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
final class x implements Runnable {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.a != null) {
            y.a(this.a.a);
        }
    }
}
