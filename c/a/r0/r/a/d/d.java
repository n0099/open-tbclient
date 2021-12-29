package c.a.r0.r.a.d;

import android.view.LayoutInflater;
import c.a.r0.r.a.d.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, eVar) == null) {
            layoutInflater.setFactory2(eVar != null ? new c.a(eVar) : null);
        }
    }
}
