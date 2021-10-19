package com.baidu.mobstat;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            b.f43335a.a(context);
            y.a(context).a(g.f43833a, System.currentTimeMillis());
        }
    }

    public static void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, context, z) == null) {
            f.f43828a.a(context, z);
            y.a(context).a(z ? g.f43836d : g.f43837e, System.currentTimeMillis());
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) {
            e.f43827a.a(context, z);
            y.a(context).a(z ? g.f43835c : g.f43834b, System.currentTimeMillis());
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            d.f43481a.a(context);
            y.a(context).a(g.f43839g, System.currentTimeMillis());
        }
    }
}
