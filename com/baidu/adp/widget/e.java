package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class e extends LinearLayout.LayoutParams {
    private int uz;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.uz = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            if ("before".equals(string)) {
                this.uz = 1;
            } else if ("after".equals(string)) {
                this.uz = 2;
            } else if ("both".equals(string)) {
                this.uz = 3;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public e(int i, int i2, int i3) {
        super(i, i2);
        this.uz = 0;
        this.uz = i3;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.uz = 0;
    }
}
