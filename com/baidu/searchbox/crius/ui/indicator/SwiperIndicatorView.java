package com.baidu.searchbox.crius.ui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.util.ColorUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SwiperIndicatorView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusIndicator";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwiperIndicatorView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getIndicateSelectedColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (NightModeHelper.isNightMode()) {
                return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorSelectedColorNight);
            }
            return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorSelectedColor);
        }
        return invokeV.intValue;
    }

    private int getIndicatorBackColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (NightModeHelper.isNightMode()) {
                return ColorUtils.parseColor(this.mRenderData.backgroundColor);
            }
            return ColorUtils.parseColor(this.mRenderData.backgroundColorNight);
        }
        return invokeV.intValue;
    }

    private int getIndicatorDefaultColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (NightModeHelper.isNightMode()) {
                return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorDefaultColorNight);
            }
            return ColorUtils.parseColor(this.mIndicatorAttrs.indicatorDefaultColor);
        }
        return invokeV.intValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
                this.mPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0606d0));
            } else {
                this.mPaint.setColor(indicatorDefaultColor);
            }
            Paint paint2 = new Paint(1);
            this.mBackgroundPaint = paint2;
            paint2.setStyle(Paint.Style.FILL);
        }
    }

    private boolean isSelectedDrawRectangle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            IndicatorAttrs indicatorAttrs = this.mIndicatorAttrs;
            return indicatorAttrs != null && indicatorAttrs.indicatorItemSelectedWidth > indicatorAttrs.indicatorItemWidth;
        }
        return invokeV.booleanValue;
    }

    public void attachViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewPager) == null) || viewPager == null) {
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this, viewPager) { // from class: com.baidu.searchbox.crius.ui.indicator.SwiperIndicatorView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwiperIndicatorView this$0;
            public final /* synthetic */ ViewPager val$viewPager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewPager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$viewPager = viewPager;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    PagerAdapter adapter = this.val$viewPager.getAdapter();
                    if (i == 0) {
                        i = adapter.getCount() - 2;
                    } else if (i == adapter.getCount() - 1) {
                        i = 1;
                    }
                    this.this$0.setCurrentIndex(i - 1);
                }
            }
        });
        PagerAdapter adapter = viewPager.getAdapter();
        this.mCount = adapter.getCount() - 2;
        if (CriusRuntime.DEBUG) {
            Log.d(TAG, "#attachViewPager#, adapter count: " + adapter.getCount() + ", mCount: " + this.mCount);
        }
        setCurrentIndex(0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.mCount > 0) {
                canvas.drawColor(0);
                float height = getHeight() / 2;
                float f = this.mIndicatorLRMargin;
                for (int i = 0; i < this.mCount; i++) {
                    if (i == this.mCurrentIndex) {
                        int indicateSelectedColor = getIndicateSelectedColor();
                        if (indicateSelectedColor == Integer.MAX_VALUE) {
                            this.mPaint.setColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0606d1));
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
                            this.mPaint.setColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0606d0));
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
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f1);
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
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setCurrentIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mCurrentIndex = i;
            postInvalidate();
        }
    }

    public void setRenderData(CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, criusData) == null) {
            this.mRenderData = criusData;
            this.mIndicatorAttrs = criusData.indicatorAttrs;
            init();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwiperIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwiperIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCount = 0;
        this.mRadius = 0.0f;
        this.mCircleMargin = 0;
        this.mCurrentIndex = 1;
    }
}
