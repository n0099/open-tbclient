package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class CustomAlertDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f6084a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6085b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6086c;

    /* renamed from: d  reason: collision with root package name */
    public Button f6087d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6088e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6089f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6090g;

    /* renamed from: h  reason: collision with root package name */
    public Spinner f6091h;

    public CustomAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f6084a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6085b = (TextView) findViewById(R.id.dialog_title);
        this.f6086c = (TextView) findViewById(R.id.msg_text);
        this.f6087d = (Button) findViewById(R.id.positive_btn);
        this.f6088e = (Button) findViewById(R.id.negative_btn);
        this.f6089f = (TextView) findViewById(R.id.neutral_btn);
    }

    public void setBtnCount(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.f6084a.setDisplayedChild(0);
        } else {
            this.f6084a.setDisplayedChild(1);
        }
    }

    public void setMessageIcon(int i) {
        this.f6086c.setText(i);
    }

    public void setMessageText(String str) {
        this.f6086c.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6088e.setText(str);
        this.f6088e.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6089f.setText(str);
        this.f6089f.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6087d.setText(str);
        this.f6087d.setOnClickListener(onClickListener);
    }

    public void setTitleMsg(String str) {
        this.f6085b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6085b.setVisibility(0);
        } else {
            this.f6085b.setVisibility(8);
        }
    }

    public CustomAlertDialog(Context context, int i) {
        super(context, i);
        a();
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
