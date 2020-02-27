package com.baidu.pass.biometrics.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes6.dex */
public class BioAlertDialog extends Dialog {
    private TextView dialogMsg;
    private TextView dialogTitle;
    private TextView msgText;
    private Button negativeBtn;
    private TextView neutralBtn;
    private Button positiveBtn;
    private LinearLayout timeOutDialogLl;
    private ViewSwitcher viewSwitcher;

    public BioAlertDialog(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_pass_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.viewSwitcher = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.dialogTitle = (TextView) findViewById(R.id.dialog_title);
        this.dialogMsg = (TextView) findViewById(R.id.dialog_msg);
        this.msgText = (TextView) findViewById(R.id.msg_text);
        this.positiveBtn = (Button) findViewById(R.id.positive_btn);
        this.negativeBtn = (Button) findViewById(R.id.negative_btn);
        this.neutralBtn = (TextView) findViewById(R.id.neutral_btn);
        this.timeOutDialogLl = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setTitleMsg(String str) {
        this.dialogTitle.setText(str);
    }

    public void setDialogMsg(String str) {
        this.dialogMsg.setVisibility(0);
        this.dialogMsg.setText(str);
    }

    public void setDialogMsgColor(int i) {
        this.dialogMsg.setTextColor(i);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.dialogTitle.setVisibility(0);
        } else {
            this.dialogTitle.setVisibility(8);
        }
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

    public void setMessageText(String str) {
        this.msgText.setVisibility(0);
        this.msgText.setText(str);
    }

    public void setMessageIcon(int i) {
        this.msgText.setText(i);
    }

    public void setTimeOutVisible(int i) {
        this.timeOutDialogLl.setVisibility(0);
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
