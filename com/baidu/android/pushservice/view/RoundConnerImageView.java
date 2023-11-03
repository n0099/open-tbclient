package com.baidu.android.pushservice.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.pushservice.R;
/* loaded from: classes.dex */
public class RoundConnerImageView extends ImageView {
    public int a;

    public RoundConnerImageView(Context context) {
        this(context, null);
    }

    public RoundConnerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundConnerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundConnerImageView, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.a = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() > this.a && getHeight() > this.a) {
            Path path = new Path();
            path.moveTo(this.a, 0.0f);
            path.lineTo(getWidth() - this.a, 0.0f);
            path.quadTo(getWidth(), 0.0f, getWidth(), this.a);
            path.lineTo(getWidth(), getHeight() - this.a);
            path.quadTo(getWidth(), getHeight(), getWidth() - this.a, getHeight());
            path.lineTo(this.a, getHeight());
            path.quadTo(0.0f, getHeight(), 0.0f, getHeight() - this.a);
            path.lineTo(0.0f, this.a);
            path.quadTo(0.0f, 0.0f, this.a, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }
}
