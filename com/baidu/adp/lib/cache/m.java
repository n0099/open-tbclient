package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k js;
    private final /* synthetic */ String jt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.js = kVar;
        this.jt = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.js.jr.I(this.jt);
    }
}
