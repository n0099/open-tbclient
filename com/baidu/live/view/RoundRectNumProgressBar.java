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
    private int bPA;
    private Paint bPB;
    private Paint bPC;
    private float bPD;
    private int bPE;
    private int bPF;
    private String bPG;
    private float bPH;
    private float bPI;
    private float bPJ;
    private float bPK;
    private float bPL;
    private float bPM;
    private RectF bPN;
    private RectF bPO;
    private RectF bPP;
    private float bPQ;
    private Path bPR;
    private float bPy;
    private int bPz;
    private float centerX;
    private float centerY;
    private int currentProgress;
    private int lastHeight;
    private int lastWidth;
    private int progressColor;
    private float radius;
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
        this.bPF = 100;
        this.bPH = 0.0f;
        this.bPI = 0.0f;
        this.bPJ = 0.0f;
        this.bPK = 0.0f;
        this.bPL = 0.0f;
        this.bPM = 0.0f;
        this.radius = 0.0f;
        this.bPN = new RectF();
        this.bPO = new RectF();
        this.bPP = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bPQ = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bPR = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bPy = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bPA = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bPF = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bPD = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bPE = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bPz = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bPz == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bPA;
            this.bPA = i2;
        }
        this.bPC = new Paint();
        this.bPC.setAntiAlias(true);
        this.bPC.setStyle(Paint.Style.STROKE);
        this.bPC.setStrokeWidth(this.bPD);
        this.bPC.setColor(this.progressColor);
        this.bPB = new Paint();
        this.bPB.setAntiAlias(true);
        this.bPB.setStyle(Paint.Style.STROKE);
        this.bPB.setStrokeWidth(this.bPD);
        this.bPB.setColor(this.bPA);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bPy);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            YC();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void YC() {
        this.bPM = 3.14f * getMeasuredHeight();
        this.bPL = this.bPM / 2.0f;
        this.radius = (getMeasuredHeight() - this.bPD) / 2.0f;
        this.bPQ = this.bPD / 2.0f;
        this.bPH = (((getMeasuredWidth() - this.bPD) - getMeasuredHeight()) + this.bPL) * 2.0f;
        this.bPI = (getMeasuredWidth() - this.bPD) - (this.radius * 2.0f);
        this.bPJ = this.bPI + this.bPL;
        this.bPK = this.bPJ + this.bPI;
        this.startX = this.bPQ + this.radius;
        this.startY = this.bPQ;
        this.bPO.left = (this.startX + this.bPI) - this.radius;
        this.bPO.top = this.startY;
        this.bPO.right = getMeasuredWidth() - this.bPQ;
        this.bPO.bottom = this.startY + (this.radius * 2.0f);
        this.bPN.left = this.bPQ;
        this.bPN.top = this.startY;
        this.bPN.right = this.bPQ + (this.radius * 2.0f);
        this.bPN.bottom = this.startY + (this.radius * 2.0f);
        this.bPP.left = this.bPQ;
        this.bPP.top = this.startY;
        this.bPP.right = getMeasuredWidth() - this.bPQ;
        this.bPP.bottom = this.startY + (this.radius * 2.0f);
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
        canvas.drawRoundRect(this.bPP, this.radius, this.radius, this.bPB);
        this.bPR.reset();
        this.bPR.moveTo(this.startX, this.startY);
        float f = (this.bPH * this.currentProgress) / this.bPF;
        if (f >= this.bPH) {
            this.bPR.lineTo(this.startX + this.bPI, this.startY);
            this.bPR.arcTo(this.bPO, -90.0f, 180.0f, false);
            this.bPR.lineTo(this.bPQ + this.radius, this.startY + (this.radius * 2.0f));
            this.bPR.arcTo(this.bPN, 90.0f, 180.0f, false);
            this.bPR.lineTo(this.startX, this.startY);
        } else if (f > this.bPK) {
            this.bPR.lineTo(this.startX + this.bPI, this.startY);
            this.bPR.arcTo(this.bPO, -90.0f, 180.0f, false);
            this.bPR.lineTo(this.bPQ + this.radius, this.startY + (this.radius * 2.0f));
            this.bPR.arcTo(this.bPN, 90.0f, ((f - this.bPK) * 360.0f) / this.bPM, false);
        } else if (f > this.bPJ) {
            this.bPR.lineTo(this.startX + this.bPI, this.startY);
            this.bPR.arcTo(this.bPO, -90.0f, 180.0f, false);
            this.bPR.lineTo(getMeasuredWidth() - ((f + (this.bPQ + this.radius)) - this.bPJ), this.startY + (this.radius * 2.0f));
        } else if (f > this.bPI) {
            this.bPR.lineTo(this.startX + this.bPI, this.startY);
            this.bPR.arcTo(this.bPO, -90.0f, ((f - this.bPI) * 360.0f) / this.bPM, false);
        } else {
            this.bPR.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bPR, this.bPC);
        if (this.bPz == 0) {
            if (this.bPE == 0) {
                this.bPG = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bPF));
                this.bPG += "%";
            } else if (this.bPE == 2) {
                this.bPG = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bPE == 1) {
                this.bPG = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bPE == 0) {
            this.bPG = String.format("%d", Integer.valueOf(((this.bPF - this.currentProgress) * 100) / this.bPF));
            this.bPG += "%";
        } else if (this.bPE == 2) {
            this.bPG = String.format("%d", Integer.valueOf(this.bPF - this.currentProgress));
        } else if (this.bPE == 1) {
            this.bPG = (this.bPF - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bPG, this.centerX - (this.textPaint.measureText(this.bPG) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bPz == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bPF - i;
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
