package com.baidu.live.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class BubbleLayout extends FrameLayout {
    public static float aCh = -1.0f;
    private float aCc;
    private float aCd;
    private float aCe;
    private float aCf;
    private ArrowDirection aCi;
    private a aCj;
    private int aCk;
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
        this.aCc = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aCe = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aCd = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aCf = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aCk = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.k.sdk_BubbleLayout_bl_strokeWidth, aCh);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.k.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.aCi = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.k.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.aCj != null) {
            this.aCj.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.aCj = new a(new RectF(i, i3, i2, i4), this.aCc, this.aCd, this.aCe, this.aCf, this.mStrokeWidth, this.mStrokeColor, this.aCk, this.aCi);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aCi) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aCc);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aCc);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aCe);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aCe);
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

    private void Bz() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.aCi) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aCc);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aCc);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aCe);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aCe);
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
        Bz();
        this.aCf = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.aCi;
    }

    public float getArrowWidth() {
        return this.aCc;
    }

    public float getCornersRadius() {
        return this.aCd;
    }

    public float getArrowHeight() {
        return this.aCe;
    }

    public float getArrowPosition() {
        return this.aCf;
    }

    public int getBubbleColor() {
        return this.aCk;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
