package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView WJ;
    private CircleView WK;
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
            this.WJ = (TextView) window.findViewById(r.g.text_progress_dialog_percent);
            this.WK = (CircleView) window.findViewById(r.g.circle_progress_dialog);
        }
    }

    public void setPercent(int i) {
        if (this.WJ != null) {
            this.WJ.setText(String.valueOf(i) + "%");
        }
        if (this.WK != null) {
            this.WK.setProgress(i);
        }
    }
}
