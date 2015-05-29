package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class f extends LinearLayout.LayoutParams {
    private int Fq;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fq = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            if ("before".equals(string)) {
                this.Fq = 1;
            } else if ("after".equals(string)) {
                this.Fq = 2;
            } else if ("both".equals(string)) {
                this.Fq = 3;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public f(int i, int i2, int i3) {
        super(i, i2);
        this.Fq = 0;
        this.Fq = i3;
    }

    public f(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.Fq = 0;
    }
}
