package com.baidu.live.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class RoundImageView extends ImageView {
    private int height;
    private boolean isTop;
    private Path path;
    private float radius;
    private int width;

    public void setTop(boolean z) {
        this.isTop = z;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public RoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radius = 18.0f;
        this.isTop = false;
        this.path = new Path();
    }

    public RoundImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radius = 18.0f;
        this.isTop = false;
        this.path = new Path();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.width > this.radius && this.height > this.radius) {
            this.path.reset();
            this.path.moveTo(this.radius, 0.0f);
            this.path.lineTo(this.width - this.radius, 0.0f);
            this.path.quadTo(this.width, 0.0f, this.width, this.radius);
            if (!this.isTop) {
                this.path.lineTo(this.width, this.height - this.radius);
                this.path.quadTo(this.width, this.height, this.width - this.radius, this.height);
                this.path.lineTo(this.radius, this.height);
                this.path.quadTo(0.0f, this.height, 0.0f, this.height - this.radius);
                this.path.lineTo(0.0f, this.radius);
                this.path.quadTo(0.0f, 0.0f, this.radius, 0.0f);
            } else {
                this.path.lineTo(this.width, this.height);
                this.path.lineTo(0.0f, this.height);
                this.path.lineTo(0.0f, this.radius);
                this.path.quadTo(0.0f, 0.0f, this.radius, 0.0f);
            }
            canvas.clipPath(this.path);
        }
        super.onDraw(canvas);
    }
}
