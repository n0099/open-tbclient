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
    private LinearGradient bDO;
    private boolean bDP;
    private final float bGN;
    private final float bGO;
    private final boolean bGP;
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
        this.bDP = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.j.sdk_TabTextView_endTextColor, -1);
        this.bGN = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_defaultTextSize, -1.0f);
        this.bGO = obtainStyledAttributes.getDimension(a.j.sdk_TabTextView_selectedTextSize, -1.0f);
        this.bGP = obtainStyledAttributes.getBoolean(a.j.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        cM(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        cM(z);
        setSelectedBold(z);
        cO(z);
    }

    private boolean Ty() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void cM(boolean z) {
        if (this.bDP) {
            if (z) {
                if (this.bGO != -1.0f) {
                    setTextSize(0, this.bGO);
                }
            } else if (this.bGN != -1.0f) {
                setTextSize(0, this.bGN);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.bGP) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void cO(boolean z) {
        if (z && Ty()) {
            if (this.bDO == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.bDO = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.bDO);
            return;
        }
        getPaint().setShader(null);
    }
}
