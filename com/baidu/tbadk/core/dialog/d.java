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
    private TextView awR;
    private CircleView1080 awT;
    private int awU;
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
            this.awR = (TextView) window.findViewById(e.g.text_progress_dialog_message);
            if (this.awR.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.awR.getLayoutParams();
                layoutParams2.topMargin = l.h(getContext(), e.C0210e.tbds35);
                this.awR.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.mMessage)) {
                this.awR.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(e.g.text_progress_dialog_percent);
            this.awT = (CircleView1080) window.findViewById(e.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (i != this.awU) {
            this.awU = i;
            if (this.mTextView != null) {
                this.mTextView.setText(i + "%");
            }
            if (this.awT != null) {
                this.awT.setProgress(i);
            }
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.awR != null) {
            this.awR.setText(this.mMessage);
        }
    }
}
