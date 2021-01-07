package com.baidu.fsg.base.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeKeyBoardEditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardEditText f2088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f2088a = safeKeyBoardEditText;
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
            z2 = this.f2088a.l;
            if (z2) {
                context = this.f2088a.f2077b;
                RimGlobalUtils.hideInputMethod(context, this.f2088a);
                safeScrollView = this.f2088a.d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.f2088a.d;
                    if (safeScrollView2.hasWindowFocus()) {
                        safeScrollView3 = this.f2088a.d;
                        if (!safeScrollView3.isPopupWindowShowing()) {
                            safeScrollView4 = this.f2088a.d;
                            viewGroup = this.f2088a.c;
                            SafeKeyBoardEditText safeKeyBoardEditText = this.f2088a;
                            view2 = this.f2088a.e;
                            safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText, view2);
                        }
                    }
                }
            }
        } else if (!this.f2088a.isAlwaysShow) {
            safeScrollView5 = this.f2088a.d;
            if (safeScrollView5 != null) {
                safeScrollView6 = this.f2088a.d;
                safeScrollView6.dismissKeyBoard(this.f2088a);
            } else {
                context2 = this.f2088a.f2077b;
                RimGlobalUtils.hideInputMethod(context2, this.f2088a);
            }
        }
        onMyFocusChangeListener = this.f2088a.n;
        if (onMyFocusChangeListener != null) {
            onMyFocusChangeListener2 = this.f2088a.n;
            onMyFocusChangeListener2.onMyFocusChange(view, z);
        }
    }
}
