package com.baidu.fsg.base.widget;

import android.text.Editable;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardPopupWindow f5453a;

    public h(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        this.f5453a = safeKeyBoardPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        int selectionStart = this.f5453a.mySafeEditText.getSelectionStart();
        int selectionEnd = this.f5453a.mySafeEditText.getSelectionEnd();
        Editable text = this.f5453a.mySafeEditText.getText();
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
