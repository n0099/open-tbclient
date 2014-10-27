package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements TextWatcher {
    final /* synthetic */ Login2Activity KT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Login2Activity login2Activity) {
        this.KT = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.KT.Kr = true;
        this.KT.on();
        this.KT.oo();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.KT.oe();
    }
}
