package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }
}
