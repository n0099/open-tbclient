package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class RoundRectNumProgressBar extends View {
    private float asA;
    private float asB;
    private float asC;
    private float asD;
    private float asE;
    private float asF;
    private float asG;
    private RectF asH;
    private RectF asI;
    private RectF asJ;
    private float asK;
    private Path asL;
    private int asg;
    private int ash;
    private float asq;
    private int asr;
    private int ass;
    private Paint ast;
    private Paint asu;
    private float asv;
    private int asw;
    private int asx;
    private int asy;
    private String asz;
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
        this.asx = 0;
        this.asy = 100;
        this.asA = 0.0f;
        this.asB = 0.0f;
        this.asC = 0.0f;
        this.asD = 0.0f;
        this.asE = 0.0f;
        this.asF = 0.0f;
        this.asG = 0.0f;
        this.asH = new RectF();
        this.asI = new RectF();
        this.asJ = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.asK = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.asL = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.asq = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.ass = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.asx = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.asy = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.asv = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.asw = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.asr = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.asr == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.ass;
            this.ass = i2;
        }
        this.asu = new Paint();
        this.asu.setAntiAlias(true);
        this.asu.setStyle(Paint.Style.STROKE);
        this.asu.setStrokeWidth(this.asv);
        this.asu.setColor(this.progressColor);
        this.ast = new Paint();
        this.ast.setAntiAlias(true);
        this.ast.setStyle(Paint.Style.STROKE);
        this.ast.setStrokeWidth(this.asv);
        this.ast.setColor(this.ass);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.asq);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.asg == 0 || this.ash == 0 || this.asg != getMeasuredWidth() || this.ash != getMeasuredHeight()) {
            wD();
            this.asg = getMeasuredWidth();
            this.ash = getMeasuredHeight();
        }
    }

    private void wD() {
        this.asF = 3.14f * getMeasuredHeight();
        this.asE = this.asF / 2.0f;
        this.asG = (getMeasuredHeight() - this.asv) / 2.0f;
        this.asK = this.asv / 2.0f;
        this.asA = (((getMeasuredWidth() - this.asv) - getMeasuredHeight()) + this.asE) * 2.0f;
        this.asB = (getMeasuredWidth() - this.asv) - (this.asG * 2.0f);
        this.asC = this.asB + this.asE;
        this.asD = this.asC + this.asB;
        this.startX = this.asK + this.asG;
        this.startY = this.asK;
        this.asI.left = (this.startX + this.asB) - this.asG;
        this.asI.top = this.startY;
        this.asI.right = getMeasuredWidth() - this.asK;
        this.asI.bottom = this.startY + (this.asG * 2.0f);
        this.asH.left = this.asK;
        this.asH.top = this.startY;
        this.asH.right = this.asK + (this.asG * 2.0f);
        this.asH.bottom = this.startY + (this.asG * 2.0f);
        this.asJ.left = this.asK;
        this.asJ.top = this.startY;
        this.asJ.right = getMeasuredWidth() - this.asK;
        this.asJ.bottom = this.startY + (this.asG * 2.0f);
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
        canvas.drawRoundRect(this.asJ, this.asG, this.asG, this.ast);
        this.asL.reset();
        this.asL.moveTo(this.startX, this.startY);
        float f = (this.asA * this.asx) / this.asy;
        if (f >= this.asA) {
            this.asL.lineTo(this.startX + this.asB, this.startY);
            this.asL.arcTo(this.asI, -90.0f, 180.0f, false);
            this.asL.lineTo(this.asK + this.asG, this.startY + (this.asG * 2.0f));
            this.asL.arcTo(this.asH, 90.0f, 180.0f, false);
            this.asL.lineTo(this.startX, this.startY);
        } else if (f > this.asD) {
            this.asL.lineTo(this.startX + this.asB, this.startY);
            this.asL.arcTo(this.asI, -90.0f, 180.0f, false);
            this.asL.lineTo(this.asK + this.asG, this.startY + (this.asG * 2.0f));
            this.asL.arcTo(this.asH, 90.0f, ((f - this.asD) * 360.0f) / this.asF, false);
        } else if (f > this.asC) {
            this.asL.lineTo(this.startX + this.asB, this.startY);
            this.asL.arcTo(this.asI, -90.0f, 180.0f, false);
            this.asL.lineTo(getMeasuredWidth() - ((f + (this.asK + this.asG)) - this.asC), this.startY + (this.asG * 2.0f));
        } else if (f > this.asB) {
            this.asL.lineTo(this.startX + this.asB, this.startY);
            this.asL.arcTo(this.asI, -90.0f, ((f - this.asB) * 360.0f) / this.asF, false);
        } else {
            this.asL.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.asL, this.asu);
        if (this.asr == 0) {
            if (this.asw == 0) {
                this.asz = String.format("%d", Integer.valueOf((this.asx * 100) / this.asy));
                this.asz += "%";
            } else if (this.asw == 2) {
                this.asz = String.format("%d", Integer.valueOf(this.asx));
            } else if (this.asw == 1) {
                this.asz = this.asx + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.asw == 0) {
            this.asz = String.format("%d", Integer.valueOf(((this.asy - this.asx) * 100) / this.asy));
            this.asz += "%";
        } else if (this.asw == 2) {
            this.asz = String.format("%d", Integer.valueOf(this.asy - this.asx));
        } else if (this.asw == 1) {
            this.asz = (this.asy - this.asx) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.asz, this.centerX - (this.textPaint.measureText(this.asz) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.asx;
    }

    public void setCurrentProgress(int i) {
        if (this.asr == 0) {
            this.asx = i;
        } else {
            this.asx = this.asy - i;
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
