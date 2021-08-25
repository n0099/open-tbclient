package c.a.w.e.g;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            int i2 = 0;
            if (identifier > 0) {
                try {
                    i2 = context.getResources().getDimensionPixelSize(identifier);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return i2 == 0 ? (int) (a(null) * 25.0f) : i2;
        }
        return invokeL.intValue;
    }
}
