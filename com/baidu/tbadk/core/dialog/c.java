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
    private FrameLayout cUm;
    private TextView duC;
    private CircleView duD;
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
            this.cUm = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cUm.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.cUm.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.duC = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.duC.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.duD = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.duD != null) {
            this.duD.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.duC != null) {
            this.duC.setText(this.mMessage);
        }
    }
}
