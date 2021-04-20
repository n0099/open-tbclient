package com.baidu.fsg.base.widget;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5554a;

    public k(j jVar) {
        this.f5554a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5554a.f5553a.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        safeScrollView = this.f5554a.f5553a.f5531e;
        if (safeScrollView.hasWindowFocus()) {
            this.f5554a.f5553a.a();
        }
    }
}
