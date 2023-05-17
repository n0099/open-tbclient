package com.baidu.searchbox.crius.ui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.util.ColorUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SwiperIndicatorView extends View {
    public static final String TAG = "CriusIndicator";
    public Paint mBackgroundPaint;
    public int mCircleMargin;
    public int mCount;
    public int mCurrentIndex;
    public float mDensity;
    public IndicatorAttrs mIndicatorAttrs;
    public int mIndicatorLRMargin;
    public Paint mPaint;
    public float mRadius;
    public CriusData mRenderData;

    public SwiperIndicatorView(Context context) {
        this(context, null);
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
        postInvalidate();
    }

    public void setRenderData(CriusData criusData) {
        this.mRenderData = criusData;
        this.mIndicatorAttrs = criusData.indicatorAttrs;
        init();
    }

    public SwiperIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwiperIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCount = 0;
        this.mRadius = 0.0f;
        this.mCircleMargin = 0;
        this.mCurrentIndex = 1;
    }

    private int getIndicateSelectedColor() {
        if (NightModeHelper.isNightMode()) {
            return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorSelectedColorNight);
        }
        return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorSelectedColor);
    }

    private int getIndicatorBackColor() {
        if (NightModeHelper.isNightMode()) {
            return ColorUtils.parseColor(this.mRenderData.backgroundColor);
        }
        return ColorUtils.parseColor(this.mRenderData.backgroundColorNight);
    }

    private int getIndicatorDefaultColor() {
        if (NightModeHelper.isNightMode()) {
            return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorDefaultColorNight);
        }
        return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorDefaultColor);
    }

    private boolean isSelectedDrawRectangle() {
        IndicatorAttrs indicatorAttrs = this.mIndicatorAttrs;
        if (indicatorAttrs == null || indicatorAttrs.indicatorItemSelectedWidth <= indicatorAttrs.indicatorItemWidth) {
            return false;
        }
        return true;
    }

    private void init() {
        float density = DeviceUtils.ScreenInfo.getDensity(getContext());
        this.mDensity = density;
        IndicatorAttrs indicatorAttrs = this.mIndicatorAttrs;
        this.mCircleMargin = (int) (indicatorAttrs.indicatorMargin * density);
        this.mIndicatorLRMargin = (int) (indicatorAttrs.indicatorContentLRMargin * density);
        this.mRadius = (indicatorAttrs.indicatorItemWidth * DeviceUtils.ScreenInfo.getDensity(getContext())) / 2.0f;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        int indicatorDefaultColor = getIndicatorDefaultColor();
        if (indicatorDefaultColor == Integer.MAX_VALUE) {
            this.mPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0606d5));
        } else {
            this.mPaint.setColor(indicatorDefaultColor);
        }
        Paint paint2 = new Paint(1);
        this.mBackgroundPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public void attachViewPager(final ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.crius.ui.indicator.SwiperIndicatorView.1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    PagerAdapter adapter = viewPager.getAdapter();
                    if (i == 0) {
                        i = adapter.getCount() - 2;
                    } else if (i == adapter.getCount() - 1) {
                        i = 1;
                    }
                    SwiperIndicatorView.this.setCurrentIndex(i - 1);
                }
            });
            PagerAdapter adapter = viewPager.getAdapter();
            this.mCount = adapter.getCount() - 2;
            if (CriusRuntime.DEBUG) {
                Log.d(TAG, "#attachViewPager#, adapter count: " + adapter.getCount() + ", mCount: " + this.mCount);
            }
            setCurrentIndex(0);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mCount > 0) {
            canvas.drawColor(0);
            float height = getHeight() / 2;
            float f = this.mIndicatorLRMargin;
            for (int i = 0; i < this.mCount; i++) {
                if (i == this.mCurrentIndex) {
                    int indicateSelectedColor = getIndicateSelectedColor();
                    if (indicateSelectedColor == Integer.MAX_VALUE) {
                        this.mPaint.setColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0606d6));
                    } else {
                        this.mPaint.setColor(indicateSelectedColor);
                    }
                    if (isSelectedDrawRectangle()) {
                        float f2 = this.mRadius;
                        canvas.drawRoundRect(f, height - f2, f + (this.mIndicatorAttrs.indicatorItemSelectedWidth * this.mDensity), height + f2, f2, f2, this.mPaint);
                    } else {
                        float f3 = this.mRadius;
                        canvas.drawCircle(f + f3, height, f3, this.mPaint);
                    }
                } else {
                    int indicatorDefaultColor = getIndicatorDefaultColor();
                    if (indicatorDefaultColor == Integer.MAX_VALUE) {
                        this.mPaint.setColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0606d5));
                    } else {
                        this.mPaint.setColor(indicatorDefaultColor);
                    }
                    float f4 = this.mRadius;
                    canvas.drawCircle(f + f4, height, f4, this.mPaint);
                }
                if (i == this.mCurrentIndex && isSelectedDrawRectangle()) {
                    f += (this.mIndicatorAttrs.indicatorItemSelectedWidth * this.mDensity) + this.mCircleMargin;
                } else {
                    float f5 = this.mRadius;
                    f += this.mCircleMargin + f5 + f5;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b);
        }
        if (isSelectedDrawRectangle()) {
            float f = this.mIndicatorAttrs.indicatorItemSelectedWidth * this.mDensity;
            int i4 = this.mCount;
            i3 = (int) (((i4 - 1) * this.mRadius * 2.0f) + (this.mCircleMargin * (i4 - 1)) + (this.mIndicatorLRMargin * 2) + f);
        } else {
            int i5 = this.mCount;
            i3 = (int) ((i5 * this.mRadius * 2.0f) + (this.mCircleMargin * (i5 - 1)) + (this.mIndicatorLRMargin * 2));
        }
        setMeasuredDimension(i3, size);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
