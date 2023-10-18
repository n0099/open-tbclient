package com.baidu.live.framework.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.a60;
/* loaded from: classes3.dex */
public class LiveFeedPageRoundRect extends FrameLayout {
    public Paint a;
    public Path b;
    public RectF c;
    public float[] d;
    public boolean e;

    public LiveFeedPageRoundRect(@NonNull Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        canvas.save();
        canvas.clipPath(c());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public final void b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(c());
        super.draw(canvas);
        canvas.restore();
    }

    public final void d(AttributeSet attributeSet) {
        f();
        e(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.e) {
            b(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public LiveFeedPageRoundRect(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet);
    }

    public final Path c() {
        this.b.reset();
        this.b.addRoundRect(this.c, this.d, Path.Direction.CW);
        return this.b;
    }

    public final void f() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.b = new Path();
        this.c = new RectF();
        this.d = new float[8];
    }

    public final void e(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a60.LiveFeedPageRoundRect);
        this.e = obtainStyledAttributes.getBoolean(0, true);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(4, dimensionPixelOffset);
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(5, dimensionPixelOffset);
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelOffset);
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(3, dimensionPixelOffset);
        obtainStyledAttributes.recycle();
        float[] fArr = this.d;
        float f = dimensionPixelOffset2;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = dimensionPixelOffset3;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = dimensionPixelOffset5;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = dimensionPixelOffset4;
        fArr[6] = f4;
        fArr[7] = f4;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(0.0f, 0.0f, i, i2);
    }
}
