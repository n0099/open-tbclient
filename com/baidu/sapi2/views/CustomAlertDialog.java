package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import com.baidu.i.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.permissions.AlertDialogInterface;
/* loaded from: classes4.dex */
public class CustomAlertDialog extends Dialog implements com.baidu.sapi2.c, AlertDialogInterface {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private Context e;

    public CustomAlertDialog(Context context) {
        super(context, a.h.SapiSdkBeautyDialog);
        a(context);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setCancel(boolean z) {
        setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setMessageText(String str) {
        this.b.setText(str);
    }

    public void setMessageVisible(int i) {
        this.b.setVisibility(i);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(new c(this, onClickListener));
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.c.setText(str);
        this.c.setOnClickListener(new b(this, onClickListener));
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setTitleText(String str) {
        this.a.setText(str);
    }

    public void setTitleVisible(int i) {
        this.a.setVisibility(i);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void showDialog() {
        show();
    }

    private void a(Context context) {
        this.e = context;
        setContentView(a.f.layout_sapi_sdk_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.a = (TextView) findViewById(a.e.title_text);
        this.b = (TextView) findViewById(a.e.msg_text);
        this.c = (TextView) findViewById(a.e.positive_btn);
        this.d = (TextView) findViewById(a.e.negative_btn);
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            ((ViewGroup) this.a.getRootView()).addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
    }
}
