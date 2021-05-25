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
    public ViewSwitcher f6011a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6012b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6013c;

    /* renamed from: d  reason: collision with root package name */
    public Button f6014d;

    /* renamed from: e  reason: collision with root package name */
    public Button f6015e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6016f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f6017g;

    /* renamed from: h  reason: collision with root package name */
    public Spinner f6018h;

    public CustomAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
        a();
    }

    private void a() {
        setContentView(R.layout.layout_sapi_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f6011a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f6012b = (TextView) findViewById(R.id.dialog_title);
        this.f6013c = (TextView) findViewById(R.id.msg_text);
        this.f6014d = (Button) findViewById(R.id.positive_btn);
        this.f6015e = (Button) findViewById(R.id.negative_btn);
        this.f6016f = (TextView) findViewById(R.id.neutral_btn);
    }

    public void setBtnCount(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 2) {
            i2 = 2;
        }
        if (i2 == 2) {
            this.f6011a.setDisplayedChild(0);
        } else {
            this.f6011a.setDisplayedChild(1);
        }
    }

    public void setMessageIcon(int i2) {
        this.f6013c.setText(i2);
    }

    public void setMessageText(String str) {
        this.f6013c.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f6015e.setText(str);
        this.f6015e.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.f6016f.setText(str);
        this.f6016f.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f6014d.setText(str);
        this.f6014d.setOnClickListener(onClickListener);
    }

    public void setTitleMsg(String str) {
        this.f6012b.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.f6012b.setVisibility(0);
        } else {
            this.f6012b.setVisibility(8);
        }
    }

    public CustomAlertDialog(Context context, int i2) {
        super(context, i2);
        a();
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }
}
