package com.baidu.live.tieba.view;

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
    private int aoS;
    private int aoT;
    private float apk;
    private float apl;
    private boolean apm;
    private LinearGradient apn;
    private boolean apo;

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
        this.aoS = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_startTextColor, -1);
        this.aoT = obtainStyledAttributes.getColor(a.k.sdk_TabTextView_endTextColor, -1);
        this.apk = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_defaultTextSize, -1.0f);
        this.apl = obtainStyledAttributes.getDimension(a.k.sdk_TabTextView_selectedTextSize, -1.0f);
        this.apm = obtainStyledAttributes.getBoolean(a.k.sdk_TabTextView_selectedBold, false);
        obtainStyledAttributes.recycle();
        aM(false);
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z) {
        super.dispatchSetSelected(z);
        aM(z);
        aN(z);
        aO(z);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        this.aoS = i;
        this.aoT = i2;
        this.apk = f;
        this.apl = f2;
        this.apm = z;
        invalidate();
    }

    private boolean vy() {
        return (this.aoS == -1 || this.aoT == -1) ? false : true;
    }

    private void aM(boolean z) {
        if (this.apo) {
            if (z) {
                if (this.apl != -1.0f) {
                    setTextSize(0, this.apl);
                }
            } else if (this.apk != -1.0f) {
                setTextSize(0, this.apk);
            }
        }
    }

    public TabTextView aN(boolean z) {
        if (this.apm) {
            if (z) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
        return this;
    }

    private void aO(boolean z) {
        if (z && vy()) {
            if (this.apn == null) {
                if (getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                this.apn = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.aoS, this.aoT}, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.apn);
            return;
        }
        getPaint().setShader(null);
    }
}
