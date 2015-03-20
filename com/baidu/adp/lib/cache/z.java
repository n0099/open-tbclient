package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x tr;
    private final /* synthetic */ Object tt;
    private final /* synthetic */ long tu;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str, Object obj, long j) {
        this.tr = xVar;
        this.val$key = str;
        this.tt = obj;
        this.tu = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tr.a(this.val$key, this.tt, this.tu);
    }
}
