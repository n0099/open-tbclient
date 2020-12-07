package com.baidu.fsg.base.widget;
/* loaded from: classes16.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1559a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f1559a.f1558a.mPopupWindow != null && this.f1559a.f1558a.mPopupWindow.isShowing()) {
            safeScrollView = this.f1559a.f1558a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f1559a.f1558a.a();
            }
        }
    }
}
