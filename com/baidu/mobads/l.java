package com.baidu.mobads;
/* loaded from: classes7.dex */
final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f2365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Runnable runnable) {
        this.f2365a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2365a.run();
    }
}
