package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView WY;
    private CircleView WZ;
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
            this.WY = (TextView) window.findViewById(t.g.text_progress_dialog_percent);
            this.WZ = (CircleView) window.findViewById(t.g.circle_progress_dialog);
        }
    }

    public void ci(int i) {
        if (this.WY != null) {
            this.WY.setText(String.valueOf(i) + "%");
        }
        if (this.WZ != null) {
            this.WZ.setProgress(i);
        }
    }
}
