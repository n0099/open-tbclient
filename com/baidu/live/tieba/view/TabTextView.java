package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class TabTextView extends TextView {
    private int bHa;
    private int bHb;
    private float bHj;
    private float bHk;
    private boolean bHl;
    private LinearGradient bHm;
    private boolean bHn;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHn = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bHa = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bHb = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bHj = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bHk = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bHl = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        db(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        db(z);
        dc(z);
        dd(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bHa = i;
        this.bHb = i2;
        this.bHj = f;
        this.bHk = f2;
        this.bHl = z;
        invalidate();
    }

    private boolean Sz() {
        return (this.bHa == -1 || this.bHb == -1) ? false : true;
    }

    private void db(boolean z) {
        if (this.bHn) {
            if (z) {
                if (this.bHk != -1.0f) {
                    setTextSize(0, this.bHk);
                }
            } else if (this.bHj != -1.0f) {
                setTextSize(0, this.bHj);
            }
        }
    }

    public TabTextView dc(boolean z) {
        if (this.bHl) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void dd(boolean z) {
        if (z && Sz()) {
            if (this.bHm == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bHm = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bHa, this.bHb}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bHm);
            return;
        }
        getPaint().setShader(null);
    }
}
