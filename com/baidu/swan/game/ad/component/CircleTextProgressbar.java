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
    private RectF aaC;
    final Rect bounds;
    private int cQG;
    private int cQH;
    private int cQI;
    private int cQJ;
    private int cQK;
    private int cQL;
    private ProgressType cQM;
    private long cQN;
    private a cQO;
    private b cQP;
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
        this.cQG = ViewCompat.MEASURED_STATE_MASK;
        this.cQH = 2;
        this.cQJ = -16776961;
        this.cQK = 8;
        this.mPaint = new Paint();
        this.aaC = new RectF();
        this.cQL = 100;
        this.cQM = ProgressType.COUNT;
        this.cQN = 3000L;
        this.bounds = new Rect();
        g(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.cQG = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.cQH = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.cQI = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.cQJ = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.cQK = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.progress = H(f);
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setTimeMillis(long j) {
        this.cQN = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.cQN;
    }

    public void setProgressType(ProgressType progressType) {
        this.cQM = progressType;
        awd();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.cQM;
    }

    public void setCountdownProgressListener(a aVar) {
        this.cQO = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.cQI);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.cQH, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.cQG);
        this.mPaint.setStrokeWidth(this.cQK);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.cQK / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.cQJ);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.cQK);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.aaC.set(this.bounds.left + (this.cQK / 2), this.bounds.top + (this.cQK / 2), this.bounds.right - (this.cQK / 2), this.bounds.bottom - (this.cQK / 2));
        canvas.drawArc(this.aaC, 270.0f, (360.0f * this.progress) / this.cQL, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.cQL = i;
        awd();
    }

    public int getProgressTotalPart() {
        return this.cQL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awc() {
        removeCallbacks(this.cQP);
        switch (this.cQM) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.cQL) {
            if (this.cQO != null) {
                this.cQO.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.cQP, this.cQN / this.cQL);
            return;
        }
        this.progress = H(this.progress);
        if (this.cQO != null) {
            this.cQO.onEnd();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.cQI = context.getResources().getColor(c.b.progress_circle_color);
        this.cQP = new b(this);
    }

    private void awd() {
        switch (this.cQM) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.cQL;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float H(float f) {
        if (f > this.cQL) {
            return this.cQL;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> cQR;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.cQR = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.cQR.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.awc();
            }
        }
    }
}
