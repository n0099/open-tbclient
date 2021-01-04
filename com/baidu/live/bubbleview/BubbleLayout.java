package com.baidu.live.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class BubbleLayout extends FrameLayout {
    public static float aIl = -1.0f;
    private float aIg;
    private float aIh;
    private float aIi;
    private float aIj;
    private ArrowDirection aIm;
    private a aIn;
    private int aIo;
    private int aIp;
    private int aIq;
    private int aIr;
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
        this.aIg = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aIi = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aIh = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aIj = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aIo = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.aIp = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_bubbleStartColor, 0);
        this.aIq = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_bubbleEndColor, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_strokeWidth, aIl);
        this.aIr = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.aIm = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.j.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aIn != null) {
            this.aIn.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aIn = new a(new RectF(i, i3, i2, i4), this.aIg, this.aIh, this.aIi, this.aIj, this.mStrokeWidth, this.aIr, this.aIo, this.aIp, this.aIq, this.aIm);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aIm) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aIg);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aIg);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aIi);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aIi);
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

    private void DA() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aIm) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aIg);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aIg);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aIi);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aIi);
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

    public BubbleLayout s(float f) {
        DA();
        this.aIj = f;
        initPadding();
        return this;
    }

    public BubbleLayout x(int i, int i2) {
        this.aIp = i;
        this.aIq = i2;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.aIm;
    }

    public float getArrowWidth() {
        return this.aIg;
    }

    public float getCornersRadius() {
        return this.aIh;
    }

    public float getArrowHeight() {
        return this.aIi;
    }

    public float getArrowPosition() {
        return this.aIj;
    }

    public int getBubbleColor() {
        return this.aIo;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.aIr;
    }
}
