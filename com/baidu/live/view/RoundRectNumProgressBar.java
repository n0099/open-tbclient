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
    private int bUD;
    private int bUE;
    private Paint bUF;
    private Paint bUG;
    private float bUH;
    private int bUI;
    private int bUJ;
    private String bUK;
    private float bUL;
    private float bUM;
    private float bUN;
    private float bUO;
    private float bUP;
    private float bUQ;
    private RectF bUR;
    private RectF bUS;
    private RectF bUT;
    private float bUU;
    private Path bUV;
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
        this.bUJ = 100;
        this.bUL = 0.0f;
        this.bUM = 0.0f;
        this.bUN = 0.0f;
        this.bUO = 0.0f;
        this.bUP = 0.0f;
        this.bUQ = 0.0f;
        this.radius = 0.0f;
        this.bUR = new RectF();
        this.bUS = new RectF();
        this.bUT = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bUU = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bUV = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.textSize = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bUE = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bUJ = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bUH = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bUI = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bUD = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bUD == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bUE;
            this.bUE = i2;
        }
        this.bUG = new Paint();
        this.bUG.setAntiAlias(true);
        this.bUG.setStyle(Paint.Style.STROKE);
        this.bUG.setStrokeWidth(this.bUH);
        this.bUG.setColor(this.progressColor);
        this.bUF = new Paint();
        this.bUF.setAntiAlias(true);
        this.bUF.setStyle(Paint.Style.STROKE);
        this.bUF.setStrokeWidth(this.bUH);
        this.bUF.setColor(this.bUE);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            ZM();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void ZM() {
        this.bUQ = 3.14f * getMeasuredHeight();
        this.bUP = this.bUQ / 2.0f;
        this.radius = (getMeasuredHeight() - this.bUH) / 2.0f;
        this.bUU = this.bUH / 2.0f;
        this.bUL = (((getMeasuredWidth() - this.bUH) - getMeasuredHeight()) + this.bUP) * 2.0f;
        this.bUM = (getMeasuredWidth() - this.bUH) - (this.radius * 2.0f);
        this.bUN = this.bUM + this.bUP;
        this.bUO = this.bUN + this.bUM;
        this.startX = this.bUU + this.radius;
        this.startY = this.bUU;
        this.bUS.left = (this.startX + this.bUM) - this.radius;
        this.bUS.top = this.startY;
        this.bUS.right = getMeasuredWidth() - this.bUU;
        this.bUS.bottom = this.startY + (this.radius * 2.0f);
        this.bUR.left = this.bUU;
        this.bUR.top = this.startY;
        this.bUR.right = this.bUU + (this.radius * 2.0f);
        this.bUR.bottom = this.startY + (this.radius * 2.0f);
        this.bUT.left = this.bUU;
        this.bUT.top = this.startY;
        this.bUT.right = getMeasuredWidth() - this.bUU;
        this.bUT.bottom = this.startY + (this.radius * 2.0f);
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
        canvas.drawRoundRect(this.bUT, this.radius, this.radius, this.bUF);
        this.bUV.reset();
        this.bUV.moveTo(this.startX, this.startY);
        float f = (this.bUL * this.currentProgress) / this.bUJ;
        if (f >= this.bUL) {
            this.bUV.lineTo(this.startX + this.bUM, this.startY);
            this.bUV.arcTo(this.bUS, -90.0f, 180.0f, false);
            this.bUV.lineTo(this.bUU + this.radius, this.startY + (this.radius * 2.0f));
            this.bUV.arcTo(this.bUR, 90.0f, 180.0f, false);
            this.bUV.lineTo(this.startX, this.startY);
        } else if (f > this.bUO) {
            this.bUV.lineTo(this.startX + this.bUM, this.startY);
            this.bUV.arcTo(this.bUS, -90.0f, 180.0f, false);
            this.bUV.lineTo(this.bUU + this.radius, this.startY + (this.radius * 2.0f));
            this.bUV.arcTo(this.bUR, 90.0f, ((f - this.bUO) * 360.0f) / this.bUQ, false);
        } else if (f > this.bUN) {
            this.bUV.lineTo(this.startX + this.bUM, this.startY);
            this.bUV.arcTo(this.bUS, -90.0f, 180.0f, false);
            this.bUV.lineTo(getMeasuredWidth() - ((f + (this.bUU + this.radius)) - this.bUN), this.startY + (this.radius * 2.0f));
        } else if (f > this.bUM) {
            this.bUV.lineTo(this.startX + this.bUM, this.startY);
            this.bUV.arcTo(this.bUS, -90.0f, ((f - this.bUM) * 360.0f) / this.bUQ, false);
        } else {
            this.bUV.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bUV, this.bUG);
        if (this.bUD == 0) {
            if (this.bUI == 0) {
                this.bUK = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bUJ));
                this.bUK += "%";
            } else if (this.bUI == 2) {
                this.bUK = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bUI == 1) {
                this.bUK = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bUI == 0) {
            this.bUK = String.format("%d", Integer.valueOf(((this.bUJ - this.currentProgress) * 100) / this.bUJ));
            this.bUK += "%";
        } else if (this.bUI == 2) {
            this.bUK = String.format("%d", Integer.valueOf(this.bUJ - this.currentProgress));
        } else if (this.bUI == 1) {
            this.bUK = (this.bUJ - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bUK, this.centerX - (this.textPaint.measureText(this.bUK) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bUD == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bUJ - i;
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
