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
    private int bnA;
    private float bnP;
    private int bnQ;
    private int bnR;
    private Paint bnS;
    private Paint bnT;
    private float bnU;
    private int bnV;
    private int bnW;
    private String bnX;
    private float bnY;
    private float bnZ;
    private int bnz;
    private float boa;
    private float bob;
    private float boc;
    private float bod;
    private float boe;
    private RectF bof;
    private RectF bog;
    private RectF boh;
    private float boi;
    private Path boj;
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
        this.bnW = 100;
        this.bnY = 0.0f;
        this.bnZ = 0.0f;
        this.boa = 0.0f;
        this.bob = 0.0f;
        this.boc = 0.0f;
        this.bod = 0.0f;
        this.boe = 0.0f;
        this.bof = new RectF();
        this.bog = new RectF();
        this.boh = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.boi = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.boj = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.bnP = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.bnR = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.bnW = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.bnU = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.bnV = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.bnQ = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.bnQ == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.bnR;
            this.bnR = i2;
        }
        this.bnT = new Paint();
        this.bnT.setAntiAlias(true);
        this.bnT.setStyle(Paint.Style.STROKE);
        this.bnT.setStrokeWidth(this.bnU);
        this.bnT.setColor(this.progressColor);
        this.bnS = new Paint();
        this.bnS.setAntiAlias(true);
        this.bnS.setStyle(Paint.Style.STROKE);
        this.bnS.setStrokeWidth(this.bnU);
        this.bnS.setColor(this.bnR);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.bnP);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.bnz == 0 || this.bnA == 0 || this.bnz != getMeasuredWidth() || this.bnA != getMeasuredHeight()) {
            KK();
            this.bnz = getMeasuredWidth();
            this.bnA = getMeasuredHeight();
        }
    }

    private void KK() {
        this.bod = 3.14f * getMeasuredHeight();
        this.boc = this.bod / 2.0f;
        this.boe = (getMeasuredHeight() - this.bnU) / 2.0f;
        this.boi = this.bnU / 2.0f;
        this.bnY = (((getMeasuredWidth() - this.bnU) - getMeasuredHeight()) + this.boc) * 2.0f;
        this.bnZ = (getMeasuredWidth() - this.bnU) - (this.boe * 2.0f);
        this.boa = this.bnZ + this.boc;
        this.bob = this.boa + this.bnZ;
        this.startX = this.boi + this.boe;
        this.startY = this.boi;
        this.bog.left = (this.startX + this.bnZ) - this.boe;
        this.bog.top = this.startY;
        this.bog.right = getMeasuredWidth() - this.boi;
        this.bog.bottom = this.startY + (this.boe * 2.0f);
        this.bof.left = this.boi;
        this.bof.top = this.startY;
        this.bof.right = this.boi + (this.boe * 2.0f);
        this.bof.bottom = this.startY + (this.boe * 2.0f);
        this.boh.left = this.boi;
        this.boh.top = this.startY;
        this.boh.right = getMeasuredWidth() - this.boi;
        this.boh.bottom = this.startY + (this.boe * 2.0f);
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
        canvas.drawRoundRect(this.boh, this.boe, this.boe, this.bnS);
        this.boj.reset();
        this.boj.moveTo(this.startX, this.startY);
        float f = (this.bnY * this.currentProgress) / this.bnW;
        if (f >= this.bnY) {
            this.boj.lineTo(this.startX + this.bnZ, this.startY);
            this.boj.arcTo(this.bog, -90.0f, 180.0f, false);
            this.boj.lineTo(this.boi + this.boe, this.startY + (this.boe * 2.0f));
            this.boj.arcTo(this.bof, 90.0f, 180.0f, false);
            this.boj.lineTo(this.startX, this.startY);
        } else if (f > this.bob) {
            this.boj.lineTo(this.startX + this.bnZ, this.startY);
            this.boj.arcTo(this.bog, -90.0f, 180.0f, false);
            this.boj.lineTo(this.boi + this.boe, this.startY + (this.boe * 2.0f));
            this.boj.arcTo(this.bof, 90.0f, ((f - this.bob) * 360.0f) / this.bod, false);
        } else if (f > this.boa) {
            this.boj.lineTo(this.startX + this.bnZ, this.startY);
            this.boj.arcTo(this.bog, -90.0f, 180.0f, false);
            this.boj.lineTo(getMeasuredWidth() - ((f + (this.boi + this.boe)) - this.boa), this.startY + (this.boe * 2.0f));
        } else if (f > this.bnZ) {
            this.boj.lineTo(this.startX + this.bnZ, this.startY);
            this.boj.arcTo(this.bog, -90.0f, ((f - this.bnZ) * 360.0f) / this.bod, false);
        } else {
            this.boj.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.boj, this.bnT);
        if (this.bnQ == 0) {
            if (this.bnV == 0) {
                this.bnX = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.bnW));
                this.bnX += "%";
            } else if (this.bnV == 2) {
                this.bnX = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.bnV == 1) {
                this.bnX = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.bnV == 0) {
            this.bnX = String.format("%d", Integer.valueOf(((this.bnW - this.currentProgress) * 100) / this.bnW));
            this.bnX += "%";
        } else if (this.bnV == 2) {
            this.bnX = String.format("%d", Integer.valueOf(this.bnW - this.currentProgress));
        } else if (this.bnV == 1) {
            this.bnX = (this.bnW - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.bnX, this.centerX - (this.textPaint.measureText(this.bnX) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.bnQ == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.bnW - i;
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
