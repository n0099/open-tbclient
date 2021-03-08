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
    private int bVh;
    private int bVi;
    private Paint bVj;
    private Paint bVk;
    private float bVl;
    private int bVm;
    private int bVn;
    private String bVo;
    private float bVp;
    private float bVq;
    private float bVr;
    private float bVs;
    private float bVt;
    private float bVu;
    private RectF bVv;
    private RectF bVw;
    private RectF bVx;
    private float bVy;
    private Path bVz;
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
        this.bVn = 100;
        this.bVp = 0.0f;
        this.bVq = 0.0f;
        this.bVr = 0.0f;
        this.bVs = 0.0f;
        this.bVt = 0.0f;
        this.bVu = 0.0f;
        this.radius = 0.0f;
        this.bVv = new RectF();
        this.bVw = new RectF();
        this.bVx = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bVy = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bVz = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.textSize = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bVi = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.j.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bVn = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bVl = obtainStyledAttributes.getDimension(a.j.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bVm = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bVh = obtainStyledAttributes.getInt(a.j.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bVh == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bVi;
            this.bVi = i2;
        }
        this.bVk = new Paint();
        this.bVk.setAntiAlias(true);
        this.bVk.setStyle(Paint.Style.STROKE);
        this.bVk.setStrokeWidth(this.bVl);
        this.bVk.setColor(this.progressColor);
        this.bVj = new Paint();
        this.bVj.setAntiAlias(true);
        this.bVj.setStyle(Paint.Style.STROKE);
        this.bVj.setStrokeWidth(this.bVl);
        this.bVj.setColor(this.bVi);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            XG();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void XG() {
        this.bVu = 3.14f * getMeasuredHeight();
        this.bVt = this.bVu / 2.0f;
        this.radius = (getMeasuredHeight() - this.bVl) / 2.0f;
        this.bVy = this.bVl / 2.0f;
        this.bVp = (((getMeasuredWidth() - this.bVl) - getMeasuredHeight()) + this.bVt) * 2.0f;
        this.bVq = (getMeasuredWidth() - this.bVl) - (this.radius * 2.0f);
        this.bVr = this.bVq + this.bVt;
        this.bVs = this.bVr + this.bVq;
        this.startX = this.bVy + this.radius;
        this.startY = this.bVy;
        this.bVw.left = (this.startX + this.bVq) - this.radius;
        this.bVw.top = this.startY;
        this.bVw.right = getMeasuredWidth() - this.bVy;
        this.bVw.bottom = this.startY + (this.radius * 2.0f);
        this.bVv.left = this.bVy;
        this.bVv.top = this.startY;
        this.bVv.right = this.bVy + (this.radius * 2.0f);
        this.bVv.bottom = this.startY + (this.radius * 2.0f);
        this.bVx.left = this.bVy;
        this.bVx.top = this.startY;
        this.bVx.right = getMeasuredWidth() - this.bVy;
        this.bVx.bottom = this.startY + (this.radius * 2.0f);
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
        canvas.drawRoundRect(this.bVx, this.radius, this.radius, this.bVj);
        this.bVz.reset();
        this.bVz.moveTo(this.startX, this.startY);
        float f = (this.bVp * this.currentProgress) / this.bVn;
        if (f >= this.bVp) {
            this.bVz.lineTo(this.startX + this.bVq, this.startY);
            this.bVz.arcTo(this.bVw, -90.0f, 180.0f, false);
            this.bVz.lineTo(this.bVy + this.radius, this.startY + (this.radius * 2.0f));
            this.bVz.arcTo(this.bVv, 90.0f, 180.0f, false);
            this.bVz.lineTo(this.startX, this.startY);
        } else if (f > this.bVs) {
            this.bVz.lineTo(this.startX + this.bVq, this.startY);
            this.bVz.arcTo(this.bVw, -90.0f, 180.0f, false);
            this.bVz.lineTo(this.bVy + this.radius, this.startY + (this.radius * 2.0f));
            this.bVz.arcTo(this.bVv, 90.0f, ((f - this.bVs) * 360.0f) / this.bVu, false);
        } else if (f > this.bVr) {
            this.bVz.lineTo(this.startX + this.bVq, this.startY);
            this.bVz.arcTo(this.bVw, -90.0f, 180.0f, false);
            this.bVz.lineTo(getMeasuredWidth() - ((f + (this.bVy + this.radius)) - this.bVr), this.startY + (this.radius * 2.0f));
        } else if (f > this.bVq) {
            this.bVz.lineTo(this.startX + this.bVq, this.startY);
            this.bVz.arcTo(this.bVw, -90.0f, ((f - this.bVq) * 360.0f) / this.bVu, false);
        } else {
            this.bVz.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bVz, this.bVk);
        if (this.bVh == 0) {
            if (this.bVm == 0) {
                this.bVo = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bVn));
                this.bVo += "%";
            } else if (this.bVm == 2) {
                this.bVo = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bVm == 1) {
                this.bVo = this.currentProgress + getContext().getResources().getString(a.h.sdk_time_second);
            }
        } else if (this.bVm == 0) {
            this.bVo = String.format("%d", Integer.valueOf(((this.bVn - this.currentProgress) * 100) / this.bVn));
            this.bVo += "%";
        } else if (this.bVm == 2) {
            this.bVo = String.format("%d", Integer.valueOf(this.bVn - this.currentProgress));
        } else if (this.bVm == 1) {
            this.bVo = (this.bVn - this.currentProgress) + getContext().getResources().getString(a.h.sdk_time_second);
        }
        canvas.drawText(this.bVo, this.centerX - (this.textPaint.measureText(this.bVo) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bVh == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bVn - i;
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
