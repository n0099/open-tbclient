package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView aaE;
    private TextView aaF;
    private CircleView aaG;
    private String mMessage;

    public e(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(w.j.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                this.aaF = (TextView) window.findViewById(w.h.text_progress_dialog_message);
                this.aaF.setText(this.mMessage);
            }
            this.aaE = (TextView) window.findViewById(w.h.text_progress_dialog_percent);
            this.aaG = (CircleView) window.findViewById(w.h.circle_progress_dialog);
        }
    }

    public void ce(int i) {
        if (this.aaE != null) {
            this.aaE.setText(String.valueOf(i) + "%");
        }
        if (this.aaG != null) {
            this.aaG.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aaF != null) {
            this.aaF.setText(this.mMessage);
        }
    }
}
