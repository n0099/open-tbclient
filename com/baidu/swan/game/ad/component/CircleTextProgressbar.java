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
/* loaded from: classes19.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF abI;
    final Rect bounds;
    private b djA;
    private int djr;
    private int djs;
    private int djt;
    private int dju;
    private int djv;
    private int djw;
    private ProgressType djx;
    private long djy;
    private a djz;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes19.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes19.dex */
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
        this.djr = ViewCompat.MEASURED_STATE_MASK;
        this.djs = 2;
        this.dju = -16776961;
        this.djv = 8;
        this.mPaint = new Paint();
        this.abI = new RectF();
        this.djw = 100;
        this.djx = ProgressType.COUNT;
        this.djy = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.djr = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.djs = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.djt = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dju = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.djv = i;
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
        this.djy = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.djy;
    }

    public void setProgressType(ProgressType progressType) {
        this.djx = progressType;
        aIm();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.djx;
    }

    public void setCountdownProgressListener(a aVar) {
        this.djz = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.djt);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.djs, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.djr);
        this.mPaint.setStrokeWidth(this.djv);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.djv / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dju);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.djv);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.abI.set(this.bounds.left + (this.djv / 2), this.bounds.top + (this.djv / 2), this.bounds.right - (this.djv / 2), this.bounds.bottom - (this.djv / 2));
        canvas.drawArc(this.abI, 270.0f, (360.0f * this.progress) / this.djw, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.djw = i;
        aIm();
    }

    public int getProgressTotalPart() {
        return this.djw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIl() {
        removeCallbacks(this.djA);
        switch (this.djx) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.djw) {
            if (this.djz != null) {
                this.djz.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.djA, this.djy / this.djw);
            return;
        }
        this.progress = N(this.progress);
        if (this.djz != null) {
            this.djz.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.djt = context.getResources().getColor(c.b.progress_circle_color);
        this.djA = new b(this);
    }

    private void aIm() {
        switch (this.djx) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.djw;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float N(float f) {
        if (f > this.djw) {
            return this.djw;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> djC;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.djC = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.djC.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aIl();
            }
        }
    }
}
