package com.baidu.tbadk;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {
    final /* synthetic */ a a;
    private View b;

    public c(a aVar, View view) {
        this.a = aVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.isFinishing()) {
            this.a.ShowSoftKeyPad((InputMethodManager) this.a.getSystemService("input_method"), this.b);
        }
    }
}
