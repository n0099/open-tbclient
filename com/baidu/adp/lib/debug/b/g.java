package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Context context2;
        Context context3;
        Dialog dialog;
        if (i == -2) {
            dialog = this.a.a.l;
            dialog.dismiss();
            return;
        }
        this.a.a.d();
        context = this.a.a.k;
        ((Activity) context).finish();
        context2 = this.a.a.k;
        Context baseContext = ((Activity) context2).getBaseContext();
        context3 = this.a.a.k;
        Toast.makeText(baseContext, ((Activity) context3).getText(com.baidu.adp.f.debug_close), 1).show();
    }
}
