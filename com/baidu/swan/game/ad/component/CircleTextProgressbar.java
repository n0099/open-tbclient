package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import d.a.h0.e.a.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CircleTextProgressbar extends AppCompatTextView {

    /* renamed from: e  reason: collision with root package name */
    public int f12335e;

    /* renamed from: f  reason: collision with root package name */
    public int f12336f;

    /* renamed from: g  reason: collision with root package name */
    public int f12337g;

    /* renamed from: h  reason: collision with root package name */
    public int f12338h;

    /* renamed from: i  reason: collision with root package name */
    public int f12339i;
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
        public static final /* synthetic */ int[] f12340a;

        static {
            int[] iArr = new int[ProgressType.values().length];
            f12340a = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12340a[ProgressType.COUNT_BACK.ordinal()] = 2;
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
        public WeakReference<CircleTextProgressbar> f12341e;

        public c(CircleTextProgressbar circleTextProgressbar) {
            this.f12341e = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.f12341e.get();
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
        this.f12337g = context.getResources().getColor(d.progress_circle_color);
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
        int i2 = a.f12340a[this.n.ordinal()];
        if (i2 == 1) {
            this.m = 0.0f;
        } else if (i2 != 2) {
            this.m = 0.0f;
        } else {
            this.m = this.l;
        }
    }

    public final void i() {
        removeCallbacks(this.r);
        int i2 = a.f12340a[this.n.ordinal()];
        if (i2 == 1) {
            this.m += 1.0f;
        } else if (i2 == 2) {
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
        int i2 = this.l;
        if (f2 > i2) {
            return i2;
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
        this.j.setColor(this.f12337g);
        this.j.setAlpha(127);
        canvas.drawCircle(this.p.centerX(), this.p.centerY(), width - this.f12336f, this.j);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setColor(this.f12335e);
        this.j.setStrokeWidth(this.f12339i);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        this.j.setAlpha(204);
        canvas.drawCircle(this.p.centerX(), this.p.centerY(), width - (this.f12339i / 2), this.j);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.p.centerX(), this.p.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.j.setColor(this.f12338h);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.f12339i);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        this.j.setAlpha(204);
        RectF rectF = this.k;
        int i2 = this.p.left;
        int i3 = this.f12339i;
        rectF.set(i2 + (i3 / 2), rect.top + (i3 / 2), rect.right - (i3 / 2), rect.bottom - (i3 / 2));
        canvas.drawArc(this.k, 270.0f, (this.m * 360.0f) / this.l, false, this.j);
    }

    public void setCountdownProgressListener(b bVar) {
        this.q = bVar;
    }

    public void setInCircleColor(int i2) {
        this.f12337g = i2;
        invalidate();
    }

    public void setOutLineColor(int i2) {
        this.f12335e = i2;
        invalidate();
    }

    public void setOutLineWidth(int i2) {
        this.f12336f = i2;
        invalidate();
    }

    public void setProgress(float f2) {
        this.m = j(f2);
        invalidate();
    }

    public void setProgressColor(int i2) {
        this.f12338h = i2;
        invalidate();
    }

    public void setProgressLineWidth(int i2) {
        this.f12339i = i2;
        invalidate();
    }

    public void setProgressTotalPart(int i2) {
        this.l = i2;
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

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12335e = -16777216;
        this.f12336f = 2;
        this.f12338h = -16776961;
        this.f12339i = 8;
        this.j = new Paint();
        this.k = new RectF();
        this.l = 100;
        this.n = ProgressType.COUNT;
        this.o = 3000L;
        this.p = new Rect();
        g(context, attributeSet);
    }
}
