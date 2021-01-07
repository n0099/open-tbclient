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
/* loaded from: classes3.dex */
public class CircleTextProgressbar extends AppCompatTextView {
    private RectF aen;
    final Rect bounds;
    private int eaf;
    private int eag;
    private int eah;
    private int eai;
    private int eaj;
    private int eak;
    private ProgressType eal;
    private long eam;
    private a ean;
    private b eao;
    private Paint mPaint;
    private float progress;

    /* loaded from: classes3.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    /* loaded from: classes3.dex */
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
        this.eaf = ViewCompat.MEASURED_STATE_MASK;
        this.eag = 2;
        this.eai = -16776961;
        this.eaj = 8;
        this.mPaint = new Paint();
        this.aen = new RectF();
        this.eak = 100;
        this.eal = ProgressType.COUNT;
        this.eam = IMConnection.RETRY_DELAY_TIMES;
        this.bounds = new Rect();
        h(context, attributeSet);
    }

    public void setOutLineColor(int i) {
        this.eaf = i;
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.eag = i;
        invalidate();
    }

    public void setInCircleColor(int i) {
        this.eah = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.eai = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.eaj = i;
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
        this.eam = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.eam;
    }

    public void setProgressType(ProgressType progressType) {
        this.eal = progressType;
        aUS();
        invalidate();
    }

    public ProgressType getProgressType() {
        return this.eal;
    }

    public void setCountdownProgressListener(a aVar) {
        this.ean = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.eah);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.eag, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.eaf);
        this.mPaint.setStrokeWidth(this.eaj);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.eaj / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.eai);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.eaj);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        this.aen.set(this.bounds.left + (this.eaj / 2), this.bounds.top + (this.eaj / 2), this.bounds.right - (this.eaj / 2), this.bounds.bottom - (this.eaj / 2));
        canvas.drawArc(this.aen, 270.0f, (360.0f * this.progress) / this.eak, false, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgressTotalPart(int i) {
        this.eak = i;
        aUS();
    }

    public int getProgressTotalPart() {
        return this.eak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUR() {
        removeCallbacks(this.eao);
        switch (this.eal) {
            case COUNT:
                this.progress += 1.0f;
                break;
            case COUNT_BACK:
                this.progress -= 1.0f;
                break;
        }
        if (this.progress >= 0.0f && this.progress <= this.eak) {
            if (this.ean != null) {
                this.ean.onProgress(this.progress);
            }
            invalidate();
            postDelayed(this.eao, this.eam / this.eak);
            return;
        }
        this.progress = U(this.progress);
        if (this.ean != null) {
            this.ean.onEnd();
        }
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        this.eah = context.getResources().getColor(c.b.progress_circle_color);
        this.eao = new b(this);
    }

    private void aUS() {
        switch (this.eal) {
            case COUNT:
                this.progress = 0.0f;
                return;
            case COUNT_BACK:
                this.progress = this.eak;
                return;
            default:
                this.progress = 0.0f;
                return;
        }
    }

    private float U(float f) {
        if (f > this.eak) {
            return this.eak;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private WeakReference<CircleTextProgressbar> weakReference;

        b(CircleTextProgressbar circleTextProgressbar) {
            this.weakReference = new WeakReference<>(circleTextProgressbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleTextProgressbar circleTextProgressbar = this.weakReference.get();
            if (circleTextProgressbar != null) {
                circleTextProgressbar.aUR();
            }
        }
    }
}
