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
/* loaded from: classes11.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF aam;
    final Rect bounds;
    private int cGA;
    private int cGB;
    private ProgressType cGC;
    private long cGD;
    private a cGE;
    private b cGF;
    private int cGw;
    private int cGx;
    private int cGy;
    private int cGz;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes11.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes11.dex */
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
        this.cGw = ViewCompat.MEASURED_STATE_MASK;
        this.cGx = 2;
        this.cGz = -16776961;
        this.cGA = 8;
        this.mPaint = new Paint();
        this.aam = new RectF();
        this.cGB = 100;
        this.cGC = ProgressType.COUNT;
        this.cGD = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.cGw = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.cGx = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.cGy = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.cGz = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.cGA = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = I(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.cGD = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.cGD;
    }

    public void setProgressType(ProgressType progressType) {
        this.cGC = progressType;
        asw();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.cGC;
    }

    public void setCountdownProgressListener(a aVar) {
        this.cGE = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.cGy);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.cGx, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.cGw);
        this.mPaint.setStrokeWidth(this.cGA);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.cGA / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.cGz);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.cGA);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.aam.set(this.bounds.left + (this.cGA / 2), this.bounds.top + (this.cGA / 2), this.bounds.right - (this.cGA / 2), this.bounds.bottom - (this.cGA / 2));
        canvas.drawArc(this.aam, 270.0f, (360.0f * this.progress) / this.cGB, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.cGB = i;
        asw();
    }

    public int getProgressTotalPart() {
        return this.cGB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asv() {
        removeCallbacks(this.cGF);
        switch (this.cGC) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.cGB) {
            if (this.cGE != null) {
                this.cGE.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.cGF, this.cGD / this.cGB);
            return;
        }
        this.progress = I(this.progress);
        if (this.cGE != null) {
            this.cGE.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.cGy = context.getResources().getColor(c.b.progress_circle_color);
        this.cGF = new b(this);
    }

    private void asw() {
        switch (this.cGC) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.cGB;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float I(float f) {
        if (f > this.cGB) {
            return this.cGB;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cGH;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cGH = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cGH.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.asv();
            }
        }
    }
}
