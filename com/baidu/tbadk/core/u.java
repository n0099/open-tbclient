package com.baidu.tbadk.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k.a {
    final /* synthetic */ TbadkCoreApplication TP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication) {
        this.TP = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aX(String str) {
        if (jm() instanceof TextView) {
            ((TextView) jm()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View jm() {
        View view;
        View view2;
        view = this.TP.mCustomToastView;
        if (view == null) {
            this.TP.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(n.g.custom_toast_textview, (ViewGroup) null);
        }
        view2 = this.TP.mCustomToastView;
        return view2;
    }
}
