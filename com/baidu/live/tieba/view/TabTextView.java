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
/* loaded from: classes4.dex */
public class TabTextView extends TextView {
    private boolean brA;
    private LinearGradient brB;
    private boolean brC;
    private int brp;
    private int brq;
    private float brz;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brC = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.brp = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.brq = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.brz = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.brA = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cw(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cw(z);
        cx(z);
        cy(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.brp = i;
        this.brq = i2;
        this.brz = f;
        this.mSelectedTextSize = f2;
        this.brA = z;
        invalidate();
    }

    private boolean OQ() {
        return (this.brp == -1 || this.brq == -1) ? false : true;
    }

    private void cw(boolean z) {
        if (this.brC) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.brz != -1.0f) {
                setTextSize(0, this.brz);
            }
        }
    }

    public TabTextView cx(boolean z) {
        if (this.brA) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cy(boolean z) {
        if (z && OQ()) {
            if (this.brB == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.brB = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.brp, this.brq}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.brB);
            return;
        }
        getPaint().setShader(null);
    }
}
