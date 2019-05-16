package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.baidu.swan.game.ad.a;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    final Rect a;
    private int b;
    private b bdi;
    private a bdj;
    private c bdk;
    private int c;
    private int d;
    private int e;
    private int f;
    private Paint g;
    private RectF h;
    private int i;
    private float j;
    private long l;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(float f);
    }

    /* loaded from: classes2.dex */
    public enum b {
        COUNT,
        COUNT_BACK
    }

    public CircleTextProgressbar(Context context) {
        this(context, null);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = ViewCompat.MEASURED_STATE_MASK;
        this.c = 2;
        this.e = -16776961;
        this.f = 8;
        this.g = new Paint();
        this.h = new RectF();
        this.i = 100;
        this.bdi = b.COUNT;
        this.l = 3000L;
        this.a = new Rect();
        a(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.b = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.c = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.e = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.f = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.j = a(f);
        invalidate();
    }

    public float getProgress() {
        return this.j;
    }

    public void setTimeMillis(long j) {
        this.l = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.l;
    }

    public void setProgressType(b bVar) {
        this.bdi = bVar;
        b();
        invalidate();
    }

    public b getProgressType() {
        return this.bdi;
    }

    public void setCountdownProgressListener(a aVar) {
        this.bdj = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.a);
        float width = (this.a.height() > this.a.width() ? this.a.width() : this.a.height()) / 2;
        this.g.setStyle(Paint.Style.FILL);
        this.g.setColor(this.d);
        this.g.setAlpha(127);
        canvas.drawCircle(this.a.centerX(), this.a.centerY(), width - this.c, this.g);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setColor(this.b);
        this.g.setStrokeWidth(this.f);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setAlpha(204);
        canvas.drawCircle(this.a.centerX(), this.a.centerY(), width - (this.f / 2), this.g);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.a.centerX(), this.a.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.g.setColor(this.e);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.f);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setAlpha(204);
        this.h.set(this.a.left + (this.f / 2), this.a.top + (this.f / 2), this.a.right - (this.f / 2), this.a.bottom - (this.f / 2));
        canvas.drawArc(this.h, 270.0f, (360.0f * this.j) / this.i, false, this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(int i, int i2) {
        if (i > 0) {
            this.j = (this.i * i2) / i;
            invalidate();
        }
    }

    public void setProgressTotalPart(int i) {
        this.i = i;
        b();
    }

    public int getProgressTotalPart() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        removeCallbacks(this.bdk);
        switch (this.bdi) {
            case COUNT:
                this.j += 1.0f;
                break;
            case COUNT_BACK:
                this.j -= 1.0f;
                break;
        }
        if (this.j >= 0.0f && this.j <= this.i) {
            if (this.bdj != null) {
                this.bdj.a(this.j);
            }
            invalidate();
            postDelayed(this.bdk, this.l / this.i);
            return;
        }
        this.j = a(this.j);
        if (this.bdj != null) {
            this.bdj.a();
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.g.setAntiAlias(true);
        this.d = context.getResources().getColor(a.b.progress_circle_color);
        this.bdk = new c(this);
    }

    private void b() {
        switch (this.bdi) {
            case COUNT:
                this.j = 0.0f;
                return;
            case COUNT_BACK:
                this.j = this.i;
                return;
            default:
                this.j = 0.0f;
                return;
        }
    }

    private float a(float f) {
        if (f > this.i) {
            return this.i;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c implements Runnable {
        private WeakReference<CircleTextProgressbar> a;

        c(CircleTextProgressbar circleTextProgressbar) {
            this.a = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.a.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.a();
            }
        }
    }
}
