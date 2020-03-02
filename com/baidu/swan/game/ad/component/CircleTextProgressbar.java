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
    private RectF Hb;
    final Rect bounds;
    private int chi;
    private int chj;
    private int chk;
    private int chl;
    private int chm;
    private int chn;
    private ProgressType cho;
    private long chp;
    private a chq;
    private b chr;
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
        this.chi = ViewCompat.MEASURED_STATE_MASK;
        this.chj = 2;
        this.chl = -16776961;
        this.chm = 8;
        this.mPaint = new Paint();
        this.Hb = new RectF();
        this.chn = 100;
        this.cho = ProgressType.COUNT;
        this.chp = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.chi = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.chj = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.chk = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.chl = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.chm = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = Y(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.chp = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.chp;
    }

    public void setProgressType(ProgressType progressType) {
        this.cho = progressType;
        akj();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.cho;
    }

    public void setCountdownProgressListener(a aVar) {
        this.chq = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.chk);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.chj, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.chi);
        this.mPaint.setStrokeWidth(this.chm);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.chm / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.chl);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.chm);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.Hb.set(this.bounds.left + (this.chm / 2), this.bounds.top + (this.chm / 2), this.bounds.right - (this.chm / 2), this.bounds.bottom - (this.chm / 2));
        canvas.drawArc(this.Hb, 270.0f, (360.0f * this.progress) / this.chn, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.chn = i;
        akj();
    }

    public int getProgressTotalPart() {
        return this.chn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aki() {
        removeCallbacks(this.chr);
        switch (this.cho) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.chn) {
            if (this.chq != null) {
                this.chq.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.chr, this.chp / this.chn);
            return;
        }
        this.progress = Y(this.progress);
        if (this.chq != null) {
            this.chq.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.chk = context.getResources().getColor(c.b.progress_circle_color);
        this.chr = new b(this);
    }

    private void akj() {
        switch (this.cho) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.chn;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float Y(float f) {
        if (f > this.chn) {
            return this.chn;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cht;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cht = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cht.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aki();
            }
        }
    }
}
