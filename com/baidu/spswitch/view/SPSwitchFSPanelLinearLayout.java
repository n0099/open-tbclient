package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.spswitch.a.a;
/* loaded from: classes13.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout {
    private a bGG;

    public SPSwitchFSPanelLinearLayout(Context context) {
        this(context, null);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.bGG = new a(this);
    }
}
