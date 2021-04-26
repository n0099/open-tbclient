package com.baidu.sdk.container.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.baidu.sdk.container.widget.AbsCountDownView;
import d.a.d0.a.k.h;
/* loaded from: classes2.dex */
public class CircleTextProgressbar extends AbsCountDownView {

    /* renamed from: h  reason: collision with root package name */
    public int f11058h;

    /* renamed from: i  reason: collision with root package name */
    public int f11059i;
    public ColorStateList j;
    public int k;
    public int l;
    public int m;
    public Paint n;
    public RectF o;
    public int p;
    public int q;
    public ProgressType r;
    public long s;
    public final Rect t;

    /* loaded from: classes2.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11060a;

        static {
            int[] iArr = new int[ProgressType.values().length];
            f11060a = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11060a[ProgressType.COUNT_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CircleTextProgressbar(Context context) {
        this(context, null);
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void b() {
        setTaskPeriod(this.s / this.p);
        super.b();
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void c() {
        super.c();
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void d() {
        int i2 = a.f11060a[this.r.ordinal()];
        if (i2 == 1) {
            this.q++;
        } else if (i2 == 2) {
            this.q--;
        }
        int i3 = this.q;
        if (i3 >= 0 && i3 <= this.p) {
            AbsCountDownView.b bVar = this.f11041f;
            if (bVar != null) {
                bVar.onProgress(i3);
            }
            postInvalidate();
            return;
        }
        this.q = i(this.q);
        AbsCountDownView.b bVar2 = this.f11041f;
        if (bVar2 != null) {
            bVar2.onEnd();
        }
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        h();
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void e(int i2, int i3) {
        this.q = (this.p * i3) / i2;
        invalidate();
    }

    public void f(Context context, AttributeSet attributeSet) {
        this.n.setAntiAlias(true);
        ColorStateList valueOf = ColorStateList.valueOf(0);
        this.j = valueOf;
        this.k = valueOf.getColorForState(getDrawableState(), 0);
        setWidth(h.a(context, 40.0f));
        setHeight(h.a(context, 40.0f));
        setOutLineColor(-7697782);
        setProgressColor(-12956454);
        setProgressLineWidth(h.a(context, 2.0f));
        setTextSize(1, 10.0f);
        setTextColor(-1);
        setText("跳过");
    }

    public final void g() {
        int i2 = a.f11060a[this.r.ordinal()];
        if (i2 == 1) {
            this.q = 0;
        } else if (i2 != 2) {
            this.q = 0;
        } else {
            this.q = this.p;
        }
    }

    public int getProgress() {
        return this.q;
    }

    public ProgressType getProgressType() {
        return this.r;
    }

    public long getTimeMillis() {
        return this.s;
    }

    public final void h() {
        int colorForState = this.j.getColorForState(getDrawableState(), 0);
        if (this.k != colorForState) {
            this.k = colorForState;
            invalidate();
        }
    }

    public final int i(int i2) {
        int i3 = this.p;
        if (i2 > i3) {
            return i3;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        getDrawingRect(this.t);
        float width = (this.t.height() > this.t.width() ? this.t.width() : this.t.height()) / 2;
        this.n.setStyle(Paint.Style.FILL);
        this.n.setColor(this.f11058h);
        this.n.setAlpha(127);
        canvas.drawCircle(this.t.centerX(), this.t.centerY(), width - this.f11059i, this.n);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setColor(this.f11058h);
        this.n.setStrokeWidth(this.m);
        this.n.setStrokeCap(Paint.Cap.ROUND);
        this.n.setAlpha(204);
        canvas.drawCircle(this.t.centerX(), this.t.centerY(), width - (this.m / 2), this.n);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.t.centerX(), this.t.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.n.setColor(this.l);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(this.m);
        this.n.setStrokeCap(Paint.Cap.ROUND);
        this.n.setAlpha(204);
        RectF rectF = this.o;
        int i2 = this.t.left;
        int i3 = this.m;
        rectF.set(i2 + (i3 / 2), rect.top + (i3 / 2), rect.right - (i3 / 2), rect.bottom - (i3 / 2));
        canvas.drawArc(this.o, 270.0f, (this.q * 360) / this.p, false, this.n);
    }

    public void setInCircleColor(int i2) {
        this.j = ColorStateList.valueOf(i2);
        invalidate();
    }

    public void setOutLineColor(int i2) {
        this.f11058h = i2;
        invalidate();
    }

    public void setOutLineWidth(int i2) {
        this.f11059i = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.q = i(i2);
        invalidate();
    }

    public void setProgressColor(int i2) {
        this.l = i2;
        invalidate();
    }

    public void setProgressLineWidth(int i2) {
        this.m = i2;
        invalidate();
    }

    public void setProgressTotalPart(int i2) {
        this.p = i2;
        g();
    }

    public void setProgressType(ProgressType progressType) {
        this.r = progressType;
        g();
        invalidate();
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void setTimeMillis(long j) {
        this.s = j;
        invalidate();
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11058h = -16777216;
        this.f11059i = 2;
        this.j = ColorStateList.valueOf(0);
        this.l = -16776961;
        this.m = 8;
        this.n = new Paint();
        this.o = new RectF();
        this.p = 100;
        this.q = 100;
        this.r = ProgressType.COUNT_BACK;
        this.s = 3000L;
        this.t = new Rect();
        f(context, attributeSet);
    }
}
