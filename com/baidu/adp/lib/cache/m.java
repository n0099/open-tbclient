package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k ju;
    private final /* synthetic */ String jv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.ju = kVar;
        this.jv = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ju.jt.I(this.jv);
    }
}
