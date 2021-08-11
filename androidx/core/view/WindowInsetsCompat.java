package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;
/* loaded from: classes.dex */
public class WindowInsetsCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final WindowInsetsCompat CONSUMED;
    public static final String TAG = "WindowInsetsCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public final Impl mImpl;

    /* loaded from: classes.dex */
    public static class BuilderImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowInsetsCompat mInsets;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((WindowInsetsCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInsets : (WindowInsetsCompat) invokeV.objValue;
        }

        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayCutoutCompat) == null) {
            }
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insets) == null) {
            }
        }

        public void setStableInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, insets) == null) {
            }
        }

        public void setSystemGestureInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, insets) == null) {
            }
        }

        public void setSystemWindowInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, insets) == null) {
            }
        }

        public void setTappableElementInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, insets) == null) {
            }
        }

        public BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mInsets = windowInsetsCompat;
        }
    }

    /* loaded from: classes.dex */
    public static class Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowInsetsCompat mHost;

        public Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHost = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHost : (WindowInsetsCompat) invokeV.objValue;
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHost : (WindowInsetsCompat) invokeV.objValue;
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHost : (WindowInsetsCompat) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Impl) {
                    Impl impl = (Impl) obj;
                    return isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (DisplayCutoutCompat) invokeV.objValue;
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getSystemWindowInsets() : (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Insets.NONE : (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getSystemWindowInsets() : (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Insets.NONE : (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getSystemWindowInsets() : (Insets) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()) : invokeV.intValue;
        }

        @NonNull
        public WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048587, this, i2, i3, i4, i5)) == null) ? WindowInsetsCompat.CONSUMED : (WindowInsetsCompat) invokeIIII.objValue;
        }

        public boolean isConsumed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isRound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Impl28 extends Impl21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout()) : (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Impl28) {
                    return Objects.equals(this.mPlatformInsets, ((Impl28) obj).mPlatformInsets);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout()) : (DisplayCutoutCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlatformInsets.hashCode() : invokeV.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, impl28);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl28};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (Impl21) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1323746145, "Landroidx/core/view/WindowInsetsCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1323746145, "Landroidx/core/view/WindowInsetsCompat;");
                return;
            }
        }
        CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    }

    @RequiresApi(20)
    public WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {windowInsets};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i4 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else if (i4 >= 21) {
            this.mImpl = new Impl21(this, windowInsets);
        } else if (i4 >= 20) {
            this.mImpl = new Impl20(this, windowInsets);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    public static Insets insetInsets(Insets insets, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{insets, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int max = Math.max(0, insets.left - i2);
            int max2 = Math.max(0, insets.top - i3);
            int max3 = Math.max(0, insets.right - i4);
            int max4 = Math.max(0, insets.bottom - i5);
            return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? insets : Insets.of(max, max2, max3, max4);
        }
        return (Insets) invokeCommon.objValue;
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, windowInsets)) == null) ? new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets)) : (WindowInsetsCompat) invokeL.objValue;
    }

    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mImpl.consumeDisplayCutout() : (WindowInsetsCompat) invokeV.objValue;
    }

    @NonNull
    public WindowInsetsCompat consumeStableInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mImpl.consumeStableInsets() : (WindowInsetsCompat) invokeV.objValue;
    }

    @NonNull
    public WindowInsetsCompat consumeSystemWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImpl.consumeSystemWindowInsets() : (WindowInsetsCompat) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WindowInsetsCompat) {
                return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImpl.getDisplayCutout() : (DisplayCutoutCompat) invokeV.objValue;
    }

    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.getMandatorySystemGestureInsets() : (Insets) invokeV.objValue;
    }

    public int getStableInsetBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getStableInsets().bottom : invokeV.intValue;
    }

    public int getStableInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getStableInsets().left : invokeV.intValue;
    }

    public int getStableInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getStableInsets().right : invokeV.intValue;
    }

    public int getStableInsetTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getStableInsets().top : invokeV.intValue;
    }

    @NonNull
    public Insets getStableInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mImpl.getStableInsets() : (Insets) invokeV.objValue;
    }

    @NonNull
    public Insets getSystemGestureInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mImpl.getSystemGestureInsets() : (Insets) invokeV.objValue;
    }

    public int getSystemWindowInsetBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getSystemWindowInsets().bottom : invokeV.intValue;
    }

    public int getSystemWindowInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getSystemWindowInsets().left : invokeV.intValue;
    }

    public int getSystemWindowInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getSystemWindowInsets().right : invokeV.intValue;
    }

    public int getSystemWindowInsetTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getSystemWindowInsets().top : invokeV.intValue;
    }

    @NonNull
    public Insets getSystemWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mImpl.getSystemWindowInsets() : (Insets) invokeV.objValue;
    }

    @NonNull
    public Insets getTappableElementInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mImpl.getTappableElementInsets() : (Insets) invokeV.objValue;
    }

    public boolean hasInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (!hasSystemWindowInsets() && !hasStableInsets() && getDisplayCutout() == null && getSystemGestureInsets().equals(Insets.NONE) && getMandatorySystemGestureInsets().equals(Insets.NONE) && getTappableElementInsets().equals(Insets.NONE)) ? false : true : invokeV.booleanValue;
    }

    public boolean hasStableInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? !getStableInsets().equals(Insets.NONE) : invokeV.booleanValue;
    }

    public boolean hasSystemWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? !getSystemWindowInsets().equals(Insets.NONE) : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Impl impl = this.mImpl;
            if (impl == null) {
                return 0;
            }
            return impl.hashCode();
        }
        return invokeV.intValue;
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, insets)) == null) ? inset(insets.left, insets.top, insets.right, insets.bottom) : (WindowInsetsCompat) invokeL.objValue;
    }

    public boolean isConsumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mImpl.isConsumed() : invokeV.booleanValue;
    }

    public boolean isRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mImpl.isRound() : invokeV.booleanValue;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048602, this, i2, i3, i4, i5)) == null) ? new Builder(this).setSystemWindowInsets(Insets.of(i2, i3, i4, i5)).build() : (WindowInsetsCompat) invokeIIII.objValue;
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Impl impl = this.mImpl;
            if (impl instanceof Impl20) {
                return ((Impl20) impl).mPlatformInsets;
            }
            return null;
        }
        return (WindowInsets) invokeV.objValue;
    }

    @RequiresApi(api = 20)
    /* loaded from: classes.dex */
    public static class BuilderImpl20 extends BuilderImpl {
        public static /* synthetic */ Interceptable $ic;
        public static Constructor<WindowInsets> sConstructor;
        public static boolean sConstructorFetched;
        public static Field sConsumedField;
        public static boolean sConsumedFieldFetched;
        public transient /* synthetic */ FieldHolder $fh;
        public WindowInsets mInsets;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1271784918, "Landroidx/core/view/WindowInsetsCompat$BuilderImpl20;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1271784918, "Landroidx/core/view/WindowInsetsCompat$BuilderImpl20;");
            }
        }

        public BuilderImpl20() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mInsets = createWindowInsetsInstance();
        }

        @Nullable
        public static WindowInsets createWindowInsetsInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (!sConsumedFieldFetched) {
                    try {
                        sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                    } catch (ReflectiveOperationException unused) {
                    }
                    sConsumedFieldFetched = true;
                }
                Field field = sConsumedField;
                if (field != null) {
                    try {
                        WindowInsets windowInsets = (WindowInsets) field.get(null);
                        if (windowInsets != null) {
                            return new WindowInsets(windowInsets);
                        }
                    } catch (ReflectiveOperationException unused2) {
                    }
                }
                if (!sConstructorFetched) {
                    try {
                        sConstructor = WindowInsets.class.getConstructor(Rect.class);
                    } catch (ReflectiveOperationException unused3) {
                    }
                    sConstructorFetched = true;
                }
                Constructor<WindowInsets> constructor = sConstructor;
                if (constructor != null) {
                    try {
                        return constructor.newInstance(new Rect());
                    } catch (ReflectiveOperationException unused4) {
                    }
                }
                return null;
            }
            return (WindowInsets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? WindowInsetsCompat.toWindowInsetsCompat(this.mInsets) : (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets windowInsets;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, insets) == null) || (windowInsets = this.mInsets) == null) {
                return;
            }
            this.mInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
        }

        public BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    /* loaded from: classes.dex */
    public static class BuilderImpl29 extends BuilderImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build()) : (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayCutoutCompat) == null) {
                this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insets) == null) {
                this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, insets) == null) {
                this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, insets) == null) {
                this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, insets) == null) {
                this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, insets) == null) {
                this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
            }
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builder;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.mPlatBuilder = builder;
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Impl21 extends Impl20 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Insets mStableInsets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets()) : (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets()) : (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mStableInsets == null) {
                    this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
                }
                return this.mStableInsets;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlatformInsets.isConsumed() : invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl21};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (Impl20) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mStableInsets = null;
        }
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048598, this, i2, i3, i4, i5)) == null) ? this.mImpl.inset(i2, i3, i4, i5) : (WindowInsetsCompat) invokeIIII.objValue;
    }

    @RequiresApi(20)
    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final WindowInsets mPlatformInsets;
        public Insets mSystemWindowInsets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((WindowInsetsCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mSystemWindowInsets == null) {
                    this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
                }
                return this.mSystemWindowInsets;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) {
                Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
                builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i2, i3, i4, i5));
                builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i2, i3, i4, i5));
                return builder.build();
            }
            return (WindowInsetsCompat) invokeIIII.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPlatformInsets.isRound() : invokeV.booleanValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl20};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Impl29 extends Impl28 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Insets mMandatorySystemGestureInsets;
        public Insets mSystemGestureInsets;
        public Insets mTappableElementInsets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mMandatorySystemGestureInsets == null) {
                    this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
                }
                return this.mMandatorySystemGestureInsets;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getSystemGestureInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mSystemGestureInsets == null) {
                    this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
                }
                return this.mSystemGestureInsets;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getTappableElementInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mTappableElementInsets == null) {
                    this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
                }
                return this.mTappableElementInsets;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i2, i3, i4, i5)) == null) ? WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i2, i3, i4, i5)) : (WindowInsetsCompat) invokeIIII.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl29};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (Impl28) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, rect)) == null) ? new Builder(this).setSystemWindowInsets(Insets.of(rect)).build() : (WindowInsetsCompat) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BuilderImpl mImpl;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else if (i4 >= 20) {
                this.mImpl = new BuilderImpl20();
            } else {
                this.mImpl = new BuilderImpl();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mImpl.build() : (WindowInsetsCompat) invokeV.objValue;
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayCutoutCompat)) == null) {
                this.mImpl.setDisplayCutout(displayCutoutCompat);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insets)) == null) {
                this.mImpl.setMandatorySystemGestureInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setStableInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, insets)) == null) {
                this.mImpl.setStableInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, insets)) == null) {
                this.mImpl.setSystemGestureInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, insets)) == null) {
                this.mImpl.setSystemWindowInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, insets)) == null) {
                this.mImpl.setTappableElementInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else if (i4 >= 20) {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {windowInsetsCompat};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            if (Build.VERSION.SDK_INT >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
                return;
            } else if (Build.VERSION.SDK_INT >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
                return;
            } else if (Build.VERSION.SDK_INT >= 21 && (impl instanceof Impl21)) {
                this.mImpl = new Impl21(this, (Impl21) impl);
                return;
            } else if (Build.VERSION.SDK_INT >= 20 && (impl instanceof Impl20)) {
                this.mImpl = new Impl20(this, (Impl20) impl);
                return;
            } else {
                this.mImpl = new Impl(this);
                return;
            }
        }
        this.mImpl = new Impl(this);
    }
}
