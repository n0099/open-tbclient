package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BestStringsFitTextView extends TextView {
    private String[] acW;
    private String acX;
    private float acY;
    private String acZ;
    private boolean ada;

    public BestStringsFitTextView(Context context) {
        super(context);
        this.acX = " ";
        this.acY = 0.0f;
        this.acZ = "";
        this.ada = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acX = " ";
        this.acY = 0.0f;
        this.acZ = "";
        this.ada = false;
    }

    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acX = " ";
        this.acY = 0.0f;
        this.acZ = "";
        this.ada = false;
    }

    protected void vr() {
        this.acY = (getWidth() - getPaddingLeft()) - getPaddingRight();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.acW.length; i++) {
            if (i > 0) {
                sb.append(this.acX);
            }
            sb.append(this.acW[i]);
            String sb2 = sb.toString();
            if (this.acY < getPaint().measureText(sb2)) {
                break;
            }
            this.ada = true;
            this.acZ = sb2;
        }
        setText(this.acZ);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.acW != null && !this.ada) {
            vr();
        }
    }

    public void setTextArray(String[] strArr) {
        this.acW = strArr;
        vr();
    }

    public String getSeperator() {
        return this.acX;
    }

    public void setSeperator(String str) {
        this.acX = str;
    }
}
