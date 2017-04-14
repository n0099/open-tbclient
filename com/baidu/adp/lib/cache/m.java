package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ String tA;
    final /* synthetic */ k tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str) {
        this.tz = kVar;
        this.tA = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tz.ty.H(this.tA);
    }
}
