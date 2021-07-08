package androidx.core.util;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class Preconditions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Preconditions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void checkArgument(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65537, null, z) == null) && !z) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int i2, int i3, int i4, @NonNull String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str})) == null) {
            if (i2 >= i3) {
                if (i2 <= i4) {
                    return i2;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        return invokeCommon.intValue;
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i2, @Nullable String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str)) == null) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException(str);
        }
        return invokeIL.intValue;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static void checkState(boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65545, null, z, str) == null) && !z) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkArgument(boolean z, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65538, null, z, obj) == null) && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 >= 0) {
                return i2;
            }
            throw new IllegalArgumentException();
        }
        return invokeI.intValue;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, t, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }
        return (T) invokeLL.objValue;
    }

    public static void checkState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            checkState(z, null);
        }
    }
}
