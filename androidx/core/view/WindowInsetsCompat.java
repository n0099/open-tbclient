package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* loaded from: classes.dex */
public class WindowInsetsCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    public static final String TAG = "WindowInsetsCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public final Impl mImpl;

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21ReflectionHolder {
        public static /* synthetic */ Interceptable $ic;
        public static Field sContentInsets;
        public static boolean sReflectionSucceeded;
        public static Field sStableInsets;
        public static Field sViewAttachInfoField;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1545430221, "Landroidx/core/view/WindowInsetsCompat$Api21ReflectionHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1545430221, "Landroidx/core/view/WindowInsetsCompat$Api21ReflectionHolder;");
                    return;
                }
            }
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
                sReflectionSucceeded = true;
            } catch (ReflectiveOperationException e) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public Api21ReflectionHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
                if (sReflectionSucceeded && view2.isAttachedToWindow()) {
                    try {
                        Object obj = sViewAttachInfoField.get(view2.getRootView());
                        if (obj != null) {
                            Rect rect = (Rect) sStableInsets.get(obj);
                            Rect rect2 = (Rect) sContentInsets.get(obj);
                            if (rect != null && rect2 != null) {
                                WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                                build.setRootWindowInsets(build);
                                build.copyRootViewBounds(view2.getRootView());
                                return build;
                            }
                        }
                    } catch (IllegalAccessException e) {
                        Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                    }
                }
                return null;
            }
            return (WindowInsetsCompat) invokeL.objValue;
        }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.mImpl = new BuilderImpl30();
            } else if (i3 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else if (i3 >= 20) {
                this.mImpl = new BuilderImpl20();
            } else {
                this.mImpl = new BuilderImpl();
            }
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.mImpl = new BuilderImpl30(windowInsetsCompat);
            } else if (i3 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else if (i3 >= 20) {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl(windowInsetsCompat);
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mImpl.build();
            }
            return (WindowInsetsCompat) invokeV.objValue;
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
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, insets)) == null) {
                this.mImpl.setMandatorySystemGestureInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, insets)) == null) {
                this.mImpl.setStableInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, insets)) == null) {
                this.mImpl.setSystemGestureInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, insets)) == null) {
                this.mImpl.setSystemWindowInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, insets)) == null) {
                this.mImpl.setTappableElementInsets(insets);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setInsets(int i, @NonNull Insets insets) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, insets)) == null) {
                this.mImpl.setInsets(i, insets);
                return this;
            }
            return (Builder) invokeIL.objValue;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, insets)) == null) {
                this.mImpl.setInsetsIgnoringVisibility(i, insets);
                return this;
            }
            return (Builder) invokeIL.objValue;
        }

        @NonNull
        public Builder setVisible(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                this.mImpl.setVisible(i, z);
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class BuilderImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowInsetsCompat mInsets;
        public Insets[] mInsetsTypeMask;

        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, displayCutoutCompat) == null) {
            }
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, insets) == null) {
            }
        }

        public void setStableInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, insets) == null) {
            }
        }

        public void setSystemGestureInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, insets) == null) {
            }
        }

        public void setSystemWindowInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, insets) == null) {
            }
        }

        public void setTappableElementInsets(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, insets) == null) {
            }
        }

        public void setVisible(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                applyInsetTypes();
                return this.mInsets;
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        public BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mInsets = windowInsetsCompat;
        }

        public final void applyInsetTypes() {
            Insets[] insetsArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (insetsArr = this.mInsetsTypeMask) != null) {
                Insets insets = insetsArr[Type.indexOf(1)];
                Insets insets2 = this.mInsetsTypeMask[Type.indexOf(2)];
                if (insets2 == null) {
                    insets2 = this.mInsets.getInsets(2);
                }
                if (insets == null) {
                    insets = this.mInsets.getInsets(1);
                }
                setSystemWindowInsets(Insets.max(insets, insets2));
                Insets insets3 = this.mInsetsTypeMask[Type.indexOf(16)];
                if (insets3 != null) {
                    setSystemGestureInsets(insets3);
                }
                Insets insets4 = this.mInsetsTypeMask[Type.indexOf(32)];
                if (insets4 != null) {
                    setMandatorySystemGestureInsets(insets4);
                }
                Insets insets5 = this.mInsetsTypeMask[Type.indexOf(64)];
                if (insets5 != null) {
                    setTappableElementInsets(insets5);
                }
            }
        }

        public void setInsets(int i, @NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, insets) == null) {
                if (this.mInsetsTypeMask == null) {
                    this.mInsetsTypeMask = new Insets[9];
                }
                for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                    if ((i & i2) != 0) {
                        this.mInsetsTypeMask[Type.indexOf(i2)] = insets;
                    }
                }
            }
        }

        public void setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048580, this, i, insets) != null) || i != 8) {
                return;
            }
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }
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
        public WindowInsets mPlatformInsets;
        public Insets mStableInsets;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                applyInsetTypes();
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
                windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
                windowInsetsCompat.setStableInsets(this.mStableInsets);
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WindowInsetsCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }

        @Nullable
        public static WindowInsets createWindowInsetsInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (!sConsumedFieldFetched) {
                    try {
                        sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                    } catch (ReflectiveOperationException e) {
                        Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
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
                    } catch (ReflectiveOperationException e2) {
                        Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e2);
                    }
                }
                if (!sConstructorFetched) {
                    try {
                        sConstructor = WindowInsets.class.getConstructor(Rect.class);
                    } catch (ReflectiveOperationException e3) {
                        Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e3);
                    }
                    sConstructorFetched = true;
                }
                Constructor<WindowInsets> constructor = sConstructor;
                if (constructor != null) {
                    try {
                        return constructor.newInstance(new Rect());
                    } catch (ReflectiveOperationException e4) {
                        Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e4);
                    }
                }
                return null;
            }
            return (WindowInsets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@Nullable Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, insets) == null) {
                this.mStableInsets = insets;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets windowInsets;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insets) == null) && (windowInsets = this.mPlatformInsets) != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                applyInsetTypes();
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
                windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WindowInsetsCompat) newInitContext.callArgs[0]);
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

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            DisplayCutout displayCutout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayCutoutCompat) == null) {
                WindowInsets.Builder builder = this.mPlatBuilder;
                if (displayCutoutCompat != null) {
                    displayCutout = displayCutoutCompat.unwrap();
                } else {
                    displayCutout = null;
                }
                builder.setDisplayCutout(displayCutout);
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
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class BuilderImpl30 extends BuilderImpl29 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BuilderImpl30() {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WindowInsetsCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsets(int i, @NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, insets) == null) {
                this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, insets) == null) {
                this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setVisible(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(i), z);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Impl {
        public static /* synthetic */ Interceptable $ic;
        @NonNull
        public static final WindowInsetsCompat CONSUMED;
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowInsetsCompat mHost;

        public void copyRootViewBounds(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            }
        }

        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, windowInsetsCompat) == null) {
            }
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (DisplayCutoutCompat) invokeV.objValue;
        }

        public boolean isConsumed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isRound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isVisible(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
                return true;
            }
            return invokeI.booleanValue;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, insetsArr) == null) {
            }
        }

        public void setRootViewData(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, insets) == null) {
            }
        }

        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, windowInsetsCompat) == null) {
            }
        }

        public void setStableInsets(Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, insets) == null) {
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1704413811, "Landroidx/core/view/WindowInsetsCompat$Impl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1704413811, "Landroidx/core/view/WindowInsetsCompat$Impl;");
                    return;
                }
            }
            CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
            }
            return invokeV.intValue;
        }

        public Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mHost = windowInsetsCompat;
        }

        @NonNull
        public Insets getInsets(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                return Insets.NONE;
            }
            return (Insets) invokeI.objValue;
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                if ((i & 8) == 0) {
                    return Insets.NONE;
                }
                throw new IllegalArgumentException("Unable to query the maximum insets for IME");
            }
            return (Insets) invokeI.objValue;
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mHost;
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mHost;
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mHost;
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return getSystemWindowInsets();
            }
            return (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return Insets.NONE;
            }
            return (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return getSystemWindowInsets();
            }
            return (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return Insets.NONE;
            }
            return (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return getSystemWindowInsets();
            }
            return (Insets) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Impl)) {
                    return false;
                }
                Impl impl = (Impl) obj;
                if (isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout())) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @NonNull
        public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048591, this, i, i2, i3, i4)) == null) {
                return CONSUMED;
            }
            return (WindowInsetsCompat) invokeIIII.objValue;
        }
    }

    @RequiresApi(20)
    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {
        public static /* synthetic */ Interceptable $ic;
        public static Class<?> sAttachInfoClass;
        public static Field sAttachInfoField;
        public static Method sGetViewRootImplMethod;
        public static Class<?> sViewRootImplClass;
        public static Field sVisibleInsetsField;
        public static boolean sVisibleRectReflectionFetched;
        public transient /* synthetic */ FieldHolder $fh;
        public Insets[] mOverriddenInsets;
        @NonNull
        public final WindowInsets mPlatformInsets;
        public Insets mRootViewVisibleInsets;
        public WindowInsetsCompat mRootWindowInsets;
        public Insets mSystemWindowInsets;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1559125493, "Landroidx/core/view/WindowInsetsCompat$Impl20;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1559125493, "Landroidx/core/view/WindowInsetsCompat$Impl20;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WindowInsetsCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private Insets getInsets(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                Insets insets = Insets.NONE;
                for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                    if ((i & i2) != 0) {
                        insets = Insets.max(insets, getInsetsForType(i2, z));
                    }
                }
                return insets;
            }
            return (Insets) invokeCommon.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl20};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        private Insets getRootStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                if (windowInsetsCompat != null) {
                    return windowInsetsCompat.getStableInsets();
                }
                return Insets.NONE;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mPlatformInsets.isRound();
            }
            return invokeV.booleanValue;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, view2)) == null) {
                if (Build.VERSION.SDK_INT < 30) {
                    if (!sVisibleRectReflectionFetched) {
                        loadReflectionField();
                    }
                    Method method = sGetViewRootImplMethod;
                    if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                        try {
                            Object invoke = method.invoke(view2, new Object[0]);
                            if (invoke == null) {
                                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                                return null;
                            }
                            Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                            if (rect == null) {
                                return null;
                            }
                            return Insets.of(rect);
                        } catch (ReflectiveOperationException e) {
                            Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                        }
                    }
                    return null;
                }
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            return (Insets) invokeL.objValue;
        }

        @SuppressLint({"PrivateApi"})
        public static void loadReflectionField() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, null) == null) {
                try {
                    sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                    sViewRootImplClass = Class.forName("android.view.ViewRootImpl");
                    Class<?> cls = Class.forName("android.view.View$AttachInfo");
                    sAttachInfoClass = cls;
                    sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                    sAttachInfoField = sViewRootImplClass.getDeclaredField("mAttachInfo");
                    sVisibleInsetsField.setAccessible(true);
                    sAttachInfoField.setAccessible(true);
                } catch (ReflectiveOperationException e) {
                    Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
                sVisibleRectReflectionFetched = true;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Insets visibleInsets = getVisibleInsets(view2);
                if (visibleInsets == null) {
                    visibleInsets = Insets.NONE;
                }
                setRootViewData(visibleInsets);
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, windowInsetsCompat) == null) {
                windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
                windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (!super.equals(obj)) {
                    return false;
                }
                return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return getInsets(i, false);
            }
            return (Insets) invokeI.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                return getInsets(i, true);
            }
            return (Insets) invokeI.objValue;
        }

        public boolean isTypeVisible(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                if (i != 1 && i != 2) {
                    if (i == 4) {
                        return false;
                    }
                    if (i != 8 && i != 128) {
                        return true;
                    }
                }
                return !getInsetsForType(i, false).equals(Insets.NONE);
            }
            return invokeI.booleanValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                    if ((i & i2) != 0 && !isTypeVisible(i2)) {
                        return false;
                    }
                }
                return true;
            }
            return invokeI.booleanValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] insetsArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, insetsArr) == null) {
                this.mOverriddenInsets = insetsArr;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootViewData(@NonNull Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, insets) == null) {
                this.mRootViewVisibleInsets = insets;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, windowInsetsCompat) == null) {
                this.mRootWindowInsets = windowInsetsCompat;
            }
        }

        @NonNull
        public Insets getInsetsForType(int i, boolean z) {
            InterceptResult invokeCommon;
            int i2;
            DisplayCutoutCompat displayCutout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                if (i != 1) {
                    Insets insets = null;
                    if (i != 2) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            return Insets.NONE;
                                        }
                                        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                                        if (windowInsetsCompat != null) {
                                            displayCutout = windowInsetsCompat.getDisplayCutout();
                                        } else {
                                            displayCutout = getDisplayCutout();
                                        }
                                        if (displayCutout != null) {
                                            return Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                                        }
                                        return Insets.NONE;
                                    }
                                    return getTappableElementInsets();
                                }
                                return getMandatorySystemGestureInsets();
                            }
                            return getSystemGestureInsets();
                        }
                        Insets[] insetsArr = this.mOverriddenInsets;
                        if (insetsArr != null) {
                            insets = insetsArr[Type.indexOf(8)];
                        }
                        if (insets != null) {
                            return insets;
                        }
                        Insets systemWindowInsets = getSystemWindowInsets();
                        Insets rootStableInsets = getRootStableInsets();
                        int i3 = systemWindowInsets.bottom;
                        if (i3 > rootStableInsets.bottom) {
                            return Insets.of(0, 0, 0, i3);
                        }
                        Insets insets2 = this.mRootViewVisibleInsets;
                        if (insets2 != null && !insets2.equals(Insets.NONE) && (i2 = this.mRootViewVisibleInsets.bottom) > rootStableInsets.bottom) {
                            return Insets.of(0, 0, 0, i2);
                        }
                        return Insets.NONE;
                    } else if (z) {
                        Insets rootStableInsets2 = getRootStableInsets();
                        Insets stableInsets = getStableInsets();
                        return Insets.of(Math.max(rootStableInsets2.left, stableInsets.left), 0, Math.max(rootStableInsets2.right, stableInsets.right), Math.max(rootStableInsets2.bottom, stableInsets.bottom));
                    } else {
                        Insets systemWindowInsets2 = getSystemWindowInsets();
                        WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                        if (windowInsetsCompat2 != null) {
                            insets = windowInsetsCompat2.getStableInsets();
                        }
                        int i4 = systemWindowInsets2.bottom;
                        if (insets != null) {
                            i4 = Math.min(i4, insets.bottom);
                        }
                        return Insets.of(systemWindowInsets2.left, 0, systemWindowInsets2.right, i4);
                    }
                } else if (z) {
                    return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
                } else {
                    return Insets.of(0, getSystemWindowInsets().top, 0, 0);
                }
            }
            return (Insets) invokeCommon.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.mSystemWindowInsets == null) {
                    this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
                }
                return this.mSystemWindowInsets;
            }
            return (Insets) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048583, this, i, i2, i3, i4)) == null) {
                Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
                builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i, i2, i3, i4));
                builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i, i2, i3, i4));
                return builder.build();
            }
            return (WindowInsetsCompat) invokeIIII.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStableInsets = null;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (Impl20) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mStableInsets = null;
            this.mStableInsets = impl21.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mPlatformInsets.isConsumed();
            }
            return invokeV.booleanValue;
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
        public void setStableInsets(@Nullable Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, insets) == null) {
                this.mStableInsets = insets;
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (Impl21) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
            }
            return (WindowInsetsCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
            }
            return (DisplayCutoutCompat) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mPlatformInsets.hashCode();
            }
            return invokeV.intValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Impl28)) {
                    return false;
                }
                Impl28 impl28 = (Impl28) obj;
                if (Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
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

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets insets) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, insets) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl29};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i, i2, i3, i4)) == null) {
                return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i, i2, i3, i4));
            }
            return (WindowInsetsCompat) invokeIIII.objValue;
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Impl30 extends Impl29 {
        public static /* synthetic */ Interceptable $ic;
        @NonNull
        public static final WindowInsetsCompat CONSUMED;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1559126454, "Landroidx/core/view/WindowInsetsCompat$Impl30;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1559126454, "Landroidx/core/view/WindowInsetsCompat$Impl30;");
                    return;
                }
            }
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, windowInsets};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (WindowInsets) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, impl30);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsCompat, impl30};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WindowInsetsCompat) objArr2[0], (Impl29) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(i)));
            }
            return (Insets) invokeI.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i)));
            }
            return (Insets) invokeI.objValue;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(i));
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class Type {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CAPTION_BAR = 4;
        public static final int DISPLAY_CUTOUT = 128;
        public static final int FIRST = 1;
        public static final int IME = 8;
        public static final int LAST = 256;
        public static final int MANDATORY_SYSTEM_GESTURES = 32;
        public static final int NAVIGATION_BARS = 2;
        public static final int SIZE = 9;
        public static final int STATUS_BARS = 1;
        public static final int SYSTEM_GESTURES = 16;
        public static final int TAPPABLE_ELEMENT = 64;
        public static final int WINDOW_DECOR = 256;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes.dex */
        public @interface InsetsType {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static int all() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        public static int captionBar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        public static int displayCutout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return 128;
            }
            return invokeV.intValue;
        }

        public static int ime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return 8;
            }
            return invokeV.intValue;
        }

        public static int mandatorySystemGestures() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        public static int navigationBars() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        public static int statusBars() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public static int systemBars() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                return 7;
            }
            return invokeV.intValue;
        }

        public static int systemGestures() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        public static int tappableElement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
                return 64;
            }
            return invokeV.intValue;
        }

        public Type() {
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

        public static int indexOf(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
                if (i != 1) {
                    if (i == 2) {
                        return 1;
                    }
                    if (i == 4) {
                        return 2;
                    }
                    if (i != 8) {
                        if (i == 16) {
                            return 4;
                        }
                        if (i != 32) {
                            if (i != 64) {
                                if (i != 128) {
                                    if (i == 256) {
                                        return 8;
                                    }
                                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
                                }
                                return 7;
                            }
                            return 6;
                        }
                        return 5;
                    }
                    return 3;
                }
                return 0;
            }
            return invokeI.intValue;
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static final class TypeImpl30 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TypeImpl30() {
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

        public static int toPlatformType(int i) {
            InterceptResult invokeI;
            int statusBars;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
                int i2 = 0;
                for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                    if ((i & i3) != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 4) {
                                    if (i3 != 8) {
                                        if (i3 != 16) {
                                            if (i3 != 32) {
                                                if (i3 != 64) {
                                                    if (i3 == 128) {
                                                        statusBars = WindowInsets.Type.displayCutout();
                                                    }
                                                } else {
                                                    statusBars = WindowInsets.Type.tappableElement();
                                                }
                                            } else {
                                                statusBars = WindowInsets.Type.mandatorySystemGestures();
                                            }
                                        } else {
                                            statusBars = WindowInsets.Type.systemGestures();
                                        }
                                    } else {
                                        statusBars = WindowInsets.Type.ime();
                                    }
                                } else {
                                    statusBars = WindowInsets.Type.captionBar();
                                }
                            } else {
                                statusBars = WindowInsets.Type.navigationBars();
                            }
                        } else {
                            statusBars = WindowInsets.Type.statusBars();
                        }
                        i2 |= statusBars;
                    }
                }
                return i2;
            }
            return invokeI.intValue;
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
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mImpl.consumeDisplayCutout();
        }
        return (WindowInsetsCompat) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImpl.consumeStableInsets();
        }
        return (WindowInsetsCompat) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImpl.consumeSystemWindowInsets();
        }
        return (WindowInsetsCompat) invokeV.objValue;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getDisplayCutout();
        }
        return (DisplayCutoutCompat) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl.getMandatorySystemGestureInsets();
        }
        return (Insets) invokeV.objValue;
    }

    @Deprecated
    public int getStableInsetBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mImpl.getStableInsets().bottom;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getStableInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mImpl.getStableInsets().left;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getStableInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mImpl.getStableInsets().right;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getStableInsetTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mImpl.getStableInsets().top;
        }
        return invokeV.intValue;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mImpl.getStableInsets();
        }
        return (Insets) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mImpl.getSystemGestureInsets();
        }
        return (Insets) invokeV.objValue;
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mImpl.getSystemWindowInsets().bottom;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mImpl.getSystemWindowInsets().left;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mImpl.getSystemWindowInsets().right;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mImpl.getSystemWindowInsets().top;
        }
        return invokeV.intValue;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mImpl.getSystemWindowInsets();
        }
        return (Insets) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mImpl.getTappableElementInsets();
        }
        return (Insets) invokeV.objValue;
    }

    @Deprecated
    public boolean hasStableInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return !this.mImpl.getStableInsets().equals(Insets.NONE);
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            Impl impl = this.mImpl;
            if (impl == null) {
                return 0;
            }
            return impl.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isConsumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mImpl.isConsumed();
        }
        return invokeV.booleanValue;
    }

    public boolean isRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mImpl.isRound();
        }
        return invokeV.booleanValue;
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            Impl impl = this.mImpl;
            if (impl instanceof Impl20) {
                return ((Impl20) impl).mPlatformInsets;
            }
            return null;
        }
        return (WindowInsets) invokeV.objValue;
    }

    @RequiresApi(20)
    public WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {windowInsets};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
        } else if (i3 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i3 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else if (i3 >= 21) {
            this.mImpl = new Impl21(this, windowInsets);
        } else if (i3 >= 20) {
            this.mImpl = new Impl20(this, windowInsets);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {windowInsetsCompat};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            if (Build.VERSION.SDK_INT >= 30 && (impl instanceof Impl30)) {
                this.mImpl = new Impl30(this, (Impl30) impl);
            } else if (Build.VERSION.SDK_INT >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
            } else if (Build.VERSION.SDK_INT >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
            } else if (Build.VERSION.SDK_INT >= 21 && (impl instanceof Impl21)) {
                this.mImpl = new Impl21(this, (Impl21) impl);
            } else if (Build.VERSION.SDK_INT >= 20 && (impl instanceof Impl20)) {
                this.mImpl = new Impl20(this, (Impl20) impl);
            } else {
                this.mImpl = new Impl(this);
            }
            impl.copyWindowDataInto(this);
            return;
        }
        this.mImpl = new Impl(this);
    }

    public static Insets insetInsets(@NonNull Insets insets, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{insets, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int max = Math.max(0, insets.left - i);
            int max2 = Math.max(0, insets.top - i2);
            int max3 = Math.max(0, insets.right - i3);
            int max4 = Math.max(0, insets.bottom - i4);
            if (max == i && max2 == i2 && max3 == i3 && max4 == i4) {
                return insets;
            }
            return Insets.of(max, max2, max3, max4);
        }
        return (Insets) invokeCommon.objValue;
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, windowInsets)) == null) {
            return toWindowInsetsCompat(windowInsets, null);
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void copyRootViewBounds(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.mImpl.copyRootViewBounds(view2);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WindowInsetsCompat)) {
                return false;
            }
            return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public Insets getInsets(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.mImpl.getInsets(i);
        }
        return (Insets) invokeI.objValue;
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.mImpl.getInsetsIgnoringVisibility(i);
        }
        return (Insets) invokeI.objValue;
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, insets)) == null) {
            return inset(insets.left, insets.top, insets.right, insets.bottom);
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public boolean isVisible(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return this.mImpl.isVisible(i);
        }
        return invokeI.booleanValue;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, rect)) == null) {
            return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void setOverriddenInsets(Insets[] insetsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, insetsArr) == null) {
            this.mImpl.setOverriddenInsets(insetsArr);
        }
    }

    public void setRootViewData(@NonNull Insets insets) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, insets) == null) {
            this.mImpl.setRootViewData(insets);
        }
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, windowInsetsCompat) == null) {
            this.mImpl.setRootWindowInsets(windowInsetsCompat);
        }
    }

    public void setStableInsets(@Nullable Insets insets) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, insets) == null) {
            this.mImpl.setStableInsets(insets);
        }
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, windowInsets, view2)) == null) {
            WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
            if (view2 != null && view2.isAttachedToWindow()) {
                windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view2));
                windowInsetsCompat.copyRootViewBounds(view2.getRootView());
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeLL.objValue;
    }

    public boolean hasInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getInsets(Type.all()).equals(Insets.NONE) && getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(Insets.NONE) && getDisplayCutout() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048601, this, i, i2, i3, i4)) == null) {
            return this.mImpl.inset(i, i2, i3, i4);
        }
        return (WindowInsetsCompat) invokeIIII.objValue;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048606, this, i, i2, i3, i4)) == null) {
            return new Builder(this).setSystemWindowInsets(Insets.of(i, i2, i3, i4)).build();
        }
        return (WindowInsetsCompat) invokeIIII.objValue;
    }
}
