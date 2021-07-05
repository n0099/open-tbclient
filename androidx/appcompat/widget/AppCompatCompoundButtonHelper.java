package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AppCompatCompoundButtonHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ColorStateList mButtonTintList;
    public PorterDuff.Mode mButtonTintMode;
    public boolean mHasButtonTint;
    public boolean mHasButtonTintMode;
    public boolean mSkipNextApply;
    @NonNull
    public final CompoundButton mView;

    public AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {compoundButton};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        Drawable buttonDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView)) == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(mutate);
        }
    }

    public int getCompoundPaddingLeft(int i2) {
        InterceptResult invokeI;
        Drawable buttonDrawable;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (Build.VERSION.SDK_INT >= 17 || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView)) == null) ? i2 : i2 + buttonDrawable.getIntrinsicWidth() : invokeI.intValue;
    }

    public ColorStateList getSupportButtonTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mButtonTintList : (ColorStateList) invokeV.objValue;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mButtonTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:5:0x0023, B:7:0x002b, B:9:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0057, B:18:0x0066, B:20:0x006e, B:21:0x0079, B:23:0x0081), top: B:33:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #0 {all -> 0x0096, blocks: (B:5:0x0023, B:7:0x002b, B:9:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0057, B:18:0x0066, B:20:0x006e, B:21:0x0079, B:23:0x0081), top: B:33:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i2) {
        boolean z;
        int resourceId;
        int resourceId2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, attributeSet, i2) == null) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.CompoundButton, i2, 0);
            CompoundButton compoundButton = this.mView;
            ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), R.styleable.CompoundButton, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
            try {
                if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonCompat) && (resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_buttonCompat, 0)) != 0) {
                    try {
                        this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), resourceId2));
                        z = true;
                    } catch (Resources.NotFoundException unused) {
                    }
                    if (!z && obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                        this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), resourceId));
                    }
                    if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                        CompoundButtonCompat.setButtonTintList(this.mView, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
                    }
                    if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
                    }
                }
                z = false;
                if (!z) {
                    this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), resourceId));
                }
                if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                }
                if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void onSetButtonDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mSkipNextApply) {
                this.mSkipNextApply = false;
                return;
            }
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorStateList) == null) {
            this.mButtonTintList = colorStateList;
            this.mHasButtonTint = true;
            applyButtonTint();
        }
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mode) == null) {
            this.mButtonTintMode = mode;
            this.mHasButtonTintMode = true;
            applyButtonTint();
        }
    }
}
