package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.io3;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
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
        if (b()) {
            io3.b(getContext(), getDrawable());
            this.b = io3.d(getContext());
            this.a = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (a()) {
            io3.c(getContext(), getDrawable(), i);
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
        if (Color.alpha(io3.d(getContext())) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (!this.a && this.b == io3.d(getContext())) {
            return false;
        }
        return true;
    }
}
