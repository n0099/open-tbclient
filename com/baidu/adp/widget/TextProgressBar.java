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
    private TextPaint GY;
    private Paint.FontMetrics GZ;
    private int Ha;
    private int Hb;
    private int Hc;
    private int Hd;
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
        this.GY = new TextPaint();
        this.GY.setTextSize(20.0f);
        this.GY.setColor(-1);
        this.GZ = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Hb = (int) Layout.getDesiredWidth("100%", this.GY);
        this.GY.getFontMetrics(this.GZ);
        this.Ha = (int) (this.GZ.descent - this.GZ.top);
        super.onMeasure(i, i2);
        this.Hc = getMeasuredWidth();
        this.Hd = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Hb, getMeasuredWidth()), getMeasuredHeight() + this.Ha + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Hc - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Hd - getPaddingBottom()) - getPaddingTop();
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
        this.Hb = (int) Layout.getDesiredWidth(this.text, this.GY);
        this.GY.getFontMetrics(this.GZ);
        this.Ha = (int) (this.GZ.descent - this.GZ.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Hb) / 2, getMeasuredHeight(), this.GY);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.GY.setColor(i);
        drawableStateChanged();
    }
}
