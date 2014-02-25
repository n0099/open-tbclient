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
        c cVar;
        c cVar2;
        Context context;
        c cVar3;
        Context context2;
        c cVar4;
        Context context3;
        c cVar5;
        Dialog dialog;
        if (i == -2) {
            cVar5 = this.a.a;
            dialog = cVar5.l;
            dialog.dismiss();
            return;
        }
        cVar = this.a.a;
        cVar.d();
        cVar2 = this.a.a;
        context = cVar2.k;
        ((Activity) context).finish();
        cVar3 = this.a.a;
        context2 = cVar3.k;
        Context baseContext = ((Activity) context2).getBaseContext();
        cVar4 = this.a.a;
        context3 = cVar4.k;
        Toast.makeText(baseContext, ((Activity) context3).getText(com.baidu.adp.f.debug_close), 1).show();
    }
}
