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
    public static float aCS = -1.0f;
    private float aCN;
    private float aCO;
    private float aCP;
    private float aCQ;
    private ArrowDirection aCT;
    private a aCU;
    private int aCV;
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
        this.aCN = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aCP = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aCO = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aCQ = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aCV = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, aCS);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.aCT = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aCU != null) {
            this.aCU.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aCU = new a(new RectF(i, i3, i2, i4), this.aCN, this.aCO, this.aCP, this.aCQ, this.mStrokeWidth, this.mStrokeColor, this.aCV, this.aCT);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aCT) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aCN);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aCN);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aCP);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aCP);
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

    private void BO() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aCT) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aCN);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aCN);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aCP);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aCP);
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

    public BubbleLayout r(float f) {
        BO();
        this.aCQ = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.aCT;
    }

    public float getArrowWidth() {
        return this.aCN;
    }

    public float getCornersRadius() {
        return this.aCO;
    }

    public float getArrowHeight() {
        return this.aCP;
    }

    public float getArrowPosition() {
        return this.aCQ;
    }

    public int getBubbleColor() {
        return this.aCV;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
