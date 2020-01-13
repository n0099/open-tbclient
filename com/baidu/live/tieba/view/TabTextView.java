package com.baidu.live.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class TabTextView extends TextView {
    private int axj;
    private int axk;
    private float axv;
    private boolean axw;
    private LinearGradient axx;
    private boolean axy;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axy = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.axj = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.axk = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.axv = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.axw = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        bh(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        bh(z);
        bi(z);
        bj(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.axj = i;
        this.axk = i2;
        this.axv = f;
        this.mSelectedTextSize = f2;
        this.axw = z;
        invalidate();
    }

    private boolean xN() {
        return (this.axj == -1 || this.axk == -1) ? false : true;
    }

    private void bh(boolean z) {
        if (this.axy) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.axv != -1.0f) {
                setTextSize(0, this.axv);
            }
        }
    }

    public TabTextView bi(boolean z) {
        if (this.axw) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void bj(boolean z) {
        if (z && xN()) {
            if (this.axx == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.axx = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.axj, this.axk}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.axx);
            return;
        }
        getPaint().setShader(null);
    }
}
