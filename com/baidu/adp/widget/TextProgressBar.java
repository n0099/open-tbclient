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
    public String f2393e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f2394f;

    /* renamed from: g  reason: collision with root package name */
    public Paint.FontMetrics f2395g;

    /* renamed from: h  reason: collision with root package name */
    public int f2396h;

    /* renamed from: i  reason: collision with root package name */
    public int f2397i;
    public int j;
    public int k;

    public TextProgressBar(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f2393e = "0%";
        TextPaint textPaint = new TextPaint();
        this.f2394f = textPaint;
        textPaint.setTextSize(20.0f);
        this.f2394f.setColor(-1);
        this.f2395g = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.f2397i = (int) Layout.getDesiredWidth(this.f2393e, this.f2394f);
        this.f2394f.getFontMetrics(this.f2395g);
        this.f2396h = (int) (this.f2395g.descent - this.f2395g.top);
        canvas.drawText(this.f2393e, (getMeasuredWidth() - this.f2397i) / 2, getMeasuredHeight(), this.f2394f);
        canvas.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        this.f2397i = (int) Layout.getDesiredWidth("100%", this.f2394f);
        this.f2394f.getFontMetrics(this.f2395g);
        this.f2396h = (int) (this.f2395g.descent - this.f2395g.top);
        super.onMeasure(i2, i3);
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.f2397i, getMeasuredWidth()), getMeasuredHeight() + this.f2396h + 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingRight = (this.j - getPaddingRight()) - getPaddingLeft();
        int width = (getWidth() - paddingRight) / 2;
        int i6 = paddingRight + width;
        int paddingBottom = (this.k - getPaddingBottom()) - getPaddingTop();
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(width, 0, i6, paddingBottom);
        }
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(width, 0, i6, paddingBottom);
        }
    }

    public synchronized void setText(String str) {
        this.f2393e = str;
        drawableStateChanged();
    }

    public void setTextColor(int i2) {
        this.f2394f.setColor(i2);
        drawableStateChanged();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
