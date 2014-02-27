package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
final class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
