package c.a.e.e.p;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (str == null) {
                str = "";
            }
            try {
                ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(str);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
