package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] XP;
    private String XQ;
    private float XR;
    private String XS;
    private boolean XT;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.XQ = " ";
        this.XR = 0.0f;
        this.XS = "";
        this.XT = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XQ = " ";
        this.XR = 0.0f;
        this.XS = "";
        this.XT = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.XQ = " ";
        this.XR = 0.0f;
        this.XS = "";
        this.XT = false;
    }

    protected void ui() {
        this.XR = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.XP.length; i++) {
            if (i > 0) {
                sb.append(this.XQ);
            }
            sb.append(this.XP[i]);
            String sb2 = sb.toString();
            if (this.XR < getPaint().measureText(sb2)) {
                break;
            }
            this.XT = true;
            this.XS = sb2;
        }
        setText(this.XS);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.XP != null && !this.XT) {
            ui();
        }
    }

    public void setTextArray(String[] strArr) {
        this.XP = strArr;
        ui();
    }

    public String getSeperator() {
        return this.XQ;
    }

    public void setSeperator(String str) {
        this.XQ = str;
    }
}
