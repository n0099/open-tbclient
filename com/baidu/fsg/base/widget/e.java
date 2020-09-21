package com.baidu.fsg.base.widget;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class e implements View.OnKeyListener {
    final /* synthetic */ SafeKeyBoardEditText a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        boolean z;
        SafeScrollView safeScrollView;
        SafeScrollView safeScrollView2;
        SafeScrollView safeScrollView3;
        if (keyEvent.getAction() == 0 && i == 4) {
            z = this.a.l;
            if (z) {
                safeScrollView = this.a.d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.a.d;
                    if (safeScrollView2.isPopupWindowShowing()) {
                        safeScrollView3 = this.a.d;
                        safeScrollView3.dismissKeyBoard(this.a);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
