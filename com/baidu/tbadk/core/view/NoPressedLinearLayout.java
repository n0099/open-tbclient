package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class NoPressedLinearLayout extends LinearLayout {
    public NoPressedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoPressedLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }
}
