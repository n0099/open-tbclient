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
    private TextPaint GU;
    private Paint.FontMetrics GV;
    private int GW;
    private int GX;
    private int GY;
    private int GZ;
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
        this.GU = new TextPaint();
        this.GU.setTextSize(20.0f);
        this.GU.setColor(-1);
        this.GV = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.GX = (int) Layout.getDesiredWidth("100%", this.GU);
        this.GU.getFontMetrics(this.GV);
        this.GW = (int) (this.GV.descent - this.GV.top);
        super.onMeasure(i, i2);
        this.GY = getMeasuredWidth();
        this.GZ = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.GX, getMeasuredWidth()), getMeasuredHeight() + this.GW + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.GY - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.GZ - getPaddingBottom()) - getPaddingTop();
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
        this.GX = (int) Layout.getDesiredWidth(this.text, this.GU);
        this.GU.getFontMetrics(this.GV);
        this.GW = (int) (this.GV.descent - this.GV.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.GX) / 2, getMeasuredHeight(), this.GU);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.GU.setColor(i);
        drawableStateChanged();
    }
}
