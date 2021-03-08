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
    private int dnl;
    private boolean dwc;

    public BdBaseImageView(Context context) {
        super(context);
        this.dwc = true;
        this.dnl = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwc = true;
        this.dnl = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwc = true;
        this.dnl = 0;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.dwc = true;
        super.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (aGB()) {
            z.a(getContext(), getDrawable());
            this.dnl = z.da(getContext());
            this.dwc = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (aGC()) {
            z.a(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean aGB() {
        return this.dwc || this.dnl != z.da(getContext());
    }

    private boolean aGC() {
        return Color.alpha(z.da(getContext())) != 0;
    }
}
