package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k mn;
    private final /* synthetic */ String mo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.mn = kVar;
        this.mo = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mn.mm.L(this.mo);
    }
}
