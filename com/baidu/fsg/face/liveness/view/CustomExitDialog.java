package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class CustomExitDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f6265a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6266b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6267c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6268d;

    public CustomExitDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_exit);
        setCanceledOnTouchOutside(false);
        this.f6265a = (TextView) findViewById(R.id.exit_dialog_title);
        this.f6266b = (TextView) findViewById(R.id.exit_dialog_content);
        this.f6267c = (TextView) findViewById(R.id.exit_dialog_positive);
        this.f6268d = (TextView) findViewById(R.id.exit_dialog_negative);
    }

    public void setDialogContext(String str) {
        this.f6266b.setVisibility(0);
        this.f6266b.setText(str);
    }

    public void setDialogTitle(String str) {
        this.f6265a.setText(str);
    }

    public void setNegativeText(String str, View.OnClickListener onClickListener) {
        this.f6268d.setText(str);
        this.f6268d.setOnClickListener(onClickListener);
    }

    public void setPositiveText(String str, View.OnClickListener onClickListener) {
        this.f6267c.setText(str);
        this.f6267c.setOnClickListener(onClickListener);
    }

    public CustomExitDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    public CustomExitDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
