package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class d extends FrameLayout.LayoutParams {
    public int a;

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.ColumnLayout_Layout);
        this.a = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        if (this.gravity == -1) {
            this.gravity = 51;
        }
    }

    public d(int i, int i2, int i3, int i4) {
        super(i, i2, i3);
        this.a = 1;
        this.a = i4;
    }

    public d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 1;
    }
}
