package c.a.n0.a.q2.k;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull b bVar, @NonNull c.a.n0.a.c1.e.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bVar, aVar) == null) {
            bVar.f(aVar.d());
            bVar.g(aVar.e());
            if (aVar.g()) {
                bVar.a(1);
            } else {
                bVar.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull c.a.n0.a.f.e.c cVar, @NonNull c.a.n0.a.c1.e.a.a aVar) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cVar, aVar)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.f(), aVar.c());
            int i2 = 0;
            if (aVar.g()) {
                i2 = cVar.getWebViewScrollX();
                i = cVar.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = aVar.d() + i2;
            layoutParams.topMargin = aVar.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
