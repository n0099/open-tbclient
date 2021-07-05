package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class WrappedDrawableState extends Drawable.ConstantState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mChangingConfigurations;
    public Drawable.ConstantState mDrawableState;
    public ColorStateList mTint;
    public PorterDuff.Mode mTintMode;

    public WrappedDrawableState(@Nullable WrappedDrawableState wrappedDrawableState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrappedDrawableState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (wrappedDrawableState != null) {
            this.mChangingConfigurations = wrappedDrawableState.mChangingConfigurations;
            this.mDrawableState = wrappedDrawableState.mDrawableState;
            this.mTint = wrappedDrawableState.mTint;
            this.mTintMode = wrappedDrawableState.mTintMode;
        }
    }

    public boolean canConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDrawableState != null : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.mChangingConfigurations;
            Drawable.ConstantState constantState = this.mDrawableState;
            return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? newDrawable(null) : (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, resources)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new WrappedDrawableApi21(this, resources);
            }
            return new WrappedDrawableApi14(this, resources);
        }
        return (Drawable) invokeL.objValue;
    }
}
