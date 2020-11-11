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
    private FrameLayout bvK;
    private TextView eHY;
    private CircleView eHZ;
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
            this.bvK = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bvK.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.bvK.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.eHY = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.eHY.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.eHZ = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.eHZ != null) {
            this.eHZ.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.eHY != null) {
            this.eHY.setText(this.mMessage);
        }
    }
}
