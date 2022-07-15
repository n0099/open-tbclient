package com.baidu.nadcore.widget.bubble.shadow;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MaskViewGroup extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public Paint d;
    public boolean e;
    public Context f;
    public int g;
    public float h;
    public float i;
    public float j;
    public int k;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            Paint paint = new Paint();
            this.d = paint;
            paint.setStyle(Paint.Style.FILL);
            this.d.setAntiAlias(true);
            this.d.setColor(this.g);
            this.d.setShadowLayer(this.h, this.i, this.j, this.g);
            this.d.setAlpha(this.k);
        }
    }

    public final void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040176, R.attr.obfuscated_res_0x7f040177, R.attr.obfuscated_res_0x7f040178, R.attr.obfuscated_res_0x7f040179, R.attr.obfuscated_res_0x7f04017a, R.attr.obfuscated_res_0x7f0401e9, R.attr.obfuscated_res_0x7f0401ea, R.attr.obfuscated_res_0x7f040219, R.attr.obfuscated_res_0x7f04058d});
            this.g = obtainStyledAttributes.getColor(3, -16777216);
            this.h = obtainStyledAttributes.getDimension(4, 0.0f);
            this.i = obtainStyledAttributes.getDimension(5, 0.0f);
            this.j = obtainStyledAttributes.getDimension(6, 0.0f);
            this.b = obtainStyledAttributes.getDimension(2, 0.0f);
            this.a = obtainStyledAttributes.getDimension(1, 0.0f);
            this.c = obtainStyledAttributes.getDimension(0, 0.0f);
            this.e = obtainStyledAttributes.getBoolean(7, true);
            this.k = obtainStyledAttributes.getInt(8, 127);
            obtainStyledAttributes.recycle();
            a();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.g;
            int i2 = (i >> 16) & 255;
            int i3 = (i >> 8) & 255;
            int i4 = (i >> 0) & 255;
            int i5 = (i >> 24) & 255;
            this.g = ((i5 == 0 ? this.k : (i5 * this.k) / 255) << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 21 && this.e) {
                if (getLayerType() != 1) {
                    setLayerType(1, null);
                }
                View childAt = getChildAt(0);
                RectF rectF = new RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                this.d.setAlpha(this.k);
                float f = this.c;
                canvas.drawRoundRect(rectF, f, f, this.d);
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LayoutParams(-2, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public float getDeltaHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.floatValue;
    }

    public float getDeltaWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : invokeV.floatValue;
    }

    public int getShadowColorAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.g >> 24) & 255 : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            View childAt = getChildAt(0);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            childAt.layout((measuredWidth - measuredWidth2) / 2, (measuredHeight - measuredHeight2) / 2, (measuredWidth + measuredWidth2) / 2, (measuredHeight + measuredHeight2) / 2);
            int childCount = getChildCount();
            if (childCount > 1) {
                for (int i5 = 1; i5 < childCount; i5++) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2.getVisibility() != 8) {
                        childAt2.layout(i, i2, i3, i4);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i5 = 0;
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int max = (int) (Math.max(this.a, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + 1.0f);
            int max2 = (int) (Math.max(this.b, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + 1.0f);
            int max3 = (int) (Math.max(this.b, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + 1.0f);
            int max4 = (int) (Math.max(this.a, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + 1.0f);
            int i6 = 1073741824;
            if (mode == 0) {
                i3 = View.MeasureSpec.getSize(i);
            } else {
                i3 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i3 == -1) {
                    i3 = (measuredWidth - max2) - max3;
                } else if (-2 == i3) {
                    i3 = (measuredWidth - max2) - max3;
                    i5 = Integer.MIN_VALUE;
                }
                i5 = 1073741824;
            }
            if (mode2 == 0) {
                i4 = View.MeasureSpec.getSize(i2);
                i6 = 0;
            } else {
                i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i4 == -1) {
                    i4 = (measuredHeight - max) - max4;
                } else if (-2 == i4) {
                    i4 = (measuredHeight - max) - max4;
                    i6 = Integer.MIN_VALUE;
                }
            }
            measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i3, i5), View.MeasureSpec.makeMeasureSpec(i4, i6));
            int mode3 = View.MeasureSpec.getMode(i);
            int mode4 = View.MeasureSpec.getMode(i2);
            int measuredHeight2 = childAt.getMeasuredHeight();
            int measuredWidth2 = childAt.getMeasuredWidth();
            int i7 = mode4 == Integer.MIN_VALUE ? max4 + measuredHeight2 + max : measuredHeight;
            int i8 = mode3 == Integer.MIN_VALUE ? max3 + measuredWidth2 + max2 : measuredWidth;
            float f = measuredWidth2;
            float f2 = this.b;
            if (i8 < (f2 * 2.0f) + f) {
                i8 = (int) (f + (f2 * 2.0f));
            }
            float f3 = measuredHeight2;
            float f4 = this.a;
            if (i7 < (f4 * 2.0f) + f3) {
                i7 = (int) (f3 + (f4 * 2.0f));
            }
            if (i7 != measuredHeight || i8 != measuredWidth) {
                setMeasuredDimension(i8, i7);
            }
            if (getChildCount() > 1) {
                for (int i9 = 1; i9 < getChildCount(); i9++) {
                    measureChild(getChildAt(i9), i, i2);
                }
            }
        }
    }

    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
            a();
        }
    }

    public void setDrawShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.e = z;
        }
    }

    public void setShadowColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.g = i;
            a();
        }
    }

    public void setShadowRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.h = f;
            a();
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

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskViewGroup(Context context, AttributeSet attributeSet, int i) {
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
        this.k = 75;
        this.f = context;
        b(attributeSet);
    }
}
