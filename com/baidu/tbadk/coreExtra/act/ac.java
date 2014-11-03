package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TextWatcher {
    final /* synthetic */ Login2Activity KU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Login2Activity login2Activity) {
        this.KU = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.KU.Kr;
        if (z) {
            this.KU.ok();
        }
        this.KU.Ks = true;
        this.KU.on();
        this.KU.oo();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.KU.oe();
        str = this.KU.mAccount;
        if (!az.aA(str)) {
            String editable2 = editable.toString();
            str2 = this.KU.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.KU.oj();
        }
    }
}
