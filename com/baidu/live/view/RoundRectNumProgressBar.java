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
    private float bMb;
    private int bMc;
    private int bMd;
    private Paint bMe;
    private Paint bMf;
    private float bMg;
    private int bMh;
    private int bMi;
    private String bMj;
    private float bMk;
    private float bMl;
    private float bMm;
    private float bMn;
    private float bMo;
    private float bMp;
    private float bMq;
    private RectF bMr;
    private RectF bMs;
    private RectF bMt;
    private float bMu;
    private Path bMv;
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
        this.bMi = 100;
        this.bMk = 0.0f;
        this.bMl = 0.0f;
        this.bMm = 0.0f;
        this.bMn = 0.0f;
        this.bMo = 0.0f;
        this.bMp = 0.0f;
        this.bMq = 0.0f;
        this.bMr = new RectF();
        this.bMs = new RectF();
        this.bMt = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bMu = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bMv = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bMb = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bMd = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bMi = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bMg = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bMh = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bMc = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bMc == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bMd;
            this.bMd = i2;
        }
        this.bMf = new Paint();
        this.bMf.setAntiAlias(true);
        this.bMf.setStyle(Paint.Style.STROKE);
        this.bMf.setStrokeWidth(this.bMg);
        this.bMf.setColor(this.progressColor);
        this.bMe = new Paint();
        this.bMe.setAntiAlias(true);
        this.bMe.setStyle(Paint.Style.STROKE);
        this.bMe.setStrokeWidth(this.bMg);
        this.bMe.setColor(this.bMd);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bMb);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            WL();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void WL() {
        this.bMp = 3.14f * getMeasuredHeight();
        this.bMo = this.bMp / 2.0f;
        this.bMq = (getMeasuredHeight() - this.bMg) / 2.0f;
        this.bMu = this.bMg / 2.0f;
        this.bMk = (((getMeasuredWidth() - this.bMg) - getMeasuredHeight()) + this.bMo) * 2.0f;
        this.bMl = (getMeasuredWidth() - this.bMg) - (this.bMq * 2.0f);
        this.bMm = this.bMl + this.bMo;
        this.bMn = this.bMm + this.bMl;
        this.startX = this.bMu + this.bMq;
        this.startY = this.bMu;
        this.bMs.left = (this.startX + this.bMl) - this.bMq;
        this.bMs.top = this.startY;
        this.bMs.right = getMeasuredWidth() - this.bMu;
        this.bMs.bottom = this.startY + (this.bMq * 2.0f);
        this.bMr.left = this.bMu;
        this.bMr.top = this.startY;
        this.bMr.right = this.bMu + (this.bMq * 2.0f);
        this.bMr.bottom = this.startY + (this.bMq * 2.0f);
        this.bMt.left = this.bMu;
        this.bMt.top = this.startY;
        this.bMt.right = getMeasuredWidth() - this.bMu;
        this.bMt.bottom = this.startY + (this.bMq * 2.0f);
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
        canvas.drawRoundRect(this.bMt, this.bMq, this.bMq, this.bMe);
        this.bMv.reset();
        this.bMv.moveTo(this.startX, this.startY);
        float f = (this.bMk * this.currentProgress) / this.bMi;
        if (f >= this.bMk) {
            this.bMv.lineTo(this.startX + this.bMl, this.startY);
            this.bMv.arcTo(this.bMs, -90.0f, 180.0f, false);
            this.bMv.lineTo(this.bMu + this.bMq, this.startY + (this.bMq * 2.0f));
            this.bMv.arcTo(this.bMr, 90.0f, 180.0f, false);
            this.bMv.lineTo(this.startX, this.startY);
        } else if (f > this.bMn) {
            this.bMv.lineTo(this.startX + this.bMl, this.startY);
            this.bMv.arcTo(this.bMs, -90.0f, 180.0f, false);
            this.bMv.lineTo(this.bMu + this.bMq, this.startY + (this.bMq * 2.0f));
            this.bMv.arcTo(this.bMr, 90.0f, ((f - this.bMn) * 360.0f) / this.bMp, false);
        } else if (f > this.bMm) {
            this.bMv.lineTo(this.startX + this.bMl, this.startY);
            this.bMv.arcTo(this.bMs, -90.0f, 180.0f, false);
            this.bMv.lineTo(getMeasuredWidth() - ((f + (this.bMu + this.bMq)) - this.bMm), this.startY + (this.bMq * 2.0f));
        } else if (f > this.bMl) {
            this.bMv.lineTo(this.startX + this.bMl, this.startY);
            this.bMv.arcTo(this.bMs, -90.0f, ((f - this.bMl) * 360.0f) / this.bMp, false);
        } else {
            this.bMv.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bMv, this.bMf);
        if (this.bMc == 0) {
            if (this.bMh == 0) {
                this.bMj = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bMi));
                this.bMj += "%";
            } else if (this.bMh == 2) {
                this.bMj = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bMh == 1) {
                this.bMj = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bMh == 0) {
            this.bMj = String.format("%d", Integer.valueOf(((this.bMi - this.currentProgress) * 100) / this.bMi));
            this.bMj += "%";
        } else if (this.bMh == 2) {
            this.bMj = String.format("%d", Integer.valueOf(this.bMi - this.currentProgress));
        } else if (this.bMh == 1) {
            this.bMj = (this.bMi - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bMj, this.centerX - (this.textPaint.measureText(this.bMj) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bMc == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bMi - i;
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
