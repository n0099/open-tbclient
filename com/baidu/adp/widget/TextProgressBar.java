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
    private TextPaint Nd;
    private Paint.FontMetrics Ne;
    private int Nf;
    private int Ng;
    private int Nh;
    private int Ni;
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
        this.Nd = new TextPaint();
        this.Nd.setTextSize(20.0f);
        this.Nd.setColor(-1);
        this.Ne = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Ng = (int) Layout.getDesiredWidth("100%", this.Nd);
        this.Nd.getFontMetrics(this.Ne);
        this.Nf = (int) (this.Ne.descent - this.Ne.top);
        super.onMeasure(i, i2);
        this.Nh = getMeasuredWidth();
        this.Ni = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Ng, getMeasuredWidth()), getMeasuredHeight() + this.Nf + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Nh - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Ni - getPaddingBottom()) - getPaddingTop();
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
        this.Ng = (int) Layout.getDesiredWidth(this.text, this.Nd);
        this.Nd.getFontMetrics(this.Ne);
        this.Nf = (int) (this.Ne.descent - this.Ne.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Ng) / 2, getMeasuredHeight(), this.Nd);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Nd.setColor(i);
        drawableStateChanged();
    }
}
