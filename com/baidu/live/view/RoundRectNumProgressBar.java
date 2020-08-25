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
/* loaded from: classes7.dex */
public class RoundRectNumProgressBar extends View {
    private float btB;
    private int btC;
    private int btD;
    private Paint btE;
    private Paint btF;
    private float btG;
    private int btH;
    private int btI;
    private String btJ;
    private float btK;
    private float btL;
    private float btM;
    private float btN;
    private float btO;
    private float btP;
    private float btQ;
    private RectF btR;
    private RectF btS;
    private RectF btT;
    private float btU;
    private Path btV;
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
        this.btI = 100;
        this.btK = 0.0f;
        this.btL = 0.0f;
        this.btM = 0.0f;
        this.btN = 0.0f;
        this.btO = 0.0f;
        this.btP = 0.0f;
        this.btQ = 0.0f;
        this.btR = new RectF();
        this.btS = new RectF();
        this.btT = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.btU = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.btV = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.btB = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.btD = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.btI = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.btG = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.btH = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.btC = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.btC == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.btD;
            this.btD = i2;
        }
        this.btF = new Paint();
        this.btF.setAntiAlias(true);
        this.btF.setStyle(Paint.Style.STROKE);
        this.btF.setStrokeWidth(this.btG);
        this.btF.setColor(this.progressColor);
        this.btE = new Paint();
        this.btE.setAntiAlias(true);
        this.btE.setStyle(Paint.Style.STROKE);
        this.btE.setStrokeWidth(this.btG);
        this.btE.setColor(this.btD);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.btB);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            QJ();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void QJ() {
        this.btP = 3.14f * getMeasuredHeight();
        this.btO = this.btP / 2.0f;
        this.btQ = (getMeasuredHeight() - this.btG) / 2.0f;
        this.btU = this.btG / 2.0f;
        this.btK = (((getMeasuredWidth() - this.btG) - getMeasuredHeight()) + this.btO) * 2.0f;
        this.btL = (getMeasuredWidth() - this.btG) - (this.btQ * 2.0f);
        this.btM = this.btL + this.btO;
        this.btN = this.btM + this.btL;
        this.startX = this.btU + this.btQ;
        this.startY = this.btU;
        this.btS.left = (this.startX + this.btL) - this.btQ;
        this.btS.top = this.startY;
        this.btS.right = getMeasuredWidth() - this.btU;
        this.btS.bottom = this.startY + (this.btQ * 2.0f);
        this.btR.left = this.btU;
        this.btR.top = this.startY;
        this.btR.right = this.btU + (this.btQ * 2.0f);
        this.btR.bottom = this.startY + (this.btQ * 2.0f);
        this.btT.left = this.btU;
        this.btT.top = this.startY;
        this.btT.right = getMeasuredWidth() - this.btU;
        this.btT.bottom = this.startY + (this.btQ * 2.0f);
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
        canvas.drawRoundRect(this.btT, this.btQ, this.btQ, this.btE);
        this.btV.reset();
        this.btV.moveTo(this.startX, this.startY);
        float f = (this.btK * this.currentProgress) / this.btI;
        if (f >= this.btK) {
            this.btV.lineTo(this.startX + this.btL, this.startY);
            this.btV.arcTo(this.btS, -90.0f, 180.0f, false);
            this.btV.lineTo(this.btU + this.btQ, this.startY + (this.btQ * 2.0f));
            this.btV.arcTo(this.btR, 90.0f, 180.0f, false);
            this.btV.lineTo(this.startX, this.startY);
        } else if (f > this.btN) {
            this.btV.lineTo(this.startX + this.btL, this.startY);
            this.btV.arcTo(this.btS, -90.0f, 180.0f, false);
            this.btV.lineTo(this.btU + this.btQ, this.startY + (this.btQ * 2.0f));
            this.btV.arcTo(this.btR, 90.0f, ((f - this.btN) * 360.0f) / this.btP, false);
        } else if (f > this.btM) {
            this.btV.lineTo(this.startX + this.btL, this.startY);
            this.btV.arcTo(this.btS, -90.0f, 180.0f, false);
            this.btV.lineTo(getMeasuredWidth() - ((f + (this.btU + this.btQ)) - this.btM), this.startY + (this.btQ * 2.0f));
        } else if (f > this.btL) {
            this.btV.lineTo(this.startX + this.btL, this.startY);
            this.btV.arcTo(this.btS, -90.0f, ((f - this.btL) * 360.0f) / this.btP, false);
        } else {
            this.btV.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.btV, this.btF);
        if (this.btC == 0) {
            if (this.btH == 0) {
                this.btJ = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.btI));
                this.btJ += "%";
            } else if (this.btH == 2) {
                this.btJ = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.btH == 1) {
                this.btJ = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.btH == 0) {
            this.btJ = String.format("%d", Integer.valueOf(((this.btI - this.currentProgress) * 100) / this.btI));
            this.btJ += "%";
        } else if (this.btH == 2) {
            this.btJ = String.format("%d", Integer.valueOf(this.btI - this.currentProgress));
        } else if (this.btH == 1) {
            this.btJ = (this.btI - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.btJ, this.centerX - (this.textPaint.measureText(this.btJ) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.btC == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.btI - i;
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
