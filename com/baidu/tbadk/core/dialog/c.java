package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView abW;
    private TextView abX;
    private CircleView abY;
    private String mMessage;

    public c(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(d.h.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                this.abX = (TextView) window.findViewById(d.g.text_progress_dialog_message);
                this.abX.setText(this.mMessage);
            }
            this.abW = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.abY = (CircleView) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.abW != null) {
            this.abW.setText(i + "%");
        }
        if (this.abY != null) {
            this.abY.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.abX != null) {
            this.abX.setText(this.mMessage);
        }
    }
}
