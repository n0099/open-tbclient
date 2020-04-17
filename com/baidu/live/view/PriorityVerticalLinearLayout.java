package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class PriorityVerticalLinearLayout extends LinearLayout {
    private int baK;

    public PriorityVerticalLinearLayout(Context context) {
        super(context);
        this.baK = -1;
        setOrientation(1);
    }

    public PriorityVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baK = -1;
        setOrientation(1);
    }

    public PriorityVerticalLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baK = -1;
        setOrientation(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        int X = X(view);
        if (X >= 0) {
            super.addView(view, X, layoutParams);
            if (this.baK >= 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                if (layoutParams2 != null) {
                    int i2 = -1;
                    if (view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer) {
                        i2 = ((Integer) view.getTag(a.g.sdk_pvl_layout_priority_tag_key)).intValue();
                    }
                    if (i2 == 20) {
                        layoutParams2.bottomMargin = 0;
                    } else {
                        layoutParams2.bottomMargin = this.baK;
                    }
                    layoutParams2.topMargin = 0;
                }
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    public void setDefaultItemMargin(int i) {
        this.baK = i;
    }

    private int X(View view) {
        if (view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) {
            return -1;
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild < 0) {
            int childCount = getChildCount();
            int intValue = ((Integer) view.getTag(a.g.sdk_pvl_layout_priority_tag_key)).intValue();
            for (int i = 0; i < childCount; i++) {
                if (intValue < ((Integer) getChildAt(i).getTag(a.g.sdk_pvl_layout_priority_tag_key)).intValue()) {
                    if (i == 0) {
                        return 0;
                    } else {
                        return i;
                    }
                }
            }
            return childCount;
        }
        return indexOfChild;
    }
}
