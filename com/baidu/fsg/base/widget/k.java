package com.baidu.fsg.base.widget;
/* loaded from: classes6.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f2095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f2095a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f2095a.f2094a.mPopupWindow != null && this.f2095a.f2094a.mPopupWindow.isShowing()) {
            safeScrollView = this.f2095a.f2094a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f2095a.f2094a.a();
            }
        }
    }
}
