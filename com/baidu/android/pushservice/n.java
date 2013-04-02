package com.baidu.android.pushservice;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ PushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PushService pushService) {
        this.a = pushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a();
    }
}
