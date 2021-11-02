package com.baidu.searchbox.ui.bubble.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MaskViewGroup extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float cornerRadius;
    public float deltaHeight;
    public float deltaWidth;
    public boolean drawShadow;
    public float dx;
    public float dy;
    public Context mContext;
    public int mShadowAlpha;
    public Paint mShadowPaint;
    public int shadowColor;
    public float shadowRadius;

    /* loaded from: classes7.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
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
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaskViewGroup(Context context) {
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

    private void initShadowPaint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            updateColorAlpha();
            Paint paint = new Paint();
            this.mShadowPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mShadowPaint.setAntiAlias(true);
            this.mShadowPaint.setColor(this.shadowColor);
            this.mShadowPaint.setShadowLayer(this.shadowRadius, this.dx, this.dy, this.shadowColor);
            this.mShadowPaint.setAlpha(this.mShadowAlpha);
        }
    }

    private void initView(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.ShadowViewGroup);
            this.shadowColor = obtainStyledAttributes.getColor(R.styleable.ShadowViewGroup_containerShadowColor, -16777216);
            this.shadowRadius = obtainStyledAttributes.getDimension(R.styleable.ShadowViewGroup_containerShadowRadius, 0.0f);
            this.dx = obtainStyledAttributes.getDimension(R.styleable.ShadowViewGroup_deltaX, 0.0f);
            this.dy = obtainStyledAttributes.getDimension(R.styleable.ShadowViewGroup_deltaY, 0.0f);
            this.deltaWidth = obtainStyledAttributes.getDimension(R.styleable.ShadowViewGroup_containerDeltaWidth, 0.0f);
            this.deltaHeight = obtainStyledAttributes.getDimension(R.styleable.ShadowViewGroup_containerDeltaHeight, 0.0f);
            this.cornerRadius = obtainStyledAttributes.getDimension(R.styleable.ShadowViewGroup_containerCornerRadius, 0.0f);
            this.drawShadow = obtainStyledAttributes.getBoolean(R.styleable.ShadowViewGroup_enable, true);
            this.mShadowAlpha = obtainStyledAttributes.getInt(R.styleable.ShadowViewGroup_shadowAlpha, 127);
            obtainStyledAttributes.recycle();
            initShadowPaint();
        }
    }

    private void updateColorAlpha() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int i2 = this.shadowColor;
            int i3 = (i2 >> 16) & 255;
            int i4 = (i2 >> 8) & 255;
            int i5 = (i2 >> 0) & 255;
            int i6 = (i2 >> 24) & 255;
            this.shadowColor = ((i6 == 0 ? this.mShadowAlpha : (i6 * this.mShadowAlpha) / 255) << 24) + (i3 << 16) + (i4 << 8) + i5;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 21 && this.drawShadow) {
                if (getLayerType() != 1) {
                    setLayerType(1, null);
                }
                View childAt = getChildAt(0);
                RectF rectF = new RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                this.mShadowPaint.setAlpha(this.mShadowAlpha);
                float f2 = this.cornerRadius;
                canvas.drawRoundRect(rectF, f2, f2, this.mShadowPaint);
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new LayoutParams(-2, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public float getDeltaHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.deltaHeight : invokeV.floatValue;
    }

    public float getDeltaWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.deltaWidth : invokeV.floatValue;
    }

    public int getShadowColorAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.shadowColor >> 24) & 255 : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            View childAt = getChildAt(0);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            childAt.layout((measuredWidth - measuredWidth2) / 2, (measuredHeight - measuredHeight2) / 2, (measuredWidth + measuredWidth2) / 2, (measuredHeight + measuredHeight2) / 2);
            int childCount = getChildCount();
            if (childCount > 1) {
                for (int i6 = 1; i6 < childCount; i6++) {
                    View childAt2 = getChildAt(i6);
                    if (childAt2.getVisibility() != 8) {
                        childAt2.layout(i2, i3, i4, i5);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int i6 = 0;
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int max = (int) (Math.max(this.deltaHeight, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + 1.0f);
            int max2 = (int) (Math.max(this.deltaWidth, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + 1.0f);
            int max3 = (int) (Math.max(this.deltaWidth, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + 1.0f);
            int max4 = (int) (Math.max(this.deltaHeight, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + 1.0f);
            int i7 = 1073741824;
            if (mode == 0) {
                i4 = View.MeasureSpec.getSize(i2);
            } else {
                i4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i4 == -1) {
                    i4 = (measuredWidth - max2) - max3;
                } else if (-2 == i4) {
                    i4 = (measuredWidth - max2) - max3;
                    i6 = Integer.MIN_VALUE;
                }
                i6 = 1073741824;
            }
            if (mode2 == 0) {
                i5 = View.MeasureSpec.getSize(i3);
                i7 = 0;
            } else {
                i5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i5 == -1) {
                    i5 = (measuredHeight - max) - max4;
                } else if (-2 == i5) {
                    i5 = (measuredHeight - max) - max4;
                    i7 = Integer.MIN_VALUE;
                }
            }
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i4, i6), View.MeasureSpec.makeMeasureSpec(i5, i7));
            int mode3 = View.MeasureSpec.getMode(i2);
            int mode4 = View.MeasureSpec.getMode(i3);
            int measuredHeight2 = childAt.getMeasuredHeight();
            int measuredWidth2 = childAt.getMeasuredWidth();
            int i8 = mode4 == Integer.MIN_VALUE ? max4 + measuredHeight2 + max : measuredHeight;
            int i9 = mode3 == Integer.MIN_VALUE ? max3 + measuredWidth2 + max2 : measuredWidth;
            float f2 = measuredWidth2;
            float f3 = this.deltaWidth;
            if (i9 < (f3 * 2.0f) + f2) {
                i9 = (int) (f2 + (f3 * 2.0f));
            }
            float f4 = measuredHeight2;
            float f5 = this.deltaHeight;
            if (i8 < (f5 * 2.0f) + f4) {
                i8 = (int) (f4 + (f5 * 2.0f));
            }
            if (i8 != measuredHeight || i9 != measuredWidth) {
                setMeasuredDimension(i9, i8);
            }
            if (getChildCount() > 1) {
                for (int i10 = 1; i10 < getChildCount(); i10++) {
                    measureChild(getChildAt(i10), i2, i3);
                }
            }
        }
    }

    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mShadowAlpha = i2;
            initShadowPaint();
        }
    }

    public void setDrawShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.drawShadow = z;
        }
    }

    public void setShadowColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.shadowColor = i2;
            initShadowPaint();
        }
    }

    public void setShadowRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            this.shadowRadius = f2;
            initShadowPaint();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaskViewGroup(Context context, AttributeSet attributeSet) {
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

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskViewGroup(Context context, AttributeSet attributeSet, int i2) {
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
        this.mShadowAlpha = 75;
        this.mContext = context;
        initView(attributeSet);
    }
}
