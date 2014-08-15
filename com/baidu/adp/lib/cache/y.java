package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x a;
    private final /* synthetic */ String b;
    private final /* synthetic */ u c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, u uVar) {
        this.a = xVar;
        this.b = str;
        this.c = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.b, this.a.a(this.b));
    }
}
