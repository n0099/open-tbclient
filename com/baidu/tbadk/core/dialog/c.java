package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView abi;
    private TextView abj;
    private CircleView abk;
    private String mMessage;

    public c(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(d.j.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                this.abj = (TextView) window.findViewById(d.h.text_progress_dialog_message);
                this.abj.setText(this.mMessage);
            }
            this.abi = (TextView) window.findViewById(d.h.text_progress_dialog_percent);
            this.abk = (CircleView) window.findViewById(d.h.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.abi != null) {
            this.abi.setText(i + "%");
        }
        if (this.abk != null) {
            this.abk.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.abj != null) {
            this.abj.setText(this.mMessage);
        }
    }
}
