package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.spswitch.a;
import com.baidu.spswitch.b;
/* loaded from: classes11.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private com.baidu.spswitch.a.b aVs;
    public static final String TAG = SPSwitchPanelLinearLayout.class.getSimpleName();
    public static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public SPSwitchPanelLinearLayout(Context context) {
        this(context, null);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.aVs = new com.baidu.spswitch.a.b(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i2));
        }
        int[] O = this.aVs.O(i, i2);
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(O[1]));
        }
        super.onMeasure(O[0], O[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.aVs.dw(i)) {
            super.setVisibility(i);
        }
    }

    @Override // com.baidu.spswitch.a
    public void Du() {
        super.setVisibility(0);
    }

    @Override // com.baidu.spswitch.a
    public void Dv() {
        this.aVs.Dv();
    }

    @Override // com.baidu.spswitch.b
    public void du(int i) {
        this.aVs.dx(i);
    }

    @Override // com.baidu.spswitch.b
    public void onSoftInputShowing(boolean z) {
        this.aVs.bC(z);
    }
}
