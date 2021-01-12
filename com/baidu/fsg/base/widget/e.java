package com.baidu.fsg.base.widget;

import android.view.KeyEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardEditText f2039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f2039a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        boolean z;
        SafeScrollView safeScrollView;
        SafeScrollView safeScrollView2;
        SafeScrollView safeScrollView3;
        if (keyEvent.getAction() == 0 && i == 4) {
            z = this.f2039a.l;
            if (z) {
                safeScrollView = this.f2039a.d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.f2039a.d;
                    if (safeScrollView2.isPopupWindowShowing()) {
                        safeScrollView3 = this.f2039a.d;
                        safeScrollView3.dismissKeyBoard(this.f2039a);
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
