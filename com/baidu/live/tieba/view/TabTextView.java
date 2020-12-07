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
    private int bGZ;
    private int bHa;
    private float bHj;
    private boolean bHk;
    private LinearGradient bHl;
    private boolean bHm;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHm = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.bGZ = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.bHa = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bHj = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bHk = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        dc(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        dc(z);
        dd(z);
        de(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bGZ = i;
        this.bHa = i2;
        this.bHj = f;
        this.mSelectedTextSize = f2;
        this.bHk = z;
        invalidate();
    }

    private boolean Vp() {
        return (this.bGZ == -1 || this.bHa == -1) ? false : true;
    }

    private void dc(boolean z) {
        if (this.bHm) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bHj != -1.0f) {
                setTextSize(0, this.bHj);
            }
        }
    }

    public TabTextView dd(boolean z) {
        if (this.bHk) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void de(boolean z) {
        if (z && Vp()) {
            if (this.bHl == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bHl = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bGZ, this.bHa}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bHl);
            return;
        }
        getPaint().setShader(null);
    }
}
