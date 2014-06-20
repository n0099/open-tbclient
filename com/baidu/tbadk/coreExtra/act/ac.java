package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TextWatcher {
    final /* synthetic */ Login2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Login2Activity login2Activity) {
        this.a = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.a.m;
        if (z) {
            this.a.k();
        }
        this.a.n = true;
        this.a.n();
        this.a.o();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.a.d();
        str = this.a.f;
        if (!bg.c(str)) {
            String editable2 = editable.toString();
            str2 = this.a.f;
            if (!editable2.equals(str2)) {
                return;
            }
            this.a.j();
        }
    }
}
