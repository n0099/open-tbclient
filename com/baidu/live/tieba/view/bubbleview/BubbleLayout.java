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
    public static float Os = -1.0f;
    private float On;
    private float Oo;
    private float Op;
    private float Oq;
    private int Ov;
    private ArrowDirection apr;
    private a aps;
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
        this.On = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.Op = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.Oo = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.Oq = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.Ov = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, Os);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.apr = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aps != null) {
            this.aps.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void e(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aps = new a(new RectF(i, i3, i2, i4), this.On, this.Oo, this.Op, this.Oq, this.mStrokeWidth, this.mStrokeColor, this.Ov, this.apr);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.apr) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.On);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.On);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.Op);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.Op);
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
        switch (this.apr) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.On);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.On);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.Op);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.Op);
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
        this.Oq = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.apr;
    }

    public float getArrowWidth() {
        return this.On;
    }

    public float getCornersRadius() {
        return this.Oo;
    }

    public float getArrowHeight() {
        return this.Op;
    }

    public float getArrowPosition() {
        return this.Oq;
    }

    public int getBubbleColor() {
        return this.Ov;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
