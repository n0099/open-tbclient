package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AppCompatImageHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TintInfo mImageTint;
    public TintInfo mInternalImageTint;
    public TintInfo mTmpInfo;
    @NonNull
    public final ImageView mView;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, drawable)) == null) {
            if (this.mTmpInfo == null) {
                this.mTmpInfo = new TintInfo();
            }
            TintInfo tintInfo = this.mTmpInfo;
            tintInfo.clear();
            ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.mView);
            if (imageTintList != null) {
                tintInfo.mHasTintList = true;
                tintInfo.mTintList = imageTintList;
            }
            PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.mView);
            if (imageTintMode != null) {
                tintInfo.mHasTintMode = true;
                tintInfo.mTintMode = imageTintMode;
            }
            if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i = Build.VERSION.SDK_INT;
            return i > 21 ? this.mInternalImageTint != null : i == 21;
        }
        return invokeV.booleanValue;
    }

    public void applySupportImageTint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Drawable drawable = this.mView.getDrawable();
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (drawable != null) {
                if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(drawable)) {
                    return;
                }
                TintInfo tintInfo = this.mImageTint;
                if (tintInfo != null) {
                    AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
                    return;
                }
                TintInfo tintInfo2 = this.mInternalImageTint;
                if (tintInfo2 != null) {
                    AppCompatDrawableManager.tintDrawable(drawable, tintInfo2, this.mView.getDrawableState());
                }
            }
        }
    }

    public ColorStateList getSupportImageTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                return tintInfo.mTintList;
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                return tintInfo.mTintMode;
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    public boolean hasOverlappingRendering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Build.VERSION.SDK_INT < 21 || !(this.mView.getBackground() instanceof RippleDrawable);
        }
        return invokeV.booleanValue;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, attributeSet, i) == null) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
            ImageView imageView = this.mView;
            ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
            try {
                Drawable drawable = this.mView.getDrawable();
                if (drawable == null && (resourceId = obtainStyledAttributes.getResourceId(1, -1)) != -1 && (drawable = AppCompatResources.getDrawable(this.mView.getContext(), resourceId)) != null) {
                    this.mView.setImageDrawable(drawable);
                }
                if (drawable != null) {
                    DrawableUtils.fixDrawable(drawable);
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    ImageViewCompat.setImageTintList(this.mView, obtainStyledAttributes.getColorStateList(2));
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(3, -1), null));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i != 0) {
                Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), i);
                if (drawable != null) {
                    DrawableUtils.fixDrawable(drawable);
                }
                this.mView.setImageDrawable(drawable);
            } else {
                this.mView.setImageDrawable(null);
            }
            applySupportImageTint();
        }
    }

    public void setInternalImageTint(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorStateList) == null) {
            if (colorStateList != null) {
                if (this.mInternalImageTint == null) {
                    this.mInternalImageTint = new TintInfo();
                }
                TintInfo tintInfo = this.mInternalImageTint;
                tintInfo.mTintList = colorStateList;
                tintInfo.mHasTintList = true;
            } else {
                this.mInternalImageTint = null;
            }
            applySupportImageTint();
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, colorStateList) == null) {
            if (this.mImageTint == null) {
                this.mImageTint = new TintInfo();
            }
            TintInfo tintInfo = this.mImageTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
            applySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mode) == null) {
            if (this.mImageTint == null) {
                this.mImageTint = new TintInfo();
            }
            TintInfo tintInfo = this.mImageTint;
            tintInfo.mTintMode = mode;
            tintInfo.mHasTintMode = true;
            applySupportImageTint();
        }
    }
}
