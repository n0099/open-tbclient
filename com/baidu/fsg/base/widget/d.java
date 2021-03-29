package com.baidu.fsg.base.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeKeyBoardEditText;
/* loaded from: classes2.dex */
public class d implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardEditText f5511a;

    public d(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f5511a = safeKeyBoardEditText;
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
        if (!z) {
            SafeKeyBoardEditText safeKeyBoardEditText = this.f5511a;
            if (!safeKeyBoardEditText.isAlwaysShow) {
                safeScrollView5 = safeKeyBoardEditText.f5478d;
                if (safeScrollView5 != null) {
                    safeScrollView6 = this.f5511a.f5478d;
                    safeScrollView6.dismissKeyBoard(this.f5511a);
                } else {
                    context2 = this.f5511a.f5476b;
                    RimGlobalUtils.hideInputMethod(context2, this.f5511a);
                }
            }
        } else {
            z2 = this.f5511a.l;
            if (z2) {
                context = this.f5511a.f5476b;
                RimGlobalUtils.hideInputMethod(context, this.f5511a);
                safeScrollView = this.f5511a.f5478d;
                if (safeScrollView != null) {
                    safeScrollView2 = this.f5511a.f5478d;
                    if (safeScrollView2.hasWindowFocus()) {
                        safeScrollView3 = this.f5511a.f5478d;
                        if (!safeScrollView3.isPopupWindowShowing()) {
                            safeScrollView4 = this.f5511a.f5478d;
                            viewGroup = this.f5511a.f5477c;
                            SafeKeyBoardEditText safeKeyBoardEditText2 = this.f5511a;
                            view2 = safeKeyBoardEditText2.f5479e;
                            safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText2, view2);
                        }
                    }
                }
            }
        }
        onMyFocusChangeListener = this.f5511a.n;
        if (onMyFocusChangeListener != null) {
            onMyFocusChangeListener2 = this.f5511a.n;
            onMyFocusChangeListener2.onMyFocusChange(view, z);
        }
    }
}
