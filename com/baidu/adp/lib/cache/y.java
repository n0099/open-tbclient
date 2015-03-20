package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x tr;
    private final /* synthetic */ u ts;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, u uVar) {
        this.tr = xVar;
        this.val$key = str;
        this.ts = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ts.onItemGet(this.val$key, this.tr.get(this.val$key));
    }
}
