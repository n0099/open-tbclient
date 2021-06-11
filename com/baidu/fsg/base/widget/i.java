package com.baidu.fsg.base.widget;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5498b;

    public i(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
        this.f5498b = safeKeyBoardPopupWindow;
        this.f5497a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f5498b.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f5498b.mySafeEditText.getSelectionEnd();
        Editable text = this.f5498b.mySafeEditText.getText();
        if (selectionStart >= 0) {
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, this.f5497a.getTag().toString(), 0, this.f5497a.getTag().toString().length());
            } else if (selectionStart == selectionEnd) {
                text.replace(selectionStart, selectionStart, this.f5497a.getTag().toString(), 0, this.f5497a.getTag().toString().length());
            } else {
                text.replace(selectionEnd, selectionStart, this.f5497a.getTag().toString(), 0, this.f5497a.getTag().toString().length());
                int selectionEnd2 = this.f5498b.mySafeEditText.getSelectionEnd() + this.f5497a.getTag().toString().length();
                if (selectionEnd2 >= 0 && selectionEnd2 <= this.f5498b.mySafeEditText.getText().toString().length()) {
                    Selection.setSelection(this.f5498b.mySafeEditText.getEditableText(), selectionEnd2);
                }
            }
            Selection.setSelection(text, text.length());
        }
    }
}
