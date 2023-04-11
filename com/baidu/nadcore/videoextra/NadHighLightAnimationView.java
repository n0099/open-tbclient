package com.baidu.nadcore.videoextra;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.q51;
import com.baidu.tieba.w31;
/* loaded from: classes2.dex */
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

    public void update(@Nullable q51 q51Var) {
        if (q51Var != null && !TextUtils.isEmpty(q51Var.a)) {
            this.a.setAlpha(0.0f);
            this.a.update(q51Var);
            this.b.setText(q51Var.a);
            this.b.setTextColor(w31.a(q51Var.b, R.color.nad_high_light_text_default_color));
            this.b.setAlpha(1.0f);
        }
    }
}
