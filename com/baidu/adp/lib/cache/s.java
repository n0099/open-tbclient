package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p jH;
    private final /* synthetic */ String jI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.jH = pVar;
        this.jI = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jH.remove(this.jI);
    }
}
