package com.baidu.fsg.base.widget;

import android.os.Handler;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardUtil f5556a;

    public j(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5556a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5556a.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing()) {
            safeScrollView = this.f5556a.f5532e;
            if (safeScrollView.hasWindowFocus()) {
                this.f5556a.a();
                return;
            }
        }
        new Handler().postDelayed(new k(this), 150L);
    }
}
