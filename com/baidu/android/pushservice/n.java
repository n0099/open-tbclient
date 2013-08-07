package com.baidu.android.pushservice;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushService f595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PushService pushService) {
        this.f595a = pushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f595a.stopSelf();
    }
}
