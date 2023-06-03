package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class SkinTextView extends TextView {
    public SkinTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (z) {
            setAlpha(0.2f);
        } else {
            setAlpha(1.0f);
        }
        super.setPressed(z);
    }

    public SkinTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SkinTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
