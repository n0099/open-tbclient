package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CircleIndicator extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CIRCLE_INTER_WIDTH = 10;
    public static final int COLOR_EMOTION_CIRCLE_INDICATOR = -2565928;
    public static final int COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT = -6579301;
    public static final int NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR = -13421773;
    public static final int NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT = -11184811;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void drawCircles(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) {
            this.mTabPaint.setColor(this.mCircleColor);
            for (int i2 = 0; i2 < this.mTabCount; i2++) {
                int i3 = this.mRadius;
                canvas.drawCircle(this.mInitTranslationX + (this.mInterWidth * i2), i3, i3, this.mTabPaint);
            }
        }
    }

    private void drawIndicators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
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
    }

    private void drawRoundRect(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, canvas) == null) {
            this.mTabPaint.setColor(this.mRectColor);
            int i2 = (this.mInitTranslationX + this.mTranslationX) - (this.mInterWidth / 2);
            canvas.drawRoundRect(new RectF(i2, 0, this.mRectWidth + i2, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
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
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            drawCircles(canvas);
            drawRoundRect(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.mHeight = i3;
            this.mWidth = i2;
            int dp2px = (int) UIUtils.dp2px(getContext(), 10.0f);
            this.mInterWidth = dp2px;
            this.mInitTranslationX = (this.mWidth - ((this.mTabCount - 1) * dp2px)) / 2;
            this.mRadius = dp2px / 5;
            this.mRectWidth = dp2px;
        }
    }

    public void scroll(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mTranslationX = (int) (this.mInterWidth * (f2 + i2));
            invalidate();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewPager) == null) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTabCount = 1;
        this.mTranslationX = 0;
        this.mPageChangeListener = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CircleIndicator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i5) == null) {
                    GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i5, float f2, int i6) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i5), Float.valueOf(f2), Integer.valueOf(i6)}) == null) || f2 <= 0.0f) {
                    return;
                }
                this.this$0.scroll(i5, f2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i5) == null) {
                    this.this$0.mCurrentPos = i5;
                }
            }
        };
        init();
    }
}
