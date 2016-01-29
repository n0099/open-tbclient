package com.baidu.tbadk.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k.a {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aW(String str) {
        if (jw() instanceof TextView) {
            ((TextView) jw()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View jw() {
        View view;
        View view2;
        view = this.this$0.mCustomToastView;
        if (view == null) {
            this.this$0.mCustomToastView = LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(t.h.custom_toast_textview, (ViewGroup) null);
        }
        view2 = this.this$0.mCustomToastView;
        return view2;
    }
}
