package com.baidu.mobads.container.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class RemoteRoundCornerImageView extends ImageView {
    public Path clipPath;
    public int cornerRadius;
    public Paint mPaint;
    public RectF mRectF;
    public CornerImageType type;

    public RemoteRoundCornerImageView(Context context) {
        super(context);
        this.clipPath = new Path();
        this.mRectF = new RectF();
        this.mPaint = new Paint();
        this.cornerRadius = 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
            this.clipPath.reset();
            if (this.type == CornerImageType.RoundRect) {
                this.clipPath.addRoundRect(this.mRectF, this.cornerRadius, this.cornerRadius, Path.Direction.CW);
            } else {
                this.clipPath.addOval(this.mRectF, Path.Direction.CW);
            }
            canvas.clipPath(this.clipPath);
            super.onDraw(canvas);
        } catch (Throwable unused) {
        }
    }

    public RemoteRoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemoteRoundCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.clipPath = new Path();
        this.mRectF = new RectF();
        this.mPaint = new Paint();
        this.cornerRadius = 0;
    }
}
