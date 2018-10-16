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
/* loaded from: classes6.dex */
public class BioAlertDialog extends Dialog {
    private ViewSwitcher a;
    private TextView b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private LinearLayout j;

    public BioAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    public BioAlertDialog(Context context, int i) {
        super(context, i);
        a();
    }

    public BioAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.b = (TextView) findViewById(R.id.dialog_title);
        this.c = (TextView) findViewById(R.id.dialog_msg);
        this.d = (TextView) findViewById(R.id.msg_text);
        this.e = (Button) findViewById(R.id.positive_btn);
        this.f = (Button) findViewById(R.id.negative_btn);
        this.g = (TextView) findViewById(R.id.neutral_btn);
        this.h = (LinearLayout) findViewById(R.id.unrecognized_dialog);
        this.i = (TextView) findViewById(R.id.tv_recog_msg1);
        this.j = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setTitleMsg(String str) {
        this.b.setText(str);
    }

    public void setDialogMsg(String str) {
        this.c.setVisibility(0);
        this.c.setText(str);
    }

    public void setDialogMsgColor(int i) {
        this.c.setTextColor(i);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void setBtnCount(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.a.setDisplayedChild(0);
        } else {
            this.a.setDisplayedChild(1);
        }
    }

    public void setMessageText(String str) {
        this.d.setVisibility(0);
        this.d.setText(str);
    }

    public void setMessageIcon(int i) {
        this.d.setText(i);
    }

    public void setRecognizedFailVisible(int i) {
        this.h.setVisibility(i);
    }

    public void setRecognizedFailMsg1(String str) {
        this.i.setText(str);
    }

    public void setTimeOutVisible(int i) {
        this.j.setVisibility(0);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(onClickListener);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.g.setText(str);
        this.g.setOnClickListener(onClickListener);
    }
}
