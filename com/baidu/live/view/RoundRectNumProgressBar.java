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
    private float bwX;
    private int bwY;
    private int bwZ;
    private Paint bxa;
    private Paint bxb;
    private float bxc;
    private int bxd;
    private int bxe;
    private String bxf;
    private float bxg;
    private float bxh;
    private float bxi;
    private float bxj;
    private float bxk;
    private float bxl;
    private float bxm;
    private RectF bxn;
    private RectF bxo;
    private RectF bxp;
    private float bxq;
    private Path bxr;
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
        this.bxe = 100;
        this.bxg = 0.0f;
        this.bxh = 0.0f;
        this.bxi = 0.0f;
        this.bxj = 0.0f;
        this.bxk = 0.0f;
        this.bxl = 0.0f;
        this.bxm = 0.0f;
        this.bxn = new RectF();
        this.bxo = new RectF();
        this.bxp = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bxq = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bxr = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bwX = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bwZ = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bxe = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bxc = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bxd = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bwY = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bwY == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bwZ;
            this.bwZ = i2;
        }
        this.bxb = new Paint();
        this.bxb.setAntiAlias(true);
        this.bxb.setStyle(Paint.Style.STROKE);
        this.bxb.setStrokeWidth(this.bxc);
        this.bxb.setColor(this.progressColor);
        this.bxa = new Paint();
        this.bxa.setAntiAlias(true);
        this.bxa.setStyle(Paint.Style.STROKE);
        this.bxa.setStrokeWidth(this.bxc);
        this.bxa.setColor(this.bwZ);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bwX);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.lastWidth == 0 || this.lastHeight == 0 || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            Rt();
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    private void Rt() {
        this.bxl = 3.14f * getMeasuredHeight();
        this.bxk = this.bxl / 2.0f;
        this.bxm = (getMeasuredHeight() - this.bxc) / 2.0f;
        this.bxq = this.bxc / 2.0f;
        this.bxg = (((getMeasuredWidth() - this.bxc) - getMeasuredHeight()) + this.bxk) * 2.0f;
        this.bxh = (getMeasuredWidth() - this.bxc) - (this.bxm * 2.0f);
        this.bxi = this.bxh + this.bxk;
        this.bxj = this.bxi + this.bxh;
        this.startX = this.bxq + this.bxm;
        this.startY = this.bxq;
        this.bxo.left = (this.startX + this.bxh) - this.bxm;
        this.bxo.top = this.startY;
        this.bxo.right = getMeasuredWidth() - this.bxq;
        this.bxo.bottom = this.startY + (this.bxm * 2.0f);
        this.bxn.left = this.bxq;
        this.bxn.top = this.startY;
        this.bxn.right = this.bxq + (this.bxm * 2.0f);
        this.bxn.bottom = this.startY + (this.bxm * 2.0f);
        this.bxp.left = this.bxq;
        this.bxp.top = this.startY;
        this.bxp.right = getMeasuredWidth() - this.bxq;
        this.bxp.bottom = this.startY + (this.bxm * 2.0f);
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
        canvas.drawRoundRect(this.bxp, this.bxm, this.bxm, this.bxa);
        this.bxr.reset();
        this.bxr.moveTo(this.startX, this.startY);
        float f = (this.bxg * this.currentProgress) / this.bxe;
        if (f >= this.bxg) {
            this.bxr.lineTo(this.startX + this.bxh, this.startY);
            this.bxr.arcTo(this.bxo, -90.0f, 180.0f, false);
            this.bxr.lineTo(this.bxq + this.bxm, this.startY + (this.bxm * 2.0f));
            this.bxr.arcTo(this.bxn, 90.0f, 180.0f, false);
            this.bxr.lineTo(this.startX, this.startY);
        } else if (f > this.bxj) {
            this.bxr.lineTo(this.startX + this.bxh, this.startY);
            this.bxr.arcTo(this.bxo, -90.0f, 180.0f, false);
            this.bxr.lineTo(this.bxq + this.bxm, this.startY + (this.bxm * 2.0f));
            this.bxr.arcTo(this.bxn, 90.0f, ((f - this.bxj) * 360.0f) / this.bxl, false);
        } else if (f > this.bxi) {
            this.bxr.lineTo(this.startX + this.bxh, this.startY);
            this.bxr.arcTo(this.bxo, -90.0f, 180.0f, false);
            this.bxr.lineTo(getMeasuredWidth() - ((f + (this.bxq + this.bxm)) - this.bxi), this.startY + (this.bxm * 2.0f));
        } else if (f > this.bxh) {
            this.bxr.lineTo(this.startX + this.bxh, this.startY);
            this.bxr.arcTo(this.bxo, -90.0f, ((f - this.bxh) * 360.0f) / this.bxl, false);
        } else {
            this.bxr.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bxr, this.bxb);
        if (this.bwY == 0) {
            if (this.bxd == 0) {
                this.bxf = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bxe));
                this.bxf += "%";
            } else if (this.bxd == 2) {
                this.bxf = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bxd == 1) {
                this.bxf = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.bxd == 0) {
            this.bxf = String.format("%d", Integer.valueOf(((this.bxe - this.currentProgress) * 100) / this.bxe));
            this.bxf += "%";
        } else if (this.bxd == 2) {
            this.bxf = String.format("%d", Integer.valueOf(this.bxe - this.currentProgress));
        } else if (this.bxd == 1) {
            this.bxf = (this.bxe - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.bxf, this.centerX - (this.textPaint.measureText(this.bxf) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bwY == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bxe - i;
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
