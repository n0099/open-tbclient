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
    private TextView aRB;
    private CircleView1080 aRD;
    private int aRE;
    private String mMessage;
    private TextView ry;

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
                layoutParams.topMargin = l.t(getContext(), d.e.tbds50);
                findViewById.setLayoutParams(layoutParams);
            }
            this.aRB = (TextView) window.findViewById(d.g.text_progress_dialog_message);
            if (this.aRB.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aRB.getLayoutParams();
                layoutParams2.topMargin = l.t(getContext(), d.e.tbds35);
                this.aRB.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.mMessage)) {
                this.aRB.setText(this.mMessage);
            }
            this.ry = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.aRD = (CircleView1080) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (i != this.aRE) {
            this.aRE = i;
            if (this.ry != null) {
                this.ry.setText(i + "%");
            }
            if (this.aRD != null) {
                this.aRD.setProgress(i);
            }
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aRB != null) {
            this.aRB.setText(this.mMessage);
        }
    }
}
