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
    private FrameLayout bzk;
    private TextView eSF;
    private CircleView eSG;
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
            this.bzk = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bzk.getLayoutParams();
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.bzk.setLayoutParams(layoutParams);
            if (!StringUtils.isNull(this.mMessage)) {
                this.eSF = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.eSF.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
            this.eSG = (CircleView) window.findViewById(R.id.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.eSG != null) {
            this.eSG.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.eSF != null) {
            this.eSF.setText(this.mMessage);
        }
    }
}
