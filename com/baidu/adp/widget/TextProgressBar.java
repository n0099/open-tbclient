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
    private TextPaint Ri;
    private Paint.FontMetrics Rj;
    private int Rk;
    private int Rl;
    private int Rm;
    private int Rn;
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
        this.Ri = new TextPaint();
        this.Ri.setTextSize(20.0f);
        this.Ri.setColor(-1);
        this.Rj = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Rl = (int) Layout.getDesiredWidth("100%", this.Ri);
        this.Ri.getFontMetrics(this.Rj);
        this.Rk = (int) (this.Rj.descent - this.Rj.top);
        super.onMeasure(i, i2);
        this.Rm = getMeasuredWidth();
        this.Rn = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Rl, getMeasuredWidth()), getMeasuredHeight() + this.Rk + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Rm - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Rn - getPaddingBottom()) - getPaddingTop();
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
        this.Rl = (int) Layout.getDesiredWidth(this.text, this.Ri);
        this.Ri.getFontMetrics(this.Rj);
        this.Rk = (int) (this.Rj.descent - this.Rj.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Rl) / 2, getMeasuredHeight(), this.Ri);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Ri.setColor(i);
        drawableStateChanged();
    }
}
