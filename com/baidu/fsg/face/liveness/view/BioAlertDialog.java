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
    public ViewSwitcher f6022a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6023b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6024c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6025d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6026e;

    /* renamed from: f  reason: collision with root package name */
    public Button f6027f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6028g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f6029h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f6030i;
    public LinearLayout j;

    public BioAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f6022a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6023b = (TextView) findViewById(R.id.dialog_title);
        this.f6024c = (TextView) findViewById(R.id.dialog_msg);
        this.f6025d = (TextView) findViewById(R.id.msg_text);
        this.f6026e = (Button) findViewById(R.id.positive_btn);
        this.f6027f = (Button) findViewById(R.id.negative_btn);
        this.f6028g = (TextView) findViewById(R.id.neutral_btn);
        this.f6029h = (LinearLayout) findViewById(R.id.unrecognized_dialog);
        this.f6030i = (TextView) findViewById(R.id.tv_recog_msg1);
        this.j = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setBtnCount(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 2) {
            i2 = 2;
        }
        if (i2 == 2) {
            this.f6022a.setDisplayedChild(0);
        } else {
            this.f6022a.setDisplayedChild(1);
        }
    }

    public void setDialogMsg(String str) {
        this.f6024c.setVisibility(0);
        this.f6024c.setText(str);
    }

    public void setDialogMsgColor(int i2) {
        this.f6024c.setTextColor(i2);
    }

    public void setMessageIcon(int i2) {
        this.f6025d.setText(i2);
    }

    public void setMessageText(String str) {
        this.f6025d.setVisibility(0);
        this.f6025d.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6027f.setText(str);
        this.f6027f.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6028g.setText(str);
        this.f6028g.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6026e.setText(str);
        this.f6026e.setOnClickListener(onClickListener);
    }

    public void setRecognizedFailMsg1(String str) {
        this.f6030i.setText(str);
    }

    public void setRecognizedFailVisible(int i2) {
        this.f6029h.setVisibility(i2);
    }

    public void setTimeOutVisible(int i2) {
        this.j.setVisibility(0);
    }

    public void setTitleMsg(String str) {
        this.f6023b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6023b.setVisibility(0);
        } else {
            this.f6023b.setVisibility(8);
        }
    }

    public BioAlertDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    public void setNegativeBtn(String str, int i2, View.OnClickListener onClickListener) {
        this.f6027f.setText(str);
        this.f6027f.setTextColor(i2);
        this.f6027f.setOnClickListener(onClickListener);
    }

    public BioAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
