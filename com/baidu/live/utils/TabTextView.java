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
    private LinearGradient bHl;
    private boolean bHm;
    private final float bKl;
    private final float bKm;
    private final boolean bKn;
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
        this.bHm = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bKl = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bKm = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bKn = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        dc(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        dc(z);
        setSelectedBold(z);
        de(z);
    }

    private boolean Vp() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void dc(boolean z) {
        if (this.bHm) {
            if (z) {
                if (this.bKm != -1.0f) {
                    setTextSize(0, this.bKm);
                }
            } else if (this.bKl != -1.0f) {
                setTextSize(0, this.bKl);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bKn) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void de(boolean z) {
        if (z && Vp()) {
            if (this.bHl == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bHl = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bHl);
            return;
        }
        getPaint().setShader(null);
    }
}
