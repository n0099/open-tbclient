package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] LE;
    private String LF;
    private float LG;
    private String LH;
    private boolean LI;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.LF = " ";
        this.LG = 0.0f;
        this.LH = "";
        this.LI = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LF = " ";
        this.LG = 0.0f;
        this.LH = "";
        this.LI = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LF = " ";
        this.LG = 0.0f;
        this.LH = "";
        this.LI = false;
    }

    protected void qu() {
        this.LG = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.LE.length; i++) {
            if (i > 0) {
                sb.append(this.LF);
            }
            sb.append(this.LE[i]);
            String sb2 = sb.toString();
            if (this.LG < getPaint().measureText(sb2)) {
                break;
            }
            this.LI = true;
            this.LH = sb2;
        }
        setText(this.LH);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.LE != null && !this.LI) {
            qu();
        }
    }

    public void setTextArray(String[] strArr) {
        this.LE = strArr;
        qu();
    }

    public String getSeperator() {
        return this.LF;
    }

    public void setSeperator(String str) {
        this.LF = str;
    }
}
