package com.baidu.sapi2.biometrics.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog {
    private TextView a;

    public LoadingDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        a();
    }

    public LoadingDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_loading);
        setCanceledOnTouchOutside(false);
        this.a = (TextView) findViewById(R.id.msg_text);
    }

    public void setMessage(String str) {
        this.a.setText(str);
    }

    public void setMessage(int i) {
        this.a.setText(i);
    }
}
