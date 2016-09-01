package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView Wb;
    private CircleView Wc;
    private String mMessage;

    public e(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(t.h.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                ((TextView) window.findViewById(t.g.text_progress_dialog_message)).setText(this.mMessage);
            }
            this.Wb = (TextView) window.findViewById(t.g.text_progress_dialog_percent);
            this.Wc = (CircleView) window.findViewById(t.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.Wb != null) {
            this.Wb.setText(String.valueOf(i) + "%");
        }
        if (this.Wc != null) {
            this.Wc.setProgress(i);
        }
    }
}
