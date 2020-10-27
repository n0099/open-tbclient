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
    private Paint bGA;
    private float bGB;
    private int bGC;
    private int bGD;
    private String bGE;
    private float bGF;
    private float bGG;
    private float bGH;
    private float bGI;
    private float bGJ;
    private float bGK;
    private float bGL;
    private RectF bGM;
    private RectF bGN;
    private RectF bGO;
    private float bGP;
    private Path bGQ;
    private float bGw;
    private int bGx;
    private int bGy;
    private Paint bGz;
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
        this.bGD = 100;
        this.bGF = 0.0f;
        this.bGG = 0.0f;
        this.bGH = 0.0f;
        this.bGI = 0.0f;
        this.bGJ = 0.0f;
        this.bGK = 0.0f;
        this.bGL = 0.0f;
        this.bGM = new RectF();
        this.bGN = new RectF();
        this.bGO = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bGP = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bGQ = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bGw = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bGy = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bGD = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bGB = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bGC = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bGx = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bGx == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bGy;
            this.bGy = i2;
        }
        this.bGA = new Paint();
        this.bGA.setAntiAlias(true);
        this.bGA.setStyle(Paint.Style.STROKE);
        this.bGA.setStrokeWidth(this.bGB);
        this.bGA.setColor(this.progressColor);
        this.bGz = new Paint();
        this.bGz.setAntiAlias(true);
        this.bGz.setStyle(Paint.Style.STROKE);
        this.bGz.setStrokeWidth(this.bGB);
        this.bGz.setColor(this.bGy);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bGw);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            Ul();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void Ul() {
        this.bGK = 3.14f * getMeasuredHeight();
        this.bGJ = this.bGK / 2.0f;
        this.bGL = (getMeasuredHeight() - this.bGB) / 2.0f;
        this.bGP = this.bGB / 2.0f;
        this.bGF = (((getMeasuredWidth() - this.bGB) - getMeasuredHeight()) + this.bGJ) * 2.0f;
        this.bGG = (getMeasuredWidth() - this.bGB) - (this.bGL * 2.0f);
        this.bGH = this.bGG + this.bGJ;
        this.bGI = this.bGH + this.bGG;
        this.startX = this.bGP + this.bGL;
        this.startY = this.bGP;
        this.bGN.left = (this.startX + this.bGG) - this.bGL;
        this.bGN.top = this.startY;
        this.bGN.right = getMeasuredWidth() - this.bGP;
        this.bGN.bottom = this.startY + (this.bGL * 2.0f);
        this.bGM.left = this.bGP;
        this.bGM.top = this.startY;
        this.bGM.right = this.bGP + (this.bGL * 2.0f);
        this.bGM.bottom = this.startY + (this.bGL * 2.0f);
        this.bGO.left = this.bGP;
        this.bGO.top = this.startY;
        this.bGO.right = getMeasuredWidth() - this.bGP;
        this.bGO.bottom = this.startY + (this.bGL * 2.0f);
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
        canvas.drawRoundRect(this.bGO, this.bGL, this.bGL, this.bGz);
        this.bGQ.reset();
        this.bGQ.moveTo(this.startX, this.startY);
        float f = (this.bGF * this.currentProgress) / this.bGD;
        if (f >= this.bGF) {
            this.bGQ.lineTo(this.startX + this.bGG, this.startY);
            this.bGQ.arcTo(this.bGN, -90.0f, 180.0f, false);
            this.bGQ.lineTo(this.bGP + this.bGL, this.startY + (this.bGL * 2.0f));
            this.bGQ.arcTo(this.bGM, 90.0f, 180.0f, false);
            this.bGQ.lineTo(this.startX, this.startY);
        } else if (f > this.bGI) {
            this.bGQ.lineTo(this.startX + this.bGG, this.startY);
            this.bGQ.arcTo(this.bGN, -90.0f, 180.0f, false);
            this.bGQ.lineTo(this.bGP + this.bGL, this.startY + (this.bGL * 2.0f));
            this.bGQ.arcTo(this.bGM, 90.0f, ((f - this.bGI) * 360.0f) / this.bGK, false);
        } else if (f > this.bGH) {
            this.bGQ.lineTo(this.startX + this.bGG, this.startY);
            this.bGQ.arcTo(this.bGN, -90.0f, 180.0f, false);
            this.bGQ.lineTo(getMeasuredWidth() - ((f + (this.bGP + this.bGL)) - this.bGH), this.startY + (this.bGL * 2.0f));
        } else if (f > this.bGG) {
            this.bGQ.lineTo(this.startX + this.bGG, this.startY);
            this.bGQ.arcTo(this.bGN, -90.0f, ((f - this.bGG) * 360.0f) / this.bGK, false);
        } else {
            this.bGQ.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bGQ, this.bGA);
        if (this.bGx == 0) {
            if (this.bGC == 0) {
                this.bGE = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bGD));
                this.bGE += "%";
            } else if (this.bGC == 2) {
                this.bGE = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bGC == 1) {
                this.bGE = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.bGC == 0) {
            this.bGE = String.format("%d", Integer.valueOf(((this.bGD - this.currentProgress) * 100) / this.bGD));
            this.bGE += "%";
        } else if (this.bGC == 2) {
            this.bGE = String.format("%d", Integer.valueOf(this.bGD - this.currentProgress));
        } else if (this.bGC == 1) {
            this.bGE = (this.bGD - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.bGE, this.centerX - (this.textPaint.measureText(this.bGE) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bGx == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bGD - i;
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
