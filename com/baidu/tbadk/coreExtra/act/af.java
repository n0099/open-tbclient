package com.baidu.tbadk.coreExtra.act;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ Login2Activity QG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(Login2Activity login2Activity) {
        this.QG = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.QG.rt();
    }
}
