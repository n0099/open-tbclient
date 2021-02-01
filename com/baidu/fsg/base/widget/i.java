package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
/* loaded from: classes5.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2041a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardPopupWindow f2042b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
        this.f2042b = safeKeyBoardPopupWindow;
        this.f2041a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f2042b.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f2042b.mySafeEditText.getSelectionEnd();
        Editable text = this.f2042b.mySafeEditText.getText();
        if (selectionStart >= 0) {
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, this.f2041a.getTag().toString(), 0, this.f2041a.getTag().toString().length());
            } else if (selectionStart == selectionEnd) {
                text.replace(selectionStart, selectionStart, this.f2041a.getTag().toString(), 0, this.f2041a.getTag().toString().length());
            } else {
                text.replace(selectionEnd, selectionStart, this.f2041a.getTag().toString(), 0, this.f2041a.getTag().toString().length());
                int selectionEnd2 = this.f2042b.mySafeEditText.getSelectionEnd() + this.f2041a.getTag().toString().length();
                if (selectionEnd2 >= 0 && selectionEnd2 <= this.f2042b.mySafeEditText.getText().toString().length()) {
                    Selection.setSelection(this.f2042b.mySafeEditText.getEditableText(), selectionEnd2);
                }
            }
            Selection.setSelection(text, text.length());
        }
    }
}
