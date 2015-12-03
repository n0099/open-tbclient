package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k tk;
    private final /* synthetic */ String tl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tk = kVar;
        this.tl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tk.tj.S(this.tl);
    }
}
