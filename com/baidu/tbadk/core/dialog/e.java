package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView SD;
    private CircleView SE;
    private String mMessage;

    public e(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(u.h.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                ((TextView) window.findViewById(u.g.text_progress_dialog_message)).setText(this.mMessage);
            }
            this.SD = (TextView) window.findViewById(u.g.text_progress_dialog_percent);
            this.SE = (CircleView) window.findViewById(u.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.SD != null) {
            this.SD.setText(String.valueOf(i) + "%");
        }
        if (this.SE != null) {
            this.SE.setProgress(i);
        }
    }
}
