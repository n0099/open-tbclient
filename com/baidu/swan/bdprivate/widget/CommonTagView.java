package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.b.h0.a.i2.h0;
import d.b.h0.b.h;
/* loaded from: classes3.dex */
public class CommonTagView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Context f12403e;

    /* renamed from: f  reason: collision with root package name */
    public int f12404f;

    /* renamed from: g  reason: collision with root package name */
    public int f12405g;

    /* renamed from: h  reason: collision with root package name */
    public int f12406h;
    public boolean i;
    public boolean j;
    public Paint k;
    public RectF l;

    public CommonTagView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.CommonTagView);
        this.f12404f = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_borderWidth, 1);
        this.f12405g = obtainStyledAttributes.getColor(h.CommonTagView_borderColor, -16777216);
        this.f12406h = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_cornerRadius, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? h0.e(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? h0.e(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? h0.e(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? h0.e(context, 1.0f) : getPaddingBottom());
        b(context);
    }

    public final void b(Context context) {
        this.f12403e = context;
        this.k = new Paint();
        this.l = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.i) {
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setAntiAlias(true);
            this.k.setStrokeWidth(this.f12404f);
            if (this.j && this.f12405g != getCurrentTextColor()) {
                this.f12405g = getCurrentTextColor();
            }
            this.k.setColor(this.f12405g);
            RectF rectF = this.l;
            int i = this.f12404f;
            rectF.left = i * 0.5f;
            rectF.top = i * 0.5f;
            rectF.right = getMeasuredWidth() - (this.f12404f * 0.5f);
            this.l.bottom = getMeasuredHeight() - (this.f12404f * 0.5f);
            RectF rectF2 = this.l;
            int i2 = this.f12406h;
            canvas.drawRoundRect(rectF2, i2, i2, this.k);
        }
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
        this.j = true;
        a(context, attributeSet, i);
    }
}
