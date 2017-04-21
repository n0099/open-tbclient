package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p tR;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.tR = pVar;
        this.val$key = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tR.remove(this.val$key);
    }
}
