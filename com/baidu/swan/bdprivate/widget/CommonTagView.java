package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes9.dex */
public class CommonTagView extends TextView {
    private boolean caN;
    private int mBorderColor;
    private int mBorderWidth;
    private Context mContext;
    private int mCornerRadius;
    private boolean mHasBorder;
    private Paint mPaint;
    private RectF mRectF;

    public CommonTagView(Context context) {
        this(context, null);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasBorder = true;
        this.caN = true;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.CommonTagView);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.CommonTagView_borderWidth, 1);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.CommonTagView_borderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelOffset(b.i.CommonTagView_cornerRadius, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? af.dip2px(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? af.dip2px(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? af.dip2px(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? af.dip2px(context, 1.0f) : getPaddingBottom());
        dk(context);
    }

    private void dk(Context context) {
        this.mContext = context;
        this.mPaint = new Paint();
        this.mRectF = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mHasBorder) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            if (this.caN && this.mBorderColor != getCurrentTextColor()) {
                this.mBorderColor = getCurrentTextColor();
            }
            this.mPaint.setColor(this.mBorderColor);
            this.mRectF.left = this.mBorderWidth * 0.5f;
            this.mRectF.top = this.mBorderWidth * 0.5f;
            this.mRectF.right = getMeasuredWidth() - (this.mBorderWidth * 0.5f);
            this.mRectF.bottom = getMeasuredHeight() - (this.mBorderWidth * 0.5f);
            canvas.drawRoundRect(this.mRectF, this.mCornerRadius, this.mCornerRadius, this.mPaint);
        }
    }
}
