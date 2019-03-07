package com.baidu.pass.biometrics.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog {
    private TextView msgText;

    public LoadingDialog(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        init();
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        init();
    }

    public LoadingDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_pass_liveness_dialog_loading);
        setCanceledOnTouchOutside(false);
        this.msgText = (TextView) findViewById(R.id.msg_text);
    }

    public void setMessage(String str) {
        this.msgText.setText(str);
    }

    public void setMessage(int i) {
        this.msgText.setText(i);
    }
}
