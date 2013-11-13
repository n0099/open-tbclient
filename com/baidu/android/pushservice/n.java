package com.baidu.android.pushservice;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushService f724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PushService pushService) {
        this.f724a = pushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f724a.stopSelf();
    }
}
