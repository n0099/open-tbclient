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
    private RectF afw;
    final Rect bounds;
    private int dZc;
    private int dZd;
    private int dZe;
    private int dZf;
    private int dZg;
    private int dZh;
    private ProgressType dZi;
    private long dZj;
    private a dZk;
    private b dZl;
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
        this.dZc = ViewCompat.MEASURED_STATE_MASK;
        this.dZd = 2;
        this.dZf = -16776961;
        this.dZg = 8;
        this.mPaint = new Paint();
        this.afw = new RectF();
        this.dZh = 100;
        this.dZi = ProgressType.COUNT;
        this.dZj = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        h(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.dZc = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.dZd = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.dZe = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.dZf = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.dZg = i;
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
        this.dZj = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.dZj;
    }

    public void setProgressType(ProgressType progressType) {
        this.dZi = progressType;
        aRr();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.dZi;
    }

    public void setCountdownProgressListener(a aVar) {
        this.dZk = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.dZe);
        this.mPaint.setAlpha(ThunderNetStateService.NetState.SYSNET_UNKNOWN);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.dZd, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.dZc);
        this.mPaint.setStrokeWidth(this.dZg);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.dZg / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.dZf);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.dZg);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.afw.set(this.bounds.left + (this.dZg / 2), this.bounds.top + (this.dZg / 2), this.bounds.right - (this.dZg / 2), this.bounds.bottom - (this.dZg / 2));
        canvas.drawArc(this.afw, 270.0f, (360.0f * this.progress) / this.dZh, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.dZh = i;
        aRr();
    }

    public int getProgressTotalPart() {
        return this.dZh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRq() {
        removeCallbacks(this.dZl);
        switch (this.dZi) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.dZh) {
            if (this.dZk != null) {
                this.dZk.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.dZl, this.dZj / this.dZh);
            return;
        }
        this.progress = Z(this.progress);
        if (this.dZk != null) {
            this.dZk.onEnd();
        }
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.dZe = context.getResources().getColor(c.b.progress_circle_color);
        this.dZl = new b(this);
    }

    private void aRr() {
        switch (this.dZi) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.dZh;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float Z(float f) {
        if (f > this.dZh) {
            return this.dZh;
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
                circleTextProgressbar.aRq();
            }
        }
    }
}
