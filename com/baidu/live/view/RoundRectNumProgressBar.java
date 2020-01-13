package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class RoundRectNumProgressBar extends View {
    private int aAA;
    private int aAB;
    private Paint aAC;
    private Paint aAD;
    private float aAE;
    private int aAF;
    private int aAG;
    private String aAH;
    private float aAI;
    private float aAJ;
    private float aAK;
    private float aAL;
    private float aAM;
    private float aAN;
    private float aAO;
    private RectF aAP;
    private RectF aAQ;
    private RectF aAR;
    private float aAS;
    private Path aAT;
    private int aAi;
    private int aAj;
    private float aAz;
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
        this.aAG = 100;
        this.aAI = 0.0f;
        this.aAJ = 0.0f;
        this.aAK = 0.0f;
        this.aAL = 0.0f;
        this.aAM = 0.0f;
        this.aAN = 0.0f;
        this.aAO = 0.0f;
        this.aAP = new RectF();
        this.aAQ = new RectF();
        this.aAR = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.aAS = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.aAT = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.aAz = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.aAB = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.aAG = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.aAE = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.aAF = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.aAA = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.aAA == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.aAB;
            this.aAB = i2;
        }
        this.aAD = new Paint();
        this.aAD.setAntiAlias(true);
        this.aAD.setStyle(Paint.Style.STROKE);
        this.aAD.setStrokeWidth(this.aAE);
        this.aAD.setColor(this.progressColor);
        this.aAC = new Paint();
        this.aAC.setAntiAlias(true);
        this.aAC.setStyle(Paint.Style.STROKE);
        this.aAC.setStrokeWidth(this.aAE);
        this.aAC.setColor(this.aAB);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.aAz);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.aAi == 0 || this.aAj == 0 || this.aAi != getMeasuredWidth() || this.aAj != getMeasuredHeight()) {
            yX();
            this.aAi = getMeasuredWidth();
            this.aAj = getMeasuredHeight();
        }
    }

    private void yX() {
        this.aAN = 3.14f * getMeasuredHeight();
        this.aAM = this.aAN / 2.0f;
        this.aAO = (getMeasuredHeight() - this.aAE) / 2.0f;
        this.aAS = this.aAE / 2.0f;
        this.aAI = (((getMeasuredWidth() - this.aAE) - getMeasuredHeight()) + this.aAM) * 2.0f;
        this.aAJ = (getMeasuredWidth() - this.aAE) - (this.aAO * 2.0f);
        this.aAK = this.aAJ + this.aAM;
        this.aAL = this.aAK + this.aAJ;
        this.startX = this.aAS + this.aAO;
        this.startY = this.aAS;
        this.aAQ.left = (this.startX + this.aAJ) - this.aAO;
        this.aAQ.top = this.startY;
        this.aAQ.right = getMeasuredWidth() - this.aAS;
        this.aAQ.bottom = this.startY + (this.aAO * 2.0f);
        this.aAP.left = this.aAS;
        this.aAP.top = this.startY;
        this.aAP.right = this.aAS + (this.aAO * 2.0f);
        this.aAP.bottom = this.startY + (this.aAO * 2.0f);
        this.aAR.left = this.aAS;
        this.aAR.top = this.startY;
        this.aAR.right = getMeasuredWidth() - this.aAS;
        this.aAR.bottom = this.startY + (this.aAO * 2.0f);
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
        canvas.drawRoundRect(this.aAR, this.aAO, this.aAO, this.aAC);
        this.aAT.reset();
        this.aAT.moveTo(this.startX, this.startY);
        float f = (this.aAI * this.currentProgress) / this.aAG;
        if (f >= this.aAI) {
            this.aAT.lineTo(this.startX + this.aAJ, this.startY);
            this.aAT.arcTo(this.aAQ, -90.0f, 180.0f, false);
            this.aAT.lineTo(this.aAS + this.aAO, this.startY + (this.aAO * 2.0f));
            this.aAT.arcTo(this.aAP, 90.0f, 180.0f, false);
            this.aAT.lineTo(this.startX, this.startY);
        } else if (f > this.aAL) {
            this.aAT.lineTo(this.startX + this.aAJ, this.startY);
            this.aAT.arcTo(this.aAQ, -90.0f, 180.0f, false);
            this.aAT.lineTo(this.aAS + this.aAO, this.startY + (this.aAO * 2.0f));
            this.aAT.arcTo(this.aAP, 90.0f, ((f - this.aAL) * 360.0f) / this.aAN, false);
        } else if (f > this.aAK) {
            this.aAT.lineTo(this.startX + this.aAJ, this.startY);
            this.aAT.arcTo(this.aAQ, -90.0f, 180.0f, false);
            this.aAT.lineTo(getMeasuredWidth() - ((f + (this.aAS + this.aAO)) - this.aAK), this.startY + (this.aAO * 2.0f));
        } else if (f > this.aAJ) {
            this.aAT.lineTo(this.startX + this.aAJ, this.startY);
            this.aAT.arcTo(this.aAQ, -90.0f, ((f - this.aAJ) * 360.0f) / this.aAN, false);
        } else {
            this.aAT.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.aAT, this.aAD);
        if (this.aAA == 0) {
            if (this.aAF == 0) {
                this.aAH = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.aAG));
                this.aAH += "%";
            } else if (this.aAF == 2) {
                this.aAH = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.aAF == 1) {
                this.aAH = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.aAF == 0) {
            this.aAH = String.format("%d", Integer.valueOf(((this.aAG - this.currentProgress) * 100) / this.aAG));
            this.aAH += "%";
        } else if (this.aAF == 2) {
            this.aAH = String.format("%d", Integer.valueOf(this.aAG - this.currentProgress));
        } else if (this.aAF == 1) {
            this.aAH = (this.aAG - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.aAH, this.centerX - (this.textPaint.measureText(this.aAH) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.aAA == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.aAG - i;
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
