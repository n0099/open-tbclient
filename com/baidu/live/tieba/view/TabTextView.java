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
    private int aVB;
    private int aVC;
    private float aVN;
    private boolean aVO;
    private LinearGradient aVP;
    private boolean aVQ;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVQ = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.aVB = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aVC = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.aVN = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.aVO = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
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
        this.aVB = i;
        this.aVC = i2;
        this.aVN = f;
        this.mSelectedTextSize = f2;
        this.aVO = z;
        invalidate();
    }

    private boolean Fk() {
        return (this.aVB == -1 || this.aVC == -1) ? false : true;
    }

    private void bU(boolean z) {
        if (this.aVQ) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.aVN != -1.0f) {
                setTextSize(0, this.aVN);
            }
        }
    }

    public TabTextView bV(boolean z) {
        if (this.aVO) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void bW(boolean z) {
        if (z && Fk()) {
            if (this.aVP == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.aVP = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aVB, this.aVC}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.aVP);
            return;
        }
        getPaint().setShader(null);
    }
}
