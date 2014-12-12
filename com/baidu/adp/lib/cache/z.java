package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x hS;
    private final /* synthetic */ Object hU;
    private final /* synthetic */ long hV;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str, Object obj, long j) {
        this.hS = xVar;
        this.val$key = str;
        this.hU = obj;
        this.hV = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hS.a(this.val$key, this.hU, this.hV);
    }
}
