package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.spswitch.a;
import com.baidu.spswitch.b;
/* loaded from: classes13.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private com.baidu.spswitch.a.b bax;
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
        this.bax = new com.baidu.spswitch.a.b(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i2));
        }
        int[] S = this.bax.S(i, i2);
        if (DEBUG) {
            Log.d(TAG, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(S[1]));
        }
        super.onMeasure(S[0], S[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.bax.dN(i)) {
            super.setVisibility(i);
        }
    }

    @Override // com.baidu.spswitch.a
    public void Gh() {
        super.setVisibility(0);
    }

    @Override // com.baidu.spswitch.a
    public void Gi() {
        this.bax.Gi();
    }

    @Override // com.baidu.spswitch.b
    public void dL(int i) {
        this.bax.dO(i);
    }

    @Override // com.baidu.spswitch.b
    public void onSoftInputShowing(boolean z) {
        this.bax.bP(z);
    }
}
