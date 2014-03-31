package com.baidu.adp.framework;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {
    final /* synthetic */ c a;
    private final /* synthetic */ com.baidu.adp.framework.message.f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.adp.framework.message.f fVar) {
        this.a = cVar;
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}
