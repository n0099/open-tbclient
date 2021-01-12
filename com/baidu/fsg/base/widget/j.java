package com.baidu.fsg.base.widget;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardUtil f2045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f2045a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f2045a.mPopupWindow != null && this.f2045a.mPopupWindow.isShowing()) {
            safeScrollView = this.f2045a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f2045a.a();
                return;
            }
        }
        new Handler().postDelayed(new k(this), 150L);
    }
}
