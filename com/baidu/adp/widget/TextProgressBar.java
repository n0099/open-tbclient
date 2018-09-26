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
    private TextPaint PD;
    private Paint.FontMetrics PE;
    private int PF;
    private int PG;
    private int PH;
    private int PI;
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
        this.PD = new TextPaint();
        this.PD.setTextSize(20.0f);
        this.PD.setColor(-1);
        this.PE = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.PG = (int) Layout.getDesiredWidth("100%", this.PD);
        this.PD.getFontMetrics(this.PE);
        this.PF = (int) (this.PE.descent - this.PE.top);
        super.onMeasure(i, i2);
        this.PH = getMeasuredWidth();
        this.PI = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.PG, getMeasuredWidth()), getMeasuredHeight() + this.PF + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.PH - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.PI - getPaddingBottom()) - getPaddingTop();
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
        this.PG = (int) Layout.getDesiredWidth(this.text, this.PD);
        this.PD.getFontMetrics(this.PE);
        this.PF = (int) (this.PE.descent - this.PE.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.PG) / 2, getMeasuredHeight(), this.PD);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.PD.setColor(i);
        drawableStateChanged();
    }
}
