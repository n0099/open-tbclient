package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.searchbox.ugc.R;
/* loaded from: classes11.dex */
public class PressAlphaLinearLayout extends LinearLayout {
    private static final float DEFAULT_ALPHA = 1.0f;
    private float mPressedAlpha;

    public PressAlphaLinearLayout(Context context) {
        this(context, null);
    }

    public PressAlphaLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressAlphaLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PressAlphaLinearLayout);
        this.mPressedAlpha = obtainStyledAttributes.getFloat(R.styleable.PressAlphaLinearLayout_pressedAlpha, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (z) {
            setAlpha(this.mPressedAlpha);
        } else {
            setAlpha(1.0f);
        }
        super.setPressed(z);
    }
}
