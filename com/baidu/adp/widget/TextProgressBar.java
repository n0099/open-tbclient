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
    private TextPaint Pi;
    private Paint.FontMetrics Pj;
    private int Pk;
    private int Pl;
    private int Pm;
    private int Pn;
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
        this.Pi = new TextPaint();
        this.Pi.setTextSize(20.0f);
        this.Pi.setColor(-1);
        this.Pj = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Pl = (int) Layout.getDesiredWidth("100%", this.Pi);
        this.Pi.getFontMetrics(this.Pj);
        this.Pk = (int) (this.Pj.descent - this.Pj.top);
        super.onMeasure(i, i2);
        this.Pm = getMeasuredWidth();
        this.Pn = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Pl, getMeasuredWidth()), getMeasuredHeight() + this.Pk + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Pm - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Pn - getPaddingBottom()) - getPaddingTop();
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
        this.Pl = (int) Layout.getDesiredWidth(this.text, this.Pi);
        this.Pi.getFontMetrics(this.Pj);
        this.Pk = (int) (this.Pj.descent - this.Pj.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Pl) / 2, getMeasuredHeight(), this.Pi);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Pi.setColor(i);
        drawableStateChanged();
    }
}
