package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class BioAlertDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f6079a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6080b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6081c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6082d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6083e;

    /* renamed from: f  reason: collision with root package name */
    public Button f6084f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6085g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f6086h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f6087i;
    public LinearLayout j;

    public BioAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f6079a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6080b = (TextView) findViewById(R.id.dialog_title);
        this.f6081c = (TextView) findViewById(R.id.dialog_msg);
        this.f6082d = (TextView) findViewById(R.id.msg_text);
        this.f6083e = (Button) findViewById(R.id.positive_btn);
        this.f6084f = (Button) findViewById(R.id.negative_btn);
        this.f6085g = (TextView) findViewById(R.id.neutral_btn);
        this.f6086h = (LinearLayout) findViewById(R.id.unrecognized_dialog);
        this.f6087i = (TextView) findViewById(R.id.tv_recog_msg1);
        this.j = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setBtnCount(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 2) {
            i2 = 2;
        }
        if (i2 == 2) {
            this.f6079a.setDisplayedChild(0);
        } else {
            this.f6079a.setDisplayedChild(1);
        }
    }

    public void setDialogMsg(String str) {
        this.f6081c.setVisibility(0);
        this.f6081c.setText(str);
    }

    public void setDialogMsgColor(int i2) {
        this.f6081c.setTextColor(i2);
    }

    public void setMessageIcon(int i2) {
        this.f6082d.setText(i2);
    }

    public void setMessageText(String str) {
        this.f6082d.setVisibility(0);
        this.f6082d.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6084f.setText(str);
        this.f6084f.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6085g.setText(str);
        this.f6085g.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6083e.setText(str);
        this.f6083e.setOnClickListener(onClickListener);
    }

    public void setRecognizedFailMsg1(String str) {
        this.f6087i.setText(str);
    }

    public void setRecognizedFailVisible(int i2) {
        this.f6086h.setVisibility(i2);
    }

    public void setTimeOutVisible(int i2) {
        this.j.setVisibility(0);
    }

    public void setTitleMsg(String str) {
        this.f6080b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6080b.setVisibility(0);
        } else {
            this.f6080b.setVisibility(8);
        }
    }

    public BioAlertDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    public void setNegativeBtn(String str, int i2, View.OnClickListener onClickListener) {
        this.f6084f.setText(str);
        this.f6084f.setTextColor(i2);
        this.f6084f.setOnClickListener(onClickListener);
    }

    public BioAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
