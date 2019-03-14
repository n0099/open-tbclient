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
    private TextPaint Rj;
    private Paint.FontMetrics Rk;
    private int Rl;
    private int Rm;
    private int Rn;
    private int Ro;
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
        this.Rj = new TextPaint();
        this.Rj.setTextSize(20.0f);
        this.Rj.setColor(-1);
        this.Rk = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Rm = (int) Layout.getDesiredWidth("100%", this.Rj);
        this.Rj.getFontMetrics(this.Rk);
        this.Rl = (int) (this.Rk.descent - this.Rk.top);
        super.onMeasure(i, i2);
        this.Rn = getMeasuredWidth();
        this.Ro = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Rm, getMeasuredWidth()), getMeasuredHeight() + this.Rl + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Rn - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Ro - getPaddingBottom()) - getPaddingTop();
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
        this.Rm = (int) Layout.getDesiredWidth(this.text, this.Rj);
        this.Rj.getFontMetrics(this.Rk);
        this.Rl = (int) (this.Rk.descent - this.Rk.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Rm) / 2, getMeasuredHeight(), this.Rj);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Rj.setColor(i);
        drawableStateChanged();
    }
}
