package com.baidu.fsg.base.widget;

import android.view.View;
/* loaded from: classes2.dex */
public class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardEditText f5545a;

    public c(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.f5545a = safeKeyBoardEditText;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z;
        z = this.f5545a.p;
        if (z) {
            this.f5545a.requestFocusFromTouch();
            return true;
        }
        return false;
    }
}
