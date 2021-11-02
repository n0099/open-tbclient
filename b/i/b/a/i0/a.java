package b.i.b.a.i0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65536, null, z) == null) && !z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65537, null, z, obj) == null) && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) {
            if (i2 < i3 || i2 >= i4) {
                throw new IndexOutOfBoundsException();
            }
            return i2;
        }
        return invokeIII.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static <T> T e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) && !z) {
            throw new IllegalStateException();
        }
    }

    public static void g(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(AdIconUtil.BAIDU_LOGO_ID, null, z, obj) == null) && !z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
