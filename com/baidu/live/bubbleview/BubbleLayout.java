package com.baidu.live.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class BubbleLayout extends FrameLayout {
    public static float atY = -1.0f;
    private float atT;
    private float atU;
    private float atV;
    private float atW;
    private ArrowDirection atZ;
    private a aua;
    private int aub;
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
        this.atT = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.atV = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.atU = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.atW = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.aub = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, atY);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.atZ = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aua != null) {
            this.aua.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aua = new a(new RectF(i, i3, i2, i4), this.atT, this.atU, this.atV, this.atW, this.mStrokeWidth, this.mStrokeColor, this.aub, this.atZ);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.atZ) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.atT);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.atT);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.atV);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.atV);
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

    private void vk() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.atZ) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.atT);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.atT);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.atV);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.atV);
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

    public BubbleLayout p(float f) {
        vk();
        this.atW = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.atZ;
    }

    public float getArrowWidth() {
        return this.atT;
    }

    public float getCornersRadius() {
        return this.atU;
    }

    public float getArrowHeight() {
        return this.atV;
    }

    public float getArrowPosition() {
        return this.atW;
    }

    public int getBubbleColor() {
        return this.aub;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
