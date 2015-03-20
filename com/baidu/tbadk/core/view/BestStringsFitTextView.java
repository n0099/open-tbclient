package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] Xc;
    private String Xd;
    private float Xe;
    private String Xf;
    private boolean Xg;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.Xd = " ";
        this.Xe = 0.0f;
        this.Xf = "";
        this.Xg = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xd = " ";
        this.Xe = 0.0f;
        this.Xf = "";
        this.Xg = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xd = " ";
        this.Xe = 0.0f;
        this.Xf = "";
        this.Xg = false;
    }

    protected void tD() {
        this.Xe = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.Xc.length; i++) {
            if (i > 0) {
                sb.append(this.Xd);
            }
            sb.append(this.Xc[i]);
            String sb2 = sb.toString();
            if (this.Xe < getPaint().measureText(sb2)) {
                break;
            }
            this.Xg = true;
            this.Xf = sb2;
        }
        setText(this.Xf);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Xc != null && !this.Xg) {
            tD();
        }
    }

    public void setTextArray(String[] strArr) {
        this.Xc = strArr;
        tD();
    }

    public String getSeperator() {
        return this.Xd;
    }

    public void setSeperator(String str) {
        this.Xd = str;
    }
}
