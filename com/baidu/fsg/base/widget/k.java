package com.baidu.fsg.base.widget;
/* loaded from: classes16.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1555a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f1555a.f1554a.mPopupWindow != null && this.f1555a.f1554a.mPopupWindow.isShowing()) {
            safeScrollView = this.f1555a.f1554a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f1555a.f1554a.a();
            }
        }
    }
}
