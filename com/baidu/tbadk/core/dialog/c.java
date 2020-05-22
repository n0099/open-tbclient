package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView dIB;
    private CircleView dIC;
    private FrameLayout dft;
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
            window.setContentView(R.layout.post_video_progress_dialog);
            this.dft = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dft.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.dft.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.dIB = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.dIB.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.dIC = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.dIC != null) {
            this.dIC.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.dIB != null) {
            this.dIB.setText(this.mMessage);
        }
    }
}
