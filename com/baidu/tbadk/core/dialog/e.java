package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView Wl;
    private CircleView Wm;
    private String mMessage;

    public e(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(r.h.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                ((TextView) window.findViewById(r.g.text_progress_dialog_message)).setText(this.mMessage);
            }
            this.Wl = (TextView) window.findViewById(r.g.text_progress_dialog_percent);
            this.Wm = (CircleView) window.findViewById(r.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.Wl != null) {
            this.Wl.setText(String.valueOf(i) + "%");
        }
        if (this.Wm != null) {
            this.Wm.setProgress(i);
        }
    }
}
