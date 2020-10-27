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
    private RectF acv;
    final Rect bounds;
    private int dGa;
    private int dGb;
    private int dGc;
    private int dGd;
    private int dGe;
    private int dGf;
    private ProgressType dGg;
    private long dGh;
    private a dGi;
    private b dGj;
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
        this.dGa = ViewCompat.MEASURED_STATE_MASK;
        this.dGb = 2;
        this.dGd = -16776961;
        this.dGe = 8;
        this.mPaint = new Paint();
        this.acv = new RectF();
        this.dGf = 100;
        this.dGg = ProgressType.COUNT;
        this.dGh = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dGa = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dGb = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dGc = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dGd = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dGe = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = R(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dGh = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dGh;
    }

    public void setProgressType(ProgressType progressType) {
        this.dGg = progressType;
        aNA();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dGg;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dGi = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dGc);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dGb, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dGa);
        this.mPaint.setStrokeWidth(this.dGe);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dGe / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dGd);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dGe);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.acv.set(this.bounds.left + (this.dGe / 2), this.bounds.top + (this.dGe / 2), this.bounds.right - (this.dGe / 2), this.bounds.bottom - (this.dGe / 2));
        canvas.drawArc(this.acv, 270.0f, (360.0f * this.progress) / this.dGf, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dGf = i;
        aNA();
    }

    public int getProgressTotalPart() {
        return this.dGf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNz() {
        removeCallbacks(this.dGj);
        switch (this.dGg) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dGf) {
            if (this.dGi != null) {
                this.dGi.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dGj, this.dGh / this.dGf);
            return;
        }
        this.progress = R(this.progress);
        if (this.dGi != null) {
            this.dGi.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dGc = context.getResources().getColor(c.b.progress_circle_color);
        this.dGj = new b(this);
    }

    private void aNA() {
        switch (this.dGg) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dGf;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float R(float f) {
        if (f > this.dGf) {
            return this.dGf;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dGl;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dGl = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dGl.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aNz();
            }
        }
    }
}
