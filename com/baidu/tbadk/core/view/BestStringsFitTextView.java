package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] Lj;
    private String Lk;
    private float Ll;
    private String Lm;
    private boolean Ln;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.Lk = " ";
        this.Ll = 0.0f;
        this.Lm = "";
        this.Ln = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lk = " ";
        this.Ll = 0.0f;
        this.Lm = "";
        this.Ln = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Lk = " ";
        this.Ll = 0.0f;
        this.Lm = "";
        this.Ln = false;
    }

    protected void qj() {
        this.Ll = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.Lj.length; i++) {
            if (i > 0) {
                sb.append(this.Lk);
            }
            sb.append(this.Lj[i]);
            String sb2 = sb.toString();
            if (this.Ll < getPaint().measureText(sb2)) {
                break;
            }
            this.Ln = true;
            this.Lm = sb2;
        }
        setText(this.Lm);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Lj != null && !this.Ln) {
            qj();
        }
    }

    public void setTextArray(String[] strArr) {
        this.Lj = strArr;
        qj();
    }

    public String getSeperator() {
        return this.Lk;
    }

    public void setSeperator(String str) {
        this.Lk = str;
    }
}
