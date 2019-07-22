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
    private TextPaint Pj;
    private Paint.FontMetrics Pk;
    private int Pl;
    private int Pm;
    private int Pn;
    private int Po;
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
        this.Pj = new TextPaint();
        this.Pj.setTextSize(20.0f);
        this.Pj.setColor(-1);
        this.Pk = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.Pm = (int) Layout.getDesiredWidth("100%", this.Pj);
        this.Pj.getFontMetrics(this.Pk);
        this.Pl = (int) (this.Pk.descent - this.Pk.top);
        super.onMeasure(i, i2);
        this.Pn = getMeasuredWidth();
        this.Po = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.Pm, getMeasuredWidth()), getMeasuredHeight() + this.Pl + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.Pn - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.Po - getPaddingBottom()) - getPaddingTop();
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
        this.Pm = (int) Layout.getDesiredWidth(this.text, this.Pj);
        this.Pj.getFontMetrics(this.Pk);
        this.Pl = (int) (this.Pk.descent - this.Pk.top);
        canvas.drawText(this.text, (getMeasuredWidth() - this.Pm) / 2, getMeasuredHeight(), this.Pj);
        canvas.restore();
    }

    public synchronized void setText(String str) {
        this.text = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.Pj.setColor(i);
        drawableStateChanged();
    }
}
