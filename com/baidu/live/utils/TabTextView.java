package com.baidu.live.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class TabTextView extends TextView {
    private LinearGradient apn;
    private boolean apo;
    private final float arx;
    private final float ary;
    private final boolean arz;
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
        this.apo = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_TabTextView);
        this.startTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.endTextColor = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.arx = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.ary = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.arz = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        aM(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        aM(z);
        setSelectedBold(z);
        aO(z);
    }

    private boolean vy() {
        return (this.startTextColor == -1 || this.endTextColor == -1) ? false : true;
    }

    private void aM(boolean z) {
        if (this.apo) {
            if (z) {
                if (this.ary != -1.0f) {
                    setTextSize(0, this.ary);
                }
            } else if (this.arx != -1.0f) {
                setTextSize(0, this.arx);
            }
        }
    }

    private void setSelectedBold(boolean z) {
        if (this.arz) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    private void aO(boolean z) {
        if (z && vy()) {
            if (this.apn == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.apn = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.startTextColor, this.endTextColor}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.apn);
            return;
        }
        getPaint().setShader(null);
    }
}
