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
    private LinearGradient bCd;
    private boolean bCe;
    private final float bFc;
    private final float bFd;
    private final boolean bFe;
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
        this.bCe = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bFc = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bFd = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bFe = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cO(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cO(z);
        setSelectedBold(z);
        cQ(z);
    }

    private boolean SP() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void cO(boolean z) {
        if (this.bCe) {
            if (z) {
                if (this.bFd != -1.0f) {
                    setTextSize(0, this.bFd);
                }
            } else if (this.bFc != -1.0f) {
                setTextSize(0, this.bFc);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bFe) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void cQ(boolean z) {
        if (z && SP()) {
            if (this.bCd == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bCd = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bCd);
            return;
        }
        getPaint().setShader(null);
    }
}
