package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k tl;
    private final /* synthetic */ String tm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tl = kVar;
        this.tm = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tl.tk.U(this.tm);
    }
}
