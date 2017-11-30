package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView abZ;
    private TextView aca;
    private CircleView acb;
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
                this.aca = (TextView) window.findViewById(d.g.text_progress_dialog_message);
                this.aca.setText(this.mMessage);
            }
            this.abZ = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.acb = (CircleView) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.abZ != null) {
            this.abZ.setText(i + "%");
        }
        if (this.acb != null) {
            this.acb.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aca != null) {
            this.aca.setText(this.mMessage);
        }
    }
}
