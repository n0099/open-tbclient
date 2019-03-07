package com.baidu.pass.biometrics.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes2.dex */
public class CustomAlertDialog extends Dialog {
    private TextView msgText;
    private TextView negativeBtn;
    private TextView neutralBtn;
    private TextView positiveBtn;
    private TextView titleText;
    private ViewSwitcher viewSwitcher;

    public CustomAlertDialog(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        init();
    }

    public CustomAlertDialog(Context context, int i) {
        super(context, i);
        init();
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.viewSwitcher = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.titleText = (TextView) findViewById(R.id.title_text);
        this.msgText = (TextView) findViewById(R.id.msg_text);
        this.positiveBtn = (TextView) findViewById(R.id.positive_btn);
        this.negativeBtn = (TextView) findViewById(R.id.negative_btn);
        this.neutralBtn = (TextView) findViewById(R.id.neutral_btn);
    }

    public void setBtnCount(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 2) {
            i = 2;
        }
        if (i == 2) {
            this.viewSwitcher.setDisplayedChild(0);
        } else {
            this.viewSwitcher.setDisplayedChild(1);
        }
    }

    public void setTitleText(String str) {
        this.titleText.setText(str);
    }

    public void setTitleVisible(int i) {
        this.titleText.setVisibility(i);
    }

    public void setMessageText(String str) {
        this.msgText.setText(str);
    }

    public void setMessageVisible(int i) {
        this.msgText.setVisibility(i);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(onClickListener);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        this.neutralBtn.setText(str);
        this.neutralBtn.setOnClickListener(onClickListener);
    }
}
