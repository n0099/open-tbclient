package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ x tr;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, String str) {
        this.tr = xVar;
        this.val$key = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tr.remove(this.val$key);
    }
}
