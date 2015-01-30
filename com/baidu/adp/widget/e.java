package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class e extends LinearLayout.LayoutParams {
    private int uF;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.uF = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            if ("before".equals(string)) {
                this.uF = 1;
            } else if ("after".equals(string)) {
                this.uF = 2;
            } else if ("both".equals(string)) {
                this.uF = 3;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public e(int i, int i2, int i3) {
        super(i, i2);
        this.uF = 0;
        this.uF = i3;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.uF = 0;
    }
}
