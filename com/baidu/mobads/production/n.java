package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class n implements Runnable {
    final /* synthetic */ com.baidu.mobads.vo.d a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar, com.baidu.mobads.vo.d dVar) {
        this.b = bVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
