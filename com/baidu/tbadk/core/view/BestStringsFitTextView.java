package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] acM;
    private String acN;
    private float acO;
    private String acP;
    private boolean acQ;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.acN = " ";
        this.acO = 0.0f;
        this.acP = "";
        this.acQ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acN = " ";
        this.acO = 0.0f;
        this.acP = "";
        this.acQ = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acN = " ";
        this.acO = 0.0f;
        this.acP = "";
        this.acQ = false;
    }

    protected void vm() {
        this.acO = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.acM.length; i++) {
            if (i > 0) {
                sb.append(this.acN);
            }
            sb.append(this.acM[i]);
            String sb2 = sb.toString();
            if (this.acO < getPaint().measureText(sb2)) {
                break;
            }
            this.acQ = true;
            this.acP = sb2;
        }
        setText(this.acP);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.acM != null && !this.acQ) {
            vm();
        }
    }

    public void setTextArray(String[] strArr) {
        this.acM = strArr;
        vm();
    }

    public String getSeperator() {
        return this.acN;
    }

    public void setSeperator(String str) {
        this.acN = str;
    }
}
