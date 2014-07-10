package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, String str) {
        this.a = wVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c(this.b);
    }
}
