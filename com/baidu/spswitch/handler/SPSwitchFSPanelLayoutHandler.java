package com.baidu.spswitch.handler;

import android.view.View;
/* loaded from: classes2.dex */
public class SPSwitchFSPanelLayoutHandler {
    public boolean isSoftInputShowing;
    public final View mPanelLayout;

    public SPSwitchFSPanelLayoutHandler(View view) {
        this.mPanelLayout = view;
    }

    public void onSoftInputShowing(boolean z) {
        this.isSoftInputShowing = z;
        if (z || this.mPanelLayout.getVisibility() != 4) {
            return;
        }
        this.mPanelLayout.setVisibility(8);
    }
}
