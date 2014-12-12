package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x hS;
    private final /* synthetic */ u hT;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, u uVar) {
        this.hS = xVar;
        this.val$key = str;
        this.hT = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hT.onItemGet(this.val$key, this.hS.get(this.val$key));
    }
}
