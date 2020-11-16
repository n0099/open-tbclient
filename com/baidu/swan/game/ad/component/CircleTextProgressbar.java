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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.game.ad.c;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF acB;
    final Rect bounds;
    private int dKk;
    private int dKl;
    private int dKm;
    private int dKn;
    private int dKo;
    private int dKp;
    private ProgressType dKq;
    private long dKr;
    private a dKs;
    private b dKt;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes12.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes12.dex */
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
        this.dKk = ViewCompat.MEASURED_STATE_MASK;
        this.dKl = 2;
        this.dKn = -16776961;
        this.dKo = 8;
        this.mPaint = new Paint();
        this.acB = new RectF();
        this.dKp = 100;
        this.dKq = ProgressType.COUNT;
        this.dKr = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dKk = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dKl = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dKm = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dKn = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dKo = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = S(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dKr = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dKr;
    }

    public void setProgressType(ProgressType progressType) {
        this.dKq = progressType;
        aPs();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dKq;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dKs = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dKm);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dKl, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dKk);
        this.mPaint.setStrokeWidth(this.dKo);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dKo / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dKn);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dKo);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.acB.set(this.bounds.left + (this.dKo / 2), this.bounds.top + (this.dKo / 2), this.bounds.right - (this.dKo / 2), this.bounds.bottom - (this.dKo / 2));
        canvas.drawArc(this.acB, 270.0f, (360.0f * this.progress) / this.dKp, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dKp = i;
        aPs();
    }

    public int getProgressTotalPart() {
        return this.dKp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPr() {
        removeCallbacks(this.dKt);
        switch (this.dKq) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dKp) {
            if (this.dKs != null) {
                this.dKs.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dKt, this.dKr / this.dKp);
            return;
        }
        this.progress = S(this.progress);
        if (this.dKs != null) {
            this.dKs.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dKm = context.getResources().getColor(c.b.progress_circle_color);
        this.dKt = new b(this);
    }

    private void aPs() {
        switch (this.dKq) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dKp;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float S(float f) {
        if (f > this.dKp) {
            return this.dKp;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dKv;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dKv = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dKv.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aPr();
            }
        }
    }
}
