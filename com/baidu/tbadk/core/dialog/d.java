package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d extends AlertDialog {
    private TextView awQ;
    private CircleView1080 awS;
    private int awT;
    private String mMessage;
    private TextView mTextView;

    public d(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(e.h.progress_dialog_1080);
            View findViewById = findViewById(e.g.frame_progress_dialog);
            if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.topMargin = l.h(getContext(), e.C0210e.tbds50);
                findViewById.setLayoutParams(layoutParams);
            }
            this.awQ = (TextView) window.findViewById(e.g.text_progress_dialog_message);
            if (this.awQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.awQ.getLayoutParams();
                layoutParams2.topMargin = l.h(getContext(), e.C0210e.tbds35);
                this.awQ.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.mMessage)) {
                this.awQ.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(e.g.text_progress_dialog_percent);
            this.awS = (CircleView1080) window.findViewById(e.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (i != this.awT) {
            this.awT = i;
            if (this.mTextView != null) {
                this.mTextView.setText(i + "%");
            }
            if (this.awS != null) {
                this.awS.setProgress(i);
            }
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.awQ != null) {
            this.awQ.setText(this.mMessage);
        }
    }
}
