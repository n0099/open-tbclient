package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private String XT;
    private TextView YG;
    private CircleView YH;

    public e(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(t.h.progress_dialog);
            if (!StringUtils.isNull(this.XT)) {
                ((TextView) window.findViewById(t.g.text_progress_dialog_message)).setText(this.XT);
            }
            this.YG = (TextView) window.findViewById(t.g.text_progress_dialog_percent);
            this.YH = (CircleView) window.findViewById(t.g.circle_progress_dialog);
        }
    }

    public void cg(int i) {
        if (this.YG != null) {
            this.YG.setText(String.valueOf(i) + "%");
        }
        if (this.YH != null) {
            this.YH.setProgress(i);
        }
    }
}
