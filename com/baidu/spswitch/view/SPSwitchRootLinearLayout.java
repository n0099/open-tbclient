package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.spswitch.a.c;
/* loaded from: classes9.dex */
public class SPSwitchRootLinearLayout extends LinearLayout {
    private c bRo;

    public SPSwitchRootLinearLayout(Context context) {
        this(context, null);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.bRo = new c(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.bRo.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }
}
