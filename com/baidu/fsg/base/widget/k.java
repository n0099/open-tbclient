package com.baidu.fsg.base.widget;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5557a;

    public k(j jVar) {
        this.f5557a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5557a.f5556a.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        safeScrollView = this.f5557a.f5556a.f5532e;
        if (safeScrollView.hasWindowFocus()) {
            this.f5557a.f5556a.a();
        }
    }
}
