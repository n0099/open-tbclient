package com.baidu.live.tieba.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class BubbleLayout extends FrameLayout {
    public static float aGL = -1.0f;
    private float aGG;
    private float aGH;
    private float aGI;
    private float aGJ;
    private int aGO;
    private int aGR;
    private a bMA;
    private ArrowDirection bMz;
    private float mStrokeWidth;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_BubbleLayout);
        this.aGG = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.aGI = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.aGH = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aGJ = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.aGO = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_strokeWidth, aGL);
        this.aGR = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.bMz = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.j.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.bMA != null) {
            this.bMA.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.bMA = new a(new RectF(i, i3, i2, i4), this.aGG, this.aGH, this.aGI, this.aGJ, this.mStrokeWidth, this.aGR, this.aGO, this.bMz);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bMz) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aGG);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aGG);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aGI);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aGI);
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

    private void As() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bMz) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aGG);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aGG);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aGI);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aGI);
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

    public BubbleLayout D(float f) {
        As();
        this.aGJ = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.bMz;
    }

    public float getArrowWidth() {
        return this.aGG;
    }

    public float getCornersRadius() {
        return this.aGH;
    }

    public float getArrowHeight() {
        return this.aGI;
    }

    public float getArrowPosition() {
        return this.aGJ;
    }

    public int getBubbleColor() {
        return this.aGO;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.aGR;
    }
}
