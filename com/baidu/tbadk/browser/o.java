package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.refresh();
    }
}
