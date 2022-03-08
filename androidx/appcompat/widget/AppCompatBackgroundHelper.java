package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AppCompatBackgroundHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackgroundResId;
    public TintInfo mBackgroundTint;
    public final AppCompatDrawableManager mDrawableManager;
    public TintInfo mInternalBackgroundTint;
    public TintInfo mTmpInfo;
    @NonNull
    public final View mView;

    public AppCompatBackgroundHelper(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBackgroundResId = -1;
        this.mView = view;
        this.mDrawableManager = AppCompatDrawableManager.get();
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
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
            if (backgroundTintList != null) {
                tintInfo.mHasTintList = true;
                tintInfo.mTintList = backgroundTintList;
            }
            PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
            if (backgroundTintMode != null) {
                tintInfo.mHasTintMode = true;
                tintInfo.mTintMode = backgroundTintMode;
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
            int i2 = Build.VERSION.SDK_INT;
            return i2 > 21 ? this.mInternalBackgroundTint != null : i2 == 21;
        }
        return invokeV.booleanValue;
    }

    public void applySupportBackgroundTint() {
        Drawable background;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (background = this.mView.getBackground()) == null) {
            return;
        }
        if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(background)) {
            return;
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(background, tintInfo, this.mView.getDrawableState());
            return;
        }
        TintInfo tintInfo2 = this.mInternalBackgroundTint;
        if (tintInfo2 != null) {
            AppCompatDrawableManager.tintDrawable(background, tintInfo2, this.mView.getDrawableState());
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                return tintInfo.mTintList;
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                return tintInfo.mTintMode;
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, attributeSet, i2) == null) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i2, 0);
            View view = this.mView;
            ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), R$styleable.ViewBackgroundHelper, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
            try {
                if (obtainStyledAttributes.hasValue(R$styleable.ViewBackgroundHelper_android_background)) {
                    this.mBackgroundResId = obtainStyledAttributes.getResourceId(R$styleable.ViewBackgroundHelper_android_background, -1);
                    ColorStateList tintList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                    if (tintList != null) {
                        setInternalBackgroundTint(tintList);
                    }
                }
                if (obtainStyledAttributes.hasValue(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                    ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(R$styleable.ViewBackgroundHelper_backgroundTint));
                }
                if (obtainStyledAttributes.hasValue(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                    ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void onSetBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.mBackgroundResId = -1;
            setInternalBackgroundTint(null);
            applySupportBackgroundTint();
        }
    }

    public void onSetBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mBackgroundResId = i2;
            AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
            setInternalBackgroundTint(appCompatDrawableManager != null ? appCompatDrawableManager.getTintList(this.mView.getContext(), i2) : null);
            applySupportBackgroundTint();
        }
    }

    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorStateList) == null) {
            if (colorStateList != null) {
                if (this.mInternalBackgroundTint == null) {
                    this.mInternalBackgroundTint = new TintInfo();
                }
                TintInfo tintInfo = this.mInternalBackgroundTint;
                tintInfo.mTintList = colorStateList;
                tintInfo.mHasTintList = true;
            } else {
                this.mInternalBackgroundTint = null;
            }
            applySupportBackgroundTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, colorStateList) == null) {
            if (this.mBackgroundTint == null) {
                this.mBackgroundTint = new TintInfo();
            }
            TintInfo tintInfo = this.mBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
            applySupportBackgroundTint();
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mode) == null) {
            if (this.mBackgroundTint == null) {
                this.mBackgroundTint = new TintInfo();
            }
            TintInfo tintInfo = this.mBackgroundTint;
            tintInfo.mTintMode = mode;
            tintInfo.mHasTintMode = true;
            applySupportBackgroundTint();
        }
    }
}
