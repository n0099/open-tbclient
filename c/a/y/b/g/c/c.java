package c.a.y.b.g.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) ? b(view, false) : invokeL.intValue;
    }

    public static int b(View view, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view, z)) == null) {
            if (view == null) {
                return 0;
            }
            return n(view) ? z ? view.getLeft() + g(view) : view.getLeft() : z ? view.getRight() - g(view) : view.getRight();
        }
        return invokeLZ.intValue;
    }

    public static int c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        }
        return invokeL.intValue;
    }

    public static int d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
        }
        return invokeL.intValue;
    }

    public static int e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        }
        return invokeL.intValue;
    }

    public static int f(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return view.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public static int g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return ViewCompat.getPaddingEnd(view);
        }
        return invokeL.intValue;
    }

    public static int h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return view.getPaddingLeft() + view.getPaddingRight();
        }
        return invokeL.intValue;
    }

    public static int i(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return ViewCompat.getPaddingStart(view);
        }
        return invokeL.intValue;
    }

    public static int j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view)) == null) ? k(view, false) : invokeL.intValue;
    }

    public static int k(View view, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, view, z)) == null) {
            if (view == null) {
                return 0;
            }
            return n(view) ? z ? view.getRight() - i(view) : view.getRight() : z ? view.getLeft() + i(view) : view.getLeft();
        }
        return invokeLZ.intValue;
    }

    public static int l(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) {
            if (view == null) {
                return 0;
            }
            return view.getWidth();
        }
        return invokeL.intValue;
    }

    public static int m(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) ? l(view) + d(view) : invokeL.intValue;
    }

    public static boolean n(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view)) == null) ? ViewCompat.getLayoutDirection(view) == 1 : invokeL.booleanValue;
    }
}
