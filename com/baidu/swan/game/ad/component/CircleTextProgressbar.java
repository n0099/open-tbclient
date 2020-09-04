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
    private RectF abK;
    final Rect bounds;
    private int djA;
    private ProgressType djB;
    private long djC;
    private a djD;
    private b djE;
    private int djv;
    private int djw;
    private int djx;
    private int djy;
    private int djz;
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
        this.djv = ViewCompat.MEASURED_STATE_MASK;
        this.djw = 2;
        this.djy = -16776961;
        this.djz = 8;
        this.mPaint = new Paint();
        this.abK = new RectF();
        this.djA = 100;
        this.djB = ProgressType.COUNT;
        this.djC = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.djv = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.djw = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.djx = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.djy = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.djz = i;
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
        this.djC = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.djC;
    }

    public void setProgressType(ProgressType progressType) {
        this.djB = progressType;
        aIm();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.djB;
    }

    public void setCountdownProgressListener(a aVar) {
        this.djD = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.djx);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.djw, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.djv);
        this.mPaint.setStrokeWidth(this.djz);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.djz / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.djy);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.djz);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.abK.set(this.bounds.left + (this.djz / 2), this.bounds.top + (this.djz / 2), this.bounds.right - (this.djz / 2), this.bounds.bottom - (this.djz / 2));
        canvas.drawArc(this.abK, 270.0f, (360.0f * this.progress) / this.djA, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.djA = i;
        aIm();
    }

    public int getProgressTotalPart() {
        return this.djA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIl() {
        removeCallbacks(this.djE);
        switch (this.djB) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.djA) {
            if (this.djD != null) {
                this.djD.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.djE, this.djC / this.djA);
            return;
        }
        this.progress = N(this.progress);
        if (this.djD != null) {
            this.djD.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.djx = context.getResources().getColor(c.b.progress_circle_color);
        this.djE = new b(this);
    }

    private void aIm() {
        switch (this.djB) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.djA;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float N(float f) {
        if (f > this.djA) {
            return this.djA;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> djG;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.djG = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.djG.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aIl();
            }
        }
    }
}
