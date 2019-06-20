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
    private TextPaint OR;
    private Paint.FontMetrics OT;
    private int OU;
    private int OV;
    private int OW;
    private int OX;
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
        this.OR = new TextPaint();
        this.OR.setTextSize(20.0f);
        this.OR.setColor(-1);
        this.OT = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.OV = (int) Layout.getDesiredWidth("100%", this.OR);
        this.OR.getFontMetrics(this.OT);
        this.OU = (int) (this.OT.descent - this.OT.top);
        super.onMeasure(i, i2);
        this.OW = getMeasuredWidth();
        this.OX = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.OV, getMeasuredWidth()), getMeasuredHeight() + this.OU + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.OW - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.OX - getPaddingBottom()) - getPaddingTop();
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
        this.OV = (int) Layout.getDesiredWidth(this.text, this.OR);
        this.OR.getFontMetrics(this.OT);
        this.OU = (int) (this.OT.descent - this.OT.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.OV) / 2, getMeasuredHeight(), this.OR);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.OR.setColor(i);
        drawableStateChanged();
    }
}
