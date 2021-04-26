package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.UIUtils;
/* loaded from: classes2.dex */
public class CircleIndicator extends View {
    public static final int CIRCLE_INTER_WIDTH = 10;
    public static final int COLOR_EMOTION_CIRCLE_INDICATOR = -2565928;
    public static final int COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT = -6579301;
    public static final int NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR = -13421773;
    public static final int NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT = -11184811;
    public int mCircleColor;
    public int mCurrentPos;
    public int mHeight;
    public int mInitTranslationX;
    public int mInterWidth;
    public final ViewPager.OnPageChangeListener mPageChangeListener;
    public int mRadius;
    public int mRectColor;
    public int mRectWidth;
    public int mTabCount;
    public Paint mTabPaint;
    public int mTranslationX;
    public ViewPager mViewPager;
    public int mWidth;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    private void drawCircles(Canvas canvas) {
        this.mTabPaint.setColor(this.mCircleColor);
        for (int i2 = 0; i2 < this.mTabCount; i2++) {
            int i3 = this.mRadius;
            canvas.drawCircle(this.mInitTranslationX + (this.mInterWidth * i2), i3, i3, this.mTabPaint);
        }
    }

    private void drawIndicators() {
        int count = this.mViewPager.getAdapter().getCount();
        this.mTabCount = count;
        if (count <= 0) {
            return;
        }
        int dp2px = (int) UIUtils.dp2px(getContext(), 10.0f);
        this.mInterWidth = dp2px;
        this.mInitTranslationX = (this.mWidth - ((this.mTabCount - 1) * dp2px)) / 2;
        this.mRadius = dp2px / 5;
        invalidate();
    }

    private void drawRoundRect(Canvas canvas) {
        this.mTabPaint.setColor(this.mRectColor);
        int i2 = (this.mInitTranslationX + this.mTranslationX) - (this.mInterWidth / 2);
        canvas.drawRoundRect(new RectF(i2, 0, this.mRectWidth + i2, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void init() {
        Paint paint = new Paint();
        this.mTabPaint = paint;
        paint.setAntiAlias(true);
        if (BDEmotionPanelManager.getInstance().isNightMode()) {
            this.mCircleColor = -13421773;
            this.mRectColor = NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT;
            return;
        }
        this.mCircleColor = COLOR_EMOTION_CIRCLE_INDICATOR;
        this.mRectColor = COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircles(canvas);
        drawRoundRect(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mHeight = i3;
        this.mWidth = i2;
        int dp2px = (int) UIUtils.dp2px(getContext(), 10.0f);
        this.mInterWidth = dp2px;
        this.mInitTranslationX = (this.mWidth - ((this.mTabCount - 1) * dp2px)) / 2;
        this.mRadius = dp2px / 5;
        this.mRectWidth = dp2px;
    }

    public void scroll(int i2, float f2) {
        this.mTranslationX = (int) (this.mInterWidth * (f2 + i2));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        drawIndicators();
        this.mViewPager.removeOnPageChangeListener(this.mPageChangeListener);
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        this.mCurrentPos = this.mViewPager.getCurrentItem();
        invalidate();
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTabCount = 1;
        this.mTranslationX = 0;
        this.mPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f2, int i4) {
                if (f2 > 0.0f) {
                    CircleIndicator.this.scroll(i3, f2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                CircleIndicator.this.mCurrentPos = i3;
            }
        };
        init();
    }
}
