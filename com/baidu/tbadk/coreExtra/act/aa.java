package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnFocusChangeListener {
    final /* synthetic */ Login2Activity QG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Login2Activity login2Activity) {
        this.QG = login2Activity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        if (z) {
            int id = view.getId();
            if (id == com.baidu.tieba.w.edit_vcode) {
                button7 = this.QG.Qs;
                button7.setVisibility(8);
                button8 = this.QG.Qr;
                button8.setVisibility(8);
                button9 = this.QG.Qt;
                button9.setVisibility(0);
            } else if (id == com.baidu.tieba.w.login_edit_account) {
                button4 = this.QG.Qs;
                button4.setVisibility(8);
                button5 = this.QG.Qr;
                button5.setVisibility(0);
                button6 = this.QG.Qt;
                button6.setVisibility(8);
            } else if (id == com.baidu.tieba.w.login_edit_password) {
                button = this.QG.Qs;
                button.setVisibility(0);
                button2 = this.QG.Qr;
                button2.setVisibility(8);
                button3 = this.QG.Qt;
                button3.setVisibility(8);
            }
        }
    }
}
