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
/* loaded from: classes2.dex */
public class d implements View.OnFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardEditText f5565a;

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
        this.f5565a = safeKeyBoardEditText;
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
            if (!z) {
                SafeKeyBoardEditText safeKeyBoardEditText = this.f5565a;
                if (!safeKeyBoardEditText.isAlwaysShow) {
                    safeScrollView5 = safeKeyBoardEditText.f5528d;
                    if (safeScrollView5 != null) {
                        safeScrollView6 = this.f5565a.f5528d;
                        safeScrollView6.dismissKeyBoard(this.f5565a);
                    } else {
                        context2 = this.f5565a.f5526b;
                        RimGlobalUtils.hideInputMethod(context2, this.f5565a);
                    }
                }
            } else {
                z2 = this.f5565a.l;
                if (z2) {
                    context = this.f5565a.f5526b;
                    RimGlobalUtils.hideInputMethod(context, this.f5565a);
                    safeScrollView = this.f5565a.f5528d;
                    if (safeScrollView != null) {
                        safeScrollView2 = this.f5565a.f5528d;
                        if (safeScrollView2.hasWindowFocus()) {
                            safeScrollView3 = this.f5565a.f5528d;
                            if (!safeScrollView3.isPopupWindowShowing()) {
                                safeScrollView4 = this.f5565a.f5528d;
                                viewGroup = this.f5565a.f5527c;
                                SafeKeyBoardEditText safeKeyBoardEditText2 = this.f5565a;
                                view2 = safeKeyBoardEditText2.f5529e;
                                safeScrollView4.showKeyBoard(viewGroup, safeKeyBoardEditText2, view2);
                            }
                        }
                    }
                }
            }
            onMyFocusChangeListener = this.f5565a.n;
            if (onMyFocusChangeListener != null) {
                onMyFocusChangeListener2 = this.f5565a.n;
                onMyFocusChangeListener2.onMyFocusChange(view, z);
            }
        }
    }
}
