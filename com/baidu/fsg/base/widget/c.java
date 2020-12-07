package com.baidu.fsg.base.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardEditText f1551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f1551a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z;
        z = this.f1551a.p;
        if (z) {
            this.f1551a.requestFocusFromTouch();
            return true;
        }
        return false;
    }
}
