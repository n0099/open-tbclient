package com.baidu.fsg.base.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeKeyBoardEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d implements View.OnFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardEditText f39795a;

    public d(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeKeyBoardEditText};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39795a = safeKeyBoardEditText;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
            SafeKeyBoardEditText safeKeyBoardEditText = this.f39795a;
            if (z) {
                z2 = safeKeyBoardEditText.o;
                if (z2) {
                    context = this.f39795a.f39755e;
                    RimGlobalUtils.hideInputMethod(context, this.f39795a);
                    safeScrollView = this.f39795a.f39757g;
                    if (safeScrollView != null) {
                        safeScrollView2 = this.f39795a.f39757g;
                        if (safeScrollView2.hasWindowFocus()) {
                            safeScrollView3 = this.f39795a.f39757g;
                            if (!safeScrollView3.isPopupWindowShowing()) {
                                safeScrollView4 = this.f39795a.f39757g;
                                viewGroup = this.f39795a.f39756f;
                                SafeKeyBoardEditText safeKeyBoardEditText2 = this.f39795a;
                                view2 = safeKeyBoardEditText2.f39758h;
                                safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText2, view2);
                            }
                        }
                    }
                }
            } else if (!safeKeyBoardEditText.isAlwaysShow) {
                safeScrollView5 = safeKeyBoardEditText.f39757g;
                if (safeScrollView5 != null) {
                    safeScrollView6 = this.f39795a.f39757g;
                    safeScrollView6.dismissKeyBoard(this.f39795a);
                } else {
                    context2 = this.f39795a.f39755e;
                    RimGlobalUtils.hideInputMethod(context2, this.f39795a);
                }
            }
            onMyFocusChangeListener = this.f39795a.q;
            if (onMyFocusChangeListener != null) {
                onMyFocusChangeListener2 = this.f39795a.q;
                onMyFocusChangeListener2.onMyFocusChange(view, z);
            }
        }
    }
}
