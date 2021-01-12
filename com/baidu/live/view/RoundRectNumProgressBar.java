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
/* loaded from: classes10.dex */
public class RoundRectNumProgressBar extends View {
    private int bPR;
    private int bPS;
    private Paint bPT;
    private Paint bPU;
    private float bPV;
    private int bPW;
    private int bPX;
    private String bPY;
    private float bPZ;
    private float bQa;
    private float bQb;
    private float bQc;
    private float bQd;
    private float bQe;
    private RectF bQf;
    private RectF bQg;
    private RectF bQh;
    private float bQi;
    private Path bQj;
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
        this.bPX = 100;
        this.bPZ = 0.0f;
        this.bQa = 0.0f;
        this.bQb = 0.0f;
        this.bQc = 0.0f;
        this.bQd = 0.0f;
        this.bQe = 0.0f;
        this.radius = 0.0f;
        this.bQf = new RectF();
        this.bQg = new RectF();
        this.bQh = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bQi = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bQj = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.textSize = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bPS = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bPX = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bPV = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bPW = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bPR = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bPR == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bPS;
            this.bPS = i2;
        }
        this.bPU = new Paint();
        this.bPU.setAntiAlias(true);
        this.bPU.setStyle(Paint.Style.STROKE);
        this.bPU.setStrokeWidth(this.bPV);
        this.bPU.setColor(this.progressColor);
        this.bPT = new Paint();
        this.bPT.setAntiAlias(true);
        this.bPT.setStyle(Paint.Style.STROKE);
        this.bPT.setStrokeWidth(this.bPV);
        this.bPT.setColor(this.bPS);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            VU();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void VU() {
        this.bQe = 3.14f * getMeasuredHeight();
        this.bQd = this.bQe / 2.0f;
        this.radius = (getMeasuredHeight() - this.bPV) / 2.0f;
        this.bQi = this.bPV / 2.0f;
        this.bPZ = (((getMeasuredWidth() - this.bPV) - getMeasuredHeight()) + this.bQd) * 2.0f;
        this.bQa = (getMeasuredWidth() - this.bPV) - (this.radius * 2.0f);
        this.bQb = this.bQa + this.bQd;
        this.bQc = this.bQb + this.bQa;
        this.startX = this.bQi + this.radius;
        this.startY = this.bQi;
        this.bQg.left = (this.startX + this.bQa) - this.radius;
        this.bQg.top = this.startY;
        this.bQg.right = getMeasuredWidth() - this.bQi;
        this.bQg.bottom = this.startY + (this.radius * 2.0f);
        this.bQf.left = this.bQi;
        this.bQf.top = this.startY;
        this.bQf.right = this.bQi + (this.radius * 2.0f);
        this.bQf.bottom = this.startY + (this.radius * 2.0f);
        this.bQh.left = this.bQi;
        this.bQh.top = this.startY;
        this.bQh.right = getMeasuredWidth() - this.bQi;
        this.bQh.bottom = this.startY + (this.radius * 2.0f);
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
        canvas.drawRoundRect(this.bQh, this.radius, this.radius, this.bPT);
        this.bQj.reset();
        this.bQj.moveTo(this.startX, this.startY);
        float f = (this.bPZ * this.currentProgress) / this.bPX;
        if (f >= this.bPZ) {
            this.bQj.lineTo(this.startX + this.bQa, this.startY);
            this.bQj.arcTo(this.bQg, -90.0f, 180.0f, false);
            this.bQj.lineTo(this.bQi + this.radius, this.startY + (this.radius * 2.0f));
            this.bQj.arcTo(this.bQf, 90.0f, 180.0f, false);
            this.bQj.lineTo(this.startX, this.startY);
        } else if (f > this.bQc) {
            this.bQj.lineTo(this.startX + this.bQa, this.startY);
            this.bQj.arcTo(this.bQg, -90.0f, 180.0f, false);
            this.bQj.lineTo(this.bQi + this.radius, this.startY + (this.radius * 2.0f));
            this.bQj.arcTo(this.bQf, 90.0f, ((f - this.bQc) * 360.0f) / this.bQe, false);
        } else if (f > this.bQb) {
            this.bQj.lineTo(this.startX + this.bQa, this.startY);
            this.bQj.arcTo(this.bQg, -90.0f, 180.0f, false);
            this.bQj.lineTo(getMeasuredWidth() - ((f + (this.bQi + this.radius)) - this.bQb), this.startY + (this.radius * 2.0f));
        } else if (f > this.bQa) {
            this.bQj.lineTo(this.startX + this.bQa, this.startY);
            this.bQj.arcTo(this.bQg, -90.0f, ((f - this.bQa) * 360.0f) / this.bQe, false);
        } else {
            this.bQj.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bQj, this.bPU);
        if (this.bPR == 0) {
            if (this.bPW == 0) {
                this.bPY = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bPX));
                this.bPY += "%";
            } else if (this.bPW == 2) {
                this.bPY = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bPW == 1) {
                this.bPY = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bPW == 0) {
            this.bPY = String.format("%d", Integer.valueOf(((this.bPX - this.currentProgress) * 100) / this.bPX));
            this.bPY += "%";
        } else if (this.bPW == 2) {
            this.bPY = String.format("%d", Integer.valueOf(this.bPX - this.currentProgress));
        } else if (this.bPW == 1) {
            this.bPY = (this.bPX - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bPY, this.centerX - (this.textPaint.measureText(this.bPY) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bPR == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bPX - i;
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
