package com.baidu.nadcore.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.jd1;
/* loaded from: classes3.dex */
public class BdBaseImageView extends ImageView {
    public boolean a;
    public int b;

    public BdBaseImageView(Context context) {
        super(context);
        this.a = true;
        this.b = 0;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (b()) {
                jd1.c(getContext(), getDrawable());
                this.b = jd1.e(getContext());
                this.a = false;
            }
            super.draw(canvas);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (a()) {
            jd1.d(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.a = true;
        super.setImageDrawable(drawable);
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = 0;
    }

    public final boolean a() {
        if (Color.alpha(jd1.e(getContext())) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (!this.a && this.b == jd1.e(getContext())) {
            return false;
        }
        return true;
    }
}
