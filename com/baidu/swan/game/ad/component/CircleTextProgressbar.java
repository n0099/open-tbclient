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
    private int dLS;
    private int dLT;
    private int dLU;
    private int dLV;
    private int dLW;
    private int dLX;
    private ProgressType dLY;
    private long dLZ;
    private a dMa;
    private b dMb;
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
        this.dLS = ViewCompat.MEASURED_STATE_MASK;
        this.dLT = 2;
        this.dLV = -16776961;
        this.dLW = 8;
        this.mPaint = new Paint();
        this.acv = new RectF();
        this.dLX = 100;
        this.dLY = ProgressType.COUNT;
        this.dLZ = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dLS = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dLT = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dLU = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dLV = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dLW = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = T(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dLZ = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dLZ;
    }

    public void setProgressType(ProgressType progressType) {
        this.dLY = progressType;
        aQa();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dLY;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dMa = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dLU);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dLT, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dLS);
        this.mPaint.setStrokeWidth(this.dLW);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dLW / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dLV);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dLW);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.acv.set(this.bounds.left + (this.dLW / 2), this.bounds.top + (this.dLW / 2), this.bounds.right - (this.dLW / 2), this.bounds.bottom - (this.dLW / 2));
        canvas.drawArc(this.acv, 270.0f, (360.0f * this.progress) / this.dLX, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dLX = i;
        aQa();
    }

    public int getProgressTotalPart() {
        return this.dLX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPZ() {
        removeCallbacks(this.dMb);
        switch (this.dLY) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dLX) {
            if (this.dMa != null) {
                this.dMa.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dMb, this.dLZ / this.dLX);
            return;
        }
        this.progress = T(this.progress);
        if (this.dMa != null) {
            this.dMa.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dLU = context.getResources().getColor(c.b.progress_circle_color);
        this.dMb = new b(this);
    }

    private void aQa() {
        switch (this.dLY) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dLX;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float T(float f) {
        if (f > this.dLX) {
            return this.dLX;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dMd;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dMd = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dMd.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aPZ();
            }
        }
    }
}
