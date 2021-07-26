package com.baidu.fsg.base.widget;

import android.text.Editable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5569a;

    public h(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeKeyBoardPopupWindow};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5569a = safeKeyBoardPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int selectionStart = this.f5569a.mySafeEditText.getSelectionStart();
            int selectionEnd = this.f5569a.mySafeEditText.getSelectionEnd();
            Editable text = this.f5569a.mySafeEditText.getText();
            if (selectionStart >= 0) {
                if (selectionStart < selectionEnd) {
                    text.replace(selectionStart, selectionEnd, "", 0, 0);
                } else if (selectionStart != selectionEnd) {
                    text.replace(selectionEnd, selectionStart, "", 0, 0);
                } else if (selectionStart > 0) {
                    text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                }
            }
        }
    }
}
