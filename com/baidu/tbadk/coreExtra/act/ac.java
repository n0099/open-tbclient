package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TextWatcher {
    final /* synthetic */ Login2Activity KT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Login2Activity login2Activity) {
        this.KT = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.KT.Kq;
        if (z) {
            this.KT.ok();
        }
        this.KT.Kr = true;
        this.KT.on();
        this.KT.oo();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.KT.oe();
        str = this.KT.mAccount;
        if (!ay.aA(str)) {
            String editable2 = editable.toString();
            str2 = this.KT.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.KT.oj();
        }
    }
}
