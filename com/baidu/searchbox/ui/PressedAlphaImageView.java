package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes11.dex */
public class PressedAlphaImageView extends ImageView {
    private static final int DEFAULT_OPAQUE_ALPHA = 255;
    private static final int DEFAULT_PRESSED_ALPHA = 51;
    private static final String TAG = "PressedImageView";
    private int mPressedAlpha;

    public PressedAlphaImageView(Context context) {
        super(context);
        this.mPressedAlpha = 51;
    }

    public PressedAlphaImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPressedAlpha = 51;
    }

    public PressedAlphaImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPressedAlpha = 51;
    }

    public void setPressedAlpha(float f) {
        this.mPressedAlpha = (int) (255.0f * f);
    }

    @Override // android.view.View
    protected void dispatchSetPressed(boolean z) {
        setImageAlpha(z ? this.mPressedAlpha : 255);
    }
}
