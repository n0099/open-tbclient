package com.baidu.fsg.base.widget;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5518a;

    public k(j jVar) {
        this.f5518a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5518a.f5517a.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        safeScrollView = this.f5518a.f5517a.f5495e;
        if (safeScrollView.hasWindowFocus()) {
            this.f5518a.f5517a.a();
        }
    }
}
