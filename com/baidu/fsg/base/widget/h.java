package com.baidu.fsg.base.widget;

import android.text.Editable;
/* loaded from: classes15.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardPopupWindow f1554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.f1554a = safeKeyBoardPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f1554a.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f1554a.mySafeEditText.getSelectionEnd();
        Editable text = this.f1554a.mySafeEditText.getText();
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
