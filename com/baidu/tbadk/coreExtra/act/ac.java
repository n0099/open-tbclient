package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TextWatcher {
    final /* synthetic */ Login2Activity Qf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Login2Activity login2Activity) {
        this.Qf = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.Qf.Pz;
        if (z) {
            this.Qf.rl();
        }
        this.Qf.PA = true;
        this.Qf.ro();
        this.Qf.rp();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.Qf.rf();
        str = this.Qf.mAccount;
        if (!ba.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.Qf.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.Qf.rk();
        }
    }
}
