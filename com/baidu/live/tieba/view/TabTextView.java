package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class TabTextView extends TextView {
    private float aVI;
    private boolean aVJ;
    private LinearGradient aVK;
    private boolean aVL;
    private int aVw;
    private int aVx;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVL = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aVw = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aVx = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aVI = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aVJ = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        bU(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        bU(z);
        bV(z);
        bW(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.aVw = i;
        this.aVx = i2;
        this.aVI = f;
        this.mSelectedTextSize = f2;
        this.aVJ = z;
        invalidate();
    }

    private boolean Fl() {
        return (this.aVw == -1 || this.aVx == -1) ? false : true;
    }

    private void bU(boolean z) {
        if (this.aVL) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.aVI != -1.0f) {
                setTextSize(0, this.aVI);
            }
        }
    }

    public TabTextView bV(boolean z) {
        if (this.aVJ) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void bW(boolean z) {
        if (z && Fl()) {
            if (this.aVK == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aVK = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aVw, this.aVx}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aVK);
            return;
        }
        getPaint().setShader(null);
    }
}
