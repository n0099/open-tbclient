package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x hU;
    private final /* synthetic */ Object hW;
    private final /* synthetic */ long hX;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str, Object obj, long j) {
        this.hU = xVar;
        this.val$key = str;
        this.hW = obj;
        this.hX = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hU.a(this.val$key, this.hW, this.hX);
    }
}
