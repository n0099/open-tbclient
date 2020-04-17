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
    private float baM;
    private int baN;
    private int baO;
    private Paint baP;
    private Paint baQ;
    private float baR;
    private int baS;
    private int baT;
    private String baU;
    private float baV;
    private float baW;
    private float baX;
    private float baY;
    private float baZ;
    private int bav;
    private int baw;
    private float bba;
    private float bbb;
    private RectF bbc;
    private RectF bbd;
    private RectF bbe;
    private float bbf;
    private Path bbg;
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
        this.baT = 100;
        this.baV = 0.0f;
        this.baW = 0.0f;
        this.baX = 0.0f;
        this.baY = 0.0f;
        this.baZ = 0.0f;
        this.bba = 0.0f;
        this.bbb = 0.0f;
        this.bbc = new RectF();
        this.bbd = new RectF();
        this.bbe = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.bbf = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.bbg = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.baM = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.baO = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.currentProgress = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.baT = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.baR = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.baS = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.baN = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.baN == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.baO;
            this.baO = i2;
        }
        this.baQ = new Paint();
        this.baQ.setAntiAlias(true);
        this.baQ.setStyle(Paint.Style.STROKE);
        this.baQ.setStrokeWidth(this.baR);
        this.baQ.setColor(this.progressColor);
        this.baP = new Paint();
        this.baP.setAntiAlias(true);
        this.baP.setStyle(Paint.Style.STROKE);
        this.baP.setStrokeWidth(this.baR);
        this.baP.setColor(this.baO);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.baM);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.bav == 0 || this.baw == 0 || this.bav != getMeasuredWidth() || this.baw != getMeasuredHeight()) {
            HA();
            this.bav = getMeasuredWidth();
            this.baw = getMeasuredHeight();
        }
    }

    private void HA() {
        this.bba = 3.14f * getMeasuredHeight();
        this.baZ = this.bba / 2.0f;
        this.bbb = (getMeasuredHeight() - this.baR) / 2.0f;
        this.bbf = this.baR / 2.0f;
        this.baV = (((getMeasuredWidth() - this.baR) - getMeasuredHeight()) + this.baZ) * 2.0f;
        this.baW = (getMeasuredWidth() - this.baR) - (this.bbb * 2.0f);
        this.baX = this.baW + this.baZ;
        this.baY = this.baX + this.baW;
        this.startX = this.bbf + this.bbb;
        this.startY = this.bbf;
        this.bbd.left = (this.startX + this.baW) - this.bbb;
        this.bbd.top = this.startY;
        this.bbd.right = getMeasuredWidth() - this.bbf;
        this.bbd.bottom = this.startY + (this.bbb * 2.0f);
        this.bbc.left = this.bbf;
        this.bbc.top = this.startY;
        this.bbc.right = this.bbf + (this.bbb * 2.0f);
        this.bbc.bottom = this.startY + (this.bbb * 2.0f);
        this.bbe.left = this.bbf;
        this.bbe.top = this.startY;
        this.bbe.right = getMeasuredWidth() - this.bbf;
        this.bbe.bottom = this.startY + (this.bbb * 2.0f);
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
        canvas.drawRoundRect(this.bbe, this.bbb, this.bbb, this.baP);
        this.bbg.reset();
        this.bbg.moveTo(this.startX, this.startY);
        float f = (this.baV * this.currentProgress) / this.baT;
        if (f >= this.baV) {
            this.bbg.lineTo(this.startX + this.baW, this.startY);
            this.bbg.arcTo(this.bbd, -90.0f, 180.0f, false);
            this.bbg.lineTo(this.bbf + this.bbb, this.startY + (this.bbb * 2.0f));
            this.bbg.arcTo(this.bbc, 90.0f, 180.0f, false);
            this.bbg.lineTo(this.startX, this.startY);
        } else if (f > this.baY) {
            this.bbg.lineTo(this.startX + this.baW, this.startY);
            this.bbg.arcTo(this.bbd, -90.0f, 180.0f, false);
            this.bbg.lineTo(this.bbf + this.bbb, this.startY + (this.bbb * 2.0f));
            this.bbg.arcTo(this.bbc, 90.0f, ((f - this.baY) * 360.0f) / this.bba, false);
        } else if (f > this.baX) {
            this.bbg.lineTo(this.startX + this.baW, this.startY);
            this.bbg.arcTo(this.bbd, -90.0f, 180.0f, false);
            this.bbg.lineTo(getMeasuredWidth() - ((f + (this.bbf + this.bbb)) - this.baX), this.startY + (this.bbb * 2.0f));
        } else if (f > this.baW) {
            this.bbg.lineTo(this.startX + this.baW, this.startY);
            this.bbg.arcTo(this.bbd, -90.0f, ((f - this.baW) * 360.0f) / this.bba, false);
        } else {
            this.bbg.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.bbg, this.baQ);
        if (this.baN == 0) {
            if (this.baS == 0) {
                this.baU = String.format("%d", Integer.valueOf((this.currentProgress * 100) / this.baT));
                this.baU += "%";
            } else if (this.baS == 2) {
                this.baU = String.format("%d", Integer.valueOf(this.currentProgress));
            } else if (this.baS == 1) {
                this.baU = this.currentProgress + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.baS == 0) {
            this.baU = String.format("%d", Integer.valueOf(((this.baT - this.currentProgress) * 100) / this.baT));
            this.baU += "%";
        } else if (this.baS == 2) {
            this.baU = String.format("%d", Integer.valueOf(this.baT - this.currentProgress));
        } else if (this.baS == 1) {
            this.baU = (this.baT - this.currentProgress) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.baU, this.centerX - (this.textPaint.measureText(this.baU) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(int i) {
        if (this.baN == 0) {
            this.currentProgress = i;
        } else {
            this.currentProgress = this.baT - i;
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
