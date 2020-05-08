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
    private int baA;
    private int baB;
    private float baR;
    private int baS;
    private int baT;
    private Paint baU;
    private Paint baV;
    private float baW;
    private int baX;
    private int baY;
    private String baZ;
    private float bba;
    private float bbb;
    private float bbc;
    private float bbd;
    private float bbe;
    private float bbf;
    private float bbg;
    private RectF bbh;
    private RectF bbi;
    private RectF bbj;
    private float bbk;
    private Path bbl;
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
        this.baY = 100;
        this.bba = 0.0f;
        this.bbb = 0.0f;
        this.bbc = 0.0f;
        this.bbd = 0.0f;
        this.bbe = 0.0f;
        this.bbf = 0.0f;
        this.bbg = 0.0f;
        this.bbh = new RectF();
        this.bbi = new RectF();
        this.bbj = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bbk = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bbl = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.baR = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.baT = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.baY = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.baW = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.baX = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.baS = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.baS == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.baT;
            this.baT = i2;
        }
        this.baV = new Paint();
        this.baV.setAntiAlias(true);
        this.baV.setStyle(Paint.Style.STROKE);
        this.baV.setStrokeWidth(this.baW);
        this.baV.setColor(this.progressColor);
        this.baU = new Paint();
        this.baU.setAntiAlias(true);
        this.baU.setStyle(Paint.Style.STROKE);
        this.baU.setStrokeWidth(this.baW);
        this.baU.setColor(this.baT);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.baR);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.baA == 0 || this.baB == 0 || this.baA != getMeasuredWidth() || this.baB != getMeasuredHeight()) {
            Hz();
            this.baA = getMeasuredWidth();
            this.baB = getMeasuredHeight();
        }
    }

    private void Hz() {
        this.bbf = 3.14f * getMeasuredHeight();
        this.bbe = this.bbf / 2.0f;
        this.bbg = (getMeasuredHeight() - this.baW) / 2.0f;
        this.bbk = this.baW / 2.0f;
        this.bba = (((getMeasuredWidth() - this.baW) - getMeasuredHeight()) + this.bbe) * 2.0f;
        this.bbb = (getMeasuredWidth() - this.baW) - (this.bbg * 2.0f);
        this.bbc = this.bbb + this.bbe;
        this.bbd = this.bbc + this.bbb;
        this.startX = this.bbk + this.bbg;
        this.startY = this.bbk;
        this.bbi.left = (this.startX + this.bbb) - this.bbg;
        this.bbi.top = this.startY;
        this.bbi.right = getMeasuredWidth() - this.bbk;
        this.bbi.bottom = this.startY + (this.bbg * 2.0f);
        this.bbh.left = this.bbk;
        this.bbh.top = this.startY;
        this.bbh.right = this.bbk + (this.bbg * 2.0f);
        this.bbh.bottom = this.startY + (this.bbg * 2.0f);
        this.bbj.left = this.bbk;
        this.bbj.top = this.startY;
        this.bbj.right = getMeasuredWidth() - this.bbk;
        this.bbj.bottom = this.startY + (this.bbg * 2.0f);
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
        canvas.drawRoundRect(this.bbj, this.bbg, this.bbg, this.baU);
        this.bbl.reset();
        this.bbl.moveTo(this.startX, this.startY);
        float f = (this.bba * this.currentProgress) / this.baY;
        if (f >= this.bba) {
            this.bbl.lineTo(this.startX + this.bbb, this.startY);
            this.bbl.arcTo(this.bbi, -90.0f, 180.0f, false);
            this.bbl.lineTo(this.bbk + this.bbg, this.startY + (this.bbg * 2.0f));
            this.bbl.arcTo(this.bbh, 90.0f, 180.0f, false);
            this.bbl.lineTo(this.startX, this.startY);
        } else if (f > this.bbd) {
            this.bbl.lineTo(this.startX + this.bbb, this.startY);
            this.bbl.arcTo(this.bbi, -90.0f, 180.0f, false);
            this.bbl.lineTo(this.bbk + this.bbg, this.startY + (this.bbg * 2.0f));
            this.bbl.arcTo(this.bbh, 90.0f, ((f - this.bbd) * 360.0f) / this.bbf, false);
        } else if (f > this.bbc) {
            this.bbl.lineTo(this.startX + this.bbb, this.startY);
            this.bbl.arcTo(this.bbi, -90.0f, 180.0f, false);
            this.bbl.lineTo(getMeasuredWidth() - ((f + (this.bbk + this.bbg)) - this.bbc), this.startY + (this.bbg * 2.0f));
        } else if (f > this.bbb) {
            this.bbl.lineTo(this.startX + this.bbb, this.startY);
            this.bbl.arcTo(this.bbi, -90.0f, ((f - this.bbb) * 360.0f) / this.bbf, false);
        } else {
            this.bbl.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bbl, this.baV);
        if (this.baS == 0) {
            if (this.baX == 0) {
                this.baZ = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.baY));
                this.baZ += "%";
            } else if (this.baX == 2) {
                this.baZ = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.baX == 1) {
                this.baZ = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.baX == 0) {
            this.baZ = String.format("%d", Integer.valueOf(((this.baY - this.currentProgress) * 100) / this.baY));
            this.baZ += "%";
        } else if (this.baX == 2) {
            this.baZ = String.format("%d", Integer.valueOf(this.baY - this.currentProgress));
        } else if (this.baX == 1) {
            this.baZ = (this.baY - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.baZ, this.centerX - (this.textPaint.measureText(this.baZ) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.baS == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.baY - i;
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
