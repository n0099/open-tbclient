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
    private int chh;
    private int chi;
    private int chj;
    private int chk;
    private int chl;
    private int chm;
    private ProgressType chn;
    private long cho;
    private a chp;
    private b chq;
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
        this.chh = ViewCompat.MEASURED_STATE_MASK;
        this.chi = 2;
        this.chk = -16776961;
        this.chl = 8;
        this.mPaint = new Paint();
        this.Hb = new RectF();
        this.chm = 100;
        this.chn = ProgressType.COUNT;
        this.cho = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.chh = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.chi = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.chj = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.chk = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.chl = i;
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
        this.cho = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.cho;
    }

    public void setProgressType(ProgressType progressType) {
        this.chn = progressType;
        akh();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.chn;
    }

    public void setCountdownProgressListener(a aVar) {
        this.chp = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.chj);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.chi, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.chh);
        this.mPaint.setStrokeWidth(this.chl);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.chl / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.chk);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.chl);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.Hb.set(this.bounds.left + (this.chl / 2), this.bounds.top + (this.chl / 2), this.bounds.right - (this.chl / 2), this.bounds.bottom - (this.chl / 2));
        canvas.drawArc(this.Hb, 270.0f, (360.0f * this.progress) / this.chm, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.chm = i;
        akh();
    }

    public int getProgressTotalPart() {
        return this.chm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akg() {
        removeCallbacks(this.chq);
        switch (this.chn) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.chm) {
            if (this.chp != null) {
                this.chp.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.chq, this.cho / this.chm);
            return;
        }
        this.progress = Y(this.progress);
        if (this.chp != null) {
            this.chp.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.chj = context.getResources().getColor(c.b.progress_circle_color);
        this.chq = new b(this);
    }

    private void akh() {
        switch (this.chn) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.chm;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float Y(float f) {
        if (f > this.chm) {
            return this.chm;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> chs;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.chs = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.chs.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.akg();
            }
        }
    }
}
