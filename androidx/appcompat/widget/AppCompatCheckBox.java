package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton, TintableBackgroundView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(@NonNull Context context) {
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.drawableStateChanged();
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.applySupportBackgroundTint();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.applyCompoundDrawablesTints();
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int compoundPaddingLeft = super.getCompoundPaddingLeft();
            AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
            return appCompatCompoundButtonHelper != null ? appCompatCompoundButtonHelper.getCompoundPaddingLeft(compoundPaddingLeft) : compoundPaddingLeft;
        }
        return invokeV.intValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                return appCompatBackgroundHelper.getSupportBackgroundTintList();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                return appCompatBackgroundHelper.getSupportBackgroundTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportButtonTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
            if (appCompatCompoundButtonHelper != null) {
                return appCompatCompoundButtonHelper.getSupportButtonTintList();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportButtonTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
            if (appCompatCompoundButtonHelper != null) {
                return appCompatCompoundButtonHelper.getSupportButtonTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.setBackgroundResource(i2);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundResource(i2);
            }
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            super.setButtonDrawable(drawable);
            AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
            if (appCompatCompoundButtonHelper != null) {
                appCompatCompoundButtonHelper.onSetButtonDrawable();
            }
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, colorStateList) == null) || (appCompatBackgroundHelper = this.mBackgroundTintHelper) == null) {
            return;
        }
        appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, mode) == null) || (appCompatBackgroundHelper = this.mBackgroundTintHelper) == null) {
            return;
        }
        appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, colorStateList) == null) || (appCompatCompoundButtonHelper = this.mCompoundButtonHelper) == null) {
            return;
        }
        appCompatCompoundButtonHelper.setSupportButtonTintList(colorStateList);
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, mode) == null) || (appCompatCompoundButtonHelper = this.mCompoundButtonHelper) == null) {
            return;
        }
        appCompatCompoundButtonHelper.setSupportButtonTintMode(mode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
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
    public AppCompatCheckBox(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.wrap(context), attributeSet, i2);
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
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper = appCompatCompoundButtonHelper;
        appCompatCompoundButtonHelper.loadFromAttributes(attributeSet, i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            setButtonDrawable(AppCompatResources.getDrawable(getContext(), i2));
        }
    }
}
