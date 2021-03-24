package com.baidu.spswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.spswitch.handler.SPSwitchFSPanelLayoutHandler;
import com.baidu.spswitch.utils.ViewUtil;
/* loaded from: classes3.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout implements IPanelHeightTarget {
    public SPSwitchFSPanelLayoutHandler mPanelHandler;

    public SPSwitchFSPanelLinearLayout(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPanelHandler = new SPSwitchFSPanelLayoutHandler(this);
    }

    @Override // com.baidu.spswitch.IPanelHeightTarget
    public void onSoftInputShowing(boolean z) {
        this.mPanelHandler.onSoftInputShowing(z);
    }

    @Override // com.baidu.spswitch.IPanelHeightTarget
    public void refreshHeight(int i) {
        ViewUtil.refreshHeight(this, i);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
