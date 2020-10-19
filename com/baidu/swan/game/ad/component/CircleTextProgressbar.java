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
    private RectF acu;
    final Rect bounds;
    private int dxD;
    private int dxE;
    private int dxF;
    private int dxG;
    private int dxH;
    private int dxI;
    private ProgressType dxJ;
    private long dxK;
    private a dxL;
    private b dxM;
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
        this.dxD = ViewCompat.MEASURED_STATE_MASK;
        this.dxE = 2;
        this.dxG = -16776961;
        this.dxH = 8;
        this.mPaint = new Paint();
        this.acu = new RectF();
        this.dxI = 100;
        this.dxJ = ProgressType.COUNT;
        this.dxK = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dxD = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dxE = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dxF = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dxG = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dxH = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = P(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dxK = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dxK;
    }

    public void setProgressType(ProgressType progressType) {
        this.dxJ = progressType;
        aLG();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dxJ;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dxL = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dxF);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dxE, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dxD);
        this.mPaint.setStrokeWidth(this.dxH);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dxH / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dxG);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dxH);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.acu.set(this.bounds.left + (this.dxH / 2), this.bounds.top + (this.dxH / 2), this.bounds.right - (this.dxH / 2), this.bounds.bottom - (this.dxH / 2));
        canvas.drawArc(this.acu, 270.0f, (360.0f * this.progress) / this.dxI, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dxI = i;
        aLG();
    }

    public int getProgressTotalPart() {
        return this.dxI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLF() {
        removeCallbacks(this.dxM);
        switch (this.dxJ) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dxI) {
            if (this.dxL != null) {
                this.dxL.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dxM, this.dxK / this.dxI);
            return;
        }
        this.progress = P(this.progress);
        if (this.dxL != null) {
            this.dxL.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dxF = context.getResources().getColor(c.b.progress_circle_color);
        this.dxM = new b(this);
    }

    private void aLG() {
        switch (this.dxJ) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dxI;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float P(float f) {
        if (f > this.dxI) {
            return this.dxI;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> dxO;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.dxO = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.dxO.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aLF();
            }
        }
    }
}
