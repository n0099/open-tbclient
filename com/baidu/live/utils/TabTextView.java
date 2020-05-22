package com.baidu.live.utils;

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
    private LinearGradient bdd;
    private boolean bde;
    private final float bfu;
    private final float bfv;
    private final boolean bfw;
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
        this.bde = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.bfu = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bfv = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bfw = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        ce(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        ce(z);
        setSelectedBold(z);
        cg(z);
    }

    private boolean Hb() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void ce(boolean z) {
        if (this.bde) {
            if (z) {
                if (this.bfv != -1.0f) {
                    setTextSize(0, this.bfv);
                }
            } else if (this.bfu != -1.0f) {
                setTextSize(0, this.bfu);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bfw) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void cg(boolean z) {
        if (z && Hb()) {
            if (this.bdd == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bdd = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bdd);
            return;
        }
        getPaint().setShader(null);
    }
}
