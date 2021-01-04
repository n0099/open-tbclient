package com.baidu.live.adp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes11.dex */
public class TextProgressBar extends ProgressBar {
    private static final int dis = 0;
    private Paint.FontMetrics fm;
    private int oldHeight;
    private int oldWidth;
    private String text;
    private int textHeight;
    private TextPaint textPaint;
    private int textWidth;

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
        this.textPaint = new TextPaint();
        this.textPaint.setTextSize(20.0f);
        this.textPaint.setColor(-1);
        this.fm = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.textWidth = (int) Layout.getDesiredWidth("100%", this.textPaint);
        this.textPaint.getFontMetrics(this.fm);
        this.textHeight = (int) (this.fm.descent - this.fm.top);
        super.onMeasure(i, i2);
        this.oldWidth = getMeasuredWidth();
        this.oldHeight = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.textWidth, getMeasuredWidth()), getMeasuredHeight() + this.textHeight + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.oldWidth - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.oldHeight - getPaddingBottom()) - getPaddingTop();
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
        this.textWidth = (int) Layout.getDesiredWidth(this.text, this.textPaint);
        this.textPaint.getFontMetrics(this.fm);
        this.textHeight = (int) (this.fm.descent - this.fm.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.textWidth) / 2, getMeasuredHeight(), this.textPaint);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.textPaint.setColor(i);
        drawableStateChanged();
    }
}
