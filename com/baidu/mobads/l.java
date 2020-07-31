package com.baidu.mobads;
/* loaded from: classes20.dex */
final class l implements Runnable {
    final /* synthetic */ Runnable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
