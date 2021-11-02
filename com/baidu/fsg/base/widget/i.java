package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f37731a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f37732b;

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
        this.f37732b = safeKeyBoardPopupWindow;
        this.f37731a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        String obj;
        int length;
        int i2;
        Editable editable;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int selectionStart = this.f37732b.mySafeEditText.getSelectionStart();
            int selectionEnd = this.f37732b.mySafeEditText.getSelectionEnd();
            Editable text = this.f37732b.mySafeEditText.getText();
            if (selectionStart >= 0) {
                if (selectionStart < selectionEnd) {
                    obj = this.f37731a.getTag().toString();
                    length = this.f37731a.getTag().toString().length();
                    i2 = 0;
                    editable = text;
                    i3 = selectionStart;
                    selectionStart = selectionEnd;
                } else if (selectionStart != selectionEnd) {
                    text.replace(selectionEnd, selectionStart, this.f37731a.getTag().toString(), 0, this.f37731a.getTag().toString().length());
                    int selectionEnd2 = this.f37732b.mySafeEditText.getSelectionEnd() + this.f37731a.getTag().toString().length();
                    if (selectionEnd2 >= 0 && selectionEnd2 <= this.f37732b.mySafeEditText.getText().toString().length()) {
                        Selection.setSelection(this.f37732b.mySafeEditText.getEditableText(), selectionEnd2);
                    }
                    Selection.setSelection(text, text.length());
                } else {
                    obj = this.f37731a.getTag().toString();
                    length = this.f37731a.getTag().toString().length();
                    i2 = 0;
                    editable = text;
                    i3 = selectionStart;
                }
                editable.replace(i3, selectionStart, obj, i2, length);
                Selection.setSelection(text, text.length());
            }
        }
    }
}
