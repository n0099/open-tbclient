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
    public TextView f6119a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6120b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6121c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6122d;

    public CustomExitDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_exit);
        setCanceledOnTouchOutside(false);
        this.f6119a = (TextView) findViewById(R.id.exit_dialog_title);
        this.f6120b = (TextView) findViewById(R.id.exit_dialog_content);
        this.f6121c = (TextView) findViewById(R.id.exit_dialog_positive);
        this.f6122d = (TextView) findViewById(R.id.exit_dialog_negative);
    }

    public void setDialogContext(String str) {
        this.f6120b.setVisibility(0);
        this.f6120b.setText(str);
    }

    public void setDialogTitle(String str) {
        this.f6119a.setText(str);
    }

    public void setNegativeText(String str, View.OnClickListener onClickListener) {
        this.f6122d.setText(str);
        this.f6122d.setOnClickListener(onClickListener);
    }

    public void setPositiveText(String str, View.OnClickListener onClickListener) {
        this.f6121c.setText(str);
        this.f6121c.setOnClickListener(onClickListener);
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
