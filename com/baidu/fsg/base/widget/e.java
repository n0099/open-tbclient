package com.baidu.fsg.base.widget;

import android.view.KeyEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e implements View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardEditText f37727a;

    public e(SafeKeyBoardEditText safeKeyBoardEditText) {
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
        this.f37727a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        boolean z;
        SafeScrollView safeScrollView;
        SafeScrollView safeScrollView2;
        SafeScrollView safeScrollView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
            if (keyEvent.getAction() == 0 && i2 == 4) {
                z = this.f37727a.o;
                if (z) {
                    safeScrollView = this.f37727a.f37692g;
                    if (safeScrollView != null) {
                        safeScrollView2 = this.f37727a.f37692g;
                        if (safeScrollView2.isPopupWindowShowing()) {
                            safeScrollView3 = this.f37727a.f37692g;
                            safeScrollView3.dismissKeyBoard(this.f37727a);
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
