package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import d.b.h0.e.a.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CircleTextProgressbar extends AppCompatTextView {

    /* renamed from: e  reason: collision with root package name */
    public int f12450e;

    /* renamed from: f  reason: collision with root package name */
    public int f12451f;

    /* renamed from: g  reason: collision with root package name */
    public int f12452g;

    /* renamed from: h  reason: collision with root package name */
    public int f12453h;
    public int i;
    public Paint j;
    public RectF k;
    public int l;
    public float m;
    public ProgressType n;
    public long o;
    public final Rect p;
    public b q;
    public c r;

    /* loaded from: classes3.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12454a;

        static {
            int[] iArr = new int[ProgressType.values().length];
            f12454a = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12454a[ProgressType.COUNT_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onEnd();

        void onProgress(float f2);
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<CircleTextProgressbar> f12455e;

        public c(CircleTextProgressbar circleTextProgressbar) {
            this.f12455e = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.f12455e.get();
            if (circleTextProgressbar == null) {
                return;
            }
            circleTextProgressbar.i();
        }
    }

    public CircleTextProgressbar(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public final void g(Context context, AttributeSet attributeSet) {
        this.j.setAntiAlias(true);
        this.f12452g = context.getResources().getColor(d.progress_circle_color);
        this.r = new c(this);
    }

    public float getProgress() {
        return this.m;
    }

    public int getProgressTotalPart() {
        return this.l;
    }

    public ProgressType getProgressType() {
        return this.n;
    }

    public long getTimeMillis() {
        return this.o;
    }

    public final void h() {
        int i = a.f12454a[this.n.ordinal()];
        if (i == 1) {
            this.m = 0.0f;
        } else if (i != 2) {
            this.m = 0.0f;
        } else {
            this.m = this.l;
        }
    }

    public final void i() {
        removeCallbacks(this.r);
        int i = a.f12454a[this.n.ordinal()];
        if (i == 1) {
            this.m += 1.0f;
        } else if (i == 2) {
            this.m -= 1.0f;
        }
        float f2 = this.m;
        if (f2 >= 0.0f && f2 <= this.l) {
            b bVar = this.q;
            if (bVar != null) {
                bVar.onProgress(f2);
            }
            invalidate();
            postDelayed(this.r, this.o / this.l);
            return;
        }
        this.m = j(this.m);
        b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.onEnd();
        }
    }

    public final float j(float f2) {
        int i = this.l;
        if (f2 > i) {
            return i;
        }
        if (f2 < 0.0f) {
            return 0.0f;
        }
        return f2;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        getDrawingRect(this.p);
        float width = (this.p.height() > this.p.width() ? this.p.width() : this.p.height()) / 2;
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(this.f12452g);
        this.j.setAlpha(127);
        canvas.drawCircle(this.p.centerX(), this.p.centerY(), width - this.f12451f, this.j);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setColor(this.f12450e);
        this.j.setStrokeWidth(this.i);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        this.j.setAlpha(204);
        canvas.drawCircle(this.p.centerX(), this.p.centerY(), width - (this.i / 2), this.j);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.p.centerX(), this.p.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.j.setColor(this.f12453h);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.i);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        this.j.setAlpha(204);
        RectF rectF = this.k;
        int i = this.p.left;
        int i2 = this.i;
        rectF.set(i + (i2 / 2), rect.top + (i2 / 2), rect.right - (i2 / 2), rect.bottom - (i2 / 2));
        canvas.drawArc(this.k, 270.0f, (this.m * 360.0f) / this.l, false, this.j);
    }

    public void setCountdownProgressListener(b bVar) {
        this.q = bVar;
    }

    public void setInCircleColor(int i) {
        this.f12452g = i;
        invalidate();
    }

    public void setOutLineColor(int i) {
        this.f12450e = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.f12451f = i;
        invalidate();
    }

    public void setProgress(float f2) {
        this.m = j(f2);
        invalidate();
    }

    public void setProgressColor(int i) {
        this.f12453h = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.i = i;
        invalidate();
    }

    public void setProgressTotalPart(int i) {
        this.l = i;
        h();
    }

    public void setProgressType(ProgressType progressType) {
        this.n = progressType;
        h();
        invalidate();
    }

    public void setTimeMillis(long j) {
        this.o = j;
        invalidate();
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12450e = -16777216;
        this.f12451f = 2;
        this.f12453h = -16776961;
        this.i = 8;
        this.j = new Paint();
        this.k = new RectF();
        this.l = 100;
        this.n = ProgressType.COUNT;
        this.o = 3000L;
        this.p = new Rect();
        g(context, attributeSet);
    }
}
