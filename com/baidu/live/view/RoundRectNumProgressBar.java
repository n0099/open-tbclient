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
    private float bDA;
    private int bDB;
    private int bDC;
    private Paint bDD;
    private Paint bDE;
    private float bDF;
    private int bDG;
    private int bDH;
    private String bDI;
    private float bDJ;
    private float bDK;
    private float bDL;
    private float bDM;
    private float bDN;
    private float bDO;
    private float bDP;
    private RectF bDQ;
    private RectF bDR;
    private RectF bDS;
    private float bDT;
    private Path bDU;
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
        this.bDH = 100;
        this.bDJ = 0.0f;
        this.bDK = 0.0f;
        this.bDL = 0.0f;
        this.bDM = 0.0f;
        this.bDN = 0.0f;
        this.bDO = 0.0f;
        this.bDP = 0.0f;
        this.bDQ = new RectF();
        this.bDR = new RectF();
        this.bDS = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bDT = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bDU = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bDA = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bDC = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bDH = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bDF = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bDG = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bDB = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bDB == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bDC;
            this.bDC = i2;
        }
        this.bDE = new Paint();
        this.bDE.setAntiAlias(true);
        this.bDE.setStyle(Paint.Style.STROKE);
        this.bDE.setStrokeWidth(this.bDF);
        this.bDE.setColor(this.progressColor);
        this.bDD = new Paint();
        this.bDD.setAntiAlias(true);
        this.bDD.setStyle(Paint.Style.STROKE);
        this.bDD.setStrokeWidth(this.bDF);
        this.bDD.setColor(this.bDC);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bDA);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            Tm();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void Tm() {
        this.bDO = 3.14f * getMeasuredHeight();
        this.bDN = this.bDO / 2.0f;
        this.bDP = (getMeasuredHeight() - this.bDF) / 2.0f;
        this.bDT = this.bDF / 2.0f;
        this.bDJ = (((getMeasuredWidth() - this.bDF) - getMeasuredHeight()) + this.bDN) * 2.0f;
        this.bDK = (getMeasuredWidth() - this.bDF) - (this.bDP * 2.0f);
        this.bDL = this.bDK + this.bDN;
        this.bDM = this.bDL + this.bDK;
        this.startX = this.bDT + this.bDP;
        this.startY = this.bDT;
        this.bDR.left = (this.startX + this.bDK) - this.bDP;
        this.bDR.top = this.startY;
        this.bDR.right = getMeasuredWidth() - this.bDT;
        this.bDR.bottom = this.startY + (this.bDP * 2.0f);
        this.bDQ.left = this.bDT;
        this.bDQ.top = this.startY;
        this.bDQ.right = this.bDT + (this.bDP * 2.0f);
        this.bDQ.bottom = this.startY + (this.bDP * 2.0f);
        this.bDS.left = this.bDT;
        this.bDS.top = this.startY;
        this.bDS.right = getMeasuredWidth() - this.bDT;
        this.bDS.bottom = this.startY + (this.bDP * 2.0f);
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
        canvas.drawRoundRect(this.bDS, this.bDP, this.bDP, this.bDD);
        this.bDU.reset();
        this.bDU.moveTo(this.startX, this.startY);
        float f = (this.bDJ * this.currentProgress) / this.bDH;
        if (f >= this.bDJ) {
            this.bDU.lineTo(this.startX + this.bDK, this.startY);
            this.bDU.arcTo(this.bDR, -90.0f, 180.0f, false);
            this.bDU.lineTo(this.bDT + this.bDP, this.startY + (this.bDP * 2.0f));
            this.bDU.arcTo(this.bDQ, 90.0f, 180.0f, false);
            this.bDU.lineTo(this.startX, this.startY);
        } else if (f > this.bDM) {
            this.bDU.lineTo(this.startX + this.bDK, this.startY);
            this.bDU.arcTo(this.bDR, -90.0f, 180.0f, false);
            this.bDU.lineTo(this.bDT + this.bDP, this.startY + (this.bDP * 2.0f));
            this.bDU.arcTo(this.bDQ, 90.0f, ((f - this.bDM) * 360.0f) / this.bDO, false);
        } else if (f > this.bDL) {
            this.bDU.lineTo(this.startX + this.bDK, this.startY);
            this.bDU.arcTo(this.bDR, -90.0f, 180.0f, false);
            this.bDU.lineTo(getMeasuredWidth() - ((f + (this.bDT + this.bDP)) - this.bDL), this.startY + (this.bDP * 2.0f));
        } else if (f > this.bDK) {
            this.bDU.lineTo(this.startX + this.bDK, this.startY);
            this.bDU.arcTo(this.bDR, -90.0f, ((f - this.bDK) * 360.0f) / this.bDO, false);
        } else {
            this.bDU.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bDU, this.bDE);
        if (this.bDB == 0) {
            if (this.bDG == 0) {
                this.bDI = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bDH));
                this.bDI += "%";
            } else if (this.bDG == 2) {
                this.bDI = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bDG == 1) {
                this.bDI = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.bDG == 0) {
            this.bDI = String.format("%d", Integer.valueOf(((this.bDH - this.currentProgress) * 100) / this.bDH));
            this.bDI += "%";
        } else if (this.bDG == 2) {
            this.bDI = String.format("%d", Integer.valueOf(this.bDH - this.currentProgress));
        } else if (this.bDG == 1) {
            this.bDI = (this.bDH - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.bDI, this.centerX - (this.textPaint.measureText(this.bDI) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bDB == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bDH - i;
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
