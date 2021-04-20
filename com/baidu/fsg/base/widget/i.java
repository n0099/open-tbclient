package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5552b;

    public i(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
        this.f5552b = safeKeyBoardPopupWindow;
        this.f5551a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f5552b.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f5552b.mySafeEditText.getSelectionEnd();
        Editable text = this.f5552b.mySafeEditText.getText();
        if (selectionStart >= 0) {
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, this.f5551a.getTag().toString(), 0, this.f5551a.getTag().toString().length());
            } else if (selectionStart == selectionEnd) {
                text.replace(selectionStart, selectionStart, this.f5551a.getTag().toString(), 0, this.f5551a.getTag().toString().length());
            } else {
                text.replace(selectionEnd, selectionStart, this.f5551a.getTag().toString(), 0, this.f5551a.getTag().toString().length());
                int selectionEnd2 = this.f5552b.mySafeEditText.getSelectionEnd() + this.f5551a.getTag().toString().length();
                if (selectionEnd2 >= 0 && selectionEnd2 <= this.f5552b.mySafeEditText.getText().toString().length()) {
                    Selection.setSelection(this.f5552b.mySafeEditText.getEditableText(), selectionEnd2);
                }
            }
            Selection.setSelection(text, text.length());
        }
    }
}
