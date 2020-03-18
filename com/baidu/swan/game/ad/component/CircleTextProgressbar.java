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
/* loaded from: classes11.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF Hb;
    final Rect bounds;
    private ProgressType chA;
    private long chB;
    private a chC;
    private b chD;
    private int chu;
    private int chv;
    private int chw;
    private int chx;
    private int chy;
    private int chz;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes11.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes11.dex */
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
        this.chu = ViewCompat.MEASURED_STATE_MASK;
        this.chv = 2;
        this.chx = -16776961;
        this.chy = 8;
        this.mPaint = new Paint();
        this.Hb = new RectF();
        this.chz = 100;
        this.chA = ProgressType.COUNT;
        this.chB = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.chu = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.chv = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.chw = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.chx = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.chy = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = Y(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.chB = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.chB;
    }

    public void setProgressType(ProgressType progressType) {
        this.chA = progressType;
        akm();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.chA;
    }

    public void setCountdownProgressListener(a aVar) {
        this.chC = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.chw);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.chv, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.chu);
        this.mPaint.setStrokeWidth(this.chy);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.chy / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.chx);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.chy);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.Hb.set(this.bounds.left + (this.chy / 2), this.bounds.top + (this.chy / 2), this.bounds.right - (this.chy / 2), this.bounds.bottom - (this.chy / 2));
        canvas.drawArc(this.Hb, 270.0f, (360.0f * this.progress) / this.chz, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.chz = i;
        akm();
    }

    public int getProgressTotalPart() {
        return this.chz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        removeCallbacks(this.chD);
        switch (this.chA) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.chz) {
            if (this.chC != null) {
                this.chC.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.chD, this.chB / this.chz);
            return;
        }
        this.progress = Y(this.progress);
        if (this.chC != null) {
            this.chC.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.chw = context.getResources().getColor(c.b.progress_circle_color);
        this.chD = new b(this);
    }

    private void akm() {
        switch (this.chA) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.chz;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float Y(float f) {
        if (f > this.chz) {
            return this.chz;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> chF;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.chF = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.chF.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.akl();
            }
        }
    }
}
