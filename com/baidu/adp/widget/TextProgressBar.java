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
    private TextPaint Nb;
    private Paint.FontMetrics Nc;
    private int Nd;
    private int Ne;
    private int Nf;
    private int Ng;
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
        this.Nb = new TextPaint();
        this.Nb.setTextSize(20.0f);
        this.Nb.setColor(-1);
        this.Nc = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Ne = (int) Layout.getDesiredWidth("100%", this.Nb);
        this.Nb.getFontMetrics(this.Nc);
        this.Nd = (int) (this.Nc.descent - this.Nc.top);
        super.onMeasure(i, i2);
        this.Nf = getMeasuredWidth();
        this.Ng = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Ne, getMeasuredWidth()), getMeasuredHeight() + this.Nd + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Nf - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Ng - getPaddingBottom()) - getPaddingTop();
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
        this.Ne = (int) Layout.getDesiredWidth(this.text, this.Nb);
        this.Nb.getFontMetrics(this.Nc);
        this.Nd = (int) (this.Nc.descent - this.Nc.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Ne) / 2, getMeasuredHeight(), this.Nb);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Nb.setColor(i);
        drawableStateChanged();
    }
}
