package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView aco;
    private CircleView acp;
    private String mMessage;
    private TextView mTextView;

    public c(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setContentView(d.j.progress_dialog);
            if (!StringUtils.isNull(this.mMessage)) {
                this.aco = (TextView) window.findViewById(d.h.text_progress_dialog_message);
                this.aco.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(d.h.text_progress_dialog_percent);
            this.acp = (CircleView) window.findViewById(d.h.circle_progress_dialog);
        }
    }

    public void ck(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.acp != null) {
            this.acp.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aco != null) {
            this.aco.setText(this.mMessage);
        }
    }
}
