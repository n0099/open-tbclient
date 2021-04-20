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
    public ViewSwitcher f6055a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6056b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6057c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6058d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6059e;

    /* renamed from: f  reason: collision with root package name */
    public Button f6060f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f6061g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f6062h;
    public TextView i;
    public LinearLayout j;

    public BioAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.f6055a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6056b = (TextView) findViewById(R.id.dialog_title);
        this.f6057c = (TextView) findViewById(R.id.dialog_msg);
        this.f6058d = (TextView) findViewById(R.id.msg_text);
        this.f6059e = (Button) findViewById(R.id.positive_btn);
        this.f6060f = (Button) findViewById(R.id.negative_btn);
        this.f6061g = (TextView) findViewById(R.id.neutral_btn);
        this.f6062h = (LinearLayout) findViewById(R.id.unrecognized_dialog);
        this.i = (TextView) findViewById(R.id.tv_recog_msg1);
        this.j = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setBtnCount(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.f6055a.setDisplayedChild(0);
        } else {
            this.f6055a.setDisplayedChild(1);
        }
    }

    public void setDialogMsg(String str) {
        this.f6057c.setVisibility(0);
        this.f6057c.setText(str);
    }

    public void setDialogMsgColor(int i) {
        this.f6057c.setTextColor(i);
    }

    public void setMessageIcon(int i) {
        this.f6058d.setText(i);
    }

    public void setMessageText(String str) {
        this.f6058d.setVisibility(0);
        this.f6058d.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6060f.setText(str);
        this.f6060f.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6061g.setText(str);
        this.f6061g.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6059e.setText(str);
        this.f6059e.setOnClickListener(onClickListener);
    }

    public void setRecognizedFailMsg1(String str) {
        this.i.setText(str);
    }

    public void setRecognizedFailVisible(int i) {
        this.f6062h.setVisibility(i);
    }

    public void setTimeOutVisible(int i) {
        this.j.setVisibility(0);
    }

    public void setTitleMsg(String str) {
        this.f6056b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6056b.setVisibility(0);
        } else {
            this.f6056b.setVisibility(8);
        }
    }

    public BioAlertDialog(Context context, int i) {
        super(context, i);
        a();
    }

    public void setNegativeBtn(String str, int i, View.OnClickListener onClickListener) {
        this.f6060f.setText(str);
        this.f6060f.setTextColor(i);
        this.f6060f.setOnClickListener(onClickListener);
    }

    public BioAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
