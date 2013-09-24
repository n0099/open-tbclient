package com.baidu.android.moplus;
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MoPlusService moPlusService) {
        this.f548a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f548a.stopSelf();
    }
}
