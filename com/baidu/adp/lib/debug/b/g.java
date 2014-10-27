package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.baidu.adp.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.hm = cVar;
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
        dialog = this.hm.hf;
        if (dialog == null) {
            context = this.hm.mContext;
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            context2 = this.hm.mContext;
            builder.setTitle(((Activity) context2).getText(R.string.prompt));
            context3 = this.hm.mContext;
            builder.setMessage(((Activity) context3).getText(R.string.prompt_close_debug));
            h hVar = new h(this);
            context4 = this.hm.mContext;
            builder.setPositiveButton(((Activity) context4).getText(R.string.dialog_ok), hVar);
            context5 = this.hm.mContext;
            builder.setNegativeButton(((Activity) context5).getText(R.string.dialog_cancel), hVar);
            this.hm.hf = builder.create();
        }
        dialog2 = this.hm.hf;
        dialog2.setCancelable(false);
        dialog3 = this.hm.hf;
        dialog3.setCanceledOnTouchOutside(false);
        dialog4 = this.hm.hf;
        dialog4.show();
    }
}
