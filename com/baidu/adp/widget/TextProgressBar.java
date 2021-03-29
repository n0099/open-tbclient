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

    /* renamed from: e  reason: collision with root package name */
    public String f2374e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f2375f;

    /* renamed from: g  reason: collision with root package name */
    public Paint.FontMetrics f2376g;

    /* renamed from: h  reason: collision with root package name */
    public int f2377h;
    public int i;
    public int j;
    public int k;

    public TextProgressBar(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f2374e = "0%";
        TextPaint textPaint = new TextPaint();
        this.f2375f = textPaint;
        textPaint.setTextSize(20.0f);
        this.f2375f.setColor(-1);
        this.f2376g = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.i = (int) Layout.getDesiredWidth(this.f2374e, this.f2375f);
        this.f2375f.getFontMetrics(this.f2376g);
        this.f2377h = (int) (this.f2376g.descent - this.f2376g.top);
        canvas.drawText(this.f2374e, (getMeasuredWidth() - this.i) / 2, getMeasuredHeight(), this.f2375f);
        canvas.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        this.i = (int) Layout.getDesiredWidth("100%", this.f2375f);
        this.f2375f.getFontMetrics(this.f2376g);
        this.f2377h = (int) (this.f2376g.descent - this.f2376g.top);
        super.onMeasure(i, i2);
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.i, getMeasuredWidth()), getMeasuredHeight() + this.f2377h + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = (this.j - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i5 = paddingRight + width;
        int paddingBottom = (this.k - getPaddingBottom()) - getPaddingTop();
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(width, 0, i5, paddingBottom);
        }
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(width, 0, i5, paddingBottom);
        }
    }

    public synchronized void setText(String str) {
        this.f2374e = str;
        drawableStateChanged();
    }

    public void setTextColor(int i) {
        this.f2375f.setColor(i);
        drawableStateChanged();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
