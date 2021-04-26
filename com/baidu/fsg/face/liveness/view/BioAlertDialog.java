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
    public ViewSwitcher f6225a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6226b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6227c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6228d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6229e;

    /* renamed from: f  reason: collision with root package name */
    public Button f6230f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6231g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f6232h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f6233i;
    public LinearLayout j;

    public BioAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f6225a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6226b = (TextView) findViewById(R.id.dialog_title);
        this.f6227c = (TextView) findViewById(R.id.dialog_msg);
        this.f6228d = (TextView) findViewById(R.id.msg_text);
        this.f6229e = (Button) findViewById(R.id.positive_btn);
        this.f6230f = (Button) findViewById(R.id.negative_btn);
        this.f6231g = (TextView) findViewById(R.id.neutral_btn);
        this.f6232h = (LinearLayout) findViewById(R.id.unrecognized_dialog);
        this.f6233i = (TextView) findViewById(R.id.tv_recog_msg1);
        this.j = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setBtnCount(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 2) {
            i2 = 2;
        }
        if (i2 == 2) {
            this.f6225a.setDisplayedChild(0);
        } else {
            this.f6225a.setDisplayedChild(1);
        }
    }

    public void setDialogMsg(String str) {
        this.f6227c.setVisibility(0);
        this.f6227c.setText(str);
    }

    public void setDialogMsgColor(int i2) {
        this.f6227c.setTextColor(i2);
    }

    public void setMessageIcon(int i2) {
        this.f6228d.setText(i2);
    }

    public void setMessageText(String str) {
        this.f6228d.setVisibility(0);
        this.f6228d.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6230f.setText(str);
        this.f6230f.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6231g.setText(str);
        this.f6231g.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6229e.setText(str);
        this.f6229e.setOnClickListener(onClickListener);
    }

    public void setRecognizedFailMsg1(String str) {
        this.f6233i.setText(str);
    }

    public void setRecognizedFailVisible(int i2) {
        this.f6232h.setVisibility(i2);
    }

    public void setTimeOutVisible(int i2) {
        this.j.setVisibility(0);
    }

    public void setTitleMsg(String str) {
        this.f6226b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6226b.setVisibility(0);
        } else {
            this.f6226b.setVisibility(8);
        }
    }

    public BioAlertDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    public void setNegativeBtn(String str, int i2, View.OnClickListener onClickListener) {
        this.f6230f.setText(str);
        this.f6230f.setTextColor(i2);
        this.f6230f.setOnClickListener(onClickListener);
    }

    public BioAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
