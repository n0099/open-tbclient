package com.baidu.searchbox.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
/* loaded from: classes12.dex */
public class BdLoadingDialog extends Dialog {
    private Context mContext;
    private String mMessage;

    public BdLoadingDialog(Context context) {
        super(context, R.style.BdWaitingDialog);
        this.mContext = context;
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

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.novel_loading_layout);
        ((TextView) findViewById(R.id.message)).setText(this.mMessage);
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence.toString();
    }

    public void setMessage(int i) {
        this.mMessage = this.mContext.getResources().getString(i);
    }
}
