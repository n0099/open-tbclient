package com.baidu.fsg.base.widget;

import android.view.KeyEvent;
import android.view.View;
/* loaded from: classes2.dex */
public class e implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardEditText f5493a;

    public e(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f5493a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        boolean z;
        SafeScrollView safeScrollView;
        SafeScrollView safeScrollView2;
        SafeScrollView safeScrollView3;
        if (keyEvent.getAction() == 0 && i2 == 4) {
            z = this.f5493a.l;
            if (z) {
                safeScrollView = this.f5493a.f5455d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.f5493a.f5455d;
                    if (safeScrollView2.isPopupWindowShowing()) {
                        safeScrollView3 = this.f5493a.f5455d;
                        safeScrollView3.dismissKeyBoard(this.f5493a);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
