package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e gq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.gq = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        h hVar2;
        if (this.gq.cJ()) {
            hVar = this.gq.gn;
            hVar.invalidate();
            hVar2 = this.gq.gn;
            hVar2.post(this);
        }
    }
}
