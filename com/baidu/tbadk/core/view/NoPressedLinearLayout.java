package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class NoPressedLinearLayout extends LinearLayout {
    public NoPressedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    public NoPressedLinearLayout(Context context) {
        super(context);
    }
}
