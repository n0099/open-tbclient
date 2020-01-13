package com.baidu.live.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class BubbleLayout extends FrameLayout {
    public static float Vg = -1.0f;
    private float Va;
    private float Vb;
    private float Vc;
    private float Ve;
    private ArrowDirection Vh;
    private a Vi;
    private int Vj;
    private int mStrokeColor;
    private float mStrokeWidth;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_BubbleLayout);
        this.Va = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.Vc = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.Vb = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.Ve = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.Vj = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, Vg);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.Vh = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        initPadding();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        f(0, getWidth(), 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Vi != null) {
            this.Vi.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.Vi = new a(new RectF(i, i3, i2, i4), this.Va, this.Vb, this.Vc, this.Ve, this.mStrokeWidth, this.mStrokeColor, this.Vj, this.Vh);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.Vh) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.Va);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.Va);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.Vc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.Vc);
                break;
        }
        if (this.mStrokeWidth > 0.0f) {
            paddingLeft = (int) (paddingLeft + this.mStrokeWidth);
            paddingRight = (int) (paddingRight + this.mStrokeWidth);
            paddingTop = (int) (paddingTop + this.mStrokeWidth);
            paddingBottom = (int) (paddingBottom + this.mStrokeWidth);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void oX() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.Vh) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.Va);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.Va);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.Vc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.Vc);
                break;
        }
        if (this.mStrokeWidth > 0.0f) {
            paddingLeft = (int) (paddingLeft - this.mStrokeWidth);
            paddingRight = (int) (paddingRight - this.mStrokeWidth);
            paddingTop = (int) (paddingTop - this.mStrokeWidth);
            paddingBottom = (int) (paddingBottom - this.mStrokeWidth);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    static float c(float f, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }

    public BubbleLayout I(float f) {
        oX();
        this.Ve = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.Vh;
    }

    public float getArrowWidth() {
        return this.Va;
    }

    public float getCornersRadius() {
        return this.Vb;
    }

    public float getArrowHeight() {
        return this.Vc;
    }

    public float getArrowPosition() {
        return this.Ve;
    }

    public int getBubbleColor() {
        return this.Vj;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
