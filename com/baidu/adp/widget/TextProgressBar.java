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
    private TextPaint Qg;
    private Paint.FontMetrics Qh;
    private int Qi;
    private int Qj;
    private int Qk;
    private int Ql;
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
        this.Qg = new TextPaint();
        this.Qg.setTextSize(20.0f);
        this.Qg.setColor(-1);
        this.Qh = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Qj = (int) Layout.getDesiredWidth("100%", this.Qg);
        this.Qg.getFontMetrics(this.Qh);
        this.Qi = (int) (this.Qh.descent - this.Qh.top);
        super.onMeasure(i, i2);
        this.Qk = getMeasuredWidth();
        this.Ql = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Qj, getMeasuredWidth()), getMeasuredHeight() + this.Qi + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Qk - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Ql - getPaddingBottom()) - getPaddingTop();
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
        this.Qj = (int) Layout.getDesiredWidth(this.text, this.Qg);
        this.Qg.getFontMetrics(this.Qh);
        this.Qi = (int) (this.Qh.descent - this.Qh.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Qj) / 2, getMeasuredHeight(), this.Qg);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Qg.setColor(i);
        drawableStateChanged();
    }
}
