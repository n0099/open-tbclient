package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ c th;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.th = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.th.gi();
    }
}
