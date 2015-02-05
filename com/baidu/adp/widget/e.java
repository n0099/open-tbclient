package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class e extends LinearLayout.LayoutParams {
    private int uC;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.uC = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            if ("before".equals(string)) {
                this.uC = 1;
            } else if ("after".equals(string)) {
                this.uC = 2;
            } else if ("both".equals(string)) {
                this.uC = 3;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public e(int i, int i2, int i3) {
        super(i, i2);
        this.uC = 0;
        this.uC = i3;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.uC = 0;
    }
}
