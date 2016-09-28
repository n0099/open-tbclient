package com.baidu.tbadk.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k.a {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aT(String str) {
        if (gJ() instanceof TextView) {
            ((TextView) gJ()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View gJ() {
        View view;
        View view2;
        view = this.this$0.mCustomToastView;
        if (view == null) {
            this.this$0.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.m9getInst()).inflate(r.h.custom_toast_textview, (ViewGroup) null);
        }
        view2 = this.this$0.mCustomToastView;
        return view2;
    }
}
