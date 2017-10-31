package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView abE;
    private TextView abF;
    private CircleView abG;
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
                this.abF = (TextView) window.findViewById(d.g.text_progress_dialog_message);
                this.abF.setText(this.mMessage);
            }
            this.abE = (TextView) window.findViewById(d.g.text_progress_dialog_percent);
            this.abG = (CircleView) window.findViewById(d.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.abE != null) {
            this.abE.setText(i + "%");
        }
        if (this.abG != null) {
            this.abG.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.abF != null) {
            this.abF.setText(this.mMessage);
        }
    }
}
