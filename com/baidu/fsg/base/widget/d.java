package com.baidu.fsg.base.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeKeyBoardEditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class d implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardEditText f1552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f1552a = safeKeyBoardEditText;
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
            z2 = this.f1552a.l;
            if (z2) {
                context = this.f1552a.b;
                RimGlobalUtils.hideInputMethod(context, this.f1552a);
                safeScrollView = this.f1552a.d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.f1552a.d;
                    if (safeScrollView2.hasWindowFocus()) {
                        safeScrollView3 = this.f1552a.d;
                        if (!safeScrollView3.isPopupWindowShowing()) {
                            safeScrollView4 = this.f1552a.d;
                            viewGroup = this.f1552a.c;
                            SafeKeyBoardEditText safeKeyBoardEditText = this.f1552a;
                            view2 = this.f1552a.e;
                            safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText, view2);
                        }
                    }
                }
            }
        } else if (!this.f1552a.isAlwaysShow) {
            safeScrollView5 = this.f1552a.d;
            if (safeScrollView5 != null) {
                safeScrollView6 = this.f1552a.d;
                safeScrollView6.dismissKeyBoard(this.f1552a);
            } else {
                context2 = this.f1552a.b;
                RimGlobalUtils.hideInputMethod(context2, this.f1552a);
            }
        }
        onMyFocusChangeListener = this.f1552a.n;
        if (onMyFocusChangeListener != null) {
            onMyFocusChangeListener2 = this.f1552a.n;
            onMyFocusChangeListener2.onMyFocusChange(view, z);
        }
    }
}
