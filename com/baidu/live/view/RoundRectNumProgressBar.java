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
    private float btE;
    private int btF;
    private int btG;
    private Paint btH;
    private Paint btI;
    private float btJ;
    private int btK;
    private int btL;
    private String btM;
    private float btN;
    private float btO;
    private float btP;
    private float btQ;
    private float btR;
    private float btS;
    private float btT;
    private RectF btU;
    private RectF btV;
    private RectF btW;
    private float btX;
    private Path btY;
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
        this.btL = 100;
        this.btN = 0.0f;
        this.btO = 0.0f;
        this.btP = 0.0f;
        this.btQ = 0.0f;
        this.btR = 0.0f;
        this.btS = 0.0f;
        this.btT = 0.0f;
        this.btU = new RectF();
        this.btV = new RectF();
        this.btW = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.btX = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.btY = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.btE = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.btG = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.btL = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.btJ = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.btK = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.btF = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.btF == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.btG;
            this.btG = i2;
        }
        this.btI = new Paint();
        this.btI.setAntiAlias(true);
        this.btI.setStyle(Paint.Style.STROKE);
        this.btI.setStrokeWidth(this.btJ);
        this.btI.setColor(this.progressColor);
        this.btH = new Paint();
        this.btH.setAntiAlias(true);
        this.btH.setStyle(Paint.Style.STROKE);
        this.btH.setStrokeWidth(this.btJ);
        this.btH.setColor(this.btG);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.btE);
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
        this.btS = 3.14f * getMeasuredHeight();
        this.btR = this.btS / 2.0f;
        this.btT = (getMeasuredHeight() - this.btJ) / 2.0f;
        this.btX = this.btJ / 2.0f;
        this.btN = (((getMeasuredWidth() - this.btJ) - getMeasuredHeight()) + this.btR) * 2.0f;
        this.btO = (getMeasuredWidth() - this.btJ) - (this.btT * 2.0f);
        this.btP = this.btO + this.btR;
        this.btQ = this.btP + this.btO;
        this.startX = this.btX + this.btT;
        this.startY = this.btX;
        this.btV.left = (this.startX + this.btO) - this.btT;
        this.btV.top = this.startY;
        this.btV.right = getMeasuredWidth() - this.btX;
        this.btV.bottom = this.startY + (this.btT * 2.0f);
        this.btU.left = this.btX;
        this.btU.top = this.startY;
        this.btU.right = this.btX + (this.btT * 2.0f);
        this.btU.bottom = this.startY + (this.btT * 2.0f);
        this.btW.left = this.btX;
        this.btW.top = this.startY;
        this.btW.right = getMeasuredWidth() - this.btX;
        this.btW.bottom = this.startY + (this.btT * 2.0f);
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
        canvas.drawRoundRect(this.btW, this.btT, this.btT, this.btH);
        this.btY.reset();
        this.btY.moveTo(this.startX, this.startY);
        float f = (this.btN * this.currentProgress) / this.btL;
        if (f >= this.btN) {
            this.btY.lineTo(this.startX + this.btO, this.startY);
            this.btY.arcTo(this.btV, -90.0f, 180.0f, false);
            this.btY.lineTo(this.btX + this.btT, this.startY + (this.btT * 2.0f));
            this.btY.arcTo(this.btU, 90.0f, 180.0f, false);
            this.btY.lineTo(this.startX, this.startY);
        } else if (f > this.btQ) {
            this.btY.lineTo(this.startX + this.btO, this.startY);
            this.btY.arcTo(this.btV, -90.0f, 180.0f, false);
            this.btY.lineTo(this.btX + this.btT, this.startY + (this.btT * 2.0f));
            this.btY.arcTo(this.btU, 90.0f, ((f - this.btQ) * 360.0f) / this.btS, false);
        } else if (f > this.btP) {
            this.btY.lineTo(this.startX + this.btO, this.startY);
            this.btY.arcTo(this.btV, -90.0f, 180.0f, false);
            this.btY.lineTo(getMeasuredWidth() - ((f + (this.btX + this.btT)) - this.btP), this.startY + (this.btT * 2.0f));
        } else if (f > this.btO) {
            this.btY.lineTo(this.startX + this.btO, this.startY);
            this.btY.arcTo(this.btV, -90.0f, ((f - this.btO) * 360.0f) / this.btS, false);
        } else {
            this.btY.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.btY, this.btI);
        if (this.btF == 0) {
            if (this.btK == 0) {
                this.btM = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.btL));
                this.btM += "%";
            } else if (this.btK == 2) {
                this.btM = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.btK == 1) {
                this.btM = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.btK == 0) {
            this.btM = String.format("%d", Integer.valueOf(((this.btL - this.currentProgress) * 100) / this.btL));
            this.btM += "%";
        } else if (this.btK == 2) {
            this.btM = String.format("%d", Integer.valueOf(this.btL - this.currentProgress));
        } else if (this.btK == 1) {
            this.btM = (this.btL - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.btM, this.centerX - (this.textPaint.measureText(this.btM) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.btF == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.btL - i;
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
