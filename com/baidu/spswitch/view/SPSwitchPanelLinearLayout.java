package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.spswitch.a;
import com.baidu.spswitch.a.b;
/* loaded from: classes13.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements a {
    private b byZ;
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
        this.byZ = new b(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i2));
        }
        int[] U = this.byZ.U(i, i2);
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(U[1]));
        }
        super.onMeasure(U[0], U[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.byZ.dV(i)) {
            super.setVisibility(i);
        }
    }

    @Override // com.baidu.spswitch.a
    public void NZ() {
        super.setVisibility(0);
    }

    @Override // com.baidu.spswitch.a
    public void Oa() {
        this.byZ.Oa();
    }
}
