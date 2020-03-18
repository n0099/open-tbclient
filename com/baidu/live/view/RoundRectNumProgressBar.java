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
    private int aEO;
    private int aEP;
    private float aFf;
    private int aFg;
    private int aFh;
    private Paint aFi;
    private Paint aFj;
    private float aFk;
    private int aFl;
    private int aFm;
    private String aFn;
    private float aFo;
    private float aFp;
    private float aFq;
    private float aFr;
    private float aFs;
    private float aFt;
    private float aFu;
    private RectF aFv;
    private RectF aFw;
    private RectF aFx;
    private float aFy;
    private Path aFz;
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
        this.aFm = 100;
        this.aFo = 0.0f;
        this.aFp = 0.0f;
        this.aFq = 0.0f;
        this.aFr = 0.0f;
        this.aFs = 0.0f;
        this.aFt = 0.0f;
        this.aFu = 0.0f;
        this.aFv = new RectF();
        this.aFw = new RectF();
        this.aFx = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.aFy = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.aFz = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.aFf = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.aFh = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.aFm = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.aFk = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.aFl = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.aFg = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.aFg == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.aFh;
            this.aFh = i2;
        }
        this.aFj = new Paint();
        this.aFj.setAntiAlias(true);
        this.aFj.setStyle(Paint.Style.STROKE);
        this.aFj.setStrokeWidth(this.aFk);
        this.aFj.setColor(this.progressColor);
        this.aFi = new Paint();
        this.aFi.setAntiAlias(true);
        this.aFi.setStyle(Paint.Style.STROKE);
        this.aFi.setStrokeWidth(this.aFk);
        this.aFi.setColor(this.aFh);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.aFf);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.aEO == 0 || this.aEP == 0 || this.aEO != getMeasuredWidth() || this.aEP != getMeasuredHeight()) {
            Bw();
            this.aEO = getMeasuredWidth();
            this.aEP = getMeasuredHeight();
        }
    }

    private void Bw() {
        this.aFt = 3.14f * getMeasuredHeight();
        this.aFs = this.aFt / 2.0f;
        this.aFu = (getMeasuredHeight() - this.aFk) / 2.0f;
        this.aFy = this.aFk / 2.0f;
        this.aFo = (((getMeasuredWidth() - this.aFk) - getMeasuredHeight()) + this.aFs) * 2.0f;
        this.aFp = (getMeasuredWidth() - this.aFk) - (this.aFu * 2.0f);
        this.aFq = this.aFp + this.aFs;
        this.aFr = this.aFq + this.aFp;
        this.startX = this.aFy + this.aFu;
        this.startY = this.aFy;
        this.aFw.left = (this.startX + this.aFp) - this.aFu;
        this.aFw.top = this.startY;
        this.aFw.right = getMeasuredWidth() - this.aFy;
        this.aFw.bottom = this.startY + (this.aFu * 2.0f);
        this.aFv.left = this.aFy;
        this.aFv.top = this.startY;
        this.aFv.right = this.aFy + (this.aFu * 2.0f);
        this.aFv.bottom = this.startY + (this.aFu * 2.0f);
        this.aFx.left = this.aFy;
        this.aFx.top = this.startY;
        this.aFx.right = getMeasuredWidth() - this.aFy;
        this.aFx.bottom = this.startY + (this.aFu * 2.0f);
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
        canvas.drawRoundRect(this.aFx, this.aFu, this.aFu, this.aFi);
        this.aFz.reset();
        this.aFz.moveTo(this.startX, this.startY);
        float f = (this.aFo * this.currentProgress) / this.aFm;
        if (f >= this.aFo) {
            this.aFz.lineTo(this.startX + this.aFp, this.startY);
            this.aFz.arcTo(this.aFw, -90.0f, 180.0f, false);
            this.aFz.lineTo(this.aFy + this.aFu, this.startY + (this.aFu * 2.0f));
            this.aFz.arcTo(this.aFv, 90.0f, 180.0f, false);
            this.aFz.lineTo(this.startX, this.startY);
        } else if (f > this.aFr) {
            this.aFz.lineTo(this.startX + this.aFp, this.startY);
            this.aFz.arcTo(this.aFw, -90.0f, 180.0f, false);
            this.aFz.lineTo(this.aFy + this.aFu, this.startY + (this.aFu * 2.0f));
            this.aFz.arcTo(this.aFv, 90.0f, ((f - this.aFr) * 360.0f) / this.aFt, false);
        } else if (f > this.aFq) {
            this.aFz.lineTo(this.startX + this.aFp, this.startY);
            this.aFz.arcTo(this.aFw, -90.0f, 180.0f, false);
            this.aFz.lineTo(getMeasuredWidth() - ((f + (this.aFy + this.aFu)) - this.aFq), this.startY + (this.aFu * 2.0f));
        } else if (f > this.aFp) {
            this.aFz.lineTo(this.startX + this.aFp, this.startY);
            this.aFz.arcTo(this.aFw, -90.0f, ((f - this.aFp) * 360.0f) / this.aFt, false);
        } else {
            this.aFz.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.aFz, this.aFj);
        if (this.aFg == 0) {
            if (this.aFl == 0) {
                this.aFn = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.aFm));
                this.aFn += "%";
            } else if (this.aFl == 2) {
                this.aFn = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.aFl == 1) {
                this.aFn = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.aFl == 0) {
            this.aFn = String.format("%d", Integer.valueOf(((this.aFm - this.currentProgress) * 100) / this.aFm));
            this.aFn += "%";
        } else if (this.aFl == 2) {
            this.aFn = String.format("%d", Integer.valueOf(this.aFm - this.currentProgress));
        } else if (this.aFl == 1) {
            this.aFn = (this.aFm - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.aFn, this.centerX - (this.textPaint.measureText(this.aFn) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.aFg == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.aFm - i;
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
