package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.a.h0.a.i2.h0;
import d.a.h0.b.h;
/* loaded from: classes3.dex */
public class CommonTagView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Context f12283e;

    /* renamed from: f  reason: collision with root package name */
    public int f12284f;

    /* renamed from: g  reason: collision with root package name */
    public int f12285g;

    /* renamed from: h  reason: collision with root package name */
    public int f12286h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12287i;
    public boolean j;
    public Paint k;
    public RectF l;

    public CommonTagView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.CommonTagView);
        this.f12284f = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_borderWidth, 1);
        this.f12285g = obtainStyledAttributes.getColor(h.CommonTagView_borderColor, -16777216);
        this.f12286h = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_cornerRadius, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? h0.e(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? h0.e(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? h0.e(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? h0.e(context, 1.0f) : getPaddingBottom());
        b(context);
    }

    public final void b(Context context) {
        this.f12283e = context;
        this.k = new Paint();
        this.l = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12287i) {
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setAntiAlias(true);
            this.k.setStrokeWidth(this.f12284f);
            if (this.j && this.f12285g != getCurrentTextColor()) {
                this.f12285g = getCurrentTextColor();
            }
            this.k.setColor(this.f12285g);
            RectF rectF = this.l;
            int i2 = this.f12284f;
            rectF.left = i2 * 0.5f;
            rectF.top = i2 * 0.5f;
            rectF.right = getMeasuredWidth() - (this.f12284f * 0.5f);
            this.l.bottom = getMeasuredHeight() - (this.f12284f * 0.5f);
            RectF rectF2 = this.l;
            int i3 = this.f12286h;
            canvas.drawRoundRect(rectF2, i3, i3, this.k);
        }
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12287i = true;
        this.j = true;
        a(context, attributeSet, i2);
    }
}
