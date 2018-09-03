package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView ald;
    private CircleView ale;
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
            window.setContentView(f.h.progress_dialog);
            this.mFrameLayout = (FrameLayout) window.findViewById(f.g.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFrameLayout.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(f.e.ds32);
            this.mFrameLayout.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.ald = (TextView) window.findViewById(f.g.text_progress_dialog_message);
                this.ald.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(f.g.text_progress_dialog_percent);
            this.ale = (CircleView) window.findViewById(f.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.ale != null) {
            this.ale.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.ald != null) {
            this.ald.setText(this.mMessage);
        }
    }
}
