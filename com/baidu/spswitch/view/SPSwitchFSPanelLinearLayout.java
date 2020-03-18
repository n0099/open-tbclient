package com.baidu.spswitch.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.spswitch.a.a;
import com.baidu.spswitch.b;
import com.baidu.spswitch.b.g;
/* loaded from: classes13.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout implements b {
    private a baK;

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
        this.baK = new a(this);
    }

    @Override // com.baidu.spswitch.b
    public void dL(int i) {
        g.f(this, i);
    }

    @Override // com.baidu.spswitch.b
    public void onSoftInputShowing(boolean z) {
        this.baK.onSoftInputShowing(z);
    }
}
