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
import com.baidu.swan.game.ad.c;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF abb;
    final Rect bounds;
    private int cZW;
    private int cZX;
    private int cZY;
    private int cZZ;
    private int daa;
    private int dab;
    private ProgressType dac;
    private long dad;
    private a dae;
    private b daf;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes9.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes9.dex */
    public interface a {
        void onEnd();

        void onProgress(float f);
    }

    public CircleTextProgressbar(Context context) {
        this(context, null);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZW = ViewCompat.MEASURED_STATE_MASK;
        this.cZX = 2;
        this.cZZ = -16776961;
        this.daa = 8;
        this.mPaint = new Paint();
        this.abb = new RectF();
        this.dab = 100;
        this.dac = ProgressType.COUNT;
        this.dad = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.cZW = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.cZX = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.cZY = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.cZZ = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.daa = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = J(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dad = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dad;
    }

    public void setProgressType(ProgressType progressType) {
        this.dac = progressType;
        azZ();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dac;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dae = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.cZY);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.cZX, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.cZW);
        this.mPaint.setStrokeWidth(this.daa);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.daa / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.cZZ);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.daa);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.abb.set(this.bounds.left + (this.daa / 2), this.bounds.top + (this.daa / 2), this.bounds.right - (this.daa / 2), this.bounds.bottom - (this.daa / 2));
        canvas.drawArc(this.abb, 270.0f, (360.0f * this.progress) / this.dab, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dab = i;
        azZ();
    }

    public int getProgressTotalPart() {
        return this.dab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azY() {
        removeCallbacks(this.daf);
        switch (this.dac) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dab) {
            if (this.dae != null) {
                this.dae.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.daf, this.dad / this.dab);
            return;
        }
        this.progress = J(this.progress);
        if (this.dae != null) {
            this.dae.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.cZY = context.getResources().getColor(c.b.progress_circle_color);
        this.daf = new b(this);
    }

    private void azZ() {
        switch (this.dac) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dab;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float J(float f) {
        if (f > this.dab) {
            return this.dab;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dah;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dah = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dah.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.azY();
            }
        }
    }
}
