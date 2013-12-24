package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        Dialog dialog4;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        dialog = this.a.l;
        if (dialog == null) {
            context = this.a.k;
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            context2 = this.a.k;
            builder.setTitle(((Activity) context2).getText(com.baidu.adp.f.prompt));
            context3 = this.a.k;
            builder.setMessage(((Activity) context3).getText(com.baidu.adp.f.prompt_close_debug));
            g gVar = new g(this);
            context4 = this.a.k;
            builder.setPositiveButton(((Activity) context4).getText(com.baidu.adp.f.dialog_ok), gVar);
            context5 = this.a.k;
            builder.setNegativeButton(((Activity) context5).getText(com.baidu.adp.f.dialog_cancel), gVar);
            this.a.l = builder.create();
        }
        dialog2 = this.a.l;
        dialog2.setCancelable(false);
        dialog3 = this.a.l;
        dialog3.setCanceledOnTouchOutside(false);
        dialog4 = this.a.l;
        dialog4.show();
    }
}
