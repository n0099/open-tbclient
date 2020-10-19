package com.baidu.live.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class BubbleLayout extends FrameLayout {
    public static float aFX = -1.0f;
    private float aFS;
    private float aFT;
    private float aFU;
    private float aFV;
    private ArrowDirection aFY;
    private a aFZ;
    private int aGa;
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
        this.aFS = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aFU = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aFT = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aFV = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aGa = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, aFX);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.aFY = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aFZ != null) {
            this.aFZ.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aFZ = new a(new RectF(i, i3, i2, i4), this.aFS, this.aFT, this.aFU, this.aFV, this.mStrokeWidth, this.mStrokeColor, this.aGa, this.aFY);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aFY) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aFS);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aFS);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aFU);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aFU);
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

    private void CL() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aFY) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aFS);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aFS);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aFU);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aFU);
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

    static float b(float f, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }

    public BubbleLayout t(float f) {
        CL();
        this.aFV = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.aFY;
    }

    public float getArrowWidth() {
        return this.aFS;
    }

    public float getCornersRadius() {
        return this.aFT;
    }

    public float getArrowHeight() {
        return this.aFU;
    }

    public float getArrowPosition() {
        return this.aFV;
    }

    public int getBubbleColor() {
        return this.aGa;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
