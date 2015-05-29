package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x tC;
    private final /* synthetic */ u tD;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, u uVar) {
        this.tC = xVar;
        this.val$key = str;
        this.tD = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tD.onItemGet(this.val$key, this.tC.get(this.val$key));
    }
}
