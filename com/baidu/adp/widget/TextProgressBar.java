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
    private TextPaint OT;
    private Paint.FontMetrics OU;
    private int OV;
    private int OW;
    private int OX;
    private int OY;
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
        this.OT = new TextPaint();
        this.OT.setTextSize(20.0f);
        this.OT.setColor(-1);
        this.OU = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.OW = (int) Layout.getDesiredWidth("100%", this.OT);
        this.OT.getFontMetrics(this.OU);
        this.OV = (int) (this.OU.descent - this.OU.top);
        super.onMeasure(i, i2);
        this.OX = getMeasuredWidth();
        this.OY = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.OW, getMeasuredWidth()), getMeasuredHeight() + this.OV + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.OX - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.OY - getPaddingBottom()) - getPaddingTop();
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
        this.OW = (int) Layout.getDesiredWidth(this.text, this.OT);
        this.OT.getFontMetrics(this.OU);
        this.OV = (int) (this.OU.descent - this.OU.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.OW) / 2, getMeasuredHeight(), this.OT);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.OT.setColor(i);
        drawableStateChanged();
    }
}
