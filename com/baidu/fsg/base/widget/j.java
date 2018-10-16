package com.baidu.fsg.base.widget;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j implements Runnable {
    final /* synthetic */ SafeKeyBoardUtil a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeScrollView safeScrollView;
        if (this.a.mPopupWindow != null && this.a.mPopupWindow.isShowing()) {
            safeScrollView = this.a.e;
            if (safeScrollView.hasWindowFocus()) {
                this.a.a();
                return;
            }
        }
        new Handler().postDelayed(new k(this), 150L);
    }
}
