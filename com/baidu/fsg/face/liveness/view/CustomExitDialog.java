package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes5.dex */
public class CustomExitDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f2331a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f2332b;
    private TextView c;
    private TextView d;

    public CustomExitDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    public CustomExitDialog(Context context, int i) {
        super(context, i);
        a();
    }

    public CustomExitDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_exit);
        setCanceledOnTouchOutside(false);
        this.f2331a = (TextView) findViewById(R.id.exit_dialog_title);
        this.f2332b = (TextView) findViewById(R.id.exit_dialog_content);
        this.c = (TextView) findViewById(R.id.exit_dialog_positive);
        this.d = (TextView) findViewById(R.id.exit_dialog_negative);
    }

    public void setDialogTitle(String str) {
        this.f2331a.setText(str);
    }

    public void setDialogContext(String str) {
        this.f2332b.setVisibility(0);
        this.f2332b.setText(str);
    }

    public void setPositiveText(String str, View.OnClickListener onClickListener) {
        this.c.setText(str);
        this.c.setOnClickListener(onClickListener);
    }

    public void setNegativeText(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(onClickListener);
    }
}
