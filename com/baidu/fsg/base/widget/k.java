package com.baidu.fsg.base.widget;
/* loaded from: classes16.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1557a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f1557a.f1556a.mPopupWindow != null && this.f1557a.f1556a.mPopupWindow.isShowing()) {
            safeScrollView = this.f1557a.f1556a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f1557a.f1556a.a();
            }
        }
    }
}
