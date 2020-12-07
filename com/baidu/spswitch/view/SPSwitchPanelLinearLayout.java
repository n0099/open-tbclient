package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.spswitch.a;
import com.baidu.spswitch.a.b;
/* loaded from: classes6.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements a {
    private b czm;
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
        this.czm = new b(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i2));
        }
        int[] ad = this.czm.ad(i, i2);
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(ad[1]));
        }
        super.onMeasure(ad[0], ad[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.czm.hI(i)) {
            super.setVisibility(i);
        }
    }

    @Override // com.baidu.spswitch.a
    public void ahQ() {
        super.setVisibility(0);
    }

    @Override // com.baidu.spswitch.a
    public void ahR() {
        this.czm.ahR();
    }
}
