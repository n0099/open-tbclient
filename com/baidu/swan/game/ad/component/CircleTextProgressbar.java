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
    private RectF aaj;
    final Rect bounds;
    private int cGq;
    private int cGr;
    private int cGs;
    private int cGt;
    private int cGu;
    private int cGv;
    private ProgressType cGw;
    private long cGx;
    private a cGy;
    private b cGz;
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
        this.cGq = ViewCompat.MEASURED_STATE_MASK;
        this.cGr = 2;
        this.cGt = -16776961;
        this.cGu = 8;
        this.mPaint = new Paint();
        this.aaj = new RectF();
        this.cGv = 100;
        this.cGw = ProgressType.COUNT;
        this.cGx = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.cGq = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.cGr = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.cGs = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.cGt = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.cGu = i;
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
        this.cGx = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.cGx;
    }

    public void setProgressType(ProgressType progressType) {
        this.cGw = progressType;
        asx();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.cGw;
    }

    public void setCountdownProgressListener(a aVar) {
        this.cGy = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.cGs);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.cGr, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.cGq);
        this.mPaint.setStrokeWidth(this.cGu);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.cGu / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.cGt);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.cGu);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.aaj.set(this.bounds.left + (this.cGu / 2), this.bounds.top + (this.cGu / 2), this.bounds.right - (this.cGu / 2), this.bounds.bottom - (this.cGu / 2));
        canvas.drawArc(this.aaj, 270.0f, (360.0f * this.progress) / this.cGv, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.cGv = i;
        asx();
    }

    public int getProgressTotalPart() {
        return this.cGv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asw() {
        removeCallbacks(this.cGz);
        switch (this.cGw) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.cGv) {
            if (this.cGy != null) {
                this.cGy.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.cGz, this.cGx / this.cGv);
            return;
        }
        this.progress = I(this.progress);
        if (this.cGy != null) {
            this.cGy.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.cGs = context.getResources().getColor(c.b.progress_circle_color);
        this.cGz = new b(this);
    }

    private void asx() {
        switch (this.cGw) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.cGv;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float I(float f) {
        if (f > this.cGv) {
            return this.cGv;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cGB;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cGB = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cGB.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.asw();
            }
        }
    }
}
