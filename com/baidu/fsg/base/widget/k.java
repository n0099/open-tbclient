package com.baidu.fsg.base.widget;
/* loaded from: classes2.dex */
class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.a.a.mPopupWindow != null && this.a.a.mPopupWindow.isShowing()) {
            safeScrollView = this.a.a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.a.a.a();
            }
        }
    }
}
