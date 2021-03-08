package com.baidu.spswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.spswitch.a.a;
/* loaded from: classes3.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout {
    private a cDo;

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
        this.cDo = new a(this);
    }
}
