package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ x hS;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, String str) {
        this.hS = xVar;
        this.val$key = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hS.remove(this.val$key);
    }
}
