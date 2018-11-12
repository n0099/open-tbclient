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
    private TextPaint PW;
    private Paint.FontMetrics PY;
    private int PZ;
    private int Qa;
    private int Qb;
    private int Qc;
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
        this.PW = new TextPaint();
        this.PW.setTextSize(20.0f);
        this.PW.setColor(-1);
        this.PY = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Qa = (int) Layout.getDesiredWidth("100%", this.PW);
        this.PW.getFontMetrics(this.PY);
        this.PZ = (int) (this.PY.descent - this.PY.top);
        super.onMeasure(i, i2);
        this.Qb = getMeasuredWidth();
        this.Qc = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Qa, getMeasuredWidth()), getMeasuredHeight() + this.PZ + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Qb - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Qc - getPaddingBottom()) - getPaddingTop();
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
        this.Qa = (int) Layout.getDesiredWidth(this.text, this.PW);
        this.PW.getFontMetrics(this.PY);
        this.PZ = (int) (this.PY.descent - this.PY.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Qa) / 2, getMeasuredHeight(), this.PW);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.PW.setColor(i);
        drawableStateChanged();
    }
}
