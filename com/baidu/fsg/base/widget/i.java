package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
/* loaded from: classes6.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2093a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardPopupWindow f2094b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
        this.f2094b = safeKeyBoardPopupWindow;
        this.f2093a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f2094b.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f2094b.mySafeEditText.getSelectionEnd();
        Editable text = this.f2094b.mySafeEditText.getText();
        if (selectionStart >= 0) {
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, this.f2093a.getTag().toString(), 0, this.f2093a.getTag().toString().length());
            } else if (selectionStart == selectionEnd) {
                text.replace(selectionStart, selectionStart, this.f2093a.getTag().toString(), 0, this.f2093a.getTag().toString().length());
            } else {
                text.replace(selectionEnd, selectionStart, this.f2093a.getTag().toString(), 0, this.f2093a.getTag().toString().length());
                int selectionEnd2 = this.f2094b.mySafeEditText.getSelectionEnd() + this.f2093a.getTag().toString().length();
                if (selectionEnd2 >= 0 && selectionEnd2 <= this.f2094b.mySafeEditText.getText().toString().length()) {
                    Selection.setSelection(this.f2094b.mySafeEditText.getEditableText(), selectionEnd2);
                }
            }
            Selection.setSelection(text, text.length());
        }
    }
}
