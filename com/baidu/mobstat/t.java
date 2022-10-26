package com.baidu.mobstat;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            synchronized (t.class) {
                ba.c().a("getBPStretegyController begin");
                uVar = new u();
                ba.c().a("Get BPStretegyController load local class");
                v.a(context, uVar);
                ba.c().a("getBPStretegyController end");
            }
            return uVar;
        }
        return (a) invokeL.objValue;
    }
}
