package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k js;
    private final /* synthetic */ String jt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.js = kVar;
        this.jt = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.js.jr.J(this.jt);
    }
}
