package com.baidu.spswitch.handler;

import android.view.View;
import com.baidu.spswitch.IPanelConflictLayout;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.spswitch.utils.ViewUtil;
/* loaded from: classes3.dex */
public class SPSwitchPanelLayoutHandler implements IPanelConflictLayout {
    public boolean mIsHide = false;
    public boolean mIsSoftInputShowing = false;
    public final View mPanelLayout;

    public SPSwitchPanelLayoutHandler(View view) {
        this.mPanelLayout = view;
    }

    public boolean filterSetVisibility(int i) {
        if (i == 0) {
            this.mIsHide = false;
        }
        if (i == this.mPanelLayout.getVisibility()) {
            return true;
        }
        return isSoftInputShowing() && i == 0;
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleHide() {
        this.mIsHide = true;
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public void handleShow() {
        if (SPConfig.isDebug()) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isSoftInputShowing() {
        return this.mIsSoftInputShowing;
    }

    @Override // com.baidu.spswitch.IPanelConflictLayout
    public boolean isVisible() {
        return !this.mIsHide;
    }

    public int[] processOnMeasure(int i, int i2) {
        if (this.mIsHide) {
            this.mPanelLayout.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i = makeMeasureSpec;
        }
        return new int[]{i, i2};
    }

    public void refreshPanelHeight(int i) {
        ViewUtil.refreshHeight(this.mPanelLayout, i);
    }

    public void setIsSoftInputShowing(boolean z) {
        this.mIsSoftInputShowing = z;
    }
}
