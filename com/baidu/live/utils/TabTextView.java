package com.baidu.live.utils;

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
    private LinearGradient brB;
    private boolean brC;
    private final float btT;
    private final float btU;
    private final boolean btV;
    private final int endTextColor;
    private final int startTextColor;

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
        this.startTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.btT = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.btU = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.btV = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cw(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cw(z);
        setSelectedBold(z);
        cy(z);
    }

    private boolean OQ() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void cw(boolean z) {
        if (this.brC) {
            if (z) {
                if (this.btU != -1.0f) {
                    setTextSize(0, this.btU);
                }
            } else if (this.btT != -1.0f) {
                setTextSize(0, this.btT);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.btV) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void cy(boolean z) {
        if (z && OQ()) {
            if (this.brB == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.brB = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.brB);
            return;
        }
        getPaint().setShader(null);
    }
}
