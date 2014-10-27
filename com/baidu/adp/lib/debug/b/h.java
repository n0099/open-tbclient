package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.baidu.adp.R;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    final /* synthetic */ g hn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.hn = gVar;
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
            cVar5 = this.hn.hm;
            dialog = cVar5.hf;
            dialog.dismiss();
            return;
        }
        cVar = this.hn.hm;
        cVar.cV();
        cVar2 = this.hn.hm;
        context = cVar2.mContext;
        ((Activity) context).finish();
        cVar3 = this.hn.hm;
        context2 = cVar3.mContext;
        Context baseContext = ((Activity) context2).getBaseContext();
        cVar4 = this.hn.hm;
        context3 = cVar4.mContext;
        Toast.makeText(baseContext, ((Activity) context3).getText(R.string.debug_close), 1).show();
    }
}
