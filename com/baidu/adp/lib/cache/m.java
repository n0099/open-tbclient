package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k mh;
    private final /* synthetic */ String mi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.mh = kVar;
        this.mi = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mh.mg.L(this.mi);
    }
}
