package com.baidu.fsg.base.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements View.OnLongClickListener {
    final /* synthetic */ SafeKeyBoardEditText a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        boolean z;
        z = this.a.p;
        if (z) {
            this.a.requestFocusFromTouch();
            return true;
        }
        return false;
    }
}
