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
    public String f2398e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f2399f;

    /* renamed from: g  reason: collision with root package name */
    public Paint.FontMetrics f2400g;

    /* renamed from: h  reason: collision with root package name */
    public int f2401h;

    /* renamed from: i  reason: collision with root package name */
    public int f2402i;
    public int j;
    public int k;

    public TextProgressBar(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f2398e = "0%";
        TextPaint textPaint = new TextPaint();
        this.f2399f = textPaint;
        textPaint.setTextSize(20.0f);
        this.f2399f.setColor(-1);
        this.f2400g = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.f2402i = (int) Layout.getDesiredWidth(this.f2398e, this.f2399f);
        this.f2399f.getFontMetrics(this.f2400g);
        this.f2401h = (int) (this.f2400g.descent - this.f2400g.top);
        canvas.drawText(this.f2398e, (getMeasuredWidth() - this.f2402i) / 2, getMeasuredHeight(), this.f2399f);
        canvas.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        this.f2402i = (int) Layout.getDesiredWidth("100%", this.f2399f);
        this.f2399f.getFontMetrics(this.f2400g);
        this.f2401h = (int) (this.f2400g.descent - this.f2400g.top);
        super.onMeasure(i2, i3);
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.f2402i, getMeasuredWidth()), getMeasuredHeight() + this.f2401h + 0);
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
        this.f2398e = str;
        drawableStateChanged();
    }

    public void setTextColor(int i2) {
        this.f2399f.setColor(i2);
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
