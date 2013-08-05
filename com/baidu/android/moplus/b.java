package com.baidu.android.moplus;
/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MoPlusService moPlusService) {
        this.f514a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f514a.stopSelf();
    }
}
