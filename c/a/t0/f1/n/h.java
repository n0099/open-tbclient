package c.a.t0.f1.n;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Drawable a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0) {
                return SkinManager.getDrawable(c.a.u0.a4.f.icon_xiangqing_n);
            }
            return SkinManager.getDrawable(c.a.u0.a4.f.icon_xiangqing_n);
        }
        return (Drawable) invokeI.objValue;
    }
}
