package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends AlertDialog {
    private TextView dIB;
    private CircleView1080 dID;
    private String mMessage;
    private int mPercent;
    private TextView mTextView;

    public d(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(R.layout.progress_dialog_1080);
            View findViewById = findViewById(R.id.frame_progress_dialog);
            if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds50);
                findViewById.setLayoutParams(layoutParams);
            }
            this.dIB = (TextView) window.findViewById(R.id.text_progress_dialog_message);
            if (this.dIB.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dIB.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds35);
                this.dIB.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.mMessage)) {
                this.dIB.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.dID = (CircleView1080) window.findViewById(R.id.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (i != this.mPercent) {
            this.mPercent = i;
            if (this.mTextView != null) {
                this.mTextView.setText(i + "%");
            }
            if (this.dID != null) {
                this.dID.setProgress(i);
            }
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.dIB != null) {
            this.dIB.setText(this.mMessage);
        }
    }
}
