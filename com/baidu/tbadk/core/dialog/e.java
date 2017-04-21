package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends AlertDialog {
    private TextView aaV;
    private CircleView aaW;
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
                this.aaV = (TextView) window.findViewById(w.h.text_progress_dialog_message);
                this.aaV.setText(this.mMessage);
            }
            this.mTextView = (TextView) window.findViewById(w.h.text_progress_dialog_percent);
            this.aaW = (CircleView) window.findViewById(w.h.circle_progress_dialog);
        }
    }

    public void ch(int i) {
        if (this.mTextView != null) {
            this.mTextView.setText(String.valueOf(i) + "%");
        }
        if (this.aaW != null) {
            this.aaW.setProgress(i);
        }
    }

    public void setMessage(String str) {
        this.mMessage = str;
        if (this.aaV != null) {
            this.aaV.setText(this.mMessage);
        }
    }
}
