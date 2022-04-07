package com.baidu.mobstat;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e A[Catch: all -> 0x005c, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x0014, B:10:0x001c, B:11:0x0025, B:17:0x0034, B:20:0x003e, B:21:0x004c), top: B:33:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        a aVar2;
        Exception e;
        Class<?> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            synchronized (u.class) {
                bb.c().a("getBPStretegyController begin");
                aVar = a;
                if (aVar == null) {
                    try {
                        a2 = x.a(context, "com.baidu.bottom.remote.BPStretegyController2");
                    } catch (Exception e2) {
                        aVar2 = aVar;
                        e = e2;
                    }
                    if (a2 != null) {
                        aVar2 = new w(a2.newInstance());
                        try {
                            bb.c().a("Get BPStretegyController load remote class v2");
                        } catch (Exception e3) {
                            e = e3;
                            bb.c().a(e);
                            aVar = aVar2;
                            if (aVar == null) {
                            }
                            a = aVar;
                            x.a(context, aVar);
                            bb.c().a("getBPStretegyController end");
                            return aVar;
                        }
                        aVar = aVar2;
                    }
                }
                if (aVar == null) {
                    aVar = new v();
                    bb.c().a("Get BPStretegyController load local class");
                }
                a = aVar;
                x.a(context, aVar);
                bb.c().a("getBPStretegyController end");
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (u.class) {
                a = null;
            }
        }
    }
}
