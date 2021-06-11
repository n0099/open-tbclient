package com.baidu.fsg.base.widget;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5500a;

    public k(j jVar) {
        this.f5500a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5500a.f5499a.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        safeScrollView = this.f5500a.f5499a.f5475e;
        if (safeScrollView.hasWindowFocus()) {
            this.f5500a.f5499a.a();
        }
    }
}
