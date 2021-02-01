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
    private int dlK;
    private boolean duB;

    public BdBaseImageView(Context context) {
        super(context);
        this.duB = true;
        this.dlK = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duB = true;
        this.dlK = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duB = true;
        this.dlK = 0;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.duB = true;
        super.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (aGy()) {
            z.a(getContext(), getDrawable());
            this.dlK = z.db(getContext());
            this.duB = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (aGz()) {
            z.a(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean aGy() {
        return this.duB || this.dlK != z.db(getContext());
    }

    private boolean aGz() {
        return Color.alpha(z.db(getContext())) != 0;
    }
}
