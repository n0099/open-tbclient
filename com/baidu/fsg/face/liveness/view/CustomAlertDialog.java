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
    public ViewSwitcher f6049a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6050b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6051c;

    /* renamed from: d  reason: collision with root package name */
    public Button f6052d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6053e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6054f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6055g;

    /* renamed from: h  reason: collision with root package name */
    public Spinner f6056h;

    public CustomAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f6049a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6050b = (TextView) findViewById(R.id.dialog_title);
        this.f6051c = (TextView) findViewById(R.id.msg_text);
        this.f6052d = (Button) findViewById(R.id.positive_btn);
        this.f6053e = (Button) findViewById(R.id.negative_btn);
        this.f6054f = (TextView) findViewById(R.id.neutral_btn);
    }

    public void setBtnCount(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.f6049a.setDisplayedChild(0);
        } else {
            this.f6049a.setDisplayedChild(1);
        }
    }

    public void setMessageIcon(int i) {
        this.f6051c.setText(i);
    }

    public void setMessageText(String str) {
        this.f6051c.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6053e.setText(str);
        this.f6053e.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6054f.setText(str);
        this.f6054f.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6052d.setText(str);
        this.f6052d.setOnClickListener(onClickListener);
    }

    public void setTitleMsg(String str) {
        this.f6050b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6050b.setVisibility(0);
        } else {
            this.f6050b.setVisibility(8);
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
