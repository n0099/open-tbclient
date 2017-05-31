package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView aap;
    private CircleView aaq;
    private String mMessage;
    private TextView mTextView;

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
                this.aap = (TextView) window.findViewById(w.h.text_progress_dialog_message);
                this.aap.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(w.h.text_progress_dialog_percent);
            this.aaq = (CircleView) window.findViewById(w.h.circle_progress_dialog);
        }
    }

    public void cg(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(String.valueOf(i) + "%");
        }
        if (this.aaq != null) {
            this.aaq.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aap != null) {
            this.aap.setText(this.mMessage);
        }
    }
}
