package com.baidu.sapi2.views;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class h implements Runnable {
    final /* synthetic */ SmsLoginView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SmsLoginView smsLoginView) {
        this.a = smsLoginView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.i.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.e.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.a.h, 0);
        }
    }
}
