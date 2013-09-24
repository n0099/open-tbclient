package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f417a = cVar;
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
        dialog = this.f417a.l;
        if (dialog == null) {
            context = this.f417a.k;
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            context2 = this.f417a.k;
            builder.setTitle(((Activity) context2).getText(com.baidu.adp.g.prompt));
            context3 = this.f417a.k;
            builder.setMessage(((Activity) context3).getText(com.baidu.adp.g.prompt_close_debug));
            g gVar = new g(this);
            context4 = this.f417a.k;
            builder.setPositiveButton(((Activity) context4).getText(com.baidu.adp.g.dialog_ok), gVar);
            context5 = this.f417a.k;
            builder.setNegativeButton(((Activity) context5).getText(com.baidu.adp.g.dialog_cancel), gVar);
            this.f417a.l = builder.create();
        }
        dialog2 = this.f417a.l;
        dialog2.setCancelable(false);
        dialog3 = this.f417a.l;
        dialog3.setCanceledOnTouchOutside(false);
        dialog4 = this.f417a.l;
        dialog4.show();
    }
}
