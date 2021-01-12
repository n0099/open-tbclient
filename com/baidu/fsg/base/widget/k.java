package com.baidu.fsg.base.widget;
/* loaded from: classes5.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f2046a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f2046a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f2046a.f2045a.mPopupWindow != null && this.f2046a.f2045a.mPopupWindow.isShowing()) {
            safeScrollView = this.f2046a.f2045a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f2046a.f2045a.a();
            }
        }
    }
}
