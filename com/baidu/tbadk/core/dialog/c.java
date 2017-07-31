package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends AlertDialog {
    private TextView acm;
    private CircleView acn;
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
                this.acm = (TextView) window.findViewById(d.h.text_progress_dialog_message);
                this.acm.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(d.h.text_progress_dialog_percent);
            this.acn = (CircleView) window.findViewById(d.h.circle_progress_dialog);
        }
    }

    public void ck(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(i + "%");
        }
        if (this.acn != null) {
            this.acn.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.acm != null) {
            this.acm.setText(this.mMessage);
        }
    }
}
