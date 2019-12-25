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
/* loaded from: classes3.dex */
public class CustomAlertDialog extends Dialog {
    private ViewSwitcher a;
    private TextView b;
    private TextView c;
    private Button d;
    private Button e;
    private TextView f;
    private LinearLayout g;
    private Spinner h;

    public CustomAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    public CustomAlertDialog(Context context, int i) {
        super(context, i);
        a();
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.b = (TextView) findViewById(R.id.dialog_title);
        this.c = (TextView) findViewById(R.id.msg_text);
        this.d = (Button) findViewById(R.id.positive_btn);
        this.e = (Button) findViewById(R.id.negative_btn);
        this.f = (TextView) findViewById(R.id.neutral_btn);
    }

    public void setTitleMsg(String str) {
        this.b.setText(str);
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
        this.c.setText(str);
    }

    public void setMessageIcon(int i) {
        this.c.setText(i);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(onClickListener);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }
}
