package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.z;
/* loaded from: classes8.dex */
public class BdBaseImageView extends ImageView {
    private int djz;
    private boolean dsp;

    public BdBaseImageView(Context context) {
        super(context);
        this.dsp = true;
        this.djz = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsp = true;
        this.djz = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dsp = true;
        this.djz = 0;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.dsp = true;
        super.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (aGd()) {
            z.a(getContext(), getDrawable());
            this.djz = z.dc(getContext());
            this.dsp = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (aGe()) {
            z.a(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean aGd() {
        return this.dsp || this.djz != z.dc(getContext());
    }

    private boolean aGe() {
        return Color.alpha(z.dc(getContext())) != 0;
    }
}
