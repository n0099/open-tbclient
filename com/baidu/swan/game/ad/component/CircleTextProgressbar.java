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
/* loaded from: classes14.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF adx;
    final Rect bounds;
    private int dRi;
    private int dRj;
    private int dRk;
    private int dRl;
    private int dRm;
    private int dRn;
    private ProgressType dRo;
    private long dRp;
    private a dRq;
    private b dRr;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes14.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes14.dex */
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
        this.dRi = ViewCompat.MEASURED_STATE_MASK;
        this.dRj = 2;
        this.dRl = -16776961;
        this.dRm = 8;
        this.mPaint = new Paint();
        this.adx = new RectF();
        this.dRn = 100;
        this.dRo = ProgressType.COUNT;
        this.dRp = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dRi = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dRj = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dRk = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dRl = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dRm = i;
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
        this.dRp = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dRp;
    }

    public void setProgressType(ProgressType progressType) {
        this.dRo = progressType;
        aSx();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dRo;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dRq = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dRk);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dRj, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dRi);
        this.mPaint.setStrokeWidth(this.dRm);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dRm / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dRl);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dRm);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.adx.set(this.bounds.left + (this.dRm / 2), this.bounds.top + (this.dRm / 2), this.bounds.right - (this.dRm / 2), this.bounds.bottom - (this.dRm / 2));
        canvas.drawArc(this.adx, 270.0f, (360.0f * this.progress) / this.dRn, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dRn = i;
        aSx();
    }

    public int getProgressTotalPart() {
        return this.dRn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSw() {
        removeCallbacks(this.dRr);
        switch (this.dRo) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dRn) {
            if (this.dRq != null) {
                this.dRq.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dRr, this.dRp / this.dRn);
            return;
        }
        this.progress = S(this.progress);
        if (this.dRq != null) {
            this.dRq.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dRk = context.getResources().getColor(c.b.progress_circle_color);
        this.dRr = new b(this);
    }

    private void aSx() {
        switch (this.dRo) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dRn;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float S(float f) {
        if (f > this.dRn) {
            return this.dRn;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dRt;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dRt = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dRt.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aSw();
            }
        }
    }
}
