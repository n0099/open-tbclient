package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView Vt;
    private CircleView Vu;
    private String mMessage;

    public e(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(r.j.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                ((TextView) window.findViewById(r.h.text_progress_dialog_message)).setText(this.mMessage);
            }
            this.Vt = (TextView) window.findViewById(r.h.text_progress_dialog_percent);
            this.Vu = (CircleView) window.findViewById(r.h.circle_progress_dialog);
        }
    }

    public void ci(int i) {
        if (this.Vt != null) {
            this.Vt.setText(String.valueOf(i) + "%");
        }
        if (this.Vu != null) {
            this.Vu.setProgress(i);
        }
    }
}
