package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p jF;
    private final /* synthetic */ String jG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.jF = pVar;
        this.jG = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jF.remove(this.jG);
    }
}
