package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x hU;
    private final /* synthetic */ u hV;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, u uVar) {
        this.hU = xVar;
        this.val$key = str;
        this.hV = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hV.onItemGet(this.val$key, this.hU.get(this.val$key));
    }
}
