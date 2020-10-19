package com.baidu.fsg.base.widget;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardUtil f1554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f1554a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f1554a.mPopupWindow != null && this.f1554a.mPopupWindow.isShowing()) {
            safeScrollView = this.f1554a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f1554a.a();
                return;
            }
        }
        new Handler().postDelayed(new k(this), 150L);
    }
}
