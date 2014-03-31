package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
final class z implements Runnable {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.a != null) {
            aa.a(this.a.a);
        }
    }
}
