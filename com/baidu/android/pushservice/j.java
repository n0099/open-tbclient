package com.baidu.android.pushservice;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ PushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PushService pushService) {
        this.a = pushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.stopSelf();
    }
}
