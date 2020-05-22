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
    private int bhX;
    private int bhY;
    private float biA;
    private float biB;
    private float biC;
    private float biD;
    private float biE;
    private float biF;
    private float biG;
    private RectF biH;
    private RectF biI;
    private RectF biJ;
    private float biK;
    private Path biL;
    private float bir;
    private int bis;
    private int bit;
    private Paint biu;
    private Paint biv;
    private float biw;
    private int bix;
    private int biy;
    private String biz;
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
        this.biy = 100;
        this.biA = 0.0f;
        this.biB = 0.0f;
        this.biC = 0.0f;
        this.biD = 0.0f;
        this.biE = 0.0f;
        this.biF = 0.0f;
        this.biG = 0.0f;
        this.biH = new RectF();
        this.biI = new RectF();
        this.biJ = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.biK = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.biL = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bir = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bit = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.biy = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.biw = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bix = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bis = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bis == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bit;
            this.bit = i2;
        }
        this.biv = new Paint();
        this.biv.setAntiAlias(true);
        this.biv.setStyle(Paint.Style.STROKE);
        this.biv.setStrokeWidth(this.biw);
        this.biv.setColor(this.progressColor);
        this.biu = new Paint();
        this.biu.setAntiAlias(true);
        this.biu.setStyle(Paint.Style.STROKE);
        this.biu.setStrokeWidth(this.biw);
        this.biu.setColor(this.bit);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bir);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.bhX == 0 || this.bhY == 0 || this.bhX != getMeasuredWidth() || this.bhY != getMeasuredHeight()) {
            Js();
            this.bhX = getMeasuredWidth();
            this.bhY = getMeasuredHeight();
        }
    }

    private void Js() {
        this.biF = 3.14f * getMeasuredHeight();
        this.biE = this.biF / 2.0f;
        this.biG = (getMeasuredHeight() - this.biw) / 2.0f;
        this.biK = this.biw / 2.0f;
        this.biA = (((getMeasuredWidth() - this.biw) - getMeasuredHeight()) + this.biE) * 2.0f;
        this.biB = (getMeasuredWidth() - this.biw) - (this.biG * 2.0f);
        this.biC = this.biB + this.biE;
        this.biD = this.biC + this.biB;
        this.startX = this.biK + this.biG;
        this.startY = this.biK;
        this.biI.left = (this.startX + this.biB) - this.biG;
        this.biI.top = this.startY;
        this.biI.right = getMeasuredWidth() - this.biK;
        this.biI.bottom = this.startY + (this.biG * 2.0f);
        this.biH.left = this.biK;
        this.biH.top = this.startY;
        this.biH.right = this.biK + (this.biG * 2.0f);
        this.biH.bottom = this.startY + (this.biG * 2.0f);
        this.biJ.left = this.biK;
        this.biJ.top = this.startY;
        this.biJ.right = getMeasuredWidth() - this.biK;
        this.biJ.bottom = this.startY + (this.biG * 2.0f);
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
        canvas.drawRoundRect(this.biJ, this.biG, this.biG, this.biu);
        this.biL.reset();
        this.biL.moveTo(this.startX, this.startY);
        float f = (this.biA * this.currentProgress) / this.biy;
        if (f >= this.biA) {
            this.biL.lineTo(this.startX + this.biB, this.startY);
            this.biL.arcTo(this.biI, -90.0f, 180.0f, false);
            this.biL.lineTo(this.biK + this.biG, this.startY + (this.biG * 2.0f));
            this.biL.arcTo(this.biH, 90.0f, 180.0f, false);
            this.biL.lineTo(this.startX, this.startY);
        } else if (f > this.biD) {
            this.biL.lineTo(this.startX + this.biB, this.startY);
            this.biL.arcTo(this.biI, -90.0f, 180.0f, false);
            this.biL.lineTo(this.biK + this.biG, this.startY + (this.biG * 2.0f));
            this.biL.arcTo(this.biH, 90.0f, ((f - this.biD) * 360.0f) / this.biF, false);
        } else if (f > this.biC) {
            this.biL.lineTo(this.startX + this.biB, this.startY);
            this.biL.arcTo(this.biI, -90.0f, 180.0f, false);
            this.biL.lineTo(getMeasuredWidth() - ((f + (this.biK + this.biG)) - this.biC), this.startY + (this.biG * 2.0f));
        } else if (f > this.biB) {
            this.biL.lineTo(this.startX + this.biB, this.startY);
            this.biL.arcTo(this.biI, -90.0f, ((f - this.biB) * 360.0f) / this.biF, false);
        } else {
            this.biL.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.biL, this.biv);
        if (this.bis == 0) {
            if (this.bix == 0) {
                this.biz = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.biy));
                this.biz += "%";
            } else if (this.bix == 2) {
                this.biz = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bix == 1) {
                this.biz = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.bix == 0) {
            this.biz = String.format("%d", Integer.valueOf(((this.biy - this.currentProgress) * 100) / this.biy));
            this.biz += "%";
        } else if (this.bix == 2) {
            this.biz = String.format("%d", Integer.valueOf(this.biy - this.currentProgress));
        } else if (this.bix == 1) {
            this.biz = (this.biy - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.biz, this.centerX - (this.textPaint.measureText(this.biz) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bis == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.biy - i;
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
