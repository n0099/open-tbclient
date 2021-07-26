package com.baidu.mobstat;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            b.f8832a.a(context);
            y.a(context).a(g.f9003a, System.currentTimeMillis());
        }
    }

    public static void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, context, z) == null) {
            f.f8998a.a(context, z);
            y.a(context).a(z ? g.f9006d : g.f9007e, System.currentTimeMillis());
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) {
            e.f8997a.a(context, z);
            y.a(context).a(z ? g.f9005c : g.f9004b, System.currentTimeMillis());
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            d.f8974a.a(context);
            y.a(context).a(g.f9009g, System.currentTimeMillis());
        }
    }
}
