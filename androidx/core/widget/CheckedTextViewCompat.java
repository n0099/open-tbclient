package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class CheckedTextViewCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CheckedTextViewCompat";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Api14Impl {
        public static /* synthetic */ Interceptable $ic;
        public static Field sCheckMarkDrawableField;
        public static boolean sResolved;
        public transient /* synthetic */ FieldHolder $fh;

        public Api14Impl() {
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

        @Nullable
        public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, checkedTextView)) == null) {
                if (!sResolved) {
                    try {
                        Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                        sCheckMarkDrawableField = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException e) {
                        Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
                    }
                    sResolved = true;
                }
                Field field = sCheckMarkDrawableField;
                if (field != null) {
                    try {
                        return (Drawable) field.get(checkedTextView);
                    } catch (IllegalAccessException e2) {
                        Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e2);
                        sCheckMarkDrawableField = null;
                    }
                }
                return null;
            }
            return (Drawable) invokeL.objValue;
        }
    }

    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api16Impl() {
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

        @Nullable
        public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, checkedTextView)) == null) {
                return checkedTextView.getCheckMarkDrawable();
            }
            return (Drawable) invokeL.objValue;
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api21Impl() {
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

        @Nullable
        public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, checkedTextView)) == null) {
                return checkedTextView.getCheckMarkTintList();
            }
            return (ColorStateList) invokeL.objValue;
        }

        @Nullable
        public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, checkedTextView)) == null) {
                return checkedTextView.getCheckMarkTintMode();
            }
            return (PorterDuff.Mode) invokeL.objValue;
        }

        public static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, checkedTextView, colorStateList) == null) {
                checkedTextView.setCheckMarkTintList(colorStateList);
            }
        }

        public static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, checkedTextView, mode) == null) {
                checkedTextView.setCheckMarkTintMode(mode);
            }
        }
    }

    public CheckedTextViewCompat() {
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

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, checkedTextView)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Api16Impl.getCheckMarkDrawable(checkedTextView);
            }
            return Api14Impl.getCheckMarkDrawable(checkedTextView);
        }
        return (Drawable) invokeL.objValue;
    }

    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, checkedTextView)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return Api21Impl.getCheckMarkTintList(checkedTextView);
            }
            if (checkedTextView instanceof TintableCheckedTextView) {
                return ((TintableCheckedTextView) checkedTextView).getSupportCheckMarkTintList();
            }
            return null;
        }
        return (ColorStateList) invokeL.objValue;
    }

    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, checkedTextView)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return Api21Impl.getCheckMarkTintMode(checkedTextView);
            }
            if (checkedTextView instanceof TintableCheckedTextView) {
                return ((TintableCheckedTextView) checkedTextView).getSupportCheckMarkTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeL.objValue;
    }

    public static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, checkedTextView, colorStateList) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Api21Impl.setCheckMarkTintList(checkedTextView, colorStateList);
            } else if (checkedTextView instanceof TintableCheckedTextView) {
                ((TintableCheckedTextView) checkedTextView).setSupportCheckMarkTintList(colorStateList);
            }
        }
    }

    public static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, checkedTextView, mode) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Api21Impl.setCheckMarkTintMode(checkedTextView, mode);
            } else if (checkedTextView instanceof TintableCheckedTextView) {
                ((TintableCheckedTextView) checkedTextView).setSupportCheckMarkTintMode(mode);
            }
        }
    }
}
