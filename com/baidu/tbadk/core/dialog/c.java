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
    private TextView alE;
    private CircleView alF;
    private FrameLayout alG;
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
            window.setContentView(d.i.progress_dialog);
            this.alG = (FrameLayout) window.findViewById(d.g.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alG.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.alG.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.alE = (TextView) window.findViewById(d.g.text_progress_dialog_message);
                this.alE.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.alF = (CircleView) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.alF != null) {
            this.alF.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.alE != null) {
            this.alE.setText(this.mMessage);
        }
    }
}
