package com.baidu.android.nebula.b;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.d(this.a.a);
    }
}
