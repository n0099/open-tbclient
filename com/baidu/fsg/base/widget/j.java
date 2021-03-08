package com.baidu.fsg.base.widget;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardUtil f1596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f1596a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.f1596a.mPopupWindow != null && this.f1596a.mPopupWindow.isShowing()) {
            safeScrollView = this.f1596a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.f1596a.a();
                return;
            }
        }
        new Handler().postDelayed(new k(this), 150L);
    }
}
