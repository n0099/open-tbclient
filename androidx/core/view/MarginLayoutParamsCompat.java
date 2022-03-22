package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MarginLayoutParamsCompat() {
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

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, marginLayoutParams)) == null) {
            int layoutDirection = Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getLayoutDirection() : 0;
            if (layoutDirection == 0 || layoutDirection == 1) {
                return layoutDirection;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, marginLayoutParams)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return marginLayoutParams.getMarginEnd();
            }
            return marginLayoutParams.rightMargin;
        }
        return invokeL.intValue;
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, marginLayoutParams)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return marginLayoutParams.getMarginStart();
            }
            return marginLayoutParams.leftMargin;
        }
        return invokeL.intValue;
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, marginLayoutParams)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return marginLayoutParams.isMarginRelative();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, marginLayoutParams, i) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        marginLayoutParams.resolveLayoutDirection(i);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65542, null, marginLayoutParams, i) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        marginLayoutParams.setLayoutDirection(i);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, marginLayoutParams, i) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginEnd(i);
            } else {
                marginLayoutParams.rightMargin = i;
            }
        }
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, marginLayoutParams, i) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(i);
            } else {
                marginLayoutParams.leftMargin = i;
            }
        }
    }
}
