package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] LA;
    private String LB;
    private float LD;
    private String LE;
    private boolean LF;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.LB = " ";
        this.LD = 0.0f;
        this.LE = "";
        this.LF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LB = " ";
        this.LD = 0.0f;
        this.LE = "";
        this.LF = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LB = " ";
        this.LD = 0.0f;
        this.LE = "";
        this.LF = false;
    }

    protected void qn() {
        this.LD = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.LA.length; i++) {
            if (i > 0) {
                sb.append(this.LB);
            }
            sb.append(this.LA[i]);
            String sb2 = sb.toString();
            if (this.LD < getPaint().measureText(sb2)) {
                break;
            }
            this.LF = true;
            this.LE = sb2;
        }
        setText(this.LE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.LA != null && !this.LF) {
            qn();
        }
    }

    public void setTextArray(String[] strArr) {
        this.LA = strArr;
        qn();
    }

    public String getSeperator() {
        return this.LB;
    }

    public void setSeperator(String str) {
        this.LB = str;
    }
}
