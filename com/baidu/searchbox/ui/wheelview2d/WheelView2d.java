package com.baidu.searchbox.ui.wheelview2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class WheelView2d extends BdGallery {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] SHADOWS_COLORS;
    public static final int[] SHADOWS_COLORS_NIGHT;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable mBottomShadow;
    public int mDefSelectorSize;
    public Rect mSelectorBound;
    public Drawable mSelectorDrawable;
    public int mSelectorHeight;
    public int mShadowHeight;
    public Drawable mTopShadow;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1635539097, "Lcom/baidu/searchbox/ui/wheelview2d/WheelView2d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1635539097, "Lcom/baidu/searchbox/ui/wheelview2d/WheelView2d;");
                return;
            }
        }
        SHADOWS_COLORS = new int[]{-1, -1140850689, 16777215};
        SHADOWS_COLORS_NIGHT = new int[]{BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG, -1155983079, 1644825};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView2d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mSelectorHeight = -1;
        initialize(context);
    }

    private void calcCustomSelectorBoundVertical() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int centerOfGallery = getCenterOfGallery();
            int i2 = this.mSelectorHeight;
            int i3 = centerOfGallery - (i2 / 2);
            this.mSelectorBound.set(getPaddingLeft(), i3, getWidth() - getPaddingRight(), i2 + i3);
        }
    }

    private void calcDefaultSelectorBoundVertical() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int centerOfGallery = getCenterOfGallery();
            View childAt = getChildAt(0);
            int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.mDefSelectorSize;
            int i2 = centerOfGallery - (measuredHeight / 2);
            this.mSelectorBound.set(getPaddingLeft(), i2, getWidth() - getPaddingRight(), measuredHeight + i2);
        }
    }

    private void calcSelectorBoundHorizontal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int centerOfGallery = getCenterOfGallery();
            View childAt = getChildAt(0);
            int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.mDefSelectorSize;
            int i2 = centerOfGallery - (measuredWidth / 2);
            this.mSelectorBound.set(i2, getPaddingTop(), measuredWidth + i2, getHeight() - getPaddingBottom());
        }
    }

    private void calcSelectorBoundVertical() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.mSelectorHeight > 0) {
                calcCustomSelectorBoundVertical();
            } else {
                calcDefaultSelectorBoundVertical();
            }
        }
    }

    private void drawCenterRect(Canvas canvas) {
        Rect rect;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, canvas) == null) || (rect = this.mSelectorBound) == null || rect.isEmpty() || (drawable = this.mSelectorDrawable) == null) {
            return;
        }
        drawable.setBounds(this.mSelectorBound);
        this.mSelectorDrawable.draw(canvas);
    }

    private void drawShadows(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, canvas) == null) {
            if (1 == getOrientation()) {
                drawShadowsHorizontal(canvas);
            } else {
                drawShadowsVertical(canvas);
            }
        }
    }

    private void drawShadowsHorizontal(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, canvas) == null) {
        }
    }

    private void drawShadowsVertical(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, canvas) == null) {
            if (this.mShadowHeight <= 0) {
                int height = (int) (this.mSelectorBound.height() * 2.0d);
                this.mShadowHeight = height;
                this.mShadowHeight = Math.min(height, this.mSelectorBound.top);
            }
            int i2 = this.mShadowHeight;
            Drawable drawable = this.mTopShadow;
            if (drawable != null) {
                drawable.setBounds(0, 0, getWidth(), i2);
                this.mTopShadow.draw(canvas);
            }
            Drawable drawable2 = this.mBottomShadow;
            if (drawable2 != null) {
                drawable2.setBounds(0, getHeight() - i2, getWidth(), getHeight());
                this.mBottomShadow.draw(canvas);
            }
        }
    }

    private void initialize(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            setVerticalScrollBarEnabled(false);
            setSlotInCenter(true);
            setOrientation(2);
            setGravity(1);
            setUnselectedAlpha(1.0f);
            setWillNotDraw(false);
            this.mSelectorDrawable = getContext().getResources().getDrawable(R.drawable.bd_wheel_val);
            if (NightModeHelper.getNightModeSwitcherState()) {
                this.mTopShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, SHADOWS_COLORS_NIGHT);
                this.mBottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, SHADOWS_COLORS_NIGHT);
            } else {
                this.mTopShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, SHADOWS_COLORS);
                this.mBottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, SHADOWS_COLORS);
            }
            setSoundEffectsEnabled(false);
            this.mDefSelectorSize = DeviceUtil.ScreenInfo.dp2px(getContext(), 50.0f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            drawCenterRect(canvas);
            drawShadows(canvas);
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery, com.baidu.searchbox.ui.wheelview2d.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (1 == getOrientation()) {
                calcSelectorBoundHorizontal();
            } else {
                calcSelectorBoundVertical();
            }
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery, com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void selectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.selectionChanged();
            playSoundEffect(0);
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (1 != i2) {
                super.setOrientation(i2);
                return;
            }
            throw new IllegalArgumentException("The orientation must be VERTICAL");
        }
    }

    public void setSelectorDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) || this.mSelectorDrawable == drawable) {
            return;
        }
        this.mSelectorDrawable = drawable;
        invalidate();
    }

    public void setSelectorDrawableHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mSelectorHeight = i2;
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, drawable, drawable2) == null) {
            this.mTopShadow = drawable;
            this.mBottomShadow = drawable2;
            invalidate();
        }
    }

    public void setShadowDrawableHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mShadowHeight = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView2d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mSelectorHeight = -1;
        initialize(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView2d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mSelectorHeight = -1;
        initialize(context);
    }
}
