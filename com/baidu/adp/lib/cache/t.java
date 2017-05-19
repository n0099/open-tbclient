package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ p tS;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str) {
        this.tS = pVar;
        this.val$key = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tS.remove(this.val$key);
    }
}
