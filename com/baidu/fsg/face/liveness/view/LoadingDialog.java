package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f6343a;

    public LoadingDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_loading);
        setCanceledOnTouchOutside(false);
        this.f6343a = (TextView) findViewById(R.id.msg_text);
    }

    public void setMessage(String str) {
        this.f6343a.setText(str);
    }

    public void setMessage(int i2) {
        this.f6343a.setText(i2);
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    public LoadingDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
