package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
/* loaded from: classes16.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1557a;
    final /* synthetic */ SafeKeyBoardPopupWindow b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
        this.b = safeKeyBoardPopupWindow;
        this.f1557a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.b.mySafeEditText.getSelectionStart();
        int selectionEnd = this.b.mySafeEditText.getSelectionEnd();
        Editable text = this.b.mySafeEditText.getText();
        if (selectionStart >= 0) {
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, this.f1557a.getTag().toString(), 0, this.f1557a.getTag().toString().length());
            } else if (selectionStart == selectionEnd) {
                text.replace(selectionStart, selectionStart, this.f1557a.getTag().toString(), 0, this.f1557a.getTag().toString().length());
            } else {
                text.replace(selectionEnd, selectionStart, this.f1557a.getTag().toString(), 0, this.f1557a.getTag().toString().length());
                int selectionEnd2 = this.b.mySafeEditText.getSelectionEnd() + this.f1557a.getTag().toString().length();
                if (selectionEnd2 >= 0 && selectionEnd2 <= this.b.mySafeEditText.getText().toString().length()) {
                    Selection.setSelection(this.b.mySafeEditText.getEditableText(), selectionEnd2);
                }
            }
            Selection.setSelection(text, text.length());
        }
    }
}
