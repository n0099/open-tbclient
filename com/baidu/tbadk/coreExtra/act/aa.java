package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnFocusChangeListener {
    final /* synthetic */ Login2Activity KT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Login2Activity login2Activity) {
        this.KT = login2Activity;
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
            if (id == com.baidu.tieba.v.edit_vcode) {
                button7 = this.KT.KG;
                button7.setVisibility(8);
                button8 = this.KT.KF;
                button8.setVisibility(8);
                button9 = this.KT.KH;
                button9.setVisibility(0);
            } else if (id == com.baidu.tieba.v.login_edit_account) {
                button4 = this.KT.KG;
                button4.setVisibility(8);
                button5 = this.KT.KF;
                button5.setVisibility(0);
                button6 = this.KT.KH;
                button6.setVisibility(8);
            } else if (id == com.baidu.tieba.v.login_edit_password) {
                button = this.KT.KG;
                button.setVisibility(0);
                button2 = this.KT.KF;
                button2.setVisibility(8);
                button3 = this.KT.KH;
                button3.setVisibility(8);
            }
        }
    }
}
