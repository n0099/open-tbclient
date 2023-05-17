package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class PressedAlphaImageView extends ImageView {
    public static final int DEFAULT_OPAQUE_ALPHA = 255;
    public static final int DEFAULT_PRESSED_ALPHA = 51;
    public static final String TAG = "PressedImageView";
    public int mPressedAlpha;

    public PressedAlphaImageView(Context context) {
        super(context);
        this.mPressedAlpha = 51;
    }

    @Override // android.view.View
    public void dispatchSetPressed(boolean z) {
        int i;
        if (z) {
            i = this.mPressedAlpha;
        } else {
            i = 255;
        }
        setImageAlpha(i);
    }

    public void setPressedAlpha(float f) {
        this.mPressedAlpha = (int) (f * 255.0f);
    }

    public PressedAlphaImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPressedAlpha = 51;
    }

    public PressedAlphaImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPressedAlpha = 51;
    }
}
