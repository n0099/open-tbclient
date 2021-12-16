package c.a.q0.a.a3.k;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull b bVar, @NonNull c.a.q0.a.m1.e.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bVar, aVar) == null) {
            bVar.f(aVar.e());
            bVar.g(aVar.f());
            if (aVar.h()) {
                bVar.a(1);
            } else {
                bVar.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull c.a.q0.a.p.e.c cVar, @NonNull c.a.q0.a.m1.e.a.a aVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cVar, aVar)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.c());
            int i3 = 0;
            if (aVar.h()) {
                i3 = cVar.getWebViewScrollX();
                i2 = cVar.getWebViewScrollY();
            } else {
                i2 = 0;
            }
            layoutParams.leftMargin = aVar.e() + i3;
            layoutParams.topMargin = aVar.f() + i2;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
