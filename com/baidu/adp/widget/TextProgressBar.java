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
    public String f2417e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f2418f;

    /* renamed from: g  reason: collision with root package name */
    public Paint.FontMetrics f2419g;

    /* renamed from: h  reason: collision with root package name */
    public int f2420h;

    /* renamed from: i  reason: collision with root package name */
    public int f2421i;
    public int j;
    public int k;

    public TextProgressBar(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f2417e = "0%";
        TextPaint textPaint = new TextPaint();
        this.f2418f = textPaint;
        textPaint.setTextSize(20.0f);
        this.f2418f.setColor(-1);
        this.f2419g = new Paint.FontMetrics();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.f2421i = (int) Layout.getDesiredWidth(this.f2417e, this.f2418f);
        this.f2418f.getFontMetrics(this.f2419g);
        this.f2420h = (int) (this.f2419g.descent - this.f2419g.top);
        canvas.drawText(this.f2417e, (getMeasuredWidth() - this.f2421i) / 2, getMeasuredHeight(), this.f2418f);
        canvas.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        this.f2421i = (int) Layout.getDesiredWidth("100%", this.f2418f);
        this.f2418f.getFontMetrics(this.f2419g);
        this.f2420h = (int) (this.f2419g.descent - this.f2419g.top);
        super.onMeasure(i2, i3);
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
        setMeasuredDimension(Math.max(this.f2421i, getMeasuredWidth()), getMeasuredHeight() + this.f2420h + 0);
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
        this.f2417e = str;
        drawableStateChanged();
    }

    public void setTextColor(int i2) {
        this.f2418f.setColor(i2);
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
