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
/* loaded from: classes10.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF GF;
    final Rect bounds;
    private int cdd;
    private int cde;
    private int cdf;
    private int cdg;
    private int cdh;
    private int cdi;
    private ProgressType cdj;
    private long cdk;
    private a cdm;
    private b cdn;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes10.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes10.dex */
    public interface a {
        void Z(float f);

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
        this.cdd = ViewCompat.MEASURED_STATE_MASK;
        this.cde = 2;
        this.cdg = -16776961;
        this.cdh = 8;
        this.mPaint = new Paint();
        this.GF = new RectF();
        this.cdi = 100;
        this.cdj = ProgressType.COUNT;
        this.cdk = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.cdd = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.cde = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.cdf = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.cdg = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.cdh = i;
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
        this.cdk = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.cdk;
    }

    public void setProgressType(ProgressType progressType) {
        this.cdj = progressType;
        ahT();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.cdj;
    }

    public void setCountdownProgressListener(a aVar) {
        this.cdm = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.cdf);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.cde, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.cdd);
        this.mPaint.setStrokeWidth(this.cdh);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.cdh / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.cdg);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.cdh);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.GF.set(this.bounds.left + (this.cdh / 2), this.bounds.top + (this.cdh / 2), this.bounds.right - (this.cdh / 2), this.bounds.bottom - (this.cdh / 2));
        canvas.drawArc(this.GF, 270.0f, (360.0f * this.progress) / this.cdi, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.cdi = i;
        ahT();
    }

    public int getProgressTotalPart() {
        return this.cdi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahS() {
        removeCallbacks(this.cdn);
        switch (this.cdj) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.cdi) {
            if (this.cdm != null) {
                this.cdm.Z(this.progress);
            }
            invalidate();
            postDelayed(this.cdn, this.cdk / this.cdi);
            return;
        }
        this.progress = Y(this.progress);
        if (this.cdm != null) {
            this.cdm.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.cdf = context.getResources().getColor(c.b.progress_circle_color);
        this.cdn = new b(this);
    }

    private void ahT() {
        switch (this.cdj) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.cdi;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float Y(float f) {
        if (f > this.cdi) {
            return this.cdi;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cdp;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cdp = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cdp.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.ahS();
            }
        }
    }
}
