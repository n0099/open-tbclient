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
    private int arO;
    private int arP;
    private float arY;
    private int arZ;
    private int asa;
    private Paint asb;
    private Paint asc;
    private float asd;
    private int ase;
    private int asf;
    private int asg;
    private String ash;
    private float asi;
    private float asj;
    private float ask;
    private float asl;
    private float asm;
    private float asn;
    private float aso;
    private RectF asp;
    private RectF asq;
    private RectF asr;
    private float ass;
    private Path ast;
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
        this.asf = 0;
        this.asg = 100;
        this.asi = 0.0f;
        this.asj = 0.0f;
        this.ask = 0.0f;
        this.asl = 0.0f;
        this.asm = 0.0f;
        this.asn = 0.0f;
        this.aso = 0.0f;
        this.asp = new RectF();
        this.asq = new RectF();
        this.asr = new RectF();
        this.startX = 0.0f;
        this.startY = 0.0f;
        this.ass = 0.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.ast = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_NumberProgress);
        this.textColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_text_color, -16776961);
        this.arY = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_text_size, f(context, 14.0f));
        this.asa = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_unprogress_color, -7829368);
        this.progressColor = obtainStyledAttributes.getColor(a.k.sdk_NumberProgress_sdk_np_progress_color, -16776961);
        this.asf = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_current_progress, 0);
        this.asg = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_max_progress, 100);
        this.asd = obtainStyledAttributes.getDimension(a.k.sdk_NumberProgress_sdk_np_progress_width, e(context, 4.0f));
        this.ase = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_text_mode, 0);
        this.arZ = obtainStyledAttributes.getInt(a.k.sdk_NumberProgress_sdk_np_direction, 0);
        obtainStyledAttributes.recycle();
        if (this.arZ == 1) {
            int i2 = this.progressColor;
            this.progressColor = this.asa;
            this.asa = i2;
        }
        this.asc = new Paint();
        this.asc.setAntiAlias(true);
        this.asc.setStyle(Paint.Style.STROKE);
        this.asc.setStrokeWidth(this.asd);
        this.asc.setColor(this.progressColor);
        this.asb = new Paint();
        this.asb.setAntiAlias(true);
        this.asb.setStyle(Paint.Style.STROKE);
        this.asb.setStrokeWidth(this.asd);
        this.asb.setColor(this.asa);
        this.textPaint = new Paint(1);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.arY);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        if (this.arO == 0 || this.arP == 0 || this.arO != getMeasuredWidth() || this.arP != getMeasuredHeight()) {
            wE();
            this.arO = getMeasuredWidth();
            this.arP = getMeasuredHeight();
        }
    }

    private void wE() {
        this.asn = 3.14f * getMeasuredHeight();
        this.asm = this.asn / 2.0f;
        this.aso = (getMeasuredHeight() - this.asd) / 2.0f;
        this.ass = this.asd / 2.0f;
        this.asi = (((getMeasuredWidth() - this.asd) - getMeasuredHeight()) + this.asm) * 2.0f;
        this.asj = (getMeasuredWidth() - this.asd) - (this.aso * 2.0f);
        this.ask = this.asj + this.asm;
        this.asl = this.ask + this.asj;
        this.startX = this.ass + this.aso;
        this.startY = this.ass;
        this.asq.left = (this.startX + this.asj) - this.aso;
        this.asq.top = this.startY;
        this.asq.right = getMeasuredWidth() - this.ass;
        this.asq.bottom = this.startY + (this.aso * 2.0f);
        this.asp.left = this.ass;
        this.asp.top = this.startY;
        this.asp.right = this.ass + (this.aso * 2.0f);
        this.asp.bottom = this.startY + (this.aso * 2.0f);
        this.asr.left = this.ass;
        this.asr.top = this.startY;
        this.asr.right = getMeasuredWidth() - this.ass;
        this.asr.bottom = this.startY + (this.aso * 2.0f);
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
        canvas.drawRoundRect(this.asr, this.aso, this.aso, this.asb);
        this.ast.reset();
        this.ast.moveTo(this.startX, this.startY);
        float f = (this.asi * this.asf) / this.asg;
        if (f >= this.asi) {
            this.ast.lineTo(this.startX + this.asj, this.startY);
            this.ast.arcTo(this.asq, -90.0f, 180.0f, false);
            this.ast.lineTo(this.ass + this.aso, this.startY + (this.aso * 2.0f));
            this.ast.arcTo(this.asp, 90.0f, 180.0f, false);
            this.ast.lineTo(this.startX, this.startY);
        } else if (f > this.asl) {
            this.ast.lineTo(this.startX + this.asj, this.startY);
            this.ast.arcTo(this.asq, -90.0f, 180.0f, false);
            this.ast.lineTo(this.ass + this.aso, this.startY + (this.aso * 2.0f));
            this.ast.arcTo(this.asp, 90.0f, ((f - this.asl) * 360.0f) / this.asn, false);
        } else if (f > this.ask) {
            this.ast.lineTo(this.startX + this.asj, this.startY);
            this.ast.arcTo(this.asq, -90.0f, 180.0f, false);
            this.ast.lineTo(getMeasuredWidth() - ((f + (this.ass + this.aso)) - this.ask), this.startY + (this.aso * 2.0f));
        } else if (f > this.asj) {
            this.ast.lineTo(this.startX + this.asj, this.startY);
            this.ast.arcTo(this.asq, -90.0f, ((f - this.asj) * 360.0f) / this.asn, false);
        } else {
            this.ast.lineTo(f + this.startX, this.startY);
        }
        canvas.drawPath(this.ast, this.asc);
        if (this.arZ == 0) {
            if (this.ase == 0) {
                this.ash = String.format("%d", Integer.valueOf((this.asf * 100) / this.asg));
                this.ash += "%";
            } else if (this.ase == 2) {
                this.ash = String.format("%d", Integer.valueOf(this.asf));
            } else if (this.ase == 1) {
                this.ash = this.asf + getContext().getResources().getString(a.i.sdk_time_second);
            }
        } else if (this.ase == 0) {
            this.ash = String.format("%d", Integer.valueOf(((this.asg - this.asf) * 100) / this.asg));
            this.ash += "%";
        } else if (this.ase == 2) {
            this.ash = String.format("%d", Integer.valueOf(this.asg - this.asf));
        } else if (this.ase == 1) {
            this.ash = (this.asg - this.asf) + getContext().getResources().getString(a.i.sdk_time_second);
        }
        canvas.drawText(this.ash, this.centerX - (this.textPaint.measureText(this.ash) / 2.0f), this.centerY - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
    }

    public int getCurrentProgress() {
        return this.asf;
    }

    public void setCurrentProgress(int i) {
        if (this.arZ == 0) {
            this.asf = i;
        } else {
            this.asf = this.asg - i;
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
