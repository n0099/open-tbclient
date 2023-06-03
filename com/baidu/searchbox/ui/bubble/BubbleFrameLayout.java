package com.baidu.searchbox.ui.bubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.res.R;
/* loaded from: classes4.dex */
public class BubbleFrameLayout extends FrameLayout {
    public static float DEFAULT_STROKE_WIDTH = -1.0f;
    public ArrowDirection mArrowDirection;
    public float mArrowHeight;
    public float mArrowPosition;
    public float mArrowWidth;
    public BubbleDrawable mBubble;
    public int mBubbleColor;
    public float mCornersRadius;
    public int mStrokeColor;
    public float mStrokeWidth;

    /* renamed from: com.baidu.searchbox.ui.bubble.BubbleFrameLayout$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleFrameLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        BubbleDrawable bubbleDrawable = this.mBubble;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public BubbleFrameLayout setArrowPosition(float f) {
        resetPadding();
        this.mArrowPosition = f;
        initPadding();
        return this;
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static float convertDpToPixel(float f, Context context) {
        return DeviceUtil.ScreenInfo.dp2px(context, f);
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleFrameLayout);
        this.mArrowWidth = obtainStyledAttributes.getDimension(3, convertDpToPixel(8.0f, context));
        this.mArrowHeight = obtainStyledAttributes.getDimension(1, convertDpToPixel(8.0f, context));
        this.mCornersRadius = obtainStyledAttributes.getDimension(5, 0.0f);
        this.mArrowPosition = obtainStyledAttributes.getDimension(2, convertDpToPixel(12.0f, context));
        this.mBubbleColor = obtainStyledAttributes.getColor(4, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(7, DEFAULT_STROKE_WIDTH);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.mArrowDirection = ArrowDirection.fromInt(obtainStyledAttributes.getInt(0, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        initPadding();
    }

    private void initDrawable(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.mBubble = new BubbleDrawable(new RectF(i, i3, i2, i4), this.mArrowWidth, this.mCornersRadius, this.mArrowHeight, this.mArrowPosition, this.mStrokeWidth, this.mStrokeColor, this.mBubbleColor, this.mArrowDirection);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[this.mArrowDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        paddingBottom = (int) (paddingBottom + this.mArrowHeight);
                    }
                } else {
                    paddingTop = (int) (paddingTop + this.mArrowHeight);
                }
            } else {
                paddingRight = (int) (paddingRight + this.mArrowWidth);
            }
        } else {
            paddingLeft = (int) (paddingLeft + this.mArrowWidth);
        }
        float f = this.mStrokeWidth;
        if (f > 0.0f) {
            paddingLeft = (int) (paddingLeft + f);
            paddingRight = (int) (paddingRight + f);
            paddingTop = (int) (paddingTop + f);
            paddingBottom = (int) (paddingBottom + f);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void resetPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[this.mArrowDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        paddingBottom = (int) (paddingBottom - this.mArrowHeight);
                    }
                } else {
                    paddingTop = (int) (paddingTop - this.mArrowHeight);
                }
            } else {
                paddingRight = (int) (paddingRight - this.mArrowWidth);
            }
        } else {
            paddingLeft = (int) (paddingLeft - this.mArrowWidth);
        }
        float f = this.mStrokeWidth;
        if (f > 0.0f) {
            paddingLeft = (int) (paddingLeft - f);
            paddingRight = (int) (paddingRight - f);
            paddingTop = (int) (paddingTop - f);
            paddingBottom = (int) (paddingBottom - f);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        initDrawable(0, getWidth(), 0, getHeight());
    }
}
