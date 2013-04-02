package com.baidu.android.pushservice;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ PushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PushService pushService) {
        this.a = pushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.stopSelf();
    }
}
