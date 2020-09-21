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
/* loaded from: classes10.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF acc;
    final Rect bounds;
    private int dlA;
    private int dlB;
    private int dlC;
    private ProgressType dlD;
    private long dlE;
    private a dlF;
    private b dlG;
    private int dlx;
    private int dly;
    private int dlz;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes10.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes10.dex */
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
        this.dlx = ViewCompat.MEASURED_STATE_MASK;
        this.dly = 2;
        this.dlA = -16776961;
        this.dlB = 8;
        this.mPaint = new Paint();
        this.acc = new RectF();
        this.dlC = 100;
        this.dlD = ProgressType.COUNT;
        this.dlE = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dlx = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dly = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dlz = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dlA = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dlB = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = N(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dlE = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dlE;
    }

    public void setProgressType(ProgressType progressType) {
        this.dlD = progressType;
        aIX();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dlD;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dlF = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dlz);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dly, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dlx);
        this.mPaint.setStrokeWidth(this.dlB);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dlB / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dlA);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dlB);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.acc.set(this.bounds.left + (this.dlB / 2), this.bounds.top + (this.dlB / 2), this.bounds.right - (this.dlB / 2), this.bounds.bottom - (this.dlB / 2));
        canvas.drawArc(this.acc, 270.0f, (360.0f * this.progress) / this.dlC, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dlC = i;
        aIX();
    }

    public int getProgressTotalPart() {
        return this.dlC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        removeCallbacks(this.dlG);
        switch (this.dlD) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dlC) {
            if (this.dlF != null) {
                this.dlF.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dlG, this.dlE / this.dlC);
            return;
        }
        this.progress = N(this.progress);
        if (this.dlF != null) {
            this.dlF.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dlz = context.getResources().getColor(c.b.progress_circle_color);
        this.dlG = new b(this);
    }

    private void aIX() {
        switch (this.dlD) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dlC;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float N(float f) {
        if (f > this.dlC) {
            return this.dlC;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dlI;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dlI = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dlI.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aIW();
            }
        }
    }
}
