package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.a.m0.a.v2.n0;
import d.a.m0.b.h;
/* loaded from: classes3.dex */
public class CommonTagView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Context f11583e;

    /* renamed from: f  reason: collision with root package name */
    public int f11584f;

    /* renamed from: g  reason: collision with root package name */
    public int f11585g;

    /* renamed from: h  reason: collision with root package name */
    public int f11586h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11587i;
    public boolean j;
    public Paint k;
    public RectF l;

    public CommonTagView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.CommonTagView);
        this.f11584f = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_borderWidth, 1);
        this.f11585g = obtainStyledAttributes.getColor(h.CommonTagView_borderColor, -16777216);
        this.f11586h = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_cornerRadius, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? n0.f(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? n0.f(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? n0.f(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? n0.f(context, 1.0f) : getPaddingBottom());
        b(context);
    }

    public final void b(Context context) {
        this.f11583e = context;
        this.k = new Paint();
        this.l = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11587i) {
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setAntiAlias(true);
            this.k.setStrokeWidth(this.f11584f);
            if (this.j && this.f11585g != getCurrentTextColor()) {
                this.f11585g = getCurrentTextColor();
            }
            this.k.setColor(this.f11585g);
            RectF rectF = this.l;
            int i2 = this.f11584f;
            rectF.left = i2 * 0.5f;
            rectF.top = i2 * 0.5f;
            rectF.right = getMeasuredWidth() - (this.f11584f * 0.5f);
            this.l.bottom = getMeasuredHeight() - (this.f11584f * 0.5f);
            RectF rectF2 = this.l;
            int i3 = this.f11586h;
            canvas.drawRoundRect(rectF2, i3, i3, this.k);
        }
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11587i = true;
        this.j = true;
        a(context, attributeSet, i2);
    }
}
