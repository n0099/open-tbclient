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
    private int bcP;
    private int bcQ;
    private float bdb;
    private boolean bdc;
    private LinearGradient bdd;
    private boolean bde;
    private float mSelectedTextSize;

    public TabTextView(Context context) {
        this(context, null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bde = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.bcP = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.bcQ = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bdb = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bdc = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        ce(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        ce(z);
        cf(z);
        cg(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.bcP = i;
        this.bcQ = i2;
        this.bdb = f;
        this.mSelectedTextSize = f2;
        this.bdc = z;
        invalidate();
    }

    private boolean Hb() {
        return (this.bcP == -1 || this.bcQ == -1) ? false : true;
    }

    private void ce(boolean z) {
        if (this.bde) {
            if (z) {
                if (this.mSelectedTextSize != -1.0f) {
                    setTextSize(0, this.mSelectedTextSize);
                }
            } else if (this.bdb != -1.0f) {
                setTextSize(0, this.bdb);
            }
        }
    }

    public TabTextView cf(boolean z) {
        if (this.bdc) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void cg(boolean z) {
        if (z && Hb()) {
            if (this.bdd == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bdd = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.bcP, this.bcQ}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bdd);
            return;
        }
        getPaint().setShader(null);
    }
}
