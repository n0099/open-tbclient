package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a != null) {
            ab.a(this.a.a);
        }
    }
}
