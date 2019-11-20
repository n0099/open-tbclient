package com.baidu.live.tieba.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class BubbleLayout extends FrameLayout {
    public static float NR = -1.0f;
    private float NL;
    private float NM;
    private float NN;
    private float NP;
    private int NV;
    private ArrowDirection aoY;
    private a aoZ;
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
        this.NL = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.NN = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.NM = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.NP = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.NV = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, NR);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.aoY = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        initPadding();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e(0, getWidth(), 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.aoZ != null) {
            this.aoZ.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void e(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aoZ = new a(new RectF(i, i3, i2, i4), this.NL, this.NM, this.NN, this.NP, this.mStrokeWidth, this.mStrokeColor, this.NV, this.aoY);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aoY) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.NL);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.NL);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.NN);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.NN);
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

    private void ny() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aoY) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.NL);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.NL);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.NN);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.NN);
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

    public BubbleLayout K(float f) {
        ny();
        this.NP = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.aoY;
    }

    public float getArrowWidth() {
        return this.NL;
    }

    public float getCornersRadius() {
        return this.NM;
    }

    public float getArrowHeight() {
        return this.NN;
    }

    public float getArrowPosition() {
        return this.NP;
    }

    public int getBubbleColor() {
        return this.NV;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
