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
    private float aEP;
    private int aEQ;
    private int aER;
    private Paint aES;
    private Paint aET;
    private float aEU;
    private int aEV;
    private int aEW;
    private String aEX;
    private float aEY;
    private float aEZ;
    private int aEy;
    private int aEz;
    private float aFa;
    private float aFb;
    private float aFc;
    private float aFd;
    private float aFe;
    private RectF aFf;
    private RectF aFg;
    private RectF aFh;
    private float aFi;
    private Path aFj;
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
        this.aEW = 100;
        this.aEY = 0.0f;
        this.aEZ = 0.0f;
        this.aFa = 0.0f;
        this.aFb = 0.0f;
        this.aFc = 0.0f;
        this.aFd = 0.0f;
        this.aFe = 0.0f;
        this.aFf = new RectF();
        this.aFg = new RectF();
        this.aFh = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.aFi = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.aFj = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.aEP = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.aER = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.aEW = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.aEU = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.aEV = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.aEQ = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.aEQ == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.aER;
            this.aER = i2;
        }
        this.aET = new Paint();
        this.aET.setAntiAlias(true);
        this.aET.setStyle(Paint.Style.STROKE);
        this.aET.setStrokeWidth(this.aEU);
        this.aET.setColor(this.progressColor);
        this.aES = new Paint();
        this.aES.setAntiAlias(true);
        this.aES.setStyle(Paint.Style.STROKE);
        this.aES.setStrokeWidth(this.aEU);
        this.aES.setColor(this.aER);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.aEP);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.aEy == 0 || this.aEz == 0 || this.aEy != getMeasuredWidth() || this.aEz != getMeasuredHeight()) {
            Bn();
            this.aEy = getMeasuredWidth();
            this.aEz = getMeasuredHeight();
        }
    }

    private void Bn() {
        this.aFd = 3.14f * getMeasuredHeight();
        this.aFc = this.aFd / 2.0f;
        this.aFe = (getMeasuredHeight() - this.aEU) / 2.0f;
        this.aFi = this.aEU / 2.0f;
        this.aEY = (((getMeasuredWidth() - this.aEU) - getMeasuredHeight()) + this.aFc) * 2.0f;
        this.aEZ = (getMeasuredWidth() - this.aEU) - (this.aFe * 2.0f);
        this.aFa = this.aEZ + this.aFc;
        this.aFb = this.aFa + this.aEZ;
        this.startX = this.aFi + this.aFe;
        this.startY = this.aFi;
        this.aFg.left = (this.startX + this.aEZ) - this.aFe;
        this.aFg.top = this.startY;
        this.aFg.right = getMeasuredWidth() - this.aFi;
        this.aFg.bottom = this.startY + (this.aFe * 2.0f);
        this.aFf.left = this.aFi;
        this.aFf.top = this.startY;
        this.aFf.right = this.aFi + (this.aFe * 2.0f);
        this.aFf.bottom = this.startY + (this.aFe * 2.0f);
        this.aFh.left = this.aFi;
        this.aFh.top = this.startY;
        this.aFh.right = getMeasuredWidth() - this.aFi;
        this.aFh.bottom = this.startY + (this.aFe * 2.0f);
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
        canvas.drawRoundRect(this.aFh, this.aFe, this.aFe, this.aES);
        this.aFj.reset();
        this.aFj.moveTo(this.startX, this.startY);
        float f = (this.aEY * this.currentProgress) / this.aEW;
        if (f >= this.aEY) {
            this.aFj.lineTo(this.startX + this.aEZ, this.startY);
            this.aFj.arcTo(this.aFg, -90.0f, 180.0f, false);
            this.aFj.lineTo(this.aFi + this.aFe, this.startY + (this.aFe * 2.0f));
            this.aFj.arcTo(this.aFf, 90.0f, 180.0f, false);
            this.aFj.lineTo(this.startX, this.startY);
        } else if (f > this.aFb) {
            this.aFj.lineTo(this.startX + this.aEZ, this.startY);
            this.aFj.arcTo(this.aFg, -90.0f, 180.0f, false);
            this.aFj.lineTo(this.aFi + this.aFe, this.startY + (this.aFe * 2.0f));
            this.aFj.arcTo(this.aFf, 90.0f, ((f - this.aFb) * 360.0f) / this.aFd, false);
        } else if (f > this.aFa) {
            this.aFj.lineTo(this.startX + this.aEZ, this.startY);
            this.aFj.arcTo(this.aFg, -90.0f, 180.0f, false);
            this.aFj.lineTo(getMeasuredWidth() - ((f + (this.aFi + this.aFe)) - this.aFa), this.startY + (this.aFe * 2.0f));
        } else if (f > this.aEZ) {
            this.aFj.lineTo(this.startX + this.aEZ, this.startY);
            this.aFj.arcTo(this.aFg, -90.0f, ((f - this.aEZ) * 360.0f) / this.aFd, false);
        } else {
            this.aFj.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.aFj, this.aET);
        if (this.aEQ == 0) {
            if (this.aEV == 0) {
                this.aEX = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.aEW));
                this.aEX += "%";
            } else if (this.aEV == 2) {
                this.aEX = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.aEV == 1) {
                this.aEX = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.aEV == 0) {
            this.aEX = String.format("%d", Integer.valueOf(((this.aEW - this.currentProgress) * 100) / this.aEW));
            this.aEX += "%";
        } else if (this.aEV == 2) {
            this.aEX = String.format("%d", Integer.valueOf(this.aEW - this.currentProgress));
        } else if (this.aEV == 1) {
            this.aEX = (this.aEW - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.aEX, this.centerX - (this.textPaint.measureText(this.aEX) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.aEQ == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.aEW - i;
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
