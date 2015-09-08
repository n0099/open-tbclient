package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p ty;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.ty = pVar;
        this.tz = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ty.remove(this.tz);
    }
}
