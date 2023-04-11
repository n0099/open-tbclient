package com.baidu.nadcore.widget.uiwidget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.a41;
import com.baidu.tieba.za1;
/* loaded from: classes2.dex */
public class ExpandIconView extends View {
    public float a;
    public float b;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float c;
    public float d;
    public final int e;
    public final int f;
    @NonNull
    public final Paint g;
    public final Point h;
    public final Point i;
    public final Point j;
    public final Point k;
    public final Point l;
    public final Path m;
    @Nullable
    public ValueAnimator n;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ExpandIconView.this.a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ExpandIconView.this.k();
            ExpandIconView.this.h();
        }
    }

    public ExpandIconView(@NonNull Context context) {
        this(context, null);
    }

    public final void d(float f) {
        g();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.a, f);
        ofFloat.addUpdateListener(new a());
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(e(f));
        ofFloat.start();
        this.n = ofFloat;
    }

    public final long e(float f) {
        return Math.abs(f - this.a) / this.d;
    }

    public final void j(boolean z) {
        float f = this.c * 45.0f;
        if (z) {
            d(f);
            return;
        }
        g();
        this.a = f;
        k();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, this.b);
        canvas.drawPath(this.m, this.g);
    }

    public ExpandIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setFraction(@FloatRange(from = -1.0d, to = 1.0d) float f, boolean z) {
        if (f < -1.0f || f > 1.0f || this.c == f) {
            return;
        }
        this.c = f;
        if (f != -1.0f) {
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        }
        j(z);
    }

    public void setState(int i, boolean z) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.c = 0.0f;
                }
            } else {
                this.c = 1.0f;
            }
        } else {
            this.c = -1.0f;
        }
        j(z);
    }

    /* JADX DEBUG: Incorrect finally slice size: {[INVOKE, CONSTRUCTOR] complete}, expected: {[INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    public ExpandIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -45.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.h = new Point();
        this.i = new Point();
        this.j = new Point();
        this.k = new Point();
        this.l = new Point();
        this.m = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, za1.ExpandIconView, 0, 0);
        try {
            this.e = obtainStyledAttributes.getDimensionPixelSize(2, a41.c.a(getContext(), 40.0f));
            this.f = obtainStyledAttributes.getDimensionPixelSize(3, a41.c.a(getContext(), 2.0f));
            int color = obtainStyledAttributes.getColor(1, -16777216);
            long integer = obtainStyledAttributes.getInteger(0, 150);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.g = paint;
            paint.setDither(true);
            this.g.setColor(color);
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setStrokeJoin(Paint.Join.ROUND);
            this.g.setPathEffect(new CornerPathEffect(10.0f));
            this.g.setStrokeCap(Paint.Cap.ROUND);
            this.d = 45.0f / ((float) integer);
            setState(1, true);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getFinalStateByFraction() {
        if (this.c < 0.0f) {
            return 0;
        }
        return 1;
    }

    public final void g() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.n.cancel();
        }
    }

    public final void h() {
        postInvalidateOnAnimation();
    }

    public final void f(int i, int i2) {
        this.g.setStrokeWidth(this.f);
        this.j.set(i / 2, i2 / 2);
        double sqrt = Math.sqrt(Math.pow(this.e / 2.0d, 2.0d) - Math.pow(this.j.y, 2.0d));
        Point point = this.h;
        Point point2 = this.j;
        int i3 = (int) sqrt;
        point.set(point2.x - i3, point2.y);
        Point point3 = this.i;
        Point point4 = this.j;
        point3.set(point4.x + i3, point4.y);
    }

    public final void i(@NonNull Point point, double d, @NonNull Point point2) {
        double radians = Math.toRadians(d);
        int i = this.j.x;
        int cos = (int) ((i + ((point.x - i) * Math.cos(radians))) - ((point.y - this.j.y) * Math.sin(radians)));
        Point point3 = this.j;
        point2.set(cos, (int) (point3.y + ((point.x - point3.x) * Math.sin(radians)) + ((point.y - this.j.y) * Math.cos(radians))));
    }

    public final void k() {
        this.m.reset();
        Point point = this.h;
        if (point != null && this.i != null) {
            i(point, -this.a, this.k);
            i(this.i, this.a, this.l);
            int i = this.j.y;
            Point point2 = this.k;
            int i2 = point2.y;
            this.b = (int) ((i - i2) / 2.0d);
            this.m.moveTo(point2.x, i2);
            Path path = this.m;
            Point point3 = this.j;
            path.lineTo(point3.x, point3.y);
            Path path2 = this.m;
            Point point4 = this.l;
            path2.lineTo(point4.x, point4.y);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        f(i, i2);
        k();
    }
}
