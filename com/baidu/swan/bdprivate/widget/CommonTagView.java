package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.ol3;
import com.baidu.tieba.wn3;
/* loaded from: classes3.dex */
public class CommonTagView extends TextView {
    public Context a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public Paint g;
    public RectF h;

    public CommonTagView(Context context) {
        this(context, null);
    }

    public final void b(Context context) {
        this.a = context;
        this.g = new Paint();
        this.h = new RectF();
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        this.f = true;
        a(context, attributeSet, i);
    }

    public final void a(Context context, AttributeSet attributeSet, int i) {
        int paddingLeft;
        int paddingRight;
        int paddingTop;
        int paddingBottom;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wn3.CommonTagView);
        this.b = obtainStyledAttributes.getDimensionPixelOffset(1, 1);
        this.c = obtainStyledAttributes.getColor(0, -16777216);
        this.d = obtainStyledAttributes.getDimensionPixelOffset(2, 3);
        obtainStyledAttributes.recycle();
        if (getPaddingLeft() == 0) {
            paddingLeft = ol3.f(context, 2.0f);
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (getPaddingRight() == 0) {
            paddingRight = ol3.f(context, 2.0f);
        } else {
            paddingRight = getPaddingRight();
        }
        if (getPaddingTop() == 0) {
            paddingTop = ol3.f(context, 1.0f);
        } else {
            paddingTop = getPaddingTop();
        }
        if (getPaddingBottom() == 0) {
            paddingBottom = ol3.f(context, 1.0f);
        } else {
            paddingBottom = getPaddingBottom();
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        b(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.e) {
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setAntiAlias(true);
            this.g.setStrokeWidth(this.b);
            if (this.f && this.c != getCurrentTextColor()) {
                this.c = getCurrentTextColor();
            }
            this.g.setColor(this.c);
            RectF rectF = this.h;
            int i = this.b;
            rectF.left = i * 0.5f;
            rectF.top = i * 0.5f;
            rectF.right = getMeasuredWidth() - (this.b * 0.5f);
            this.h.bottom = getMeasuredHeight() - (this.b * 0.5f);
            RectF rectF2 = this.h;
            int i2 = this.d;
            canvas.drawRoundRect(rectF2, i2, i2, this.g);
        }
    }
}
