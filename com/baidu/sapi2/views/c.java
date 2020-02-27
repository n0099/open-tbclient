package com.baidu.sapi2.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* loaded from: classes6.dex */
class c implements View.OnClickListener {
    final /* synthetic */ View.OnClickListener a;
    final /* synthetic */ CustomAlertDialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CustomAlertDialog customAlertDialog, View.OnClickListener onClickListener) {
        this.b = customAlertDialog;
        this.a = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            context = this.b.e;
            ViewUtility.dismissDialog((Activity) context, this.b);
        } catch (Exception e) {
        }
        this.a.onClick(view);
    }
}
