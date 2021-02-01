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
/* loaded from: classes11.dex */
public class RoundRectNumProgressBar extends View {
    private int bTH;
    private int bTI;
    private Paint bTJ;
    private Paint bTK;
    private float bTL;
    private int bTM;
    private int bTN;
    private String bTO;
    private float bTP;
    private float bTQ;
    private float bTR;
    private float bTS;
    private float bTT;
    private float bTU;
    private RectF bTV;
    private RectF bTW;
    private RectF bTX;
    private float bTY;
    private Path bTZ;
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
    private float textSize;

    public RoundRectNumProgressBar(Context context) {
        this(context, null);
    }

    public RoundRectNumProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectNumProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentProgress = 0;
        this.bTN = 100;
        this.bTP = 0.0f;
        this.bTQ = 0.0f;
        this.bTR = 0.0f;
        this.bTS = 0.0f;
        this.bTT = 0.0f;
        this.bTU = 0.0f;
        this.radius = 0.0f;
        this.bTV = new RectF();
        this.bTW = new RectF();
        this.bTX = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bTY = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bTZ = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.textSize = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bTI = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bTN = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bTL = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bTM = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bTH = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bTH == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bTI;
            this.bTI = i2;
        }
        this.bTK = new Paint();
        this.bTK.setAntiAlias(true);
        this.bTK.setStyle(Paint.Style.STROKE);
        this.bTK.setStrokeWidth(this.bTL);
        this.bTK.setColor(this.progressColor);
        this.bTJ = new Paint();
        this.bTJ.setAntiAlias(true);
        this.bTJ.setStyle(Paint.Style.STROKE);
        this.bTJ.setStrokeWidth(this.bTL);
        this.bTJ.setColor(this.bTI);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            XD();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void XD() {
        this.bTU = 3.14f * getMeasuredHeight();
        this.bTT = this.bTU / 2.0f;
        this.radius = (getMeasuredHeight() - this.bTL) / 2.0f;
        this.bTY = this.bTL / 2.0f;
        this.bTP = (((getMeasuredWidth() - this.bTL) - getMeasuredHeight()) + this.bTT) * 2.0f;
        this.bTQ = (getMeasuredWidth() - this.bTL) - (this.radius * 2.0f);
        this.bTR = this.bTQ + this.bTT;
        this.bTS = this.bTR + this.bTQ;
        this.startX = this.bTY + this.radius;
        this.startY = this.bTY;
        this.bTW.left = (this.startX + this.bTQ) - this.radius;
        this.bTW.top = this.startY;
        this.bTW.right = getMeasuredWidth() - this.bTY;
        this.bTW.bottom = this.startY + (this.radius * 2.0f);
        this.bTV.left = this.bTY;
        this.bTV.top = this.startY;
        this.bTV.right = this.bTY + (this.radius * 2.0f);
        this.bTV.bottom = this.startY + (this.radius * 2.0f);
        this.bTX.left = this.bTY;
        this.bTX.top = this.startY;
        this.bTX.right = getMeasuredWidth() - this.bTY;
        this.bTX.bottom = this.startY + (this.radius * 2.0f);
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
        canvas.drawRoundRect(this.bTX, this.radius, this.radius, this.bTJ);
        this.bTZ.reset();
        this.bTZ.moveTo(this.startX, this.startY);
        float f = (this.bTP * this.currentProgress) / this.bTN;
        if (f >= this.bTP) {
            this.bTZ.lineTo(this.startX + this.bTQ, this.startY);
            this.bTZ.arcTo(this.bTW, -90.0f, 180.0f, false);
            this.bTZ.lineTo(this.bTY + this.radius, this.startY + (this.radius * 2.0f));
            this.bTZ.arcTo(this.bTV, 90.0f, 180.0f, false);
            this.bTZ.lineTo(this.startX, this.startY);
        } else if (f > this.bTS) {
            this.bTZ.lineTo(this.startX + this.bTQ, this.startY);
            this.bTZ.arcTo(this.bTW, -90.0f, 180.0f, false);
            this.bTZ.lineTo(this.bTY + this.radius, this.startY + (this.radius * 2.0f));
            this.bTZ.arcTo(this.bTV, 90.0f, ((f - this.bTS) * 360.0f) / this.bTU, false);
        } else if (f > this.bTR) {
            this.bTZ.lineTo(this.startX + this.bTQ, this.startY);
            this.bTZ.arcTo(this.bTW, -90.0f, 180.0f, false);
            this.bTZ.lineTo(getMeasuredWidth() - ((f + (this.bTY + this.radius)) - this.bTR), this.startY + (this.radius * 2.0f));
        } else if (f > this.bTQ) {
            this.bTZ.lineTo(this.startX + this.bTQ, this.startY);
            this.bTZ.arcTo(this.bTW, -90.0f, ((f - this.bTQ) * 360.0f) / this.bTU, false);
        } else {
            this.bTZ.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bTZ, this.bTK);
        if (this.bTH == 0) {
            if (this.bTM == 0) {
                this.bTO = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bTN));
                this.bTO += "%";
            } else if (this.bTM == 2) {
                this.bTO = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bTM == 1) {
                this.bTO = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bTM == 0) {
            this.bTO = String.format("%d", Integer.valueOf(((this.bTN - this.currentProgress) * 100) / this.bTN));
            this.bTO += "%";
        } else if (this.bTM == 2) {
            this.bTO = String.format("%d", Integer.valueOf(this.bTN - this.currentProgress));
        } else if (this.bTM == 1) {
            this.bTO = (this.bTN - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bTO, this.centerX - (this.textPaint.measureText(this.bTO) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bTH == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bTN - i;
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
