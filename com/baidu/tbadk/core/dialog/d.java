package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends AlertDialog {
    private TextView ald;
    private CircleView1080 alg;
    private int alh;
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
            window.setContentView(d.h.progress_dialog_1080);
            View findViewById = findViewById(d.g.frame_progress_dialog);
            if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.topMargin = l.f(getContext(), d.e.tbds50);
                findViewById.setLayoutParams(layoutParams);
            }
            this.ald = (TextView) window.findViewById(d.g.text_progress_dialog_message);
            if (this.ald.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ald.getLayoutParams();
                layoutParams2.topMargin = l.f(getContext(), d.e.tbds35);
                this.ald.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.mMessage)) {
                this.ald.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.alg = (CircleView1080) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (i != this.alh) {
            this.alh = i;
            if (this.mTextView != null) {
                this.mTextView.setText(i + "%");
            }
            if (this.alg != null) {
                this.alg.setProgress(i);
            }
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.ald != null) {
            this.ald.setText(this.mMessage);
        }
    }
}
