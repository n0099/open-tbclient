package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] Xe;
    private String Xf;
    private float Xg;
    private String Xh;
    private boolean Xi;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.Xf = " ";
        this.Xg = 0.0f;
        this.Xh = "";
        this.Xi = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xf = " ";
        this.Xg = 0.0f;
        this.Xh = "";
        this.Xi = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xf = " ";
        this.Xg = 0.0f;
        this.Xh = "";
        this.Xi = false;
    }

    protected void tD() {
        this.Xg = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.Xe.length; i++) {
            if (i > 0) {
                sb.append(this.Xf);
            }
            sb.append(this.Xe[i]);
            String sb2 = sb.toString();
            if (this.Xg < getPaint().measureText(sb2)) {
                break;
            }
            this.Xi = true;
            this.Xh = sb2;
        }
        setText(this.Xh);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Xe != null && !this.Xi) {
            tD();
        }
    }

    public void setTextArray(String[] strArr) {
        this.Xe = strArr;
        tD();
    }

    public String getSeperator() {
        return this.Xf;
    }

    public void setSeperator(String str) {
        this.Xf = str;
    }
}
