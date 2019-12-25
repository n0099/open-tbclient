package com.baidu.live.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes2.dex */
public class BDLayoutInflateFactory implements LayoutInflater.Factory {
    private BDLayoutMode viewMode;

    public BDLayoutMode getViewMode() {
        return this.viewMode;
    }

    public void setViewMode(BDLayoutMode bDLayoutMode) {
        this.viewMode = bDLayoutMode;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.viewMode == null) {
            this.viewMode = new BDLayoutMode();
        }
        this.viewMode.initModeInfos(str, context, attributeSet);
        return null;
    }
}
