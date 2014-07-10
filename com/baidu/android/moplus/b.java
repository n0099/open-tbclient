package com.baidu.android.moplus;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ MoPlusService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MoPlusService moPlusService) {
        this.a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.stopSelf();
    }
}
