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
    public static float aDy = -1.0f;
    private int aDB;
    private int aDE;
    private float aDt;
    private float aDu;
    private float aDv;
    private float aDw;
    private ArrowDirection bHp;
    private a bHq;
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
        this.aDt = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.aDv = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.aDu = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aDw = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.aDB = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_strokeWidth, aDy);
        this.aDE = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.bHp = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.j.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.bHq != null) {
            this.bHq.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.bHq = new a(new RectF(i, i3, i2, i4), this.aDt, this.aDu, this.aDv, this.aDw, this.mStrokeWidth, this.aDE, this.aDB, this.bHp);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bHp) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aDt);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aDt);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aDv);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aDv);
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

    private void zF() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bHp) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aDt);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aDt);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aDv);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aDv);
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

    public BubbleLayout v(float f) {
        zF();
        this.aDw = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.bHp;
    }

    public float getArrowWidth() {
        return this.aDt;
    }

    public float getCornersRadius() {
        return this.aDu;
    }

    public float getArrowHeight() {
        return this.aDv;
    }

    public float getArrowPosition() {
        return this.aDw;
    }

    public int getBubbleColor() {
        return this.aDB;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.aDE;
    }
}
