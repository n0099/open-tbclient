package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f468a = fVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Context context2;
        Context context3;
        Dialog dialog;
        if (i == -2) {
            dialog = this.f468a.f467a.l;
            dialog.dismiss();
            return;
        }
        this.f468a.f467a.d();
        context = this.f468a.f467a.k;
        ((Activity) context).finish();
        context2 = this.f468a.f467a.k;
        Context baseContext = ((Activity) context2).getBaseContext();
        context3 = this.f468a.f467a.k;
        Toast.makeText(baseContext, ((Activity) context3).getText(com.baidu.adp.g.debug_close), 1).show();
    }
}
