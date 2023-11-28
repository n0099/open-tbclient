package com.baidu.searchbox.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BdLoadingDialog extends Dialog {
    public Context mContext;
    public String mMessage;

    public BdLoadingDialog(Context context) {
        super(context, R.style.obfuscated_res_0x7f1000fa);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0774);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f09181a)).setText(this.mMessage);
    }

    public void setMessage(int i) {
        this.mMessage = this.mContext.getResources().getString(i);
    }

    public static BdLoadingDialog show(Context context, CharSequence charSequence) {
        return show(context, charSequence, false);
    }

    public static BdLoadingDialog show(Context context, CharSequence charSequence, boolean z) {
        return show(context, charSequence, z, null);
    }

    public static BdLoadingDialog show(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        BdLoadingDialog bdLoadingDialog = new BdLoadingDialog(context);
        bdLoadingDialog.setMessage(charSequence);
        bdLoadingDialog.setCancelable(z);
        bdLoadingDialog.setOnCancelListener(onCancelListener);
        bdLoadingDialog.show();
        return bdLoadingDialog;
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence.toString();
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }
}
