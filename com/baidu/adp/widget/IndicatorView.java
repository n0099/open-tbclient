package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
/* loaded from: classes.dex */
public class IndicatorView extends View {

    /* renamed from: a  reason: collision with root package name */
    private boolean f480a;
    private int b;
    private int c;
    private float d;
    private float e;
    private Drawable f;
    private Drawable g;
    private final ac h;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, int i, int i2) {
        indicatorView.setMeasuredDimension(i, i2);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a(int):int, com.baidu.adp.widget.m.a(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(IndicatorView indicatorView) {
        return indicatorView.b;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a(int):int, com.baidu.adp.widget.m.a(int, int):void, com.baidu.adp.widget.m.a(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(IndicatorView indicatorView) {
        return indicatorView.c;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, float f) {
        indicatorView.d = f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float e(IndicatorView indicatorView) {
        return indicatorView.d;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float f(IndicatorView indicatorView) {
        return indicatorView.e;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a(int):int, com.baidu.adp.widget.m.a(int, int):void, com.baidu.adp.widget.m.a(android.graphics.Canvas):void, com.baidu.adp.widget.m.b(int):int] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable a(IndicatorView indicatorView) {
        return indicatorView.f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.a(int):int, com.baidu.adp.widget.m.a(int, int):void, com.baidu.adp.widget.m.a(android.graphics.Canvas):void, com.baidu.adp.widget.m.b(int):int] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable b(IndicatorView indicatorView) {
        return indicatorView.g;
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new m(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.h.IndicatorView);
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.c = obtainStyledAttributes.getInteger(4, 0);
        this.f = obtainStyledAttributes.getDrawable(1);
        if (this.f == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.f.setBounds(0, 0, this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.f.getBounds());
        }
        this.g = obtainStyledAttributes.getDrawable(2);
        if (this.g == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.g.setBounds(0, 0, this.g.getIntrinsicWidth(), this.g.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.g.getBounds());
        }
        this.f480a = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.h.a(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.h.a(canvas);
    }

    public void setAutoHide(boolean z) {
        this.f480a = z;
    }

    public void setDrawable(Drawable drawable) {
        this.f = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.f;
    }

    public void setSelector(Drawable drawable) {
        this.g = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.g;
    }

    public void setSpacing(int i) {
        this.b = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.b;
    }

    public int getCount() {
        return this.c;
    }

    public void setCount(int i) {
        this.c = i;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f) {
        Log.d("IndicatorView$IndicatorView", "@setPosition");
        this.d = f;
        invalidate();
    }

    public float getPosition() {
        return this.d;
    }
}
