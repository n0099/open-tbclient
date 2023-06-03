package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class CommonTagView extends TextView {
    public static final int CORNER_RADIUS = 3;
    public static final float LR_PADDING = 2.0f;
    public static final int STROKE_WIDTH = 1;
    public static final float TB_PADDING = 1.0f;
    public int mBorderColor;
    public int mBorderWidth;
    public Context mContext;
    public int mCornerRadius;
    public boolean mFollowTextColor;
    public boolean mHasBorder;
    public Paint mPaint;
    public RectF mRectF;

    public CommonTagView(Context context) {
        this(context, null);
    }

    private void initVariable(Context context) {
        this.mContext = context;
        this.mPaint = new Paint();
        this.mRectF = new RectF();
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasBorder = true;
        this.mFollowTextColor = true;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        int paddingLeft;
        int paddingRight;
        int paddingTop;
        int paddingBottom;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.searchbox.common.res.R.styleable.CommonTagView);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(1, 1);
        this.mBorderColor = obtainStyledAttributes.getColor(0, -16777216);
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelOffset(2, 3);
        obtainStyledAttributes.recycle();
        if (getPaddingLeft() == 0) {
            paddingLeft = DeviceUtil.ScreenInfo.dp2px(context, 2.0f);
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (getPaddingRight() == 0) {
            paddingRight = DeviceUtil.ScreenInfo.dp2px(context, 2.0f);
        } else {
            paddingRight = getPaddingRight();
        }
        if (getPaddingTop() == 0) {
            paddingTop = DeviceUtil.ScreenInfo.dp2px(context, 1.0f);
        } else {
            paddingTop = getPaddingTop();
        }
        if (getPaddingBottom() == 0) {
            paddingBottom = DeviceUtil.ScreenInfo.dp2px(context, 1.0f);
        } else {
            paddingBottom = getPaddingBottom();
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        initVariable(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mHasBorder) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            if (this.mFollowTextColor && this.mBorderColor != getCurrentTextColor()) {
                this.mBorderColor = getCurrentTextColor();
            }
            this.mPaint.setColor(this.mBorderColor);
            RectF rectF = this.mRectF;
            int i = this.mBorderWidth;
            rectF.left = i * 0.5f;
            rectF.top = i * 0.5f;
            rectF.right = getMeasuredWidth() - (this.mBorderWidth * 0.5f);
            this.mRectF.bottom = getMeasuredHeight() - (this.mBorderWidth * 0.5f);
            RectF rectF2 = this.mRectF;
            int i2 = this.mCornerRadius;
            canvas.drawRoundRect(rectF2, i2, i2, this.mPaint);
        }
    }
}
