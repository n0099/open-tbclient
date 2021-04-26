package com.baidu.fsg.base.widget;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f5703a;

    public k(j jVar) {
        this.f5703a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5703a.f5702a.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            return;
        }
        safeScrollView = this.f5703a.f5702a.f5678e;
        if (safeScrollView.hasWindowFocus()) {
            this.f5703a.f5702a.a();
        }
    }
}
