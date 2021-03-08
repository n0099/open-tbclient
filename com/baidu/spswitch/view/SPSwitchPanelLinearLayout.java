package com.baidu.spswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.spswitch.a;
import com.baidu.spswitch.a.b;
/* loaded from: classes3.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements a {
    private b cDp;
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
        this.cDp = new b(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i2));
        }
        int[] V = this.cDp.V(i, i2);
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(V[1]));
        }
        super.onMeasure(V[0], V[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.cDp.fZ(i)) {
            super.setVisibility(i);
        }
    }

    @Override // com.baidu.spswitch.a
    public void afI() {
        super.setVisibility(0);
    }

    @Override // com.baidu.spswitch.a
    public void afJ() {
        this.cDp.afJ();
    }
}
