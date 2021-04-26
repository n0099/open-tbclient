package com.baidu.mobads.container.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class CircleTextProgressbar extends TextView {
    public final Rect bounds;
    public int circleColor;
    public ColorStateList inCircleColors;
    public RectF mArcRect;
    public BaseTask mBaseTask;
    public OnCountdownProgressListener mCountdownProgressListener;
    public Paint mPaint;
    public int mProgressTotalPart;
    public ProgressType mProgressType;
    public int outLineColor;
    public int outLineWidth;
    public int progress;
    public int progressLineColor;
    public int progressLineWidth;
    public long timeMillis;

    /* renamed from: com.baidu.mobads.container.components.CircleTextProgressbar$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType;

        static {
            int[] iArr = new int[ProgressType.values().length];
            $SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType[ProgressType.COUNT_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnCountdownProgressListener {
        void onEnd();

        void onProgress(int i2);
    }

    /* loaded from: classes2.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    public CircleTextProgressbar(Context context) {
        this(context, null);
    }

    private void executeTimer() {
        this.mBaseTask = new BaseTask() { // from class: com.baidu.mobads.container.components.CircleTextProgressbar.1
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                CircleTextProgressbar.this.updateProTask();
                return null;
            }
        };
        TaskScheduler.getInstance().submitAtFixedRate(this.mBaseTask, 0L, this.timeMillis / this.mProgressTotalPart, TimeUnit.MILLISECONDS);
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        this.mPaint.setAntiAlias(true);
        ColorStateList valueOf = ColorStateList.valueOf(0);
        this.inCircleColors = valueOf;
        this.circleColor = valueOf.getColorForState(getDrawableState(), 0);
    }

    private void resetProgress() {
        int i2 = AnonymousClass2.$SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType[this.mProgressType.ordinal()];
        if (i2 == 1) {
            this.progress = 0;
        } else if (i2 != 2) {
            this.progress = 0;
        } else {
            this.progress = this.mProgressTotalPart;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProTask() {
        int i2 = AnonymousClass2.$SwitchMap$com$baidu$mobads$container$components$CircleTextProgressbar$ProgressType[this.mProgressType.ordinal()];
        if (i2 == 1) {
            this.progress++;
        } else if (i2 == 2) {
            this.progress--;
        }
        int i3 = this.progress;
        if (i3 >= 0 && i3 <= this.mProgressTotalPart) {
            OnCountdownProgressListener onCountdownProgressListener = this.mCountdownProgressListener;
            if (onCountdownProgressListener != null) {
                onCountdownProgressListener.onProgress(i3);
            }
            postInvalidate();
            return;
        }
        this.progress = validateProgress(this.progress);
        OnCountdownProgressListener onCountdownProgressListener2 = this.mCountdownProgressListener;
        if (onCountdownProgressListener2 != null) {
            onCountdownProgressListener2.onEnd();
        }
        stop();
    }

    private void validateCircleColor() {
        int colorForState = this.inCircleColors.getColorForState(getDrawableState(), 0);
        if (this.circleColor != colorForState) {
            this.circleColor = colorForState;
            invalidate();
        }
    }

    private int validateProgress(int i2) {
        int i3 = this.mProgressTotalPart;
        if (i2 > i3) {
            return i3;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        validateCircleColor();
    }

    public int getProgress() {
        return this.progress;
    }

    public ProgressType getProgressType() {
        return this.mProgressType;
    }

    public long getTimeMillis() {
        return this.timeMillis;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        getDrawingRect(this.bounds);
        float width = (this.bounds.height() > this.bounds.width() ? this.bounds.width() : this.bounds.height()) / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.outLineColor);
        this.mPaint.setAlpha(127);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - this.outLineWidth, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.outLineColor);
        this.mPaint.setStrokeWidth(this.progressLineWidth);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        canvas.drawCircle(this.bounds.centerX(), this.bounds.centerY(), width - (this.progressLineWidth / 2), this.mPaint);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.bounds.centerX(), this.bounds.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.mPaint.setColor(this.progressLineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.progressLineWidth);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAlpha(204);
        RectF rectF = this.mArcRect;
        int i2 = this.bounds.left;
        int i3 = this.progressLineWidth;
        rectF.set(i2 + (i3 / 2), rect.top + (i3 / 2), rect.right - (i3 / 2), rect.bottom - (i3 / 2));
        canvas.drawArc(this.mArcRect, 270.0f, (this.progress * 360) / this.mProgressTotalPart, false, this.mPaint);
    }

    public void reStart() {
        resetProgress();
        start();
    }

    public void setCountdownProgressListener(OnCountdownProgressListener onCountdownProgressListener) {
        this.mCountdownProgressListener = onCountdownProgressListener;
    }

    public void setInCircleColor(int i2) {
        this.inCircleColors = ColorStateList.valueOf(i2);
        invalidate();
    }

    public void setOutLineColor(int i2) {
        this.outLineColor = i2;
        invalidate();
    }

    public void setOutLineWidth(int i2) {
        this.outLineWidth = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.progress = validateProgress(i2);
        invalidate();
    }

    public void setProgressColor(int i2) {
        this.progressLineColor = i2;
        invalidate();
    }

    public void setProgressLineWidth(int i2) {
        this.progressLineWidth = i2;
        invalidate();
    }

    public void setProgressTotalPart(int i2) {
        this.mProgressTotalPart = i2;
        resetProgress();
    }

    public void setProgressType(ProgressType progressType) {
        this.mProgressType = progressType;
        resetProgress();
        invalidate();
    }

    public void setTimeMillis(long j) {
        this.timeMillis = j;
        invalidate();
    }

    public void start() {
        stop();
        executeTimer();
    }

    public void stop() {
        BaseTask baseTask = this.mBaseTask;
        if (baseTask != null) {
            baseTask.cancel();
            this.mBaseTask = null;
        }
    }

    public void updateProgres(int i2, int i3) {
        this.progress = (this.mProgressTotalPart * i3) / i2;
        invalidate();
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.outLineColor = -16777216;
        this.outLineWidth = 2;
        this.inCircleColors = ColorStateList.valueOf(0);
        this.progressLineColor = -16776961;
        this.progressLineWidth = 8;
        this.mPaint = new Paint();
        this.mArcRect = new RectF();
        this.mProgressTotalPart = 100;
        this.progress = 100;
        this.mProgressType = ProgressType.COUNT_BACK;
        this.timeMillis = 3000L;
        this.bounds = new Rect();
        initialize(context, attributeSet);
    }
}
