package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.z;
/* loaded from: classes9.dex */
public class BdBaseImageView extends ImageView {
    private int don;
    private boolean dxd;

    public BdBaseImageView(Context context) {
        super(context);
        this.dxd = true;
        this.don = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxd = true;
        this.don = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxd = true;
        this.don = 0;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.dxd = true;
        super.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (aJW()) {
            z.a(getContext(), getDrawable());
            this.don = z.dd(getContext());
            this.dxd = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (aJX()) {
            z.a(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean aJW() {
        return this.dxd || this.don != z.dd(getContext());
    }

    private boolean aJX() {
        return Color.alpha(z.dd(getContext())) != 0;
    }
}
