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
import com.thunder.livesdk.system.ThunderNetStateService;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF aee;
    final Rect bounds;
    private int dXB;
    private int dXC;
    private int dXD;
    private int dXE;
    private int dXF;
    private int dXG;
    private ProgressType dXH;
    private long dXI;
    private a dXJ;
    private b dXK;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes5.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes5.dex */
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
        this.dXB = ViewCompat.MEASURED_STATE_MASK;
        this.dXC = 2;
        this.dXE = -16776961;
        this.dXF = 8;
        this.mPaint = new Paint();
        this.aee = new RectF();
        this.dXG = 100;
        this.dXH = ProgressType.COUNT;
        this.dXI = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        h(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dXB = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dXC = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dXD = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dXE = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dXF = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = V(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.dXI = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dXI;
    }

    public void setProgressType(ProgressType progressType) {
        this.dXH = progressType;
        aRo();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dXH;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dXJ = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dXD);
        this.mPaint.setAlpha(ThunderNetStateService.NetState.SYSNET_UNKNOWN);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dXC, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dXB);
        this.mPaint.setStrokeWidth(this.dXF);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dXF / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dXE);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dXF);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.aee.set(this.bounds.left + (this.dXF / 2), this.bounds.top + (this.dXF / 2), this.bounds.right - (this.dXF / 2), this.bounds.bottom - (this.dXF / 2));
        canvas.drawArc(this.aee, 270.0f, (360.0f * this.progress) / this.dXG, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dXG = i;
        aRo();
    }

    public int getProgressTotalPart() {
        return this.dXG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRn() {
        removeCallbacks(this.dXK);
        switch (this.dXH) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dXG) {
            if (this.dXJ != null) {
                this.dXJ.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dXK, this.dXI / this.dXG);
            return;
        }
        this.progress = V(this.progress);
        if (this.dXJ != null) {
            this.dXJ.onEnd();
        }
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dXD = context.getResources().getColor(c.b.progress_circle_color);
        this.dXK = new b(this);
    }

    private void aRo() {
        switch (this.dXH) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dXG;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float V(float f) {
        if (f > this.dXG) {
            return this.dXG;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> weakReference;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.weakReference = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.weakReference.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aRn();
            }
        }
    }
}
