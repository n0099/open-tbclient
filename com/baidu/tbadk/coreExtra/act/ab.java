package com.baidu.tbadk.coreExtra.act;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements TextView.OnEditorActionListener {
    final /* synthetic */ Login2Activity QG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Login2Activity login2Activity) {
        this.QG = login2Activity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.QG.Qq;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.QG.Qq;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        this.QG.rt();
        return true;
    }
}
