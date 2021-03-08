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
/* loaded from: classes10.dex */
public class TabTextView extends TextView {
    private LinearGradient bMw;
    private boolean bMx;
    private final float bPw;
    private final float bPx;
    private final boolean bPy;
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
        this.bMx = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bPw = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bPx = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bPy = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        dj(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        dj(z);
        setSelectedBold(z);
        dl(z);
    }

    private boolean Uj() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void dj(boolean z) {
        if (this.bMx) {
            if (z) {
                if (this.bPx != -1.0f) {
                    setTextSize(0, this.bPx);
                }
            } else if (this.bPw != -1.0f) {
                setTextSize(0, this.bPw);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bPy) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void dl(boolean z) {
        if (z && Uj()) {
            if (this.bMw == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bMw = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bMw);
            return;
        }
        getPaint().setShader(null);
    }
}
