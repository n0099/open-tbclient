package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ k mn;
    private final /* synthetic */ String mo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.mn = kVar;
        this.mo = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mn.mm.M(this.mo);
    }
}
