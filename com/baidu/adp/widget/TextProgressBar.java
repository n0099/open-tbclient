package com.baidu.adp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class TextProgressBar extends ProgressBar {
    private TextPaint PU;
    private Paint.FontMetrics PV;
    private int PW;
    private int PY;
    private int PZ;
    private int Qa;
    private String text;

    public TextProgressBar(Context context) {
        super(context);
        init();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.text = "0%";
        this.PU = new TextPaint();
        this.PU.setTextSize(20.0f);
        this.PU.setColor(-1);
        this.PV = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.PY = (int) Layout.getDesiredWidth("100%", this.PU);
        this.PU.getFontMetrics(this.PV);
        this.PW = (int) (this.PV.descent - this.PV.top);
        super.onMeasure(i, i2);
        this.PZ = getMeasuredWidth();
        this.Qa = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.PY, getMeasuredWidth()), getMeasuredHeight() + this.PW + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.PZ - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Qa - getPaddingBottom()) - getPaddingTop();
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(width, 0, i5, paddingBottom);
        }
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(width, 0, i5, paddingBottom);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.PY = (int) Layout.getDesiredWidth(this.text, this.PU);
        this.PU.getFontMetrics(this.PV);
        this.PW = (int) (this.PV.descent - this.PV.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.PY) / 2, getMeasuredHeight(), this.PU);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.PU.setColor(i);
        drawableStateChanged();
    }
}
