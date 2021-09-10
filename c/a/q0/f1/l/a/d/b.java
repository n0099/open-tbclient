package c.a.q0.f1.l.a.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, view, runnable) == null) {
            view.postDelayed(runnable, 16L);
        }
    }

    public static void b(View view, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, view, drawable) == null) {
            view.setBackgroundDrawable(drawable);
        }
    }
}
