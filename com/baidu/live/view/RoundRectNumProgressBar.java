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
    private int aEA;
    private float aEQ;
    private int aER;
    private int aES;
    private Paint aET;
    private Paint aEU;
    private float aEV;
    private int aEW;
    private int aEX;
    private String aEY;
    private float aEZ;
    private int aEz;
    private float aFa;
    private float aFb;
    private float aFc;
    private float aFd;
    private float aFe;
    private float aFf;
    private RectF aFg;
    private RectF aFh;
    private RectF aFi;
    private float aFj;
    private Path aFk;
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
        this.aEX = 100;
        this.aEZ = 0.0f;
        this.aFa = 0.0f;
        this.aFb = 0.0f;
        this.aFc = 0.0f;
        this.aFd = 0.0f;
        this.aFe = 0.0f;
        this.aFf = 0.0f;
        this.aFg = new RectF();
        this.aFh = new RectF();
        this.aFi = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.aFj = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.aFk = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.aEQ = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.aES = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.aEX = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.aEV = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.aEW = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.aER = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.aER == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.aES;
            this.aES = i2;
        }
        this.aEU = new Paint();
        this.aEU.setAntiAlias(true);
        this.aEU.setStyle(Paint.Style.STROKE);
        this.aEU.setStrokeWidth(this.aEV);
        this.aEU.setColor(this.progressColor);
        this.aET = new Paint();
        this.aET.setAntiAlias(true);
        this.aET.setStyle(Paint.Style.STROKE);
        this.aET.setStrokeWidth(this.aEV);
        this.aET.setColor(this.aES);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.aEQ);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.aEz == 0 || this.aEA == 0 || this.aEz != getMeasuredWidth() || this.aEA != getMeasuredHeight()) {
            Bp();
            this.aEz = getMeasuredWidth();
            this.aEA = getMeasuredHeight();
        }
    }

    private void Bp() {
        this.aFe = 3.14f * getMeasuredHeight();
        this.aFd = this.aFe / 2.0f;
        this.aFf = (getMeasuredHeight() - this.aEV) / 2.0f;
        this.aFj = this.aEV / 2.0f;
        this.aEZ = (((getMeasuredWidth() - this.aEV) - getMeasuredHeight()) + this.aFd) * 2.0f;
        this.aFa = (getMeasuredWidth() - this.aEV) - (this.aFf * 2.0f);
        this.aFb = this.aFa + this.aFd;
        this.aFc = this.aFb + this.aFa;
        this.startX = this.aFj + this.aFf;
        this.startY = this.aFj;
        this.aFh.left = (this.startX + this.aFa) - this.aFf;
        this.aFh.top = this.startY;
        this.aFh.right = getMeasuredWidth() - this.aFj;
        this.aFh.bottom = this.startY + (this.aFf * 2.0f);
        this.aFg.left = this.aFj;
        this.aFg.top = this.startY;
        this.aFg.right = this.aFj + (this.aFf * 2.0f);
        this.aFg.bottom = this.startY + (this.aFf * 2.0f);
        this.aFi.left = this.aFj;
        this.aFi.top = this.startY;
        this.aFi.right = getMeasuredWidth() - this.aFj;
        this.aFi.bottom = this.startY + (this.aFf * 2.0f);
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
        canvas.drawRoundRect(this.aFi, this.aFf, this.aFf, this.aET);
        this.aFk.reset();
        this.aFk.moveTo(this.startX, this.startY);
        float f = (this.aEZ * this.currentProgress) / this.aEX;
        if (f >= this.aEZ) {
            this.aFk.lineTo(this.startX + this.aFa, this.startY);
            this.aFk.arcTo(this.aFh, -90.0f, 180.0f, false);
            this.aFk.lineTo(this.aFj + this.aFf, this.startY + (this.aFf * 2.0f));
            this.aFk.arcTo(this.aFg, 90.0f, 180.0f, false);
            this.aFk.lineTo(this.startX, this.startY);
        } else if (f > this.aFc) {
            this.aFk.lineTo(this.startX + this.aFa, this.startY);
            this.aFk.arcTo(this.aFh, -90.0f, 180.0f, false);
            this.aFk.lineTo(this.aFj + this.aFf, this.startY + (this.aFf * 2.0f));
            this.aFk.arcTo(this.aFg, 90.0f, ((f - this.aFc) * 360.0f) / this.aFe, false);
        } else if (f > this.aFb) {
            this.aFk.lineTo(this.startX + this.aFa, this.startY);
            this.aFk.arcTo(this.aFh, -90.0f, 180.0f, false);
            this.aFk.lineTo(getMeasuredWidth() - ((f + (this.aFj + this.aFf)) - this.aFb), this.startY + (this.aFf * 2.0f));
        } else if (f > this.aFa) {
            this.aFk.lineTo(this.startX + this.aFa, this.startY);
            this.aFk.arcTo(this.aFh, -90.0f, ((f - this.aFa) * 360.0f) / this.aFe, false);
        } else {
            this.aFk.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.aFk, this.aEU);
        if (this.aER == 0) {
            if (this.aEW == 0) {
                this.aEY = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.aEX));
                this.aEY += "%";
            } else if (this.aEW == 2) {
                this.aEY = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.aEW == 1) {
                this.aEY = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.aEW == 0) {
            this.aEY = String.format("%d", Integer.valueOf(((this.aEX - this.currentProgress) * 100) / this.aEX));
            this.aEY += "%";
        } else if (this.aEW == 2) {
            this.aEY = String.format("%d", Integer.valueOf(this.aEX - this.currentProgress));
        } else if (this.aEW == 1) {
            this.aEY = (this.aEX - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.aEY, this.centerX - (this.textPaint.measureText(this.aEY) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.aER == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.aEX - i;
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
