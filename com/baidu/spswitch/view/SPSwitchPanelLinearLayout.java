package com.baidu.spswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.spswitch.IPanelConflictLayout;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.spswitch.handler.SPSwitchPanelLayoutHandler;
import com.baidu.spswitch.utils.SPConfig;
/* loaded from: classes2.dex */
public class SPSwitchPanelLinearLayout extends LinearLayout implements IPanelConflictLayout, IPanelHeightTarget {
    public SPSwitchPanelLayoutHandler mPanelLayoutHandler;
    public static final String TAG = SPSwitchPanelLinearLayout.class.getSimpleName();
    public static final boolean DEBUG = SPConfig.isDebug();

    public SPSwitchPanelLinearLayout(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPanelLayoutHandler = new SPSwitchPanelLayoutHandler(this);
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleHide() {
        this.mPanelLayoutHandler.handleHide();
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleShow() {
        super.setVisibility(0);
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isSoftInputShowing() {
        return this.mPanelLayoutHandler.isSoftInputShowing();
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isVisible() {
        return this.mPanelLayoutHandler.isVisible();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (DEBUG) {
            String str = TAG;
            Log.d(str, "panelLayout onMeasure, height: " + View.MeasureSpec.getSize(i3));
        }
        int[] processOnMeasure = this.mPanelLayoutHandler.processOnMeasure(i2, i3);
        if (DEBUG) {
            String str2 = TAG;
            Log.d(str2, "panelLayout onMeasure after process, height: " + View.MeasureSpec.getSize(processOnMeasure[1]));
        }
        super.onMeasure(processOnMeasure[0], processOnMeasure[1]);
    }

    @Override // com.baidu.spswitch.IPanelHeightTarget
    public void onSoftInputShowing(boolean z) {
        this.mPanelLayoutHandler.setIsSoftInputShowing(z);
    }

    @Override // com.baidu.spswitch.IPanelHeightTarget
    public void refreshHeight(int i2) {
        this.mPanelLayoutHandler.refreshPanelHeight(i2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (this.mPanelLayoutHandler.filterSetVisibility(i2)) {
            return;
        }
        super.setVisibility(i2);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
