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
        if ((interceptable != null && interceptable.invokeL(65536, null, context) != null) || !bu.a().d()) {
            return;
        }
        b.a.a(context);
        w.a(context).a(g.a, System.currentTimeMillis());
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, context) != null) || !bu.a().d()) {
            return;
        }
        d.a.a(context);
        w.a(context).a(g.g, System.currentTimeMillis());
    }

    public static void a(Context context, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, context, z) != null) || !bu.a().d()) {
            return;
        }
        e.a.a(context, z);
        long currentTimeMillis = System.currentTimeMillis();
        w a = w.a(context);
        if (z) {
            gVar = g.c;
        } else {
            gVar = g.b;
        }
        a.a(gVar, currentTimeMillis);
    }

    public static void b(Context context, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65539, null, context, z) != null) || !bu.a().d()) {
            return;
        }
        f.a.a(context, z);
        long currentTimeMillis = System.currentTimeMillis();
        w a = w.a(context);
        if (z) {
            gVar = g.d;
        } else {
            gVar = g.e;
        }
        a.a(gVar, currentTimeMillis);
    }
}
