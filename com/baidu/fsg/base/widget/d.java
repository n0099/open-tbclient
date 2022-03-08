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
/* loaded from: classes4.dex */
public class d implements View.OnFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ SafeKeyBoardEditText a;

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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
            SafeKeyBoardEditText safeKeyBoardEditText = this.a;
            if (z) {
                z2 = safeKeyBoardEditText.o;
                if (z2) {
                    context = this.a.f32576e;
                    RimGlobalUtils.hideInputMethod(context, this.a);
                    safeScrollView = this.a.f32578g;
                    if (safeScrollView != null) {
                        safeScrollView2 = this.a.f32578g;
                        if (safeScrollView2.hasWindowFocus()) {
                            safeScrollView3 = this.a.f32578g;
                            if (!safeScrollView3.isPopupWindowShowing()) {
                                safeScrollView4 = this.a.f32578g;
                                viewGroup = this.a.f32577f;
                                SafeKeyBoardEditText safeKeyBoardEditText2 = this.a;
                                view2 = safeKeyBoardEditText2.f32579h;
                                safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText2, view2);
                            }
                        }
                    }
                }
            } else if (!safeKeyBoardEditText.isAlwaysShow) {
                safeScrollView5 = safeKeyBoardEditText.f32578g;
                if (safeScrollView5 != null) {
                    safeScrollView6 = this.a.f32578g;
                    safeScrollView6.dismissKeyBoard(this.a);
                } else {
                    context2 = this.a.f32576e;
                    RimGlobalUtils.hideInputMethod(context2, this.a);
                }
            }
            onMyFocusChangeListener = this.a.q;
            if (onMyFocusChangeListener != null) {
                onMyFocusChangeListener2 = this.a.q;
                onMyFocusChangeListener2.onMyFocusChange(view, z);
            }
        }
    }
}
