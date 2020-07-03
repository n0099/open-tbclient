package com.baidu.live.tieba.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class BubbleLayout extends FrameLayout {
    public static float awa = -1.0f;
    private float avV;
    private float avW;
    private float avX;
    private float avY;
    private int awd;
    private ArrowDirection bit;
    private a biu;
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
        this.avV = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.avX = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.avW = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.avY = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.awd = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, awa);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.bit = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.biu != null) {
            this.biu.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.biu = new a(new RectF(i, i3, i2, i4), this.avV, this.avW, this.avX, this.avY, this.mStrokeWidth, this.mStrokeColor, this.awd, this.bit);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bit) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.avV);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.avV);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.avX);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.avX);
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

    private void vF() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bit) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.avV);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.avV);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.avX);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.avX);
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

    public BubbleLayout u(float f) {
        vF();
        this.avY = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.bit;
    }

    public float getArrowWidth() {
        return this.avV;
    }

    public float getCornersRadius() {
        return this.avW;
    }

    public float getArrowHeight() {
        return this.avX;
    }

    public float getArrowPosition() {
        return this.avY;
    }

    public int getBubbleColor() {
        return this.awd;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
