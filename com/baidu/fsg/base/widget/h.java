package com.baidu.fsg.base.widget;

import android.text.Editable;
/* loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ SafeKeyBoardPopupWindow a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.a = safeKeyBoardPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.a.mySafeEditText.getSelectionStart();
        int selectionEnd = this.a.mySafeEditText.getSelectionEnd();
        Editable text = this.a.mySafeEditText.getText();
        if (selectionStart >= 0) {
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, "", 0, 0);
            } else if (selectionStart == selectionEnd) {
                if (selectionStart > 0) {
                    text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                }
            } else {
                text.replace(selectionEnd, selectionStart, "", 0, 0);
            }
        }
    }
}
