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
    public static float aGf = -1.0f;
    private float aGa;
    private float aGb;
    private float aGc;
    private float aGd;
    private ArrowDirection aGg;
    private a aGh;
    private int aGi;
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
        this.aGa = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aGc = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aGb = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aGd = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aGi = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, aGf);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.aGg = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aGh != null) {
            this.aGh.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aGh = new a(new RectF(i, i3, i2, i4), this.aGa, this.aGb, this.aGc, this.aGd, this.mStrokeWidth, this.mStrokeColor, this.aGi, this.aGg);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aGg) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aGa);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aGa);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aGc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aGc);
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

    private void CR() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aGg) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aGa);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aGa);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aGc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aGc);
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
        CR();
        this.aGd = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.aGg;
    }

    public float getArrowWidth() {
        return this.aGa;
    }

    public float getCornersRadius() {
        return this.aGb;
    }

    public float getArrowHeight() {
        return this.aGc;
    }

    public float getArrowPosition() {
        return this.aGd;
    }

    public int getBubbleColor() {
        return this.aGi;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
