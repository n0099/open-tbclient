package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar;
        g gVar2;
        if (this.a.a()) {
            gVar = this.a.a;
            gVar.invalidate();
            gVar2 = this.a.a;
            gVar2.post(this);
        }
    }
}
