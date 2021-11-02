package com.baidu.searchbox.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TabIndicator extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    public int mCount;
    public int mCurrentIndex;
    public Drawable mSelected;
    public int mSpacing;
    public Drawable mUnselected;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabIndicator(Resources resources, int i2, int i3, int i4) {
        this(resources, i2, i3, i4, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Resources) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getWidthForIndicators(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? ((i2 - 1) * this.mUnselected.getIntrinsicWidth()) + this.mSelected.getIntrinsicWidth() : invokeI.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int save = canvas.save();
            int i2 = this.mCount;
            canvas.translate((getBounds().width() - (getWidthForIndicators(i2) + ((i2 - 1) * this.mSpacing))) / 2, 0.0f);
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 == this.mCurrentIndex) {
                    drawable = this.mSelected;
                } else {
                    drawable = this.mUnselected;
                }
                int i4 = this.mAlpha;
                if (i4 != 255) {
                    drawable.setAlpha(i4);
                }
                drawable.draw(canvas);
                canvas.translate(drawable.getIntrinsicWidth() + this.mSpacing, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getBounds().height() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getBounds().width() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rect) == null) {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mAlpha = i2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorFilter) == null) {
        }
    }

    public void setIndicatorCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mCount = i2;
        }
    }

    public void setSelectedIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mCurrentIndex = i2;
            setIndicatorCount(this.mCount);
            invalidateSelf();
        }
    }

    public void updateDrawable(Resources resources, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, resources, i2, i3) == null) {
            this.mSelected = resources.getDrawable(i2);
            this.mUnselected = resources.getDrawable(i3);
            Drawable drawable = this.mSelected;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mSelected.getIntrinsicHeight());
            Drawable drawable2 = this.mUnselected;
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.mUnselected.getIntrinsicHeight());
        }
    }

    public TabIndicator(Resources resources, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentIndex = -1;
        this.mAlpha = 255;
        this.mSpacing = 0;
        this.mSpacing = i5;
        this.mSelected = resources.getDrawable(i2);
        this.mUnselected = resources.getDrawable(i3);
        Drawable drawable = this.mSelected;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mSelected.getIntrinsicHeight());
        Drawable drawable2 = this.mUnselected;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.mUnselected.getIntrinsicHeight());
        setBounds(0, 0, getWidthForIndicators(i4) + ((i4 - 1) * this.mSpacing), Math.max(this.mUnselected.getIntrinsicHeight(), this.mSelected.getIntrinsicHeight()));
    }
}
