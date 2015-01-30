package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ x hU;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, String str) {
        this.hU = xVar;
        this.val$key = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hU.remove(this.val$key);
    }
}
