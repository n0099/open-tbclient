package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView abv;
    private TextView abw;
    private CircleView abx;
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
                this.abw = (TextView) window.findViewById(d.h.text_progress_dialog_message);
                this.abw.setText(this.mMessage);
            }
            this.abv = (TextView) window.findViewById(d.h.text_progress_dialog_percent);
            this.abx = (CircleView) window.findViewById(d.h.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.abv != null) {
            this.abv.setText(i + "%");
        }
        if (this.abx != null) {
            this.abx.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.abw != null) {
            this.abw.setText(this.mMessage);
        }
    }
}
