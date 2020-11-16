package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class RoundRectNumProgressBar extends View {
    private float bKA;
    private float bKB;
    private float bKC;
    private float bKD;
    private float bKE;
    private float bKF;
    private float bKG;
    private RectF bKH;
    private RectF bKI;
    private RectF bKJ;
    private float bKK;
    private Path bKL;
    private float bKr;
    private int bKs;
    private int bKt;
    private Paint bKu;
    private Paint bKv;
    private float bKw;
    private int bKx;
    private int bKy;
    private String bKz;
    private float centerX;
    private float centerY;
    private int currentProgress;
    private int lastHeight;
    private int lastWidth;
    private int progressColor;
    private float startX;
    private float startY;
    private int textColor;
    private Paint textPaint;

    public RoundRectNumProgressBar(Context context) {
        this(context, null);
    }

    public RoundRectNumProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectNumProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentProgress = 0;
        this.bKy = 100;
        this.bKA = 0.0f;
        this.bKB = 0.0f;
        this.bKC = 0.0f;
        this.bKD = 0.0f;
        this.bKE = 0.0f;
        this.bKF = 0.0f;
        this.bKG = 0.0f;
        this.bKH = new RectF();
        this.bKI = new RectF();
        this.bKJ = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bKK = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bKL = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bKr = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bKt = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bKy = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bKw = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bKx = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bKs = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bKs == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bKt;
            this.bKt = i2;
        }
        this.bKv = new Paint();
        this.bKv.setAntiAlias(true);
        this.bKv.setStyle(Paint.Style.STROKE);
        this.bKv.setStrokeWidth(this.bKw);
        this.bKv.setColor(this.progressColor);
        this.bKu = new Paint();
        this.bKu.setAntiAlias(true);
        this.bKu.setStyle(Paint.Style.STROKE);
        this.bKu.setStrokeWidth(this.bKw);
        this.bKu.setColor(this.bKt);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bKr);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            Wc();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void Wc() {
        this.bKF = 3.14f * getMeasuredHeight();
        this.bKE = this.bKF / 2.0f;
        this.bKG = (getMeasuredHeight() - this.bKw) / 2.0f;
        this.bKK = this.bKw / 2.0f;
        this.bKA = (((getMeasuredWidth() - this.bKw) - getMeasuredHeight()) + this.bKE) * 2.0f;
        this.bKB = (getMeasuredWidth() - this.bKw) - (this.bKG * 2.0f);
        this.bKC = this.bKB + this.bKE;
        this.bKD = this.bKC + this.bKB;
        this.startX = this.bKK + this.bKG;
        this.startY = this.bKK;
        this.bKI.left = (this.startX + this.bKB) - this.bKG;
        this.bKI.top = this.startY;
        this.bKI.right = getMeasuredWidth() - this.bKK;
        this.bKI.bottom = this.startY + (this.bKG * 2.0f);
        this.bKH.left = this.bKK;
        this.bKH.top = this.startY;
        this.bKH.right = this.bKK + (this.bKG * 2.0f);
        this.bKH.bottom = this.startY + (this.bKG * 2.0f);
        this.bKJ.left = this.bKK;
        this.bKJ.top = this.startY;
        this.bKJ.right = getMeasuredWidth() - this.bKK;
        this.bKJ.bottom = this.startY + (this.bKG * 2.0f);
        this.centerX = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) / 2.0f;
        this.centerY = ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f;
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode != 1073741824) {
            int suggestedMinimumHeight = paddingTop + getSuggestedMinimumHeight();
            return mode == Integer.MIN_VALUE ? Math.max(suggestedMinimumHeight, size) : suggestedMinimumHeight;
        }
        return size;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode != 1073741824) {
            int suggestedMinimumHeight = paddingTop + getSuggestedMinimumHeight();
            return mode == Integer.MIN_VALUE ? Math.min(suggestedMinimumHeight, size) : suggestedMinimumHeight;
        }
        return size;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) e(getContext(), 100.0f);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return (int) e(getContext(), 100.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.bKJ, this.bKG, this.bKG, this.bKu);
        this.bKL.reset();
        this.bKL.moveTo(this.startX, this.startY);
        float f = (this.bKA * this.currentProgress) / this.bKy;
        if (f >= this.bKA) {
            this.bKL.lineTo(this.startX + this.bKB, this.startY);
            this.bKL.arcTo(this.bKI, -90.0f, 180.0f, false);
            this.bKL.lineTo(this.bKK + this.bKG, this.startY + (this.bKG * 2.0f));
            this.bKL.arcTo(this.bKH, 90.0f, 180.0f, false);
            this.bKL.lineTo(this.startX, this.startY);
        } else if (f > this.bKD) {
            this.bKL.lineTo(this.startX + this.bKB, this.startY);
            this.bKL.arcTo(this.bKI, -90.0f, 180.0f, false);
            this.bKL.lineTo(this.bKK + this.bKG, this.startY + (this.bKG * 2.0f));
            this.bKL.arcTo(this.bKH, 90.0f, ((f - this.bKD) * 360.0f) / this.bKF, false);
        } else if (f > this.bKC) {
            this.bKL.lineTo(this.startX + this.bKB, this.startY);
            this.bKL.arcTo(this.bKI, -90.0f, 180.0f, false);
            this.bKL.lineTo(getMeasuredWidth() - ((f + (this.bKK + this.bKG)) - this.bKC), this.startY + (this.bKG * 2.0f));
        } else if (f > this.bKB) {
            this.bKL.lineTo(this.startX + this.bKB, this.startY);
            this.bKL.arcTo(this.bKI, -90.0f, ((f - this.bKB) * 360.0f) / this.bKF, false);
        } else {
            this.bKL.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bKL, this.bKv);
        if (this.bKs == 0) {
            if (this.bKx == 0) {
                this.bKz = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bKy));
                this.bKz += "%";
            } else if (this.bKx == 2) {
                this.bKz = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bKx == 1) {
                this.bKz = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bKx == 0) {
            this.bKz = String.format("%d", Integer.valueOf(((this.bKy - this.currentProgress) * 100) / this.bKy));
            this.bKz += "%";
        } else if (this.bKx == 2) {
            this.bKz = String.format("%d", Integer.valueOf(this.bKy - this.currentProgress));
        } else if (this.bKx == 1) {
            this.bKz = (this.bKy - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bKz, this.centerX - (this.textPaint.measureText(this.bKz) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bKs == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bKy - i;
        }
        invalidate();
    }

    public static float e(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public static float f(Context context, float f) {
        return (context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f;
    }
}
