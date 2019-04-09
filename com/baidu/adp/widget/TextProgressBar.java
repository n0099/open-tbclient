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
    private TextPaint Rk;
    private Paint.FontMetrics Rl;
    private int Rm;
    private int Rn;
    private int Ro;
    private int Rp;
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
        this.Rk = new TextPaint();
        this.Rk.setTextSize(20.0f);
        this.Rk.setColor(-1);
        this.Rl = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Rn = (int) Layout.getDesiredWidth("100%", this.Rk);
        this.Rk.getFontMetrics(this.Rl);
        this.Rm = (int) (this.Rl.descent - this.Rl.top);
        super.onMeasure(i, i2);
        this.Ro = getMeasuredWidth();
        this.Rp = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Rn, getMeasuredWidth()), getMeasuredHeight() + this.Rm + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Ro - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Rp - getPaddingBottom()) - getPaddingTop();
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
        this.Rn = (int) Layout.getDesiredWidth(this.text, this.Rk);
        this.Rk.getFontMetrics(this.Rl);
        this.Rm = (int) (this.Rl.descent - this.Rl.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Rn) / 2, getMeasuredHeight(), this.Rk);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Rk.setColor(i);
        drawableStateChanged();
    }
}
