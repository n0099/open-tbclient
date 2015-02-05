package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TextWatcher {
    final /* synthetic */ Login2Activity QD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Login2Activity login2Activity) {
        this.QD = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.QD.PZ;
        if (z) {
            this.QD.rq();
        }
        this.QD.Qa = true;
        this.QD.rt();
        this.QD.ru();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.QD.rk();
        str = this.QD.mAccount;
        if (!bf.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.QD.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.QD.rp();
        }
    }
}
