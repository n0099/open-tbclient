package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView aQm;
    private CircleView aQn;
    private FrameLayout mFrameLayout;
    private String mMessage;
    private TextView rz;

    public c(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(d.h.progress_dialog);
            this.mFrameLayout = (FrameLayout) window.findViewById(d.g.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFrameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.mFrameLayout.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.aQm = (TextView) window.findViewById(d.g.text_progress_dialog_message);
                this.aQm.setText(this.mMessage);
            }
            this.rz = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.aQn = (CircleView) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.rz != null) {
            this.rz.setText(i + "%");
        }
        if (this.aQn != null) {
            this.aQn.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aQm != null) {
            this.aQm.setText(this.mMessage);
        }
    }
}
