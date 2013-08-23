package com.baidu.android.moplus;
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f536a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MoPlusService moPlusService) {
        this.f536a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f536a.stopSelf();
    }
}
