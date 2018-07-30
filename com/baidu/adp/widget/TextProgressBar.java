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
    private TextPaint Na;
    private Paint.FontMetrics Nb;
    private int Nc;
    private int Nd;
    private int Ne;
    private int Nf;
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
        this.Na = new TextPaint();
        this.Na.setTextSize(20.0f);
        this.Na.setColor(-1);
        this.Nb = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Nd = (int) Layout.getDesiredWidth("100%", this.Na);
        this.Na.getFontMetrics(this.Nb);
        this.Nc = (int) (this.Nb.descent - this.Nb.top);
        super.onMeasure(i, i2);
        this.Ne = getMeasuredWidth();
        this.Nf = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Nd, getMeasuredWidth()), getMeasuredHeight() + this.Nc + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Ne - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Nf - getPaddingBottom()) - getPaddingTop();
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
        this.Nd = (int) Layout.getDesiredWidth(this.text, this.Na);
        this.Na.getFontMetrics(this.Nb);
        this.Nc = (int) (this.Nb.descent - this.Nb.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Nd) / 2, getMeasuredHeight(), this.Na);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Na.setColor(i);
        drawableStateChanged();
    }
}
