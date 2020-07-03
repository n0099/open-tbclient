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
/* loaded from: classes3.dex */
public class RoundRectNumProgressBar extends View {
    private int bnA;
    private int bnB;
    private String bnC;
    private float bnD;
    private float bnE;
    private float bnF;
    private float bnG;
    private float bnH;
    private float bnI;
    private float bnJ;
    private RectF bnK;
    private RectF bnL;
    private RectF bnM;
    private float bnN;
    private Path bnO;
    private int bne;
    private int bnf;
    private float bnu;
    private int bnv;
    private int bnw;
    private Paint bnx;
    private Paint bny;
    private float bnz;
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
        this.bnB = 100;
        this.bnD = 0.0f;
        this.bnE = 0.0f;
        this.bnF = 0.0f;
        this.bnG = 0.0f;
        this.bnH = 0.0f;
        this.bnI = 0.0f;
        this.bnJ = 0.0f;
        this.bnK = new RectF();
        this.bnL = new RectF();
        this.bnM = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bnN = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bnO = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bnu = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bnw = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bnB = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bnz = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bnA = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bnv = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bnv == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bnw;
            this.bnw = i2;
        }
        this.bny = new Paint();
        this.bny.setAntiAlias(true);
        this.bny.setStyle(Paint.Style.STROKE);
        this.bny.setStrokeWidth(this.bnz);
        this.bny.setColor(this.progressColor);
        this.bnx = new Paint();
        this.bnx.setAntiAlias(true);
        this.bnx.setStyle(Paint.Style.STROKE);
        this.bnx.setStrokeWidth(this.bnz);
        this.bnx.setColor(this.bnw);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bnu);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.bne == 0 || this.bnf == 0 || this.bne != getMeasuredWidth() || this.bnf != getMeasuredHeight()) {
            KD();
            this.bne = getMeasuredWidth();
            this.bnf = getMeasuredHeight();
        }
    }

    private void KD() {
        this.bnI = 3.14f * getMeasuredHeight();
        this.bnH = this.bnI / 2.0f;
        this.bnJ = (getMeasuredHeight() - this.bnz) / 2.0f;
        this.bnN = this.bnz / 2.0f;
        this.bnD = (((getMeasuredWidth() - this.bnz) - getMeasuredHeight()) + this.bnH) * 2.0f;
        this.bnE = (getMeasuredWidth() - this.bnz) - (this.bnJ * 2.0f);
        this.bnF = this.bnE + this.bnH;
        this.bnG = this.bnF + this.bnE;
        this.startX = this.bnN + this.bnJ;
        this.startY = this.bnN;
        this.bnL.left = (this.startX + this.bnE) - this.bnJ;
        this.bnL.top = this.startY;
        this.bnL.right = getMeasuredWidth() - this.bnN;
        this.bnL.bottom = this.startY + (this.bnJ * 2.0f);
        this.bnK.left = this.bnN;
        this.bnK.top = this.startY;
        this.bnK.right = this.bnN + (this.bnJ * 2.0f);
        this.bnK.bottom = this.startY + (this.bnJ * 2.0f);
        this.bnM.left = this.bnN;
        this.bnM.top = this.startY;
        this.bnM.right = getMeasuredWidth() - this.bnN;
        this.bnM.bottom = this.startY + (this.bnJ * 2.0f);
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
        canvas.drawRoundRect(this.bnM, this.bnJ, this.bnJ, this.bnx);
        this.bnO.reset();
        this.bnO.moveTo(this.startX, this.startY);
        float f = (this.bnD * this.currentProgress) / this.bnB;
        if (f >= this.bnD) {
            this.bnO.lineTo(this.startX + this.bnE, this.startY);
            this.bnO.arcTo(this.bnL, -90.0f, 180.0f, false);
            this.bnO.lineTo(this.bnN + this.bnJ, this.startY + (this.bnJ * 2.0f));
            this.bnO.arcTo(this.bnK, 90.0f, 180.0f, false);
            this.bnO.lineTo(this.startX, this.startY);
        } else if (f > this.bnG) {
            this.bnO.lineTo(this.startX + this.bnE, this.startY);
            this.bnO.arcTo(this.bnL, -90.0f, 180.0f, false);
            this.bnO.lineTo(this.bnN + this.bnJ, this.startY + (this.bnJ * 2.0f));
            this.bnO.arcTo(this.bnK, 90.0f, ((f - this.bnG) * 360.0f) / this.bnI, false);
        } else if (f > this.bnF) {
            this.bnO.lineTo(this.startX + this.bnE, this.startY);
            this.bnO.arcTo(this.bnL, -90.0f, 180.0f, false);
            this.bnO.lineTo(getMeasuredWidth() - ((f + (this.bnN + this.bnJ)) - this.bnF), this.startY + (this.bnJ * 2.0f));
        } else if (f > this.bnE) {
            this.bnO.lineTo(this.startX + this.bnE, this.startY);
            this.bnO.arcTo(this.bnL, -90.0f, ((f - this.bnE) * 360.0f) / this.bnI, false);
        } else {
            this.bnO.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bnO, this.bny);
        if (this.bnv == 0) {
            if (this.bnA == 0) {
                this.bnC = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bnB));
                this.bnC += "%";
            } else if (this.bnA == 2) {
                this.bnC = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bnA == 1) {
                this.bnC = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.bnA == 0) {
            this.bnC = String.format("%d", Integer.valueOf(((this.bnB - this.currentProgress) * 100) / this.bnB));
            this.bnC += "%";
        } else if (this.bnA == 2) {
            this.bnC = String.format("%d", Integer.valueOf(this.bnB - this.currentProgress));
        } else if (this.bnA == 1) {
            this.bnC = (this.bnB - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.bnC, this.centerX - (this.textPaint.measureText(this.bnC) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bnv == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bnB - i;
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
