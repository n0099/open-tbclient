package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout.LayoutParams {

    /* renamed from: a  reason: collision with root package name */
    private int f603a;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f603a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.FloatingLayout_Layout);
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            if ("before".equals(string)) {
                this.f603a = 1;
            } else if ("after".equals(string)) {
                this.f603a = 2;
            } else if ("both".equals(string)) {
                this.f603a = 3;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public e(int i, int i2, int i3) {
        super(i, i2);
        this.f603a = 0;
        this.f603a = i3;
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f603a = 0;
    }
}
