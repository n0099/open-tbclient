package com.baidu.fsg.base.widget;

import android.text.Editable;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5553a;

    public h(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.f5553a = safeKeyBoardPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f5553a.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f5553a.mySafeEditText.getSelectionEnd();
        Editable text = this.f5553a.mySafeEditText.getText();
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
