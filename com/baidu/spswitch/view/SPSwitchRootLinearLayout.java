package com.baidu.spswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.spswitch.handler.SPSwitchRootLayoutHandler;
/* loaded from: classes2.dex */
public class SPSwitchRootLinearLayout extends LinearLayout {
    public SPSwitchRootLayoutHandler conflictHandler;

    public SPSwitchRootLinearLayout(Context context) {
        this(context, null);
    }

    private void init() {
        this.conflictHandler = new SPSwitchRootLayoutHandler(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.conflictHandler.handleBeforeMeasure(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
