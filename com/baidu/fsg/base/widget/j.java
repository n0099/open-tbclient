package com.baidu.fsg.base.widget;

import android.os.Handler;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardUtil f5499a;

    public j(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5499a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5499a.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing()) {
            safeScrollView = this.f5499a.f5475e;
            if (safeScrollView.hasWindowFocus()) {
                this.f5499a.a();
                return;
            }
        }
        new Handler().postDelayed(new k(this), 150L);
    }
}
