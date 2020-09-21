package com.baidu.fsg.base.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeKeyBoardEditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d implements View.OnFocusChangeListener {
    final /* synthetic */ SafeKeyBoardEditText a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        boolean z2;
        Context context;
        SafeScrollView safeScrollView;
        SafeScrollView safeScrollView2;
        SafeScrollView safeScrollView3;
        SafeScrollView safeScrollView4;
        ViewGroup viewGroup;
        View view2;
        SafeKeyBoardEditText.OnMyFocusChangeListener onMyFocusChangeListener;
        SafeKeyBoardEditText.OnMyFocusChangeListener onMyFocusChangeListener2;
        SafeScrollView safeScrollView5;
        Context context2;
        SafeScrollView safeScrollView6;
        if (z) {
            z2 = this.a.l;
            if (z2) {
                context = this.a.b;
                RimGlobalUtils.hideInputMethod(context, this.a);
                safeScrollView = this.a.d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.a.d;
                    if (safeScrollView2.hasWindowFocus()) {
                        safeScrollView3 = this.a.d;
                        if (!safeScrollView3.isPopupWindowShowing()) {
                            safeScrollView4 = this.a.d;
                            viewGroup = this.a.c;
                            SafeKeyBoardEditText safeKeyBoardEditText = this.a;
                            view2 = this.a.e;
                            safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText, view2);
                        }
                    }
                }
            }
        } else if (!this.a.isAlwaysShow) {
            safeScrollView5 = this.a.d;
            if (safeScrollView5 != null) {
                safeScrollView6 = this.a.d;
                safeScrollView6.dismissKeyBoard(this.a);
            } else {
                context2 = this.a.b;
                RimGlobalUtils.hideInputMethod(context2, this.a);
            }
        }
        onMyFocusChangeListener = this.a.n;
        if (onMyFocusChangeListener != null) {
            onMyFocusChangeListener2 = this.a.n;
            onMyFocusChangeListener2.onMyFocusChange(view, z);
        }
    }
}
