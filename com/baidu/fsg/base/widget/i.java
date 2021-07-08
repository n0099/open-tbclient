package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5544a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5545b;

    public i(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {safeKeyBoardPopupWindow, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5545b = safeKeyBoardPopupWindow;
        this.f5544a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int selectionStart = this.f5545b.mySafeEditText.getSelectionStart();
            int selectionEnd = this.f5545b.mySafeEditText.getSelectionEnd();
            Editable text = this.f5545b.mySafeEditText.getText();
            if (selectionStart >= 0) {
                if (selectionStart < selectionEnd) {
                    text.replace(selectionStart, selectionEnd, this.f5544a.getTag().toString(), 0, this.f5544a.getTag().toString().length());
                } else if (selectionStart == selectionEnd) {
                    text.replace(selectionStart, selectionStart, this.f5544a.getTag().toString(), 0, this.f5544a.getTag().toString().length());
                } else {
                    text.replace(selectionEnd, selectionStart, this.f5544a.getTag().toString(), 0, this.f5544a.getTag().toString().length());
                    int selectionEnd2 = this.f5545b.mySafeEditText.getSelectionEnd() + this.f5544a.getTag().toString().length();
                    if (selectionEnd2 >= 0 && selectionEnd2 <= this.f5545b.mySafeEditText.getText().toString().length()) {
                        Selection.setSelection(this.f5545b.mySafeEditText.getEditableText(), selectionEnd2);
                    }
                }
                Selection.setSelection(text, text.length());
            }
        }
    }
}
