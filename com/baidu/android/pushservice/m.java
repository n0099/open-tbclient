package com.baidu.android.pushservice;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ PushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PushService pushService) {
        this.a = pushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushService.a.b();
    }
}
