package com.baidu.fsg.base.widget;
/* loaded from: classes5.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1597a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f1597a.f1596a.mPopupWindow != null && this.f1597a.f1596a.mPopupWindow.isShowing()) {
            safeScrollView = this.f1597a.f1596a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f1597a.f1596a.a();
            }
        }
    }
}
