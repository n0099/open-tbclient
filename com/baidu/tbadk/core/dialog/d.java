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
    private TextView aRM;
    private CircleView1080 aRO;
    private int aRP;
    private String mMessage;
    private TextView rz;

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
            this.aRM = (TextView) window.findViewById(d.g.text_progress_dialog_message);
            if (this.aRM.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aRM.getLayoutParams();
                layoutParams2.topMargin = l.t(getContext(), d.e.tbds35);
                this.aRM.setLayoutParams(layoutParams2);
            }
            if (!StringUtils.isNull(this.mMessage)) {
                this.aRM.setText(this.mMessage);
            }
            this.rz = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.aRO = (CircleView1080) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (i != this.aRP) {
            this.aRP = i;
            if (this.rz != null) {
                this.rz.setText(i + "%");
            }
            if (this.aRO != null) {
                this.aRO.setProgress(i);
            }
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aRM != null) {
            this.aRM.setText(this.mMessage);
        }
    }
}
