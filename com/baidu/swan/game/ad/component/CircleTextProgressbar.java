package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.game.ad.c;
import java.lang.ref.WeakReference;
/* loaded from: classes14.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF ael;
    final Rect bounds;
    private long dVA;
    private a dVB;
    private b dVC;
    private int dVt;
    private int dVu;
    private int dVv;
    private int dVw;
    private int dVx;
    private int dVy;
    private ProgressType dVz;
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
        this.dVt = ViewCompat.MEASURED_STATE_MASK;
        this.dVu = 2;
        this.dVw = -16776961;
        this.dVx = 8;
        this.mPaint = new Paint();
        this.ael = new RectF();
        this.dVy = 100;
        this.dVz = ProgressType.COUNT;
        this.dVA = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        h(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dVt = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dVu = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dVv = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dVw = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dVx = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = U(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dVA = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dVA;
    }

    public void setProgressType(ProgressType progressType) {
        this.dVz = progressType;
        aQY();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dVz;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dVB = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dVv);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dVu, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dVt);
        this.mPaint.setStrokeWidth(this.dVx);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dVx / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dVw);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dVx);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.ael.set(this.bounds.left + (this.dVx / 2), this.bounds.top + (this.dVx / 2), this.bounds.right - (this.dVx / 2), this.bounds.bottom - (this.dVx / 2));
        canvas.drawArc(this.ael, 270.0f, (360.0f * this.progress) / this.dVy, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dVy = i;
        aQY();
    }

    public int getProgressTotalPart() {
        return this.dVy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQX() {
        removeCallbacks(this.dVC);
        switch (this.dVz) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dVy) {
            if (this.dVB != null) {
                this.dVB.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dVC, this.dVA / this.dVy);
            return;
        }
        this.progress = U(this.progress);
        if (this.dVB != null) {
            this.dVB.onEnd();
        }
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dVv = context.getResources().getColor(c.b.progress_circle_color);
        this.dVC = new b(this);
    }

    private void aQY() {
        switch (this.dVz) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dVy;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float U(float f) {
        if (f > this.dVy) {
            return this.dVy;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> weakReference;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.weakReference = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.weakReference.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aQX();
            }
        }
    }
}
