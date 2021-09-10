package c.a.r0.v3;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? Build.VERSION.SDK_INT >= 26 ? SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY : i2 : invokeI.intValue;
    }

    public static void b(int i2, WindowManager.LayoutParams layoutParams, Window window) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65537, null, i2, layoutParams, window) == null) || layoutParams == null || window == null) {
            return;
        }
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField("layoutInDisplayCutoutMode");
            if (declaredField != null) {
                declaredField.set(layoutParams, Integer.valueOf(i2));
                window.setAttributes(layoutParams);
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }
}
