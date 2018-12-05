package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView awQ;
    private CircleView awR;
    private FrameLayout mFrameLayout;
    private String mMessage;
    private TextView mTextView;

    public c(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(e.h.progress_dialog);
            this.mFrameLayout = (FrameLayout) window.findViewById(e.g.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFrameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.ds32);
            this.mFrameLayout.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.awQ = (TextView) window.findViewById(e.g.text_progress_dialog_message);
                this.awQ.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(e.g.text_progress_dialog_percent);
            this.awR = (CircleView) window.findViewById(e.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.awR != null) {
            this.awR.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.awQ != null) {
            this.awQ.setText(this.mMessage);
        }
    }
}
