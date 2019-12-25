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
/* loaded from: classes9.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF Gz;
    final Rect bounds;
    private int ccR;
    private int ccS;
    private int ccT;
    private int ccU;
    private int ccV;
    private int ccW;
    private ProgressType ccX;
    private long ccY;
    private a ccZ;
    private b cda;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes9.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes9.dex */
    public interface a {
        void aa(float f);

        void onEnd();
    }

    public CircleTextProgressbar(Context context) {
        this(context, null);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccR = ViewCompat.MEASURED_STATE_MASK;
        this.ccS = 2;
        this.ccU = -16776961;
        this.ccV = 8;
        this.mPaint = new Paint();
        this.Gz = new RectF();
        this.ccW = 100;
        this.ccX = ProgressType.COUNT;
        this.ccY = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.ccR = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.ccS = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.ccT = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.ccU = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.ccV = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = Z(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.ccY = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.ccY;
    }

    public void setProgressType(ProgressType progressType) {
        this.ccX = progressType;
        ahA();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.ccX;
    }

    public void setCountdownProgressListener(a aVar) {
        this.ccZ = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.ccT);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.ccS, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.ccR);
        this.mPaint.setStrokeWidth(this.ccV);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.ccV / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.ccU);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.ccV);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.Gz.set(this.bounds.left + (this.ccV / 2), this.bounds.top + (this.ccV / 2), this.bounds.right - (this.ccV / 2), this.bounds.bottom - (this.ccV / 2));
        canvas.drawArc(this.Gz, 270.0f, (360.0f * this.progress) / this.ccW, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.ccW = i;
        ahA();
    }

    public int getProgressTotalPart() {
        return this.ccW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahz() {
        removeCallbacks(this.cda);
        switch (this.ccX) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.ccW) {
            if (this.ccZ != null) {
                this.ccZ.aa(this.progress);
            }
            invalidate();
            postDelayed(this.cda, this.ccY / this.ccW);
            return;
        }
        this.progress = Z(this.progress);
        if (this.ccZ != null) {
            this.ccZ.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.ccT = context.getResources().getColor(c.b.progress_circle_color);
        this.cda = new b(this);
    }

    private void ahA() {
        switch (this.ccX) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.ccW;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float Z(float f) {
        if (f > this.ccW) {
            return this.ccW;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cdc;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cdc = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cdc.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.ahz();
            }
        }
    }
}
