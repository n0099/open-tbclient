package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class e extends FrameLayout.LayoutParams {
    public int column;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.column = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout_Layout);
        this.column = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        if (this.gravity == -1) {
            this.gravity = 51;
        }
    }

    public e(int i, int i2, int i3, int i4) {
        super(i, i2, i3);
        this.column = 1;
        this.column = i4;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.column = 1;
    }
}
