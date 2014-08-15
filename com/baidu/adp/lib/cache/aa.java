package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ x a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, String str) {
        this.a = xVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c(this.b);
    }
}
