package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p ki;
    private final /* synthetic */ String kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.ki = pVar;
        this.kj = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ki.remove(this.kj);
    }
}
