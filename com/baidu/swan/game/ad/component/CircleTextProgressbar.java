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
    private RectF abh;
    final Rect bounds;
    private int cVq;
    private int cVr;
    private int cVs;
    private int cVt;
    private int cVu;
    private int cVv;
    private ProgressType cVw;
    private long cVx;
    private a cVy;
    private b cVz;
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
        this.cVq = ViewCompat.MEASURED_STATE_MASK;
        this.cVr = 2;
        this.cVt = -16776961;
        this.cVu = 8;
        this.mPaint = new Paint();
        this.abh = new RectF();
        this.cVv = 100;
        this.cVw = ProgressType.COUNT;
        this.cVx = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.cVq = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.cVr = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.cVs = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.cVt = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.cVu = i;
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
        this.cVx = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.cVx;
    }

    public void setProgressType(ProgressType progressType) {
        this.cVw = progressType;
        axj();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.cVw;
    }

    public void setCountdownProgressListener(a aVar) {
        this.cVy = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.cVs);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.cVr, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.cVq);
        this.mPaint.setStrokeWidth(this.cVu);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.cVu / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.cVt);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.cVu);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.abh.set(this.bounds.left + (this.cVu / 2), this.bounds.top + (this.cVu / 2), this.bounds.right - (this.cVu / 2), this.bounds.bottom - (this.cVu / 2));
        canvas.drawArc(this.abh, 270.0f, (360.0f * this.progress) / this.cVv, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.cVv = i;
        axj();
    }

    public int getProgressTotalPart() {
        return this.cVv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axi() {
        removeCallbacks(this.cVz);
        switch (this.cVw) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.cVv) {
            if (this.cVy != null) {
                this.cVy.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.cVz, this.cVx / this.cVv);
            return;
        }
        this.progress = J(this.progress);
        if (this.cVy != null) {
            this.cVy.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.cVs = context.getResources().getColor(c.b.progress_circle_color);
        this.cVz = new b(this);
    }

    private void axj() {
        switch (this.cVw) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.cVv;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float J(float f) {
        if (f > this.cVv) {
            return this.cVv;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cVB;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cVB = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cVB.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.axi();
            }
        }
    }
}
