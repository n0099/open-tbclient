package com.baidu.nadcore.videoextra;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class NadHighLightAnimationView extends FrameLayout {
    public NadHighLightTextView a;
    public NadHighLightTextView b;

    public NadHighLightAnimationView(@NonNull Context context) {
        this(context, null);
    }

    public final void a(@NonNull Context context) {
        this.a = new NadHighLightTextView(context);
        this.b = new NadHighLightTextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        removeAllViews();
        addView(this.b, layoutParams);
        addView(this.a, layoutParams);
    }

    public void setMaxLines(int i) {
        this.a.setMaxLines(i);
        this.b.setMaxLines(i);
    }

    public void setTextGravity(int i) {
        this.a.setGravity(i);
        this.b.setGravity(i);
    }

    public NadHighLightAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTextSize(int i, float f) {
        this.a.setTextSize(i, f);
        this.b.setTextSize(i, f);
    }

    public NadHighLightAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void setFinalHighlight() {
        this.a.setAlpha(1.0f);
        this.b.setAlpha(0.0f);
    }
}
