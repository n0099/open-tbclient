package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes16.dex */
public class LoadingDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1766a;

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
        this.f1766a = (TextView) findViewById(R.id.msg_text);
    }

    public void setMessage(String str) {
        this.f1766a.setText(str);
    }

    public void setMessage(int i) {
        this.f1766a.setText(i);
    }
}
