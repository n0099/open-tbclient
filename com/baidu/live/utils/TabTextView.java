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
    private LinearGradient bHm;
    private boolean bHn;
    private final float bKm;
    private final float bKn;
    private final boolean bKo;
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
        this.bHn = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bKm = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bKn = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bKo = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        db(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        db(z);
        setSelectedBold(z);
        dd(z);
    }

    private boolean Sz() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void db(boolean z) {
        if (this.bHn) {
            if (z) {
                if (this.bKn != -1.0f) {
                    setTextSize(0, this.bKn);
                }
            } else if (this.bKm != -1.0f) {
                setTextSize(0, this.bKm);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bKo) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void dd(boolean z) {
        if (z && Sz()) {
            if (this.bHm == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bHm = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bHm);
            return;
        }
        getPaint().setShader(null);
    }
}
