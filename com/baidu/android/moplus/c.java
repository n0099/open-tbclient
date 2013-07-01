package com.baidu.android.moplus;
/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MoPlusService moPlusService) {
        this.f250a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f250a.stopSelf();
    }
}
