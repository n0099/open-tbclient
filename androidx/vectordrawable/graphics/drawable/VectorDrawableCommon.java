package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable mDelegateDrawable;

    public VectorDrawableCommon() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, theme) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        DrawableCompat.applyTheme(drawable, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.clearColorFilter();
            } else {
                super.clearColorFilter();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getCurrent();
            }
            return super.getCurrent();
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getMinimumHeight();
            }
            return super.getMinimumHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getMinimumWidth();
            }
            return super.getMinimumWidth();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rect)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getPadding(rect);
            }
            return super.getPadding(rect);
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getState();
            }
            return super.getState();
        }
        return (int[]) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getTransparentRegion();
            }
            return super.getTransparentRegion();
        }
        return (Region) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        DrawableCompat.jumpToCurrentState(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setBounds(rect);
            } else {
                super.onBoundsChange(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setLevel(i);
            }
            return super.onLevelChange(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setChangingConfigurations(i);
            } else {
                super.setChangingConfigurations(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, mode) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setColorFilter(i, mode);
            } else {
                super.setColorFilter(i, mode);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        drawable.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        DrawableCompat.setHotspot(drawable, f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        DrawableCompat.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, iArr)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setState(iArr);
            }
            return super.setState(iArr);
        }
        return invokeL.booleanValue;
    }
}
