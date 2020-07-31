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
    private LinearGradient biK;
    private boolean biL;
    private final float bkW;
    private final float bkX;
    private final boolean bkY;
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
        this.biL = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bkW = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bkX = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bkY = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cl(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cl(z);
        setSelectedBold(z);
        cn(z);
    }

    private boolean Iu() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void cl(boolean z) {
        if (this.biL) {
            if (z) {
                if (this.bkX != -1.0f) {
                    setTextSize(0, this.bkX);
                }
            } else if (this.bkW != -1.0f) {
                setTextSize(0, this.bkW);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bkY) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void cn(boolean z) {
        if (z && Iu()) {
            if (this.biK == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.biK = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.biK);
            return;
        }
        getPaint().setShader(null);
    }
}
