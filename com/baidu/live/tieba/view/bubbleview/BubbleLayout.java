package com.baidu.live.tieba.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class BubbleLayout extends FrameLayout {
    public static float aHQ = -1.0f;
    private float aHL;
    private float aHM;
    private float aHN;
    private float aHO;
    private int aHT;
    private ArrowDirection bHo;
    private a bHp;
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_BubbleLayout);
        this.aHL = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aHN = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aHM = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_cornersRadius, 0.0f);
        this.aHO = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aHT = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(a.j.sdk_BubbleLayout_bl_strokeWidth, aHQ);
        this.mStrokeColor = obtainStyledAttributes.getColor(a.j.sdk_BubbleLayout_bl_strokeColor, -7829368);
        this.bHo = ArrowDirection.fromInt(obtainStyledAttributes.getInt(a.j.sdk_BubbleLayout_sdk_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.bHp != null) {
            this.bHp.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.bHp = new a(new RectF(i, i3, i2, i4), this.aHL, this.aHM, this.aHN, this.aHO, this.mStrokeWidth, this.mStrokeColor, this.aHT, this.bHo);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bHo) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aHL);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aHL);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aHN);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aHN);
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

    private void El() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.bHo) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aHL);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aHL);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aHN);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aHN);
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

    public BubbleLayout v(float f) {
        El();
        this.aHO = f;
        initPadding();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.bHo;
    }

    public float getArrowWidth() {
        return this.aHL;
    }

    public float getCornersRadius() {
        return this.aHM;
    }

    public float getArrowHeight() {
        return this.aHN;
    }

    public float getArrowPosition() {
        return this.aHO;
    }

    public int getBubbleColor() {
        return this.aHT;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
