package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class RoundRectNumProgressBar extends View {
    private float aAa;
    private float aAb;
    private float aAc;
    private float aAd;
    private float aAe;
    private RectF aAf;
    private RectF aAg;
    private RectF aAh;
    private float aAi;
    private Path aAj;
    private float azO;
    private int azP;
    private int azQ;
    private Paint azR;
    private Paint azS;
    private float azT;
    private int azU;
    private int azV;
    private int azW;
    private String azX;
    private float azY;
    private float azZ;
    private int azy;
    private int azz;
    private float centerX;
    private float centerY;
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
        this.azV = 0;
        this.azW = 100;
        this.azY = 0.0f;
        this.azZ = 0.0f;
        this.aAa = 0.0f;
        this.aAb = 0.0f;
        this.aAc = 0.0f;
        this.aAd = 0.0f;
        this.aAe = 0.0f;
        this.aAf = new RectF();
        this.aAg = new RectF();
        this.aAh = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.aAi = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.aAj = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.azO = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.azQ = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.azV = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.azW = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.azT = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.azU = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.azP = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.azP == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.azQ;
            this.azQ = i2;
        }
        this.azS = new Paint();
        this.azS.setAntiAlias(true);
        this.azS.setStyle(Paint.Style.STROKE);
        this.azS.setStrokeWidth(this.azT);
        this.azS.setColor(this.progressColor);
        this.azR = new Paint();
        this.azR.setAntiAlias(true);
        this.azR.setStyle(Paint.Style.STROKE);
        this.azR.setStrokeWidth(this.azT);
        this.azR.setColor(this.azQ);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.azO);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.azy == 0 || this.azz == 0 || this.azy != getMeasuredWidth() || this.azz != getMeasuredHeight()) {
            yE();
            this.azy = getMeasuredWidth();
            this.azz = getMeasuredHeight();
        }
    }

    private void yE() {
        this.aAd = 3.14f * getMeasuredHeight();
        this.aAc = this.aAd / 2.0f;
        this.aAe = (getMeasuredHeight() - this.azT) / 2.0f;
        this.aAi = this.azT / 2.0f;
        this.azY = (((getMeasuredWidth() - this.azT) - getMeasuredHeight()) + this.aAc) * 2.0f;
        this.azZ = (getMeasuredWidth() - this.azT) - (this.aAe * 2.0f);
        this.aAa = this.azZ + this.aAc;
        this.aAb = this.aAa + this.azZ;
        this.startX = this.aAi + this.aAe;
        this.startY = this.aAi;
        this.aAg.left = (this.startX + this.azZ) - this.aAe;
        this.aAg.top = this.startY;
        this.aAg.right = getMeasuredWidth() - this.aAi;
        this.aAg.bottom = this.startY + (this.aAe * 2.0f);
        this.aAf.left = this.aAi;
        this.aAf.top = this.startY;
        this.aAf.right = this.aAi + (this.aAe * 2.0f);
        this.aAf.bottom = this.startY + (this.aAe * 2.0f);
        this.aAh.left = this.aAi;
        this.aAh.top = this.startY;
        this.aAh.right = getMeasuredWidth() - this.aAi;
        this.aAh.bottom = this.startY + (this.aAe * 2.0f);
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
        canvas.drawRoundRect(this.aAh, this.aAe, this.aAe, this.azR);
        this.aAj.reset();
        this.aAj.moveTo(this.startX, this.startY);
        float f = (this.azY * this.azV) / this.azW;
        if (f >= this.azY) {
            this.aAj.lineTo(this.startX + this.azZ, this.startY);
            this.aAj.arcTo(this.aAg, -90.0f, 180.0f, false);
            this.aAj.lineTo(this.aAi + this.aAe, this.startY + (this.aAe * 2.0f));
            this.aAj.arcTo(this.aAf, 90.0f, 180.0f, false);
            this.aAj.lineTo(this.startX, this.startY);
        } else if (f > this.aAb) {
            this.aAj.lineTo(this.startX + this.azZ, this.startY);
            this.aAj.arcTo(this.aAg, -90.0f, 180.0f, false);
            this.aAj.lineTo(this.aAi + this.aAe, this.startY + (this.aAe * 2.0f));
            this.aAj.arcTo(this.aAf, 90.0f, ((f - this.aAb) * 360.0f) / this.aAd, false);
        } else if (f > this.aAa) {
            this.aAj.lineTo(this.startX + this.azZ, this.startY);
            this.aAj.arcTo(this.aAg, -90.0f, 180.0f, false);
            this.aAj.lineTo(getMeasuredWidth() - ((f + (this.aAi + this.aAe)) - this.aAa), this.startY + (this.aAe * 2.0f));
        } else if (f > this.azZ) {
            this.aAj.lineTo(this.startX + this.azZ, this.startY);
            this.aAj.arcTo(this.aAg, -90.0f, ((f - this.azZ) * 360.0f) / this.aAd, false);
        } else {
            this.aAj.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.aAj, this.azS);
        if (this.azP == 0) {
            if (this.azU == 0) {
                this.azX = String.format("%d", Integer.valueOf((this.azV * 100) / this.azW));
                this.azX += "%";
            } else if (this.azU == 2) {
                this.azX = String.format("%d", Integer.valueOf(this.azV));
            } else if (this.azU == 1) {
                this.azX = this.azV + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.azU == 0) {
            this.azX = String.format("%d", Integer.valueOf(((this.azW - this.azV) * 100) / this.azW));
            this.azX += "%";
        } else if (this.azU == 2) {
            this.azX = String.format("%d", Integer.valueOf(this.azW - this.azV));
        } else if (this.azU == 1) {
            this.azX = (this.azW - this.azV) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.azX, this.centerX - (this.textPaint.measureText(this.azX) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.azV;
    }

    public void setCurrentProgress(int i) {
        if (this.azP == 0) {
            this.azV = i;
        } else {
            this.azV = this.azW - i;
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
