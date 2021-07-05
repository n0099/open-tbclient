package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class GravityCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;
    public transient /* synthetic */ FieldHolder $fh;

    public GravityCompat() {
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

    public static void apply(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), rect, rect2, Integer.valueOf(i5)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Gravity.apply(i2, i3, i4, rect, rect2, i5);
            } else {
                Gravity.apply(i2, i3, i4, rect, rect2);
            }
        }
    }

    public static void applyDisplay(int i2, Rect rect, Rect rect2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), rect, rect2, Integer.valueOf(i3)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Gravity.applyDisplay(i2, rect, rect2, i3);
            } else {
                Gravity.applyDisplay(i2, rect, rect2);
            }
        }
    }

    public static int getAbsoluteGravity(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65540, null, i2, i3)) == null) ? Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i2, i3) : i2 & (-8388609) : invokeII.intValue;
    }

    public static void apply(int i2, int i3, int i4, Rect rect, int i5, int i6, Rect rect2, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), rect, Integer.valueOf(i5), Integer.valueOf(i6), rect2, Integer.valueOf(i7)}) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Gravity.apply(i2, i3, i4, rect, i5, i6, rect2, i7);
            } else {
                Gravity.apply(i2, i3, i4, rect, i5, i6, rect2);
            }
        }
    }
}
