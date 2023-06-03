package com.baidu.searchbox.ui;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class CustomLinkByEllipsize implements ViewTreeObserver.OnGlobalLayoutListener {
    public int maxLines;
    public TextView textView;

    public CustomLinkByEllipsize(TextView textView) {
        int maxLines = textView.getMaxLines();
        this.maxLines = maxLines;
        if (maxLines <= 0) {
            this.maxLines = 1;
        }
        this.textView = textView;
        textView.setMaxLines(this.maxLines + 1);
        this.textView.setSingleLine(false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        CharSequence text;
        String str;
        if (this.textView.getLineCount() > this.maxLines) {
            try {
                text = this.textView.getText().subSequence(0, this.textView.getLayout().getLineEnd(this.maxLines - 1) - 2);
                str = "...";
            } catch (Exception unused) {
                text = this.textView.getText();
                str = "";
            }
            TextUtils.TruncateAt ellipsize = this.textView.getEllipsize();
            if (ellipsize == TextUtils.TruncateAt.START) {
                this.textView.setText(str);
                this.textView.append(text);
            } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                this.textView.setText(text.subSequence(0, text.length() / 2));
                this.textView.append(str);
                this.textView.append(text.subSequence(text.length() / 2, text.length()));
            } else {
                this.textView.setText(text);
                this.textView.append(str);
            }
        }
    }
}
