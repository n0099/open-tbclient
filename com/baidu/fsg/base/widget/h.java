package com.baidu.fsg.base.widget;

import android.text.Editable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f38560a;

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
        this.f38560a = safeKeyBoardPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        int i3;
        String str;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int selectionStart = this.f38560a.mySafeEditText.getSelectionStart();
            int selectionEnd = this.f38560a.mySafeEditText.getSelectionEnd();
            Editable text = this.f38560a.mySafeEditText.getText();
            if (selectionStart >= 0) {
                if (selectionStart < selectionEnd) {
                    i2 = 0;
                    i3 = 0;
                    str = "";
                    i4 = selectionStart;
                    selectionStart = selectionEnd;
                } else if (selectionStart != selectionEnd) {
                    i2 = 0;
                    i3 = 0;
                    str = "";
                    i4 = selectionEnd;
                } else if (selectionStart <= 0) {
                    return;
                } else {
                    i4 = selectionStart - 1;
                    i2 = 0;
                    i3 = 0;
                    str = "";
                }
                text.replace(i4, selectionStart, str, i2, i3);
            }
        }
    }
}
