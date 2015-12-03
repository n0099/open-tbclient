package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ String tA;
    final /* synthetic */ p tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.tz = pVar;
        this.tA = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tz.remove(this.tA);
    }
}
