package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class RoundRectNumProgressBar extends View {
    private int aEA;
    private int aEB;
    private float aER;
    private int aES;
    private int aET;
    private Paint aEU;
    private Paint aEV;
    private float aEW;
    private int aEX;
    private int aEY;
    private String aEZ;
    private float aFa;
    private float aFb;
    private float aFc;
    private float aFd;
    private float aFe;
    private float aFf;
    private float aFg;
    private RectF aFh;
    private RectF aFi;
    private RectF aFj;
    private float aFk;
    private Path aFl;
    private float centerX;
    private float centerY;
    private int currentProgress;
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
        this.aEY = 100;
        this.aFa = 0.0f;
        this.aFb = 0.0f;
        this.aFc = 0.0f;
        this.aFd = 0.0f;
        this.aFe = 0.0f;
        this.aFf = 0.0f;
        this.aFg = 0.0f;
        this.aFh = new RectF();
        this.aFi = new RectF();
        this.aFj = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.aFk = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.aFl = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.aER = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.aET = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.aEY = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.aEW = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.aEX = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.aES = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.aES == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.aET;
            this.aET = i2;
        }
        this.aEV = new Paint();
        this.aEV.setAntiAlias(true);
        this.aEV.setStyle(Paint.Style.STROKE);
        this.aEV.setStrokeWidth(this.aEW);
        this.aEV.setColor(this.progressColor);
        this.aEU = new Paint();
        this.aEU.setAntiAlias(true);
        this.aEU.setStyle(Paint.Style.STROKE);
        this.aEU.setStrokeWidth(this.aEW);
        this.aEU.setColor(this.aET);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.aER);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.aEA == 0 || this.aEB == 0 || this.aEA != getMeasuredWidth() || this.aEB != getMeasuredHeight()) {
            Bp();
            this.aEA = getMeasuredWidth();
            this.aEB = getMeasuredHeight();
        }
    }

    private void Bp() {
        this.aFf = 3.14f * getMeasuredHeight();
        this.aFe = this.aFf / 2.0f;
        this.aFg = (getMeasuredHeight() - this.aEW) / 2.0f;
        this.aFk = this.aEW / 2.0f;
        this.aFa = (((getMeasuredWidth() - this.aEW) - getMeasuredHeight()) + this.aFe) * 2.0f;
        this.aFb = (getMeasuredWidth() - this.aEW) - (this.aFg * 2.0f);
        this.aFc = this.aFb + this.aFe;
        this.aFd = this.aFc + this.aFb;
        this.startX = this.aFk + this.aFg;
        this.startY = this.aFk;
        this.aFi.left = (this.startX + this.aFb) - this.aFg;
        this.aFi.top = this.startY;
        this.aFi.right = getMeasuredWidth() - this.aFk;
        this.aFi.bottom = this.startY + (this.aFg * 2.0f);
        this.aFh.left = this.aFk;
        this.aFh.top = this.startY;
        this.aFh.right = this.aFk + (this.aFg * 2.0f);
        this.aFh.bottom = this.startY + (this.aFg * 2.0f);
        this.aFj.left = this.aFk;
        this.aFj.top = this.startY;
        this.aFj.right = getMeasuredWidth() - this.aFk;
        this.aFj.bottom = this.startY + (this.aFg * 2.0f);
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
        canvas.drawRoundRect(this.aFj, this.aFg, this.aFg, this.aEU);
        this.aFl.reset();
        this.aFl.moveTo(this.startX, this.startY);
        float f = (this.aFa * this.currentProgress) / this.aEY;
        if (f >= this.aFa) {
            this.aFl.lineTo(this.startX + this.aFb, this.startY);
            this.aFl.arcTo(this.aFi, -90.0f, 180.0f, false);
            this.aFl.lineTo(this.aFk + this.aFg, this.startY + (this.aFg * 2.0f));
            this.aFl.arcTo(this.aFh, 90.0f, 180.0f, false);
            this.aFl.lineTo(this.startX, this.startY);
        } else if (f > this.aFd) {
            this.aFl.lineTo(this.startX + this.aFb, this.startY);
            this.aFl.arcTo(this.aFi, -90.0f, 180.0f, false);
            this.aFl.lineTo(this.aFk + this.aFg, this.startY + (this.aFg * 2.0f));
            this.aFl.arcTo(this.aFh, 90.0f, ((f - this.aFd) * 360.0f) / this.aFf, false);
        } else if (f > this.aFc) {
            this.aFl.lineTo(this.startX + this.aFb, this.startY);
            this.aFl.arcTo(this.aFi, -90.0f, 180.0f, false);
            this.aFl.lineTo(getMeasuredWidth() - ((f + (this.aFk + this.aFg)) - this.aFc), this.startY + (this.aFg * 2.0f));
        } else if (f > this.aFb) {
            this.aFl.lineTo(this.startX + this.aFb, this.startY);
            this.aFl.arcTo(this.aFi, -90.0f, ((f - this.aFb) * 360.0f) / this.aFf, false);
        } else {
            this.aFl.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.aFl, this.aEV);
        if (this.aES == 0) {
            if (this.aEX == 0) {
                this.aEZ = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.aEY));
                this.aEZ += "%";
            } else if (this.aEX == 2) {
                this.aEZ = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.aEX == 1) {
                this.aEZ = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.aEX == 0) {
            this.aEZ = String.format("%d", Integer.valueOf(((this.aEY - this.currentProgress) * 100) / this.aEY));
            this.aEZ += "%";
        } else if (this.aEX == 2) {
            this.aEZ = String.format("%d", Integer.valueOf(this.aEY - this.currentProgress));
        } else if (this.aEX == 1) {
            this.aEZ = (this.aEY - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.aEZ, this.centerX - (this.textPaint.measureText(this.aEZ) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.aES == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.aEY - i;
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
